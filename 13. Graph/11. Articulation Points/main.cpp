#include <bits/stdc++.h>
using namespace std;
#define ll	long long
#define pb	push_back
#define mp	make_pair
#define fp(i, n)	for (int i = 0; i < (int) n; i++)
#define fpr(i, a, b)	for (int i = (int) a; i <= (int) b; i++)

void fio()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

int timer = 0;
vector<int> points;

void dfs (vector<int> *gr, int src, int par, int *disc, int *low)
{
	disc[src] = low[src] = ++timer;
	int children = 0;
	for (int adj : gr[src]) {
		if (adj == par) {continue;}
		if (disc[adj] != -1) {
			low[src] = min(low[src], disc[adj]);
		}
		else {
			children++;
			dfs(gr, adj, src, disc, low);
			low[src] = min(low[src], low[adj]);
			if (children > 1 && par == -1) {
				points.pb(src);
			}
			if (par != -1 && low[adj] >= disc[src]) {
				points.pb(src);
			}
		}
	}
}

void artnPoints (vector<int> *gr, int n)
{
	int disc[n];
	memset(disc, -1, sizeof(disc));
	int low[n];
	fp(i, n) {
		if (disc[i] == -1) {
			dfs(gr, i, -1, disc, low);
		}
	}
	cout << "Articulation Points:" << "\n";
	for (auto x : points) {
		cout << x << "\n";
	}
}


int main()
{
	fio();

#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	int n = 5;
	vector<int> gr[n];

	gr[0].pb(1);
	gr[1].pb(0);
	gr[0].pb(2);
	gr[2].pb(0);
	gr[2].pb(1);
	gr[1].pb(2);
	gr[0].pb(3);
	gr[3].pb(0);
	gr[3].pb(4);
	gr[4].pb(3);

	artnPoints(gr, n);

	return 0;
}
