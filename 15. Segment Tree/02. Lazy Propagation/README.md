# Lazy Propagation in Segment Tree
 - Optimization to perform Range Updates in O(log n) time
 
## Idea:
Postpone the updates to descendants of a Node until the descendants themselves need to be accessed.

## implementation of Lazy-Update and Lazy-Sum queries
```java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        FileReader input = new FileReader("input.txt");
		// InputStreamReader input = new InputStreamReader(System.in);
        In in = new In(input);
        int n = in.ni();
        int[] ar = in.ia(n);
        SgT sgt = new SgT(ar, n);
        int q = in.ni();
        for (int i=0; i<q; i++) {
        	int qr = in.ni();
        	if (qr == 1) {
        		int res = sgt.getSum(in.ni(), in.ni());
        		System.out.println(res);
        	}
        	else if (qr == 2) {
        		int index = in.ni();
        		int diff = in.ni() - ar[index];
        		sgt.ru(index, index, diff);
        	}
        	else {
        		sgt.ru(in.ni(), in.ni(), in.ni());
        	}
        }
    }
}

class SgT {

	int[] ar; 
	int[] tr, lazy;
	int n, size;

	SgT (int[] ar, int n) {
		this.ar = ar;
		this.n = n;
		int x = (int) (Math.log(n) / Math.log(2)) + 1;
		this.size = (1 << (x+1)) + 1;
		this.tr = new int[size];
		this.lazy = new int[size];
		build(0, n-1, 0);
	}

	void build (int ss, int se, int si) {
		if (ss == se) {
			tr[si] = ar[ss];
			return ;
		}
		int mid = (ss + se) >> 1;
		build(ss, mid, (si << 1)+1);
		build(mid+1, se, (si << 1)+2);
		tr[si]= tr[(si << 1)+1] + tr[(si << 1)+2];
	}

	int getSum (int qs, int qe) {
		return getSumRec(qs, qe, 0, n-1, 0);
	}

	int getSumRec (int qs, int qe, int ss, int se, int si) {
		if (lazy[si] != 0) {
			int dx = lazy[si];
			lazy[si] = 0;
			tr[si] += (se - ss + 1)*dx;
			if (ss != se) {
				lazy[(si << 1) + 1] += dx;
				lazy[(si << 1) + 2] += dx;
			}
		}
		if (qs > se || qe < ss) {return 0;}
		if (qs <= ss && se <= qe) {return tr[si];}
		int mid = (ss + se) >> 1;
		return getSumRec(qs, qe, ss, mid, (si<<1)+1) + getSumRec(qs, qe, mid+1, se, (si<<1)+2);
	}

	void ru (int qs, int qe, int val) {
		ruRec(qs, qe, 0, n-1, 0, val);
	}

	void ruRec(int qs, int qe, int ss, int se, int si, int val) {
		if (lazy[si] != 0) {
			int dx = lazy[si];
			lazy[si] = 0;
			tr[si] += (se - ss + 1)*dx;
			if (ss != se) {
				lazy[(si << 1) + 1] += dx;
				lazy[(si << 1) + 2] += dx;
			}
		}
		if (qs > se || qe < ss) {return;}
		if (qs <= ss && se <= qe) {
			tr[si] += (se - ss + 1)*val;
			if (ss != se) {
				lazy[(si << 1) + 1] += val;
				lazy[(si << 1) + 2] += val;
			}
			return ;
		}
		int mid = (ss + se) >> 1;
		ruRec(qs, qe, ss, mid, (si << 1)+1, val);
		ruRec(qs, qe, mid+1, se, (si << 1)+2, val);
		tr[si] = tr[(si << 1)+1] + tr[(si << 1)+2];
	}
}
}
```

## input
```
6
1 2 3 4 5 6
8
1 2 3
1 0 5
1 3 3
2 4 8
1 0 5
3 0 3 5
1 2 5
1 3 3
```

## output
```
7
21
4
24
31
9
```
