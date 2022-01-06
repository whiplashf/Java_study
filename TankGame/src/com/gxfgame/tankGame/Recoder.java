package com.gxfgame.tankGame;

/*
    Author: Whiplash
    Date: 2021/12/27 21:53
    记录击毁坦克树，并在关闭窗口时导出enemyTank的位置方向信息。
*/

import java.io.*;
import java.util.Vector;

public class Recoder {

    private static int DeadEnemyTankNum = 0;
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordPath = "F:\\JAVA_FILE\\IDEA_File\\TankGame\\src\\com\\gxfgame\\tankGame\\MyRecord.txt";
    private static Vector<EnemyTank> enemyTanks = null;
    private static Vector<Node> nodes = new Vector<>(); // null的话没有办法add

    public static String getRecordPath() {
        return recordPath;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recoder.enemyTanks = enemyTanks;
    }

    public static int getDeadEnemyTankNum() {
        return DeadEnemyTankNum;
    }

    public static void add() {
        DeadEnemyTankNum++;
    }

    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordPath));
            bw.write(DeadEnemyTankNum + "\r\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isAlive) {
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                    bw.write(record + "\r\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vector<Node> getNodes() {
        try {
            br = new BufferedReader(new FileReader(recordPath)); // 没有判断文件是否存在
            DeadEnemyTankNum = Integer.parseInt(br.readLine());
            //循环读取文件，生成nodes 集合
            String line = "";//255 40 0
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]),
                        Integer.parseInt(xyd[2]));
                nodes.add(node);//放入nodes Vector
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return nodes;

    }

}
