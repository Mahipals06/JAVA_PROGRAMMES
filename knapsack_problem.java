package new_start;

import java.util.*;

class item{
	int weight;
	int value;
	item(int w,int v){
		this.weight=w;
		this.value=v;
	}
}
public class Knapsack_problem {
	
	public static double knapsacksol(item[] items,int max_wt) {
		Arrays.sort(items,Comparator.comparingDouble((item i) ->(double)i.value/i.weight));//sorting on basis of value per unit weight
		double res=0;
		for(int i=items.length-1;i>=0;i--) {
			if(items[i].weight<=max_wt) {
				max_wt-=items[i].weight;
				res+=items[i].value;
			}
			else {
				double fraction=(double)max_wt/items[i].weight;
				res+=fraction*items[i].value;
				break;
			}
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		item[] items = {
	            new item(2, 30),    
	            new item(5, 70),
	            new item(10, 100),
	            new item(3, 40)
	        };
    /*
    here 4 items 1st wt=2kg val=30 val/wt=15
                 2nd wt=5kg val=70 val/wt=14
                 3rd wt=10kg val=100 val/wt=10
                 4th wt=3kg val=40 val/wt=13.33
                 so after sorting {{10,100},{3,40},{5,70},{2,30}}
                 starting from max 
                 val=30,capacity=16-2=14
                 val=30+70,capacity=14-5=9
                 val=100+40,capacity=9-3=6
                 val=140+10*6=200 capacity=0

                 final ans=200
    */

	        int capacity = 16;

	        double maxTotalValue = knapsacksol(items, capacity);
	        System.out.println("Maximum total value in the knapsack: " + maxTotalValue);
	    }
	}
