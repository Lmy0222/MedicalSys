package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Medicine;
import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicineDao extends BaseMapper<MedicineDao> {
    //根据type对药物进行模糊查询，实现药物的分类展示
    @Select("select * from medicine where type like concat('%',#{type},'%')")
    List<Medicine> getMedicineByType(String type);
}
