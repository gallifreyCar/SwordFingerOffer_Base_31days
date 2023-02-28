class Solution10II {

    //跳楼梯问题 跳n阶级=跳n-1阶+跳n-2阶
    //f(n)=f(n-1)+f(n-2)
    //求多种可能性的题目一般具有递推性质：f(n)和f(n-1)....f(1)有关
    public int numWays(int n) {
        int arr[] = new int[101];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        return arr[n];
    }
}

public class day08_offer10II {
    public static void main(String[] args) {
        Solution10II solution10II = new Solution10II();
        System.out.println(solution10II.numWays(10));
    }
}
