package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface PatientDao extends BaseMapper<Patient> {
    //根据id修改申请挂号的状态
    @Update("update registration set apply where id=#{id}")
    boolean updateApplyById(int id);

    //医生开药，将药品名称逗号分隔，将useMedicine暂无修改为药品数组
    @Update("update registration set useMedicine where id=#{id}")
    boolean updateUseMedicineById(int id);

    //患者申请挂号，将信息存储到registration库里面
    @Insert("insert into registration values(#{id},#{name},#{sex},#{age},#{apply},#{symptom},#{status},#{result},#{suggestion},#{saying},#{date},#{useMedicine},#{plan})")
    boolean insertRegistration(Patient patient);

    //患者查看自己现在的排名，预估大概的排队时长
    @Select("select * from registration where id<#{id} and apply=#{apply} and status=#{status}")
    int getCountById(int id,String apply,String status);

    //患者查看自己的检查结果
    @Select("select result from registration where id=#{id}")
    String getResultById(int id);

    //患者查看医生建议
    @Select("select suggestion from registration where id=#{id}")
    String getSuggestionById(int id);

    //患者评论
    @Update("update registration set saying where id=#{id}")
    boolean updateSayingById(int id);

    //患者查看自己的使用药方
    @Select("select userMedicine from registration where id=#{id}")
    String getUseMedicineById(int id);

    //医生为患者提供建议
    @Update("update registration set suggestion where id=#{id}")
    boolean updateSuggestionById(int id);

    //医生为患者制定治疗计划
    @Update("update registration set plan where id=#{id}")
    boolean updatePlanById(int id);

    //医生利用身份证号的唯一性进行查询
    @Select("select * from registration where idCard=#{idCard}")
    List<Patient> getHistoryByIdCard(String idCard);
}
