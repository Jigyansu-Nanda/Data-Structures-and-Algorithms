#include <bits/stdc++.h>
using namespace std;
#define ll	long long
#define pb	push_back
#define mp	make_pair
#define pii	pair<int, int>
#define fp(i, n)	for (int i = 0; i < (int) n; i++)
#define fpr(i, a, b)	for (int i = (int) a; i <= (int) b; i++)

void fio()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

void solve (vector<pii> *gr, int n)
{
	bool mst[n + 1];
	memset(mst, 0, sizeof(mst));
	priority_queue<pii, vector<pii>, greater<pii>> pq;
	pq.push(mp(0, 1));
	int res = 0;
	while (!pq.empty()) {
		auto curr = pq.top();
		pq.pop();
		if (mst[curr.second]) {continue;}
		mst[curr.second] = 1;
		res += curr.first;
		for (auto nbr : gr[curr.second]) {
			if (mst[nbr.first] == false) {
				pq.push(mp(nbr.second, nbr.first));
			}
		}
	}
	cout << res;
}

int main()
{
	fio();

#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	int n, m, a, b, w;
	cin >> n >> m;
	vector<pii> gr[n + 1];
	fp(i, m) {
		cin >> a >> b >> w;
		gr[a].pb(mp(b, w));
		gr[b].pb(mp(a, w));
	}
	solve(gr, n);

	return 0;
}
