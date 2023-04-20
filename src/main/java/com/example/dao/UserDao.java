package com.example.dao;

import com.example.domain.Medicine;
import com.example.domain.Patient;
import com.example.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {
    //查找出已经申请挂号的患者，医生执行挂号功能
    @Select("select * from registration where apply=#{apply}")
    public List<User> getList(String status);












}
