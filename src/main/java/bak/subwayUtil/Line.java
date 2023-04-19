package bak.subwayUtil;

import java.util.ArrayList;
import java.util.List;

public class Line {


    private String lineName;                              //存储站点所在线路名
    private List<String> stations = new ArrayList<>();      //存储线路内所有站点名

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }
    @Override
    public String toString() {
        return "Station{" +
                "stationNum='" + lineName + '\'' +
                ", stations=" + stations +
                '}';
    }
}
