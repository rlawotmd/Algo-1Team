package week_9.rlawotmd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_아이템줍기 {
    static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[] nx = {0, 1, 0, -1};
        int[] ny = {1, 0, -1, 0};

        int[][] map = new int[51 * 2 + 1][51 * 2 + 1];
        boolean[][] v = new boolean[51 * 2][51 * 2];
        for (int i = 0; i < rectangle.length; i++) {
            for (int x = rectangle[i][0] * 2; x <= rectangle[i][2] * 2; x++) {
                map[rectangle[i][1] * 2][x] = 1;
                map[rectangle[i][3] * 2][x] = 1;
            }

            for (int y = rectangle[i][1] * 2; y <= rectangle[i][3] * 2; y++) {
                map[y][rectangle[i][0] * 2] = 1;
                map[y][rectangle[i][2] * 2] = 1;
            }
        }
//        System.out.println("=====================================================================");
//
//        for (int[] ints : map) {
//            System.out.println(Arrays.toString(ints));
//        }
//
//        System.out.println("=====================================================================");
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX * 2, characterY * 2});
        v[characterY * 2][characterX * 2] = true;
        map[characterY * 2][characterX * 2] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int x = cur[0];
            int y = cur[1];
            if (x == itemX * 2 && y == itemY * 2) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ax = x + nx[i];
                int ay = y + ny[i];
                if (ax < 2 || ay < 2 || ax > 51 * 2 || ay > 51 * 2) continue;
                if (v[ay][ax] || map[ay][ax] == 0) continue;
                boolean c = true;
                for (int[] ints : rectangle) {
                    if (ax > ints[0] * 2 && ax < ints[2] * 2 && ay > ints[1] * 2 && ay < ints[3] * 2) {
                        c = false;
                        break;
                    }
                }
                if (c) {
                    map[ay][ax] = map[y][x] + 1;
                    q.add(new int[]{ax, ay});
                    v[ay][ax] = true;
                }
            }
        }

        answer = map[itemY * 2][itemX * 2];

        return answer / 2;
    }

    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // 17

        rectangle = new int[][] {{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}};
        characterX = 9;
        characterY = 7;
        itemX = 6;
        itemY = 1;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // 11

        rectangle = new int[][] {{1, 1, 5, 7}};
        characterX = 1;
        characterY = 1;
        itemX = 4;
        itemY = 7;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // 9

        rectangle = new int[][] {{2, 1, 7, 5}, {6, 4, 10, 10}};
        characterX = 3;
        characterY = 1;
        itemX = 7;
        itemY = 10;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // 15

        rectangle = new int[][] {{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}};
        characterX = 1;
        characterY = 4;
        itemX = 6;
        itemY = 3;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY)); // 10
    }
}
