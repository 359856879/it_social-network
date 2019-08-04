package com.czxy.service.lmpl;

import com.czxy.dao.LEmailsendMapper;
import com.czxy.domain.LEmailsend;
import com.czxy.service.LEmailsendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LEmailsendServiceImpl implements LEmailsendService {

    @Autowired
    private LEmailsendMapper lEmailsendMapper;


    /**
     * 添加  发送的邮件
     * @param lEmailsend
     */
    @Override
    public void addLES(LEmailsend lEmailsend) {

        lEmailsendMapper.insert(lEmailsend);
    }




    /**
     * 查询所有   发送邮件
     * @return
     */
    @Override
    public List<LEmailsend> findLES() {

        List<LEmailsend> lEmailsends = lEmailsendMapper.selectAll();

        return lEmailsends;
    }


    /**
     * 删除  发送的邮件
     * @param
     */
    @Override
    public void deleteLES() {

        lEmailsendMapper.deleteLES();
    }
}
