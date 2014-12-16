import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Algos {
	
	public static Set<Attribute> attrHuelle(Set<FD> fds, Set<Attribute> attris){
		Set<Attribute> result = new HashSet<Attribute>(attris);
		Set<Attribute> oldResult = new HashSet<Attribute>(); //emptyset
		while(!result.equals(oldResult)){
			oldResult = result;
			for(FD fd : fds){
				if(result.containsAll(fd.getLeftSide()))
					result.addAll(fd.getRightSide());
			}
		}
		return result;
	}
	
	public static Set<FD> readFDs(){
		Set<FD> fds = new HashSet<FD>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Lese fds...");
		while(true){
			System.out.print("Bitte FD eingeben:");
			String line = sc.nextLine();
			if(line.equals(""))
				break;
			fds.add(new FD(line));	
		}
		sc.close();
		return fds;
	}
	
	public static Set<FD> leftReduc(Set<FD> fds){
		for(FD fd : fds){
			Set<Attribute> attris = new HashSet<>(fd.getLeftSide());
			for(Attribute attr : fd.getLeftSide()){
				attris.remove(attr);
				if(attrHuelle(fds, attris).containsAll(fd.getRightSide()))
					fd.removeFromLeft(attr);
				else
					attris.add(attr);
			}
		}
		return fds;
	}
	
	public static void main(String[] args){
		Set<FD> fds = readFDs();
		System.out.println("Es wurden folgende FDs gelesen:");
		for(FD fd : fds){
			System.out.println(fd);
		}
		System.out.println("Fuehre linksreduktion durch");
		leftReduc(fds);
		System.out.println(fds);
	}
}
