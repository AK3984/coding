package com.device.serviceImpl;

import com.device.entity.Mobile;
import com.device.repository.MobileRepository;
import com.device.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MobileServiceImpl implements MobileService {

    private final MobileRepository mobileRepository;

    @Override
    public List<Mobile> getAllMobiles() {
        return mobileRepository.findAll();
    }

    @Override
    public Mobile createMobile(Mobile mobile) {
        return mobileRepository.save(mobile);
    }

    @Override
    public Mobile getMobileById(Long id) {
        return mobileRepository.findById(id).orElseThrow(()->new RuntimeException("Resource not found"));
    }

    @Override
    public void deleteMobileById(Long id) {
        mobileRepository.deleteById(id);
    }

    @Override
    public Mobile updateMobileById(Mobile mobile, Long id) {
//        if (mobileRepository.existsById(id)){
//            mobile.setId(id);
//           return mobileRepository.save(mobile);
//        }else {
//            throw new RuntimeException("Details not found to update");
//        }
//
        Mobile oldMobile = mobileRepository.findById(id).get();
        System.out.println(oldMobile);
        oldMobile.setBrand(mobile.getBrand());
        Mobile save = mobileRepository.save(oldMobile);
        System.out.println("save" +save);
        return save;
    }
}
