package com.czxy.service.lmpl;

import com.czxy.dao.BorgekeyMapper;
import com.czxy.domain.Borgekey;
import com.czxy.service.BorgekeyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/8/1 14:18
 * @Description:
 */
@Service
@Transactional
public class BorgekeyServicelmpl implements BorgekeyService {

    @Resource
    private BorgekeyMapper borgekeyMapper;


    @Override
    public List<Borgekey> findAll() {
        List<Borgekey> borgekeys = borgekeyMapper.selectAll();

        return borgekeys;
    }
}