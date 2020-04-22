package com.gxy.user.wrapper;


import com.gxy.service.base.DistribID;

public class IDWrapper {
    private DistribID distribID = new DistribID(1L,1L);
    public Long getLongId() {
        return distribID.nextId();
    }
}
