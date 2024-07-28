package com.diallo.cab_book_driver.controller;


import com.diallo.cab_book_driver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {

        int k = 0;
        while(k < 50) {
            cabLocationService.updateLocation(Math.random() + " " + Math.random());
            //cabLocationService.updateLocation("From Spring app producer Test");
            Thread.sleep(1000);
            k++;
        }
        return  new ResponseEntity(Map.of("message", "location updated"), HttpStatus.OK);
    }
}
