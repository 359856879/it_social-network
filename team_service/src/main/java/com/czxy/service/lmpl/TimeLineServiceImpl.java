package com.czxy.service.lmpl;

import com.czxy.dao.TimeLineMapper;
import com.czxy.domain.TimeLine;
import com.czxy.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TimeLineServiceImpl implements TimeLineService {

    @Autowired
    private TimeLineMapper timeLineMapper;

    /**
     * 通过id查询对应的事件
     * @param userIid
     * @return
     */
    @Override
    public List<TimeLine> findUserById(Integer userIid) {
        return timeLineMapper.findAll(userIid);
    }

    /**
     * 添加时间线对象
     * @param
     */
    @Override
    public void add(Integer userid,String info) {
        System.out.println("接收到的用户id ：       "+userid);
        System.out.println("接收到的用户信息 ：       "+info);
        //精确到时分秒的日期格式
        DateFormat df = DateFormat.getDateTimeInstance();

        TimeLine timeLine = new TimeLine();
        //赋值
        timeLine.setUserIid(userid);
        timeLine.setTimeline(df.format(new Date()));
        timeLine.setInfo(info);
        timeLineMapper.insert(timeLine);
    }

    /**
     * 根据时间线主键删除此条数据
     * @param timelineid
     */
    @Override
    public void delete(Integer timelineid) {
        timeLineMapper.deleteByPrimaryKey(timelineid);
    }


}
