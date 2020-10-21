# Rabin Karp Algorithm

### Problem statement:
Given two strings - a pattern `pat` and text `txt`, determine if the pattern appears in the text and if it does, enumerate all its occurrences in `O(|txt|+|pat|)` time.

### sample input
```
3
AbcdkghKfabdkre
dk
aaaaa
aaa
abcabcd
abd
```

### code
```java
static void RabinKarp (String txt, String pat) {
		int t = txt.length();
		int p = pat.length();
		long pw = 31;
		long mod = (long) 1e9 + 9;

		long[] pow = new long[Math.max(t, p) + 1];
		pow[0] = 1;
		for (int i=1; i<pow.length; i++) {
			pow[i] = (pow[i-1] * pw)%mod;
		}

		long[] ht = new long[t+1];
		for (int i=0; i<t; i++) {
			ht[i+1] = (ht[i] + (txt.charAt(i) - 'a' + 1)*pow[i])%mod;
		}
		long hs = 0;
		for (int i=0; i<p; i++) {
			hs = (hs + (pat.charAt(i) - 'a' + 1)*pow[i])%mod;
		}
		ArrayList<Integer> occ = new ArrayList<Integer>();
		for (int i=0; i+p-1 < t; i++) {
			long curr = (ht[i+p] + mod - ht[i]) % mod;
			if (curr == (hs * pow[i]) % mod) {
				occ.add(i);
			}
		}
		if (occ.size() == 0) {
			System.out.println("NOT FOUND !!!");
		}
		else {
			for (int x: occ) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
  ```
  
### output
```
3 11 
0 1 2 
NOT FOUND !!!
```
