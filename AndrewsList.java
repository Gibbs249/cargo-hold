package FinalProject;

public class AndrewsList {
	private Node start, tail;

	public void add(Item item) {
		if (start == null) {
			start = new Node(item, null);
			tail = start;
		} else {
			tail.setNext(new Node(item, null));
			tail = tail.getNext();
		}
	}

	public int size() {
		int count = 0;
		Node p = start;
		while (p != null) {
			p = p.getNext();
			count++;
		}
		return count;
	}

	public Item get(int i) {
		int count = 0;
		Node p = start;
		while (p != null) {
			if(count == i) {
				return p.getItem();
			}
			p = p.getNext();
			count++;
		}
		return null;
	}
	
	public int getTotal() {
		int total = 0;
		Node p = start;
		while (p != null) {
			total += p.getItem().getIntWeight();
			p = p.getNext();
		}
		return total;
	}

	public boolean remove(String strItem) {
		Node prev = null, del = start;
		while (del != null && !del.getItem().getStrName().equals(strItem)) {
			prev = del;
			del = del.getNext();
		}
		if (del == null) {
			return false;
		} else {
			if (del == start) {
				start = start.getNext();
			} else {
				if (del == tail) {
					tail = prev;
				}
				prev.setNext(del.getNext());
			}
			return true;
		}
	}
	
	public Node getStart() {
		return start;
	}

}