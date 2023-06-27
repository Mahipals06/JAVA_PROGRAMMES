import java.util.*;
class Stack_Queue{
	Queue<Integer> q1;
	Queue<Integer> q2;
	Stack_Queue(){
		q1=new LinkedList<>();
		q2=new LinkedList<>();
	}
	void push(int n){
		while(!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		q1.add(n);
		while(!q2.isEmpty()) {
			q1.add(q2.remove());
		}
	}
	int pop() {
		return q1.remove();
	}
	boolean isEmpty() {
		return q1.isEmpty();
	}
	int size() {
		return q1.size();
	}
}

public class Stack_Using_Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack_Queue sq=new Stack_Queue();
		sq.push(5);
		sq.push(7);
		sq.push(9);
		while(!sq.isEmpty())
		System.out.println(sq.pop()+" "+sq.size());
	}

}
