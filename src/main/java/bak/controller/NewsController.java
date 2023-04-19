package bak.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import bak.dao.NewsDao;
import bak.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsDao newsDao;

    @PostMapping("/create")
    public boolean craete(@RequestBody News news){
        news.setTime(new Date());
        news.setFabu("待发");
        newsDao.insert(news);
        return true;
    }
    @GetMapping("/getAll")
    public List<News> getAll(){
        return newsDao.selectList(null);
    }
    @PostMapping("/upd")
    public boolean upd(@RequestBody News news){
        newsDao.updateById(news);
        return true;
    }
    @PostMapping("/chaxun1")
    public  List<News> chaxun1(@RequestBody News news){
        System.out.println("条件为---------------" + news.getTitle());
        LambdaQueryWrapper<News> qw = new LambdaQueryWrapper<>();
        qw.eq(News::getTitle, news.getTitle());
        List<News> list = newsDao.selectList(qw);
        return list;
    }
    @PostMapping("/chaxun2")
    public  List<News> chaxun2(@RequestBody News news){
        LambdaQueryWrapper<News> qw = new LambdaQueryWrapper<>();
        qw.eq(News::getName, news.getName());
        List<News> list = newsDao.selectList(qw);
        return list;
    }
    @PostMapping("/chaxun3")
    public  List<News> chaxun3(@RequestBody News news){
        System.out.println("条件为---------------" + news.getTitle());
        LambdaQueryWrapper<News> qw = new LambdaQueryWrapper<>();
        qw.eq(News::getContent, news.getContent());
        List<News> list = newsDao.selectList(qw);
        return list;
    }
    @PostMapping("/chaxun4")
    public  List<News> chaxun4(@RequestBody News news){
        System.out.println("条件为---------------" + news.getTitle());
        LambdaQueryWrapper<News> qw = new LambdaQueryWrapper<>();
        qw.eq(News::getLanmu, news.getLanmu());
        List<News> list = newsDao.selectList(qw);
        return list;
    }
    @DeleteMapping("/del/{id}")
    public boolean del(@PathVariable Integer id){
        newsDao.deleteById(id);
        return true;
    }

}
