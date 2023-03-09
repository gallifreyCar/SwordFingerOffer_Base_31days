
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 */
class MedianFinder {

    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> small;//小顶堆存较大的数据
    PriorityQueue<Integer> big;//大顶堆存较小的数据

    public MedianFinder() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (small.size() != big.size()) {
            small.add(num);
            big.add(small.poll());
        } else {
            big.add(num);
            small.add(big.poll());
        }

    }

    public double findMedian() {
        if (big.size() == small.size()) return (big.peek() + small.peek()) / 2.0;
        else return small.peek();
    }
}

public class day17_offer41 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());

    }
}