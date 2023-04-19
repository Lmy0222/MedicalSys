package bak.domain;

import lombok.Data;

import java.util.Date;

@Data
public class News {
    int id;
    String title;
    String name;
    String content;
    Date time;
    String lanmu;
    String sug;
    String pinglun;
    String fabu;
}
