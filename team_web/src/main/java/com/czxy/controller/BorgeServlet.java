package com.czxy.controller;

import com.czxy.domain.Borge;
import com.czxy.service.BorgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/8/1 10:32
 * @Description:
 */
@RestController
@RequestMapping("borge")
public class BorgeServlet {


    @Resource
    private BorgeService borgeService;



    @GetMapping("showAll")
    public ResponseEntity<List<Borge>> findAll(){

        List<Borge> all = null;
        try {
            all = borgeService.findAll();
            System.out.println("博客集合:"+all);

            return new ResponseEntity<>(all,HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
    //寻找热门文章
    @GetMapping("findHot")
    public ResponseEntity<List<Borge>> findHot(){


        try {
            List<Borge> hot = borgeService.findHot();
            System.out.println("热门博客集合:"+hot);
            return new ResponseEntity<>(hot,HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }

    @GetMapping("findAllInfo")
    public ResponseEntity<List<Borge>> findAllInfo(){

        try {
            List<Borge> infos = borgeService.findInfos();
            System.out.println("博客集合:"+infos);
            return new ResponseEntity<>(infos,HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
}