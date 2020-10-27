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

void toposort (vector<int> *gr, int src, bool *vis, stack<int> &st)
{
	vis[src] = 1;
	for (int nbr : gr[src]) {
		if (!vis[nbr]) {
			toposort(gr, nbr, vis, st);
		}
	}
	st.push(src);
}

void dfs (vector<int> *g, int src, bool *vis, vector<int> &sc)
{
	vis[src] = 1;
	sc.pb(src);
	for (int nbr : g[src]) {
		if (!vis[nbr]) {
			dfs(g, nbr, vis, sc);
		}
	}
}

void kosaraju (vector<int> *gr, int n)
{
	bool vis[n + 1];
	memset(vis, 0, sizeof(vis));
	stack<int> st;
	fpr(i, 1, n) {
		if (!vis[i]) {
			toposort(gr, i, vis, st);
		}
	}
	vector<int> g[n + 1];
	fpr(i, 1, n) {
		for (int nbr : gr[i]) {
			g[nbr].pb(i);
		}
	}
	vector<vector<int>> scc;
	memset(vis, 0, sizeof(vis));
	while (!st.empty()) {
		int u = st.top();
		st.pop();
		if (!vis[u]) {
			vector<int> sc;
			dfs(g, u, vis, sc);
			scc.pb(sc);
		}
	}
	cout << "Total number of strongly connected components: " << scc.size() << "\n";
	fp(i, scc.size()) {
		vector<int> sc = scc[i];
		fp(j, sc.size()) {
			cout << sc[j] << " ";
		}
		cout << "\n";
	}
}

int main()
{
	fio();

#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	int n = 6;
	vector<int> gr[n + 1];

	gr[1].pb(2);
	gr[2].pb(5);
	gr[2].pb(3);
	gr[5].pb(6);
	gr[3].pb(4);
	gr[4].pb(1);

	kosaraju(gr, n);

	return 0;
}
