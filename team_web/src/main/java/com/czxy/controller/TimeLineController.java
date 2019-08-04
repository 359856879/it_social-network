package com.czxy.controller;

import com.czxy.domain.TimeLine;
import com.czxy.domain.User;
import com.czxy.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("timeline")
@SuppressWarnings("all")
public class TimeLineController {


    @Autowired
    private TimeLineService timeLineService;


    /**
     * 添加时间线对象到数据库
     * @param timeLine
     * @return
     */
//    @PostMapping("/add")
//    public ResponseEntity<Void> add(HttpSession session,String info){
////        //精确到时分秒的日期格式
////        DateFormat df = DateFormat.getDateTimeInstance();
//
//        User user = (User) session.getAttribute("user");
//        if (user != null){
//           timeLineService.add(user.getUserid());
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }


    /**
     * 查询当前登陆用户所有的行为
     * @param session
     * @return
     */
    @GetMapping("findUserById")
    public ResponseEntity<List<TimeLine>> findUserById(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){
            List<TimeLine> timeLines = timeLineService.findUserById(user.getUserid());

            return ResponseEntity.ok(timeLines);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 根据主键删除此条数据
     * @param timelineid
     * @return
     */
    @DeleteMapping("/{timelineid}")
    public ResponseEntity<Void> delete(@PathVariable("timelineid") Integer timelineid){
        System.out.println(timelineid);
        try {
            timeLineService.delete(timelineid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
