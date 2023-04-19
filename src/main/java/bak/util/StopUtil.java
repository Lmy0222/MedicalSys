package bak.util;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import bak.dao.ConnectInfoDao;
import bak.dao.StopInfoDao;
import bak.domain.Connectinfo;
import bak.domain.Stopinfo;

import java.util.List;

public class StopUtil {
    StopInfoDao stopInfoDao;
    ConnectInfoDao connectInfoDao;
    List<Stopinfo> stopInfo;
    List<Connectinfo> connectInfo;

    public StopUtil(StopInfoDao stopInfoDao, ConnectInfoDao connectInfoDao) {
        this.stopInfoDao = stopInfoDao;
        this.connectInfoDao = connectInfoDao;
        stopInfo = stopInfoDao.selectList(null);
        connectInfo = connectInfoDao.selectList(null);
    }

    // 查询在一条线路上的站点间距离
    public int selectOneLine(String stop1, String stop2) {
        int stop_id1 = 0, stop_id2 = 0;
        for (int i = 0; i < stopInfo.size(); i++) {
            if (stop1.equals(stopInfo.get(i).getStopName())) {
                stop_id1 = stopInfo.get(i).getStopId();
                break;
            }
        }
        for (int i = 0; i < stopInfo.size(); i++) {
            if (stop2.equals(stopInfo.get(i).getStopName())) {
                stop_id2 = stopInfo.get(i).getStopId();
                break;
            }
        }
        System.out.println("\n\n\n" + stopInfo + "\n\n\n");
        return Math.abs(stop_id1 - stop_id2);
    }

    // 查询两个不在一个线路但相交的站点的距离
    public int selectIsUnion(String stop1, String stop2) {

        String midStop = getUnionStop(stop1, stop2);
//        System.out.println(midStop);
        // stop1到mid距离, mid到stop2距离
        int len1 = 0, len2 = 0;
//        //
        int stop_id1 = 0, stop_id2 = 0;
        // stop1 和 stop2 所在的线路
        int line1 = 0, line2 = 0;

        for (int i = 0; i < stopInfo.size(); i++) {
            if (stop1.equals(stopInfo.get(i).getStopName())) {
                stop_id1 = stopInfo.get(i).getStopId();
                line1 = stopInfo.get(i).getLineId();
                break;
            }
        }
        for (int i = 0; i < stopInfo.size(); i++) {
            if (stop2.equals(stopInfo.get(i).getStopName())) {
                stop_id2 = stopInfo.get(i).getStopId();
                line2 = stopInfo.get(i).getLineId();
                break;
            }
        }
        for (int i = 0; i < stopInfo.size(); i++) {
            if (midStop.equals(stopInfo.get(i).getStopName()) && line1 == stopInfo.get(i).getLineId()) {
                len1 = Math.abs(stopInfo.get(i).getStopId() - stop_id1);
                break;
            }
        }
        for (int i = 0; i < stopInfo.size(); i++) {
            if (midStop.equals(stopInfo.get(i).getStopName()) && line2 == stopInfo.get(i).getLineId()) {
                len2 = Math.abs(stopInfo.get(i).getStopId() - stop_id2);
                break;
            }
        }

        return len1 + len2;
    }

    // 查询两个不在一个线路但相交的站点的相交站
    public String getUnionStop(String stop1, String stop2) {

        // stop1 和 stop2 所在的线路
        int line1 = 0, line2 = 0;
        for (int i = 0; i < stopInfo.size(); i++) {
            if (stop1.equals(stopInfo.get(i).getStopName())) {
                line1 = stopInfo.get(i).getLineId();
                break;
            }
        }
        for (int i = 0; i < stopInfo.size(); i++) {
            if (stop2.equals(stopInfo.get(i).getStopName())) {
                line2 = stopInfo.get(i).getLineId();
                break;
            }
        }
        LambdaQueryWrapper<Connectinfo> qw = new LambdaQueryWrapper<>();
        qw.eq(Connectinfo::getLine1, line1);
        qw.eq(Connectinfo::getLine2, line2);
        Connectinfo connectinfo = connectInfoDao.selectOne(qw);
//        System.out.println(connectinfo);

//        System.out.println(connectinfo.getStopName());


        return connectinfo.getStopName();
    }

    public int selectNotUnion(String stop1, String stop2) {


        return 0;
    }

//    public static void main(String[] args) {
//        StopUtil stopUtil = new StopUtil();
//        stopUtil.init();
//        System.out.println(stopUtil.selectOneLine("苹果园", "古城"));
//
//    }


}
