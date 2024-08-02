#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 计算最多两笔交易的最大利润
int maxProfit(vector<int>& prices) {
    if (prices.empty()) return 0;

    int n = prices.size();
    // 创建一个二维数组，dp[i][k] 表示在第 i 天进行 k 次交易的最大利润
    vector<vector<int>> dp(n, vector<int>(3, 0));

    for (int k = 1; k <= 2; ++k) {
        int min_price = prices[0];
        for (int i = 1; i < n; ++i) {
            // 更新 min_price 为在第 k 次交易前的最低价格
            min_price = min(min_price, prices[i] - dp[i-1][k-1]);
            // 计算在第 i 天进行 k 次交易的最大利润
            dp[i][k] = max(dp[i-1][k], prices[i] - min_price);
        }
    }

    return dp[n-1][2]; // 返回在最后一天最多进行两次交易的最大利润
}

int main() {
    vector<int> prices;
    int n, price;
    cout << "输入价格的数量: ";
    cin >> n;
    cout << "输入股票价格: ";
    for (int i = 0; i < n; ++i) {
        cin >> price;
        prices.push_back(price);
    }

    int result = maxProfit(prices);
    cout << "最多可以完成两笔交易的最大利润为: " << result << endl;

    return 0;
}