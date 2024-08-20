package com.device.controller;

import com.device.entity.Mobile;
import com.device.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/api/mobile")
@RequiredArgsConstructor
public class MobileController {

    private final MobileService mobileService;

    @GetMapping
    public List<Mobile> getAllMobiles(){
            return mobileService.getAllMobiles();

    }

    @PostMapping
    public ResponseEntity<String> createMobile(@RequestBody Mobile mobile){
            Mobile newMobile = mobileService.createMobile(mobile);
            return new ResponseEntity<>("Mobile details successfully added", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mobile> getMobileById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(mobileService.getMobileById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.CREATED);
           // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMobileById(@PathVariable Long id){
        try {
            mobileService.deleteMobileById(id);
            return new ResponseEntity<>("Mobile details deleted successfully", HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Mobile details not found to delete");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mobile> updateMobileById(@RequestBody Mobile mobile, @PathVariable Long id){
        try{
            Mobile mobileX = mobileService.updateMobileById(mobile, id);
            return new ResponseEntity<>(mobileX, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mobile details not found to update");
        }
    }

}
