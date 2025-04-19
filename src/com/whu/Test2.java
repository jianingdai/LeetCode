package com.whu;

import java.awt.geom.CubicCurve2D;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
//        地铁线路的条数n
        int N = sc.nextInt();
        List<List<String>> lines = new ArrayList<>();
        Map<String, List<Integer>> stationToLines = new HashMap<>();
//        读取线路并且建立站点-线路的映射
        for (int i = 0; i < N; i++) {
            String[] stations = sc.nextLine().split(" ");
            List<String> line = Arrays.asList(stations);
            lines.add(line);
            for (String s : stations) {
                stationToLines.putIfAbsent(s, new ArrayList<>());
                stationToLines.get(s).add(i);
            }
        }
        String[] input = sc.nextLine().split(" ");
        String start = input[0];
        String end = input[1];

//        先判断起点终点是否可达
        if (!stationToLines.containsKey(start)) {
            System.out.println("NA");
            return;
        }
//        BFS
        Queue<State> queue = new LinkedList<>();
        Map<String, Map<Integer, Integer>> visited = new HashMap<>();
//        将起点所在的所有线路加入队列
        for (int lineId : stationToLines.get(start)) {
            List<String> path = new ArrayList<>();
            path.add(start);
            State initState = new State(start, lineId, 0, path);
            queue.add(initState);
            visited.putIfAbsent(start, new HashMap<>());
            visited.get(start).put(lineId, 0);
        }
        String resultPath = null;
        int minTransfers = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            State current = queue.poll();

//            到达终点构建输出
            if (current.station.equals(end)) {
                List<String> fullPath = new ArrayList<>(current.path);
                fullPath.add(end);
                resultPath = String.join("-", fullPath);
                minTransfers = current.transfers;
                break;
            }
//            处理当前线路的所有站点
            List<String> lineStations = lines.get(current.line);
            for (String s : lineStations) {
                if (s.equals(current.station)) {
                    continue;
                }
                if (visited.containsKey(s) && visited.get(s).getOrDefault(current.line, Integer.MAX_VALUE) <= current.transfers) {
                    continue;
                }
//                更新访问记录
                if (!visited.containsKey(s)) {
                    visited.put(s, new HashMap<>());
                }
                visited.get(s).put(current.line, current.transfers);
//                创建新状态，路径不变
                State newState = new State(s, current.line, current.transfers, current.path);
                queue.add(newState);
            }

//            处理换乘其他线路
            for (int newLine : stationToLines.get(current.station)) {
                if (newLine == current.line) {
                    continue;
                }
                int newTransfers = current.transfers + 1;
//                构造新路径
                List<String> newPath = new ArrayList<>(current.path);
                newPath.add(current.station);
//                检查是否是访问过更优的状态
                if (visited.containsKey(current.station) && visited.get(current.station).getOrDefault(newLine, Integer.MAX_VALUE) <= newTransfers) {
                    continue;
                }
//              更新访问记录
                if(!visited.containsKey(current.station)) {
                    visited.put(current.station, new HashMap<>());
                }
                visited.get(current.station).put(newLine, newTransfers);
//                创建新状态
                State newState = new State(current.station, newLine, newTransfers, newPath);
                queue.add(newState);
            }
        }
        if(resultPath != null) {
            System.out.println(resultPath);
            System.out.println(2+minTransfers);
        }
        else {
            System.out.println("NA");
        }
    }

    static class State {
        String station;
        int line;
        int transfers;
        List<String> path;

        public State(String station, int line, int transfers, List<String> path) {
            this.station = station;
            this.line = line;
            this.transfers = transfers;
            this.path = new ArrayList<>(path);
        }
    }
}
