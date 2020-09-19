### Problem statement
**Given a boolean matrix (consisting of 0s and 1s), count number of distinct rows in it.**

#### input
```
First line contains an integer T (number of testcases).
First line of each testcase contains two integer m, n denoting number of rows and columns.
Next i lines (1 to m) contain n integers denoting elements of the i-th row.
```

#### sample input
```
3
4 3
1 0 0
1 1 1
1 0 0
0 1 0
4 3
1 0 0
1 1 1
1 0 0
1 1 1
4 4
1 1 0 0
1 1 0 0
1 1 0 0
1 1 0 0
```

#### sample output
```
3
2
1
```

### code
```java
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main {

    static class Node {
        Node[] child = new Node[2];
    }

    static boolean insert(Node root, int[][] mat, int r, int col) {
        Node curr = root;
        boolean flag = false;
        for (int c=0; c<col; c++) {
            int index = mat[r][c];
            if (curr.child[index] == null) {
                flag = true;
                curr.child[index] = new Node();
            }
            curr = curr.child[index];
        }
        return flag;
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] nums = br.readLine().trim().split(" ");
            int row = Integer.parseInt(nums[0]);
            int col = Integer.parseInt(nums[1]);
            int[][] mat = new int[row][col];
            for (int i=0; i<row; i++) {
                nums = br.readLine().trim().split(" ");
                for (int j=0; j<col; j++) {
                    mat[i][j] = Integer.parseInt(nums[j]);
                }
            }
            Node root = new Node();
            int res = 0;
            for (int i=0; i<row; i++) {
                if (insert(root, mat, i, col)) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
```
