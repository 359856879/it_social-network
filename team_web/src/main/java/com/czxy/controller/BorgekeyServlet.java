package com.czxy.controller;

import com.czxy.domain.Borgekey;
import com.czxy.service.BorgekeyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/8/1 14:19
 * @Description:
 */
@RestController
@RequestMapping("/borgekey")
public class BorgekeyServlet {

    @Resource
    private BorgekeyService borgekeyService;


    @GetMapping("findAll")
    public ResponseEntity<List<Borgekey>> findAll(){

        try {
            List<Borgekey> all = borgekeyService.findAll();
            return new ResponseEntity<>(all, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }




}