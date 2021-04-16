#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

// Recursive approach
int maxProfit(vector<int> arr,int i){
    if(i==0) return arr[0];
    if(i==1) return max(arr[0],arr[1]);
    return max(maxProfit(arr, i-2)+arr[i],maxProfit(arr, i-1));
}
// Memoization
int maxProfitTd(vector<int> arr,unordered_map<int,int> memo,int i){
    if(memo.find(i)!=memo.end())
        return memo.at(i);
    else if (i==0) return arr[0];
    else if (i==1) return max(arr[0],arr[1]);
    else 
        memo[i]=max(maxProfitTd(arr,memo,i-2)+arr[i],maxProfitTd(arr,memo,i-1));
    return memo.at(i);
    
}
//Buttom Up approach
int maxProfitBu(vector<int> arr){
    int n=arr.size();
    vector<int> dp(n,0);
    dp[0]=arr[0];
    dp[1]=max(arr[0],arr[1]);
    for(int i=2;i<n;i++){
        dp[i]=max(dp[i-2]+arr[i],dp[i-1]);
    }
    return dp[n-1];

}

int main(){
    vector<int> arr{2,7,9,3,1};
    int n=arr.size();
    unordered_map<int,int> memo;
    // cout<<maxProfitTd(arr,memo,n);
    cout<< maxProfitBu(arr);
}