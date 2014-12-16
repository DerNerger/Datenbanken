import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class FD {
	private Set<Attribute> leftSide;
	private Set<Attribute> rightSide;
	
	public FD(Set<Attribute> leftSide, Set<Attribute> rightSide) {
		super();
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	
	public FD(FD fd){
		this.leftSide = new HashSet<>(fd.leftSide);
		this.rightSide = new HashSet<>(fd.rightSide);
	}
	
	public FD(String fdString){
		leftSide = new HashSet<>();
		rightSide = new HashSet<>();
		String[] parts = fdString.split("->");
		String leftSideStr = parts[0];
		String rightSideStr = parts[1];
		//read the ride side
		String[] leftAttris = leftSideStr.split(",");
		String[] rightAttris = rightSideStr.split(",");
		for(String s : leftAttris)
			leftSide.add(new Attribute(s));
		for(String s : rightAttris)
			rightSide.add(new Attribute(s));
	}

	public Set<Attribute> getLeftSide() {
		return leftSide;
	}

	public void setLeftSide(Set<Attribute> leftSide) {
		this.leftSide = leftSide;
	}

	public Set<Attribute> getRightSide() {
		return rightSide;
	}

	public void setRightSide(Set<Attribute> rightSide) {
		this.rightSide = rightSide;
	}
	
	public void removeFromLeft(Attribute attr){
		leftSide.remove(attr);
	}
	
	public void removeFromRight(Attribute attr){
		rightSide.remove(attr);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Attribute attr : leftSide)
			sb.append(attr+" ");
		sb.append("->");
		for(Attribute attr : rightSide)
			sb.append(attr+" ");
		return sb.toString();
	}
}
