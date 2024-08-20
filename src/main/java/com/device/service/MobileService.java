package com.device.service;

import com.device.entity.Mobile;

import java.util.List;

public interface MobileService {

    public List<Mobile> getAllMobiles();

    public Mobile createMobile(Mobile mobile);

    public Mobile getMobileById(Long id);

    public void deleteMobileById(Long id);

    public Mobile updateMobileById(Mobile mobile, Long id);
}
