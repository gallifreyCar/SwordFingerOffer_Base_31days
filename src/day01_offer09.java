import java.util.LinkedList;

public class day01_offer09 {
    public static void main(String[] args) {
        CQueue cQueue=new CQueue();
        cQueue.deleteHead();
        cQueue.deleteHead();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

    }
}
class CQueue {
    int[] arr1=new int[10000];
    int[]arr2=new int[10000];
    int top1=-1;
    int top2=-1;



    public CQueue() {

    }

    public void appendTail(int value) {
        arr1[++top1]=value;

    }

    public int deleteHead() {
        if(top2<=-1&&top1<=-1){
            return -1;
        }

        if(top2<=-1){
            while(top1>-1){
                arr2[++top2]=arr1[top1--];
            }
        }
        return arr2[top2--];

    }
}
