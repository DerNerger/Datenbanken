
public class Attribute {
	public String name;
	
	public Attribute(String name){
		this.name = name;
	}
	
	public boolean equals(Object o){
		if(o==null) return false;
		if(! (o instanceof Attribute)) return false;
		Attribute attr = (Attribute)o;
		return attr.name.equals(name);
	}
	
	public String toString(){
		return name;
	}
}
