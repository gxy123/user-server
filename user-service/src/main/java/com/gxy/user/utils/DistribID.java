package com.gxy.user.utils;
import java.lang.management.ManagementFactory;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
public class DistribID {
    private final long twepoch = 1288834974657L;

    private final long workerIdBits = 5L;

    private final long dataCenterIdBits = 5L;

    private final long maxWorkerId = 31L;

    private final long maxDataCenterId = 31L;

    private final long sequenceBits = 12L;

    private final long workerIdShift = 12L;

    private final long dataCenterIdShift = 17L;

    private final long timestampLeftShift = 22L;

    private final long sequenceMask = 4095L;

    private long workerId;

    private long dataCenterId;

    private long sequence = 0L;

    private long lastTimestamp = -1L;

    public DistribID() {
        this.dataCenterId = getDataCenterId(31L);
        this.workerId = getWorkerId(this.dataCenterId, 31L);
    }

    public DistribID(long workerId, long datacenterId) {
        if (workerId > 31L || workerId < 0L)
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", new Object[] { Long.valueOf(31L) }));
        if (datacenterId > 31L || datacenterId < 0L)
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", new Object[] { Long.valueOf(31L) }));
        this.workerId = workerId;
        this.dataCenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < this.lastTimestamp)
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", new Object[] { Long.valueOf(this.lastTimestamp - timestamp) }));
        if (this.lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1L & 0xFFFL;
            if (this.sequence == 0L)
                timestamp = tilNextMillis(this.lastTimestamp);
        } else {
            this.sequence = 0L;
        }
        this.lastTimestamp = timestamp;
        return timestamp - 1288834974657L << 22L | this.dataCenterId << 17L | this.workerId << 12L | this.sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp)
            timestamp = timeGen();
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    protected static long getWorkerId(long datacenterId, long maxWorkerId) {
        StringBuffer mpid = new StringBuffer();
        mpid.append(datacenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (!StringUtils.isEmpty(name))
            mpid.append(name.split("@")[0]);
        return (mpid.toString().hashCode() & 0xFFFF) % (maxWorkerId + 1L);
    }

    protected static long getDataCenterId(long maxDataCenterId) {
        long id = 0L;
        try {
            byte[] mac = null;
            Enumeration<NetworkInterface> subInterfaces = NetworkInterface.getNetworkInterfaces();
            while (subInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = subInterfaces.nextElement();
                if (networkInterface.getHardwareAddress() != null) {
                    mac = networkInterface.getHardwareAddress();
                    break;
                }
            }
            if (mac == null)
                mac = UUID.randomUUID().toString().getBytes();
            id = (0xFFL & mac[mac.length - 1] | 0xFF00L & mac[mac.length - 2] << 8L) >> 6L;
            id %= maxDataCenterId + 1L;
        } catch (Exception e) {
            LoggerFactory.getLogger(DistribID.class).error("get_data_center_id", e);
        }
        return id;
    }

    public static void main(String[] args) {

        DistribID distribID =new DistribID(22L,11L);
        for (int i = 0; i < 10; i++) {
            System.out.println(distribID.nextId()+"");
        }

    }
}
