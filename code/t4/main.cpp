#include <iostream>

using namespace std;

int a[15], b[15], n;

bool flag;

void dfs(int cnt) {
    if (flag) {
        return;
    }
    if (cnt == n) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (b[i] - b[j] == a[n-1] || b[j] - b[i] == a[n-1]) {
                    flag = true;
                }
            }
        }
        return;
    }
    for (int i = 0; i < cnt; i++) {
        b[cnt] = b[i] + a[cnt-1];
        dfs(cnt+1);
        b[cnt] = b[i] - a[cnt-1];
        dfs(cnt+1);
    }
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        if (a[i] < 0) {
            a[i] = -a[i];
        }
    }
    b[0] = 0;
    dfs(1);
    if (flag) {
        cout << "yes" << endl;
    } else {
        cout << "no" << endl;
    }
    return 0;
}
