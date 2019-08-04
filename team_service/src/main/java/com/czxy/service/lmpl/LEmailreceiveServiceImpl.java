package com.czxy.service.lmpl;

import com.czxy.dao.LEmailreceiveMapper;
import com.czxy.domain.LEmailreceive;
import com.czxy.service.LEmailreceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LEmailreceiveServiceImpl implements LEmailreceiveService {

    @Autowired
    private LEmailreceiveMapper lEmailreceiveMapper;

    /**
     * 查询所有 接收邮件
     * @return
     */
    @Override
    public List<LEmailreceive> findAllLER(Integer receiveuserid) {

        List<LEmailreceive> allLER = lEmailreceiveMapper.findAllLER(receiveuserid);

        return allLER;
    }


    /**
     * 查询  接受邮件  个数
     * @return
     */
    @Override
    public Integer findLERCount(Integer receiveuserid) {

        Integer lerCount = lEmailreceiveMapper.findLERInCount(receiveuserid);

        return lerCount;
    }




    /**
     * 查询  接受 草案 邮件  个数
     * @return
     */
    @Override
    public Integer findLERDrCount(Integer receiveuserid) {

        Integer lerCount = lEmailreceiveMapper.findLERDrCount(receiveuserid);

        return lerCount;
    }



    /**
     * 查询  接受 已发送 邮件  个数
     * @return
     */
    @Override
    public Integer findLERSeCount(Integer receiveuserid) {

        Integer lerCount = lEmailreceiveMapper.findLERSeCount(receiveuserid);

        return lerCount;
    }
//
//
//
//    /**
//     * 查询  接受 垃圾  邮件  个数
//     * @return
//     */
//    @Override
//    public Integer findLERTrCount(Integer receiveuserid) {
//
//        Integer lerCount = lEmailreceiveMapper.findLERTrCount(receiveuserid);
//
//        return lerCount;
//    }


    /**
     * 添加 接受邮件
     * @param lEmailreceive
     */
    @Override
    public void addLER(LEmailreceive lEmailreceive) {

        lEmailreceiveMapper.insert(lEmailreceive);
    }



    /**
     * 根据状态 查询  接收邮件
     * @param receiveuserid
     * @param receiveemailstatus
     * @return
     */
    @Override
    public List<LEmailreceive> findAllLERByStatus(Integer receiveuserid, Integer receiveemailstatus) {

        List<LEmailreceive> allLERByStatus = lEmailreceiveMapper.findAllLERByStatus(receiveuserid, receiveemailstatus);

        return allLERByStatus;
    }



    /**
     * 修改邮件状态值
     * @param receiveemailid
     */
    @Override
    public void update(Integer receiveemailid) {

        lEmailreceiveMapper.updateStatus(receiveemailid);
    }
}
