package com.czxy.service;

import com.czxy.domain.Borge;

import java.util.List;

/**
 * @version v 1.0
 * @date 2019/8/1
 */
public interface BorgeService {



    public List<Borge> findAll();

    public List<Borge> findHot();


    public List<Borge> findAllInfo();

    public List<Borge> findInfos();


    public void addDis(Integer bid,Integer uid,String info);

}
