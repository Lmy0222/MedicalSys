package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("registration")
public class Patient {
    Integer id;
    String name;
    String sex;
    Integer age;
    String apply;//申请挂号状态
    String g;//挂号状态
    String symptom;//相关症状
    String status;//就诊状态
    String result;//检查结果
    String suggestion;//医生建议
    String saying;//患者评论
    String date;//当前日期--年月日
    String useMedicine;//患者用药
    String plan;//治疗计划

    String idCard;//患者身份证号，用于历史查询
}
