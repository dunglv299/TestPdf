import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestCollection {
	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("1");
		Set<String> hashsetList = new HashSet<String>(myList);
		System.out.println("Unique values using HashSet: " + hashsetList);
		Set<String> treesetList = new TreeSet<String>(myList);
		System.out.println("Unique values using TreeSet - Sorted order: "
				+ treesetList);
		List<String> newList = new ArrayList<String>(
				new TreeSet<String>(myList));
		System.out.println("Unique values using List " + newList);
	}
}
