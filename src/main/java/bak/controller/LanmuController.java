package bak.controller;

import bak.dao.LanmuDao;
import bak.domain.Lanmu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/lanmu")
public class LanmuController {
    @Autowired
    LanmuDao lanmuDao ;

    @GetMapping("/getAll")
    public List<Lanmu> getAll(){
        List<Lanmu> lanmus = lanmuDao.selectList(null);


        System.out.println(lanmus);
        return lanmus;
    }
    @PostMapping("/upd")
    public boolean upd(@RequestBody Lanmu lanmu){
        lanmuDao.updateById(lanmu);
        return true;
    }
    @GetMapping("/hebing")
    public boolean hebing(@PathParam("id1") Integer id1, @PathParam("id2") Integer id2, @PathParam("ming") String ming){
//        System.out.println(id1);
//        System.out.println(id2);
//        System.out.println(ming);
        lanmuDao.deleteById(id1);
        lanmuDao.deleteById(id2);
        Lanmu lanmu = new Lanmu();

        lanmu.setLanmuming(ming);
        lanmuDao.insert(lanmu);
        return true;
    }

}
