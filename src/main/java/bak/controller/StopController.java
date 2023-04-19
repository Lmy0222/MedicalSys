package bak.controller;

import bak.domain.Stopinfo;
import bak.util.StopUtil;
import bak.dao.ConnectInfoDao;
import bak.dao.StopInfoDao;
import bak.subwayUtil.SearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stops")
public class StopController {
    @Autowired
    StopInfoDao stopInfoDao;
    @Autowired
    ConnectInfoDao connectInfoDao;

    @GetMapping("/getOneLine")
    public int getOneLine(@PathParam("stop1") String stop1, @PathParam("stop2") String stop2){
        StopUtil stopUtil = new StopUtil(stopInfoDao, connectInfoDao);
         return stopUtil.selectOneLine(stop1, stop2);
    }
    @GetMapping("/getIsUnion")
    public int getIsUnion(@PathParam("stop1") String stop1, @PathParam("stop2") String stop2){
        StopUtil stopUtil = new StopUtil(stopInfoDao, connectInfoDao);
        return stopUtil.selectIsUnion(stop1, stop2);
    }
    @GetMapping("/lineSearch")
    public List<Stopinfo> lineSearch(@PathParam("line") String line){
        List<Stopinfo> temp = stopInfoDao.selectList(null);
        List<Stopinfo> list = new ArrayList<>();
        for (Stopinfo stopinfo : temp) {
            if (stopinfo.getLineName().equals(line)){
                list.add(stopinfo);
            }
        }
        return list;

    }
    @GetMapping("/stopSearch")
    public List<Stopinfo> stopSearch(@PathParam("stop") String stop){
        List<Stopinfo> temp = stopInfoDao.selectList(null);
        List<Stopinfo> list = new ArrayList<>();
        for (Stopinfo stopinfo : temp) {
            if (stopinfo.getStopName().equals(stop)){
                list.add(stopinfo);
            }
        }
        return list;
    }
    @GetMapping("/searchOntInOneLine")
    public List<String> searchOntInOneLine(@PathParam("stop1") String stop1,@PathParam("stop2") String stop2){
        System.out.println("\n\n\ncontroller" + stop1);

        List<Stopinfo> allStops = stopInfoDao.selectList(null);
        List<String> path = SearchUtil.searchNoInOneLine(allStops, stop1, stop2);
        return path;
    }
    @PostMapping("/getLine")
    public List<String> getLine(@RequestBody ArrayList<String> paths){
        List<String> stopInLine = new ArrayList<>();
        List<Stopinfo> allStops = stopInfoDao.selectList(null);
        for (String stopName : paths) {
            for (Stopinfo allStop : allStops) {
                if (stopName.equals(allStop.getStopName())){
                    stopInLine.add(allStop.getLineName());
                    break;
                }
            }
        }

        return stopInLine;
    }




}
