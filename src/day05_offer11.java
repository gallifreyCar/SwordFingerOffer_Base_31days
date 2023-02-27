class Solution11 {
    //迭代法
    public int minArray(int[] numbers) {
        int i = 0;
        if (numbers.length == 1) {
            return numbers[0];
        }
        while (i + 1 < numbers.length) {
            if (numbers[i] > numbers[++i]) {
                return numbers[i];
            }
        }

        return numbers[0];
    }

    //二分法
    public int minArray2(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (numbers[r] < numbers[mid]) {
                l = mid + 1;
            } else if (numbers[r] > numbers[mid]) {
                r = mid;
            } else {
                r--;
            }
        }
        return numbers[l];
    }
}

public class day05_offer11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int arr[] = {3, 4, 5, 5, 1, 2, 2};
        System.out.println(solution11.minArray(arr));
        System.out.println(solution11.minArray2(arr));
    }
}
