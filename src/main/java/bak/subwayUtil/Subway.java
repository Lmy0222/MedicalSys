package bak.subwayUtil;

import java.util.List;

public class Subway {
    private int[][] subwayMatrix;           //存储地铁线路
    private List<String> stationName;       //存储所有站点名
    private int[][] path;                   //存储两站点间路径
    private static final int max = 99999;   //最大距离，两站点间不可达


    //初始化地铁线路图
    public Subway(List<String> stationName){
        System.out.println("\n\n\n\n" + stationName.size() + "\n\n\n\n");
        this.stationName = stationName;
        this.subwayMatrix = new int[stationName.size()][stationName.size()];
        this.path = new int[stationName.size()][stationName.size()];
        for(int i = 0; i < stationName.size(); i++){
            for(int j = 0; j < stationName.size(); j++){
                if(i == j)
                    subwayMatrix[i][j] = 0;
                else {
                    subwayMatrix[i][j] = max;
                    subwayMatrix[j][i] = max;
                }
            }
        }
    }

    public int getSite(String station){
        return stationName.indexOf(station);
    }

    public String getName(int site){
        return stationName.get(site);
    }


    //初始化相邻地铁站之间距离为1
    public void relation(String start, String end){
        int i = getSite(start);
        int j = getSite(end);
        this.subwayMatrix[i][j] = 1;
        this.subwayMatrix[j][i] = 1;
    }

    public int[][] getSubwayMatrix() {
        return subwayMatrix;
    }

    public void setSubwayMatrix(int[][] subwayMatrix) {
        this.subwayMatrix = subwayMatrix;
    }

    public List<String> getStationName() {
        return stationName;
    }

    public void setStationName(List<String> stationName) {
        this.stationName = stationName;
    }

    public int[][] getPath() {
        return path;
    }

    public void setPath(int[][] path) {
        this.path = path;
    }

    public static int getMax() {
        return max;
    }

}
