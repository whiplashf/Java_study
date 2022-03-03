package com.gxf;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseOnChessBoard {
    private static int X = 6; // col 为什么反过来呢，因为在坐标(x,y)中，图里的x对应数组的列
    private static int Y = 6; // row
    private static int[][] chess = new int[Y][X]; // 棋盘用于存放走过的路径
    private static boolean[][] visited = new boolean[Y][X];
    private static boolean finished = false;

    public static void main(String[] args) {
//        System.out.println(visited[0][0]);
        int x = 2;
        int y = 2;
        long start = System.currentTimeMillis();
        running(chess, x - 1, y - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - start));

        for (int[] row : chess) {
            for (int n : row) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    // 递归走棋
    public static void running(int[][] chessBoard, int x, int y, int step) {
        chessBoard[y][x] = step; // y x !!!
        Point p = new Point(x, y);
        visited[y][x] = true;
        ArrayList<Point> availPos = next(p);
        sort(availPos);
        while (!availPos.isEmpty()) {
            Point np = availPos.remove(0);
            if (!visited[np.y][np.x]) {
                running(chessBoard, np.x, np.y, step + 1);
            }
        }

        if (step < X * Y && !finished) {
            chessBoard[y][x] = 0;
            visited[y][x] = false;
        } else {
            finished = true;
        }

    }

    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }
    // 寻找下一步能去的坐标 的函数
    public static ArrayList<Point> next(Point p) {
        Point np = new Point();
        ArrayList<Point> list = new ArrayList<>();

        // 左上上
        if (((np.x = p.x - 1) >= 0) && ((np.y = p.y - 2) >= 0)) {
            if (true) {
                list.add(new Point(np));
            }
        }
        // 左上下
        if (((np.x = p.x - 2) >= 0) && ((np.y = p.y - 1) >= 0)) {
            if (true) {
                list.add(new Point(np));
            }
        }
        // 左下上
        if (((np.x = p.x - 2) >= 0) && ((np.y = p.y + 1) < Y)) {
            if (true) {
                list.add(new Point(np));
            }
        }
        // 左下下
        if (((np.x = p.x - 1) >= 0) && ((np.y = p.y + 2) < Y)) {
            if (true) {
                list.add(new Point(np));
            }
        }
        // 右上上
        if (((np.x = p.x + 1) < X) && ((np.y = p.y - 2) >= 0)) {
            if (true) {
                list.add(new Point(np));
            }
        }
        // 右上下
        if (((np.x = p.x + 2) < X) && ((np.y = p.y - 1) >= 0)) {
            if (true) {
                list.add(new Point(np));
            }
        }
        // 右下上
        if (((np.x = p.x + 2) < X) && ((np.y = p.y + 1) < Y)) {
            if (true) {
                list.add(new Point(np));
            }
        }
        // 右下下
        if (((np.x = p.x + 1) < X) && ((np.y = p.y + 2) < Y)) {
            if (true) {
                list.add(new Point(np));
            }
        }
        return list;
    }
}

