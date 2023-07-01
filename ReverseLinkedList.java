public void reverse() {
		Node current,prev,next;
		current=head;
		prev=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	} 
