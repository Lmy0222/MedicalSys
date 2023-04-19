package bak.subwayUtil;

import bak.domain.Stopinfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SearchUtil {

    public static List<String> searchNoInOneLine(List<Stopinfo> allStop, String stop1, String stop2){
        System.out.println(allStop);
        // 创建所有线路列表
        List<Line> lines = new ArrayList<>();
        for (Stopinfo stopinfo : allStop) {
            int flag = 0;
            for (Line line : lines) {
                if (line.getLineName().equals(stopinfo.getLineName())){
                    line.getStations().add(stopinfo.getStopName());
                    flag = 1;
                }
            }
            if (flag == 0){
                Line line = new Line();
                line.setLineName(stopinfo.getLineName());
                line.getStations().add(stopinfo.getStopName());
                lines.add(line);
            }
        }
        System.out.println("\n\n\n\nlog\n\n\n");
        for (Line line : lines) {
            System.out.println(line.getLineName());
            for (String station : line.getStations()) {
                System.out.print(station + " ");
            }

        }
// 存储所有站点
        List<String> allStations = new ArrayList<>();
        for (Line line : lines) {
            allStations.addAll(line.getStations());
        }
        // 去重
        HashSet hashSet = new HashSet(allStations);
        allStations = new ArrayList<>(hashSet);

        Subway subway = new Subway(allStations);

        // 添加线路图中的边
        for (Line item : lines) {
            List<String> line = item.getStations();
            if (item.getLineName().equals("10号线"))
                subway.relation(line.get(0), line.get(line.size()-1));
            for (int i = 0; i < line.size()-1; i++) {
                subway.relation(line.get(i), line.get(i+1));
            }
        }

        Floyd floyd = new Floyd(subway.getSubwayMatrix());
        subway.setPath(floyd.getPath());
        System.out.println("\n\n\n"+stop1+"   "+stop2+"\n\n\n");
        List<Integer> path = floyd.printPath(subway.getSite(stop1), subway.getSite(stop2));
        List<String> pathName = new ArrayList<>();
        for (Integer idx : path) {
            pathName.add(subway.getName(idx));
        }

        return pathName;
    }

}
