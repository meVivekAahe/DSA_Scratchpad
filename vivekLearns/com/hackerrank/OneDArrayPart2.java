package vivekLearns.com.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



public class OneDArrayPart2 {
    //1st implementation
    public static boolean canReach(int[] arr, int m, int i) {
        if (i < 0 || arr[i] == 1) return false; // Out of bounds or already visited
        if (i >= arr.length - 1 || i + m >= arr.length) return true; // Win condition
    
        arr[i] = 1; // Mark as visited
        return canReach(arr, m, i + m) || canReach(arr, m, i + 1) || canReach(arr, m, i - 1);
    }
//2nd implementation
    public static boolean canWin(int leap, int[] game) {
        int n = game.length;
        boolean[] visited = new boolean[n]; 
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (i >= n - 1 || i + leap >= n) return true; // Win condition

            // Mark as visited
            visited[i] = true;

            // Explore neighbors
            if (i + leap < n && !visited[i + leap] && game[i + leap] == 0) queue.add(i + leap);
            if (i + 1 < n && !visited[i + 1] && game[i + 1] == 0) queue.add(i + 1);
            if (i - 1 >= 0 && !visited[i - 1] && game[i - 1] == 0) queue.add(i - 1);
        }

        return false;
    }

    //3rd approach
    public static boolean canWin3(int leap, int[] game) {
        return canWinFromPosition(0, leap, game);
    }
    
    private static boolean canWinFromPosition(int i, int leap, int[] game) {
        // Base cases
        if (i >= game.length) {
            return true; // Win by reaching or jumping beyond the end.
        }
        if (i < 0 || game[i] == 1) {
            return false; // Out of bounds or blocked cell.
        }
    
        // Mark position as visited
        game[i] = 1;
    
        // Explore possible moves:
        // 1. Move forward
        // 2. Move backward
        // 3. Jump forward
        return canWinFromPosition(i + 1, leap, game) || 
               canWinFromPosition(i - 1, leap, game) || 
               canWinFromPosition(i + leap, leap, game);
    }
    //4th approach 
    public static boolean canWin4(int leap, int[] game) {
    int n = game.length;
    Stack<Integer> stack = new Stack<>();
    stack.push(0); // Start at the first index

    while (!stack.isEmpty()) {
        int pos = stack.pop();

        if (pos >= n) {
            return true; // Win by reaching or jumping beyond the array
        }

        if (pos < 0 || game[pos] == 1) {
            continue; // Ignore invalid or visited positions
        }

        // Mark as visited
        game[pos] = 1;

        // Explore possible moves
        stack.push(pos + 1); // Move forward
        stack.push(pos - 1); // Move backward
        stack.push(pos + leap); // Jump forward
    }

    return false; // No valid path found
}



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println(canWin(leap, game) ? "YES" : "NO");
        }
        scan.close();
    }
}


