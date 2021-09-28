#include <iostream>

using namespace std;

int nums[100010];

int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> nums[i];
    }
    long long minNum, maxNum, result = 0;
    for (int i = 1; i < n; i++) {
        minNum = nums[i];
        maxNum = nums[i];
        for (int j = i+1; j <= n; j++) {
            if (nums[j] > maxNum) {
                maxNum = nums[j];
            } else if (nums[j] < minNum) {
                minNum = nums[j];
            }
            if (minNum * maxNum > result) {
                result = minNum * maxNum;
            }
        }
    }
    cout << result;
    return 0;
}
