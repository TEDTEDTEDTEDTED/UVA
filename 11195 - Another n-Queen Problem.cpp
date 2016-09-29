#include <bits/stdc++.h>
#define FOR(x,y) for (int x = 0 ; x < y ; ++ x)
#define FOR1(x,y,z) for (int x = y ; x < z ; ++ x)
#define FOR2(x,y,z) for (int x = y ; x >= z ; -- x)
#define pb(x) push_back(x)
#define clr(x,y) memset (x , y , sizeof(x))
#define omar cout<<"omar"<<endl;
#define tr1(x) cout << x << endl;
#define tr2(x , y) cout << x << " " << y <<  endl;
#define SSTR( x ) static_cast< std::ostringstream & >( \
        ( std::ostringstream() << std::dec << x ) ).str()
#define fast 	ios_base::sync_with_stdio(0); cin.tie(0);
#define inp freopen("input.txt", "r", stdin);
#define out freopen("output.txt", "w", stdout);
using namespace std;

typedef long long ll;

string arr[16];
bitset<16> row;
bitset<80> ld;
bitset<80> rd;
int n ;
ll cnt ;
void solve (int col) {
	if (col == n) {cnt ++ ; return ;}
	FOR (i , n) if (arr[i][col] == '.' && !row[i] && !rd[i - col + 50] && !ld[i + col]) {
		row[i] = rd[i - col + 50] = ld[i + col] = 1;
		solve (col + 1);
		row[i] = rd[i - col + 50] = ld[i + col] = 0;
	}
}
int main() {

	fast
	int tt = 1;
	while ((cin >> n) && (n)) {
		FOR (i , n) cin >> arr[i] ;
		cnt = 0 ;
		row.reset();
		rd.reset();
		ld.reset();
		solve (0) ;
		cout << "Case " << tt++ << ": " << cnt << "\n";
	}

	return 0;
}
