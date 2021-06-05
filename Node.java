package FinalProject;

public class Node {
	private Item item;
	private Node next;

	public Node(Item item, Node next) {
		this.item = item;
		this.next = next;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
