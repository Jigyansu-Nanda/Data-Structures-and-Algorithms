# Z - Algorithm for Pattern Matching
The core of the algorithm is:
  - function **Z(k): longest substring starting at k which is also prefix of the string**
  - Example: for string `aabxaayaab`, Z(0 1 2 3 4 5 6 7 8 9) = (0 1 0 0 2 1 0 3 1 0)
  
## Naive implementation of Z - array:
```java
static void zArray(String s) {
		int n = s.length();
		int[] z = new int[n];
		for (int i=1; i<n; i++) {
			while (i+z[i] < n && s.charAt(i+z[i]) == s.charAt(z[i])) {
				++z[i];
			}
		}
}
```

## Efficient implementation of Z - array:
```java
static void zArray(String s) {
		int n = s.length();
		int[] z = new int[n];
		for (int i=1, l=0, r=0; i<n; i++) {
			if (i <= r) {
				z[i] = Math.min(z[i-l], r-i+1);
			}
			while (i+z[i] < n && s.charAt(z[i]) == s.charAt(i+z[i])) {
				++z[i];
			}
			if (i+z[i]-1 > r) {
				l = i;
				r = i+z[i]-1;
			}
		}
}
```

## Applications of Z - Algorithm
  - Pattern Searching
  - Number of Distinct Substrings in a String
  - String Compression
  
## Pattern Searching using Z - Algorithm
```java
static void SearchPattern(String txt, String pat) {
		String s = pat + "$" + txt;
		int[] z = new int[s.length()];
		for (int i=1,l=0,r=0; i<s.length(); i++) {
			if (i <= r) {
				z[i] = Math.min(z[i-l], r-i+1);
			}
			while (i+z[i] < s.length() && s.charAt(i+z[i]) == s.charAt(z[i])) {
				++z[i];
			}
			if (i+z[i]-1 > r) {
				l = i;
				r = i+z[i]-1;
			}
		}
		ArrayList<Integer> occ = new ArrayList<Integer>();
		for (int i=pat.length(); i<s.length(); i++) {
			if (z[i] == pat.length()) {
				occ.add(i-pat.length()-1);
			}
		}
		if (occ.size() == 0) {
			System.out.println("NOT FOUND !!");
		}
		else {
			for (int x: occ) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
}
```
