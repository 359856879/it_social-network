package com.czxy.controller;

import com.czxy.domain.LEmailreceive;
import com.czxy.domain.LEmailsend;
import com.czxy.domain.User;
import com.czxy.service.LEmailreceiveService;
import com.czxy.service.LEmailsendService;
import com.czxy.service.TimeLineService;
import com.czxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("LER")
public class LEmailController {

    @Autowired
    private LEmailreceiveService lEmailreceiveService;

    @Autowired
    private LEmailsendService lEmailsendService;

    @Autowired
    private UserService userService;

    @Resource
    private TimeLineService timeLineService;

    /**
     * 查询所有  接受邮件列表
     * @return
     */
    @GetMapping("findAllLER")
    public ResponseEntity<List<LEmailreceive>> findAllLER(HttpServletRequest request){

            User user = (User) request.getSession().getAttribute("user");

            if(user != null) {
                List<LEmailreceive> allLER = lEmailreceiveService.findAllLER(user.getUserid());


                return new ResponseEntity<>(allLER,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }




    /**
     * 查询 已发送 邮件
     * @param request
     * @return
     */
    @GetMapping("findLERS/{receiveemailstatus}")
    public ResponseEntity<List<LEmailreceive>> findLERSByDraft(@PathVariable("receiveemailstatus") Integer receiveemailstatus , HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");

        if(user != null) {

            if(receiveemailstatus == 1) {
                List<LEmailreceive> allLER = lEmailreceiveService.findAllLERByStatus(user.getUserid(), 1);
                return new ResponseEntity<>(allLER,HttpStatus.OK);
            }

            if(receiveemailstatus == 2){
                List<LEmailreceive> allLER = lEmailreceiveService.findAllLERByStatus(user.getUserid(), 2);
                return new ResponseEntity<>(allLER,HttpStatus.OK);
            }

            if(receiveemailstatus == 3){
                List<LEmailreceive> allLER = lEmailreceiveService.findAllLERByStatus(user.getUserid(), 3);
                return new ResponseEntity<>(allLER,HttpStatus.OK);
            }


            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    /**
     *
     * 查询  所有 邮件 个数
     * @return
     */
    @GetMapping("findLERCount")
    public ResponseEntity<Integer> findLERCount(HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");


        if(user != null){

            Integer lerCount = lEmailreceiveService.findLERCount(user.getUserid());

            return new ResponseEntity<>(lerCount,HttpStatus.OK);
        }else{

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    /**
     * 查询  接受 草案 邮件  个数
     * @param request
     * @return
     */
    @GetMapping("findLERDrCount")
    public ResponseEntity<Integer> findLERDrCount(HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");


        if(user != null){

                Integer lerCount = lEmailreceiveService.findLERDrCount(user.getUserid());
                return new ResponseEntity<>(lerCount,HttpStatus.OK);

        }else{

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    /**
     * 查询  接受 已发送 邮件  个数
     * @param request
     * @return
     */
    @GetMapping("findLERSeCount")
    public ResponseEntity<Integer> findLERSeCount(HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");


        if(user != null){

            Integer lerCount = lEmailreceiveService.findLERSeCount(user.getUserid());

            return new ResponseEntity<>(lerCount,HttpStatus.OK);
        }else{

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }








    /**
     * 直接发送邮件  到用户
     */
    @PostMapping("addLERBySend")
    public ResponseEntity<Void> addLERBySend(LEmailsend lEmailsend,HttpServletRequest request){

        //通过用户邮箱查找用户
        User user = userService.findUserByMail(lEmailsend.getSendusermail());
        //获取存到session域中的用户
        User loginU = (User) request.getSession().getAttribute("user");
        LEmailsend loginLEmailsend = new LEmailsend();

        if(user != null){

            //邮件当时的显示状态:  0 收件箱   1 草稿 , 2 已发送 , 3 垃圾
            //数据库生成两条数据  一条发送到对方用户的邮箱
            lEmailsend.setSendemailstatus(0);
            lEmailsend.setSendemaildate(new Date());
            lEmailsend.setSenduserid(user.getUserid());
            lEmailsendService.addLES(lEmailsend);



            //一条发送到当前用户的 发送列表中
            loginLEmailsend.setSendemaildate(new Date());
            loginLEmailsend.setSendemailstatus(2);
            loginLEmailsend.setSendemailcontent(lEmailsend.getSendemailcontent());
            loginLEmailsend.setSenduserid(loginU.getUserid());
            loginLEmailsend.setSendmailsubject(lEmailsend.getSendmailsubject());
            loginLEmailsend.setSendusermail(loginU.getUseremail());
            lEmailsendService.addLES(loginLEmailsend);

            //将信息加入时间线
         timeLineService.add(loginU.getUserid(),"You send an email!");


            //将信息 存入 接受邮件库中
            List<LEmailsend> les = lEmailsendService.findLES();

            for (LEmailsend le : les) {
                if(le.getSendemailstatus() == 0){
                    if(Integer.toString(le.getSenduserid()).equals(Integer.toString(user.getUserid()))){

                        LEmailreceive lEmailreceive = new LEmailreceive();
                        lEmailreceive.setReceiveemailcontent(le.getSendemailcontent());
                        lEmailreceive.setReceiveemailstatus(le.getSendemailstatus());
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        String format = df.format(le.getSendemaildate());
                        lEmailreceive.setReceiveemaildate(format);
                        lEmailreceive.setReceiveusermail(le.getSendusermail());
                        lEmailreceive.setReceiveuserid(le.getSenduserid());
                        lEmailreceiveService.addLER(lEmailreceive);
                    }
                }else if(le.getSendemailstatus() == 2){

                    if(Integer.toString(le.getSenduserid()).equals(Integer.toString(loginU.getUserid()))){

                        LEmailreceive lEmailreceive = new LEmailreceive();
                        lEmailreceive.setReceiveemailcontent(le.getSendemailcontent());
                        lEmailreceive.setReceiveemailstatus(le.getSendemailstatus());
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        String format = df.format(le.getSendemaildate());
                        lEmailreceive.setReceiveemaildate(format);
                        lEmailreceive.setReceiveusermail(le.getSendusermail());
                        lEmailreceive.setReceiveuserid(le.getSenduserid());
                        lEmailreceiveService.addLER(lEmailreceive);
                    }
                }
            }


                         lEmailsendService.deleteLES();


            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    /**
     *  发送邮件  到 草稿中
     * @param lEmailsend
     * @return
     */
    @PostMapping("addLESBySave")
    public ResponseEntity<Void> addLESBySave(LEmailsend lEmailsend , HttpServletRequest request){

        //获取存到session域中的用户
        User loginU = (User) request.getSession().getAttribute("user");

        //通过用户邮箱查找用户
        User user = userService.findUserByMail(lEmailsend.getSendusermail());
        if(user == null) {
            timeLineService.add(loginU.getUserid(),"You saved an email to the draft box!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



        if(loginU != null) {


                        LEmailreceive lEmailreceive = new LEmailreceive();
                        lEmailreceive.setReceiveemailcontent(lEmailsend.getSendemailcontent());
                        lEmailreceive.setReceiveemailstatus(1);
                        Date d = new Date();
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        String format = df.format(d);
                        lEmailreceive.setReceiveemaildate(format);
                        lEmailreceive.setReceiveusermail(lEmailsend.getSendusermail());
                        lEmailreceive.setReceiveuserid(loginU.getUserid());
                        lEmailreceiveService.addLER(lEmailreceive);


            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





    /**
     * 删除
     * @param param
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity<Void> deleteLER(@RequestBody List<String> param,HttpServletRequest request){

        //获取域中的对象
        User user = (User) request.getSession().getAttribute("user");

        try {

            for (String s : param) {

                lEmailreceiveService.update(Integer.parseInt(s));

            }
            timeLineService.add(user.getUserid(),"You deleted an email!");

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
