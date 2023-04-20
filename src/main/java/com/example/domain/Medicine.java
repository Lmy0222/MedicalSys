package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("medicine")
public class Medicine {
    Integer id;
    String name;
    String type;

}
