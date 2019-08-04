package com.czxy.service.lmpl;

import com.czxy.dao.BorgeMapper;
import com.czxy.dao.DiscussMapper;
import com.czxy.dao.UserMapper;
import com.czxy.domain.Borge;
import com.czxy.domain.Discuss;
import com.czxy.service.BorgeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/8/1 10:34
 * @Description:
 */
@Service
@Transactional
public class BorgeServicelmpl implements BorgeService{

    @Resource
    private BorgeMapper borgeMapper;

    @Resource
    private DiscussMapper discussMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<Borge> findAll() {

        List<Borge> borges = borgeMapper.selectAll();

        return borges;

    }

    @Override
    public List<Borge> findHot() {

        List<Borge> hots = borgeMapper.findHots();

        return hots;

    }

    @Override
    public List<Borge> findAllInfo() {

//        List<Borge> borges = borgeMapper.selectAll();
//
//
//        //给每个博客赋值--评论集合
//        for (Borge borge : borges) {
//
//            //先调用方法判断当前博客有几级评论
//            Integer level = discussMapper.checkLevel(borge.getBorgeid());
//
//            //查出所有的一级评论
//            List<Discuss> all = discussMapper.findAll(1, 0, borge.getBorgeid());
//
//            if (level==0){
//                break;
//            }
//
//
//            for (Discuss discuss : all) {
//                discuss.setUser(userMapper.selectByPrimaryKey(discuss.getUserid()));
//            }
//
//
//            //定义一个集合,保存当前遍历博客下所对应的完整评论集合
//            List<Discuss> save=new ArrayList<>();
//
//            //遍历二级评论
//            //定义一个变量表示的是每一级评论对应的上一级评论集合
//
//            List<Discuss> list=all;
//            //新建一个集合,用来保存每次需要遍历的评论对象
//            List<Discuss> load=new ArrayList<>();
//
//            for (int le = 2; le < level; le++) {
//
//                for (Discuss discuss : list) {
//                    //获取到每一个评论下对应的user对象
//                    User user = discuss.getUser();
//
//                    List<Discuss> low = discussMapper.findAll(le, user.getUserid(), borge.getBorgeid());
//
//                    //在当前评论下已经不存在下一级评论,直接跳过当前评论对象
//                    if (low.size()==0){
//                        break;
//
//                    }else{
//                        //在当前评论下存在下一级评论
//                        for (Discuss discuss1 : low) {
//                            discuss1.setUser(userMapper.selectByPrimaryKey(discuss1.getUserid()));
//                            load.add(discuss1);
//
//                        }
//                        user.setDiscusses(low);
//                        //把第二层评论赋值给上一级之后
//                    }
//
//                }
//                //把load的值赋值给新的遍历对象list
//                list=load;
//                System.out.println(list);
//                //把load数据清除
//                load.clear();
//
//
//            }
//
//        }

        return null;

    }

    @Override
    public List<Borge> findInfos() {

        List<Borge> borges = borgeMapper.selectAll();

        for (Borge borge : borges) {

            //找到每个博客下的评论集合
            List<Discuss> all = discussMapper.findAll(1, 0, borge.getBorgeid());

            for (Discuss discuss : all) {
                //为每个评论对象赋值User实体类对象
                discuss.setUser(userMapper.selectByPrimaryKey(discuss.getUserid()));
            }
            borge.setList(all);
        }

        return borges;
    }

    @Override
    public void addDis(Integer bid,Integer uid,String info) {

        //新建一个评论对象
        Discuss discuss = new Discuss();
        discuss.setUserid(uid);
        discuss.setUpuserid(0);
        discuss.setDiscusslevel(1);
        discuss.setTodiscussid(bid);
        discuss.setDiscusstime(new Date());
        discuss.setDiscussmsg(info);

        //调用工程方法,完成信息的提交
        discussMapper.insert(discuss);


    }

    @Override
    public Borge FindBorge(Integer id) {

        Borge borge = borgeMapper.selectByPrimaryKey(id);
        return borge;

    }

    @Override
    public void updateBorge(Borge borge) {

        borgeMapper.updateByPrimaryKey(borge);
        System.out.println("更新成功！");
    }



}