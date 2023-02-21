import java.util.LinkedList;

public class day02_offer30 {
    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(46);
        minStack.push(46);
        minStack.push(47);
        System.out.println(minStack.top());
        minStack.pop();

        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        minStack.push(47);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.push(-48);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
class MinStack {

    int arr1[]=new int[20000];
    int arr2[]=new int[20000];
    int top=-1;
    int top2=-1;




    /** initialize your data structure here. */
    public MinStack() {


    }

    public void push(int x) {
        arr1[++top]=x;
        if(top2==-1) {
            arr2[++top2]=x;
            return;
        }
        if(arr1[top]<=arr2[top2]){
            arr2[++top2]=arr1[top];
        }
    }

    public void pop() {
        if(arr2[top2]==arr1[top]){
            top2--;
        }
        top--;

    }

    public int top() {
        return arr1[top];
    }

    public int min() {
        return arr2[top2];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */