package lab10_2;

public class UndirectedListGraph {
	private class Node {
		int data;
		Node link;
		Node(int i) {
			this.data=i;
			this.link=null;
		}
	}
	private Node[] list;
	private int n;
	public UndirectedListGraph(int i) {
		this.n=i;
		list=new Node[i];
	}
	public boolean hasEdge(int a,int b) {
		if(list[a]==null) return false;
		Node n=list[a];
		while(n!=null) {
			if(n.data==b) return true;
			n=n.link;
		}
		return false;
	}
	public void addEdge(int a,int b) {
		if(a>n||b>n) System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <"+a+", "+b+">");
		else if(this.hasEdge(a, b)) System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다. <"+a+", "+b+">");
		else {
			Node m=new Node(b);
			m.link=list[a];
			list[a]=m;
			Node n=new Node(a);
			n.link=list[b];
			list[b]=n;
		}
	}
	/*
		if(list[a]==null) {
			list[a]=new Node(b);
			list[b]=new Node(a);
		}
		if(hasEdge(a,b)) {
			System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다. <"+a+", "+b+">");
			return;
		}
		else if(a>=n||b>=n) System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <"+a+", "+b+">");
		else {
			if(list[a]==null) list[a]=new Node(b);
			else {
				Node n=list[a];
				while(n.link!=null) n=n.link;
				n.link=new Node(b);
			}
			if(list[b]==null) list[b]=new Node(a);
			else {
				Node n=list[b];
				while(n.link!=null) n=n.link;
				n.link=new Node(a);
			}
		}
	 */

	public void printAdjacentVertices(int i) {
		//System.out.print("\n정점 "+i+"에 인접한 정점 = ");
		Node n=list[i];
		while(n!=null) {
			System.out.print(n.data+" ");
			n=n.link;
		}
		System.out.print("\n");
	}
	/*
	public void printing() {
		for(int i=0;i<m.length;i++) {
			System.out.print("\n정점 "+i+"에 인접한 정점 = ");
			for(int j=0;j<m[i].length;j++) {
				if(m[i][j]==1) System.out.print(j+" ");
			}
		}
	}
	 */
}