package com.joonseolee.enc;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class CodingTest {
    @Test
    void hello() {
        int[][] grid = {{1,0,0}, {0,0,0}, {0,0,0}};
        int result = maxDistance(grid);

        System.out.println(result);
    }

    private int[] locationX = {0, 1, -1, 0};
    private int[] locationY = {1, 0, 0, -1};

    public int maxDistance(int[][] grid) {
        Stack<Location> stack = new Stack<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    stack.add(new Location(i, j, -1));
                }
            }
        }

        bfs(stack, grid);

        int min = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                min = Math.min(min, grid[i][j]);
            }
        }

        if (min == 0) {
            return -1;
        }

        return min * -1;
    }

    private void bfs(Stack<Location> stack, int[][] grid) {
        while (!stack.isEmpty()) {
            Location location = stack.pop();

            for (int k = 0; k < 4; k++) {
                int moveX = locationX[k] + location.x;
                int moveY = locationY[k] + location.y;

                if (moveX > -1 && moveX < grid.length && moveY > -1 && moveY < grid[0].length) {
                    if (grid[moveX][moveY] == 0 || grid[moveX][moveY] < location.distance) {
                        grid[moveX][moveY] = location.distance;
                        stack.add(new Location(moveX, moveY, location.distance - 1));
                    }
                }
            }
        }
    }

    public class Location {
        int x;
        int y;
        int distance;

        public Location(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
