package bak.util;

import bak.domain.Connectinfo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GrapUtil {
    static int n = 49;// 点数
    static int e;// 边数
    static int G[][];// 领接矩阵
    static int dis[];// 路径 dis[i] = j, 默认1到节点i最短路径j
    static int path[];// 记录路线
    public static int[][] listToGrap(List<Connectinfo> list){
        int[][] g = new int[51][51];
//        for (int i = 0; i <= 50; i++)
//            for (int j = 0; j <= 50; j++)
//                g[i][j] = Integer.MAX_VALUE;
        for (Connectinfo connectinfo : list) {
            g[connectinfo.getLine1()][connectinfo.getLine2()] = 1;
            g[connectinfo.getLine2()][connectinfo.getLine1()] = 1;
        }
        return g;
    }

    public static void Bfs(int u){
        path[u] = -1;// 起点
        // 源点 初始化为访问过
        dis[u] = 0;
        Queue<Integer> qu = new LinkedList<Integer>();// 队列
        qu.offer(u);// 添加源点进入
        while(!qu.isEmpty()){
            u = qu.poll();// 弹出最早的
            // 以u点扩散
            for(int i = 1; i <= n; i++){
				/*
				dis[i] == -1：代表是否访问过
				因为无权图，边权值默认为1，不用判断出现的节点k使，节点i到节点j的长度 > 节点i到节点k + 节点k到节点j的长度
				G[u][i] == 1，点u到点i存在路径
				*/
                if(dis[i] == -1 && G[u][i] == 1){
                    // 更新路径：为源点到点u的路径+1，因为无权图，只需+1
                    dis[i] = dis[u] + 1;
                    // 记录路径
                    path[i] = u;
                    // 添加到队列中
                    qu.offer(i);
                }
            }
        }
    }
    // 打印路径
    public static void printPath(int u){
        // 如果是-1代表到达起点
        if(path[u] == -1){
            System.out.print("路径："+u+"->");
        }else{
            // 上一层
            printPath(path[u]);
            // 递归结束，打印路径
            System.out.print(u+"->");
        }
    }


    public static void main(String[] args) {
        dis = new int[51];
        path = new int[51];
        G = new int[51][51];
        G[1][4] = G[4][1] = 1;
        G[1][2] = G[2][1] = 1;
        G[4][2] = G[2][4] = 1;
        G[2][3] = G[3][2] = 1;


        Bfs(4);
        printPath(2);
    }

}
