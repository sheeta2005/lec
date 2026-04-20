package com.sheeta1998.lec.lc2751;

import java.util.*;

class Solution {
    // 封装机器人信息
    static class Robot implements Comparable<Robot> {
        int pos;
        int health;
        char dir;
        int index; // 原编号（1开始）

        public Robot(int pos, int health, char dir, int index) {
            this.pos = pos;
            this.health = health;
            this.dir = dir;
            this.index = index;
        }

        // 按位置升序排序
        @Override
        public int compareTo(Robot o) {
            return Integer.compare(this.pos, o.pos);
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        // 初始化机器人信息
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i + 1);
        }
        // 按位置从小到大排序
        Arrays.sort(robots);

        Deque<Robot> stack = new ArrayDeque<>();
        for (Robot curr : robots) {
            // 循环处理碰撞
            while (true) {
                // 无碰撞可能：栈空/当前向右/栈顶向左，直接入栈
                if (stack.isEmpty() || curr.dir == 'R' || stack.peek().dir == 'L') {
                    stack.push(curr);
                    break;
                }
                // 碰撞逻辑：栈顶向右(R)，当前向左(L)，相向而行
                Robot top = stack.pop();
                if (top.health > curr.health) {
                    // 栈顶存活，健康度-1
                    top.health--;
                    stack.push(top);
                    break;
                } else if (top.health < curr.health) {
                    // 当前机器人存活，健康度-1，继续和下一个栈顶碰撞
                    curr.health--;
                } else {
                    // 健康度相同，双双销毁，结束碰撞
                    break;
                }
            }
        }

        // 按原编号升序排序，提取健康度
        List<Robot> survived = new ArrayList<>(stack);
        survived.sort(Comparator.comparingInt(a -> a.index));
        List<Integer> res = new ArrayList<>();
        for (Robot r : survived) {
            res.add(r.health);
        }
        return res;
    }
}