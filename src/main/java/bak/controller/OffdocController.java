package bak.controller;


import bak.dao.OffdocDao;
import bak.domain.Offdoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/offdocs")
public class OffdocController {

    @Autowired
    private OffdocDao offdocDao;

    /**
     * 添加 addOff
     * 删除 delOff
     * 修改 updOff
     * 修改 getOffId getOffAll getOffWhere
     */

    @PostMapping("/addOff")
    public int addOff(@RequestBody Offdoc offdoc){
        offdoc.setTime(new Date());
        offdoc.setPostion("办公室");
        return offdocDao.insert(offdoc);
    }
    @GetMapping("/delOff/{id}")
    public int delOff(@PathVariable int id){
        return offdocDao.deleteById(id);
    }
    @PostMapping("/updOff")
    public int updOff(@RequestBody Offdoc offdoc){
        return offdocDao.updateById(offdoc);
    }
    @GetMapping("/getOffId/{id}")
    public Offdoc getOffId(@PathVariable int id){
        return offdocDao.selectById(id);
    }
    @GetMapping("/getOffAll")
    public List<Offdoc> getOffAll(){
        return offdocDao.selectList(null);
    }

}
