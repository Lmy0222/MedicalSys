package bak.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Offdoc {
    int id;
    String title;
    String name;
    String bumen;
    String content;
    String suggestion1; // 副厂长意见
    String suggestion2; // 厂长意见
    String postion; // 部门,办公室,厂长，副厂长
    Date time;
    String msg;
}
