package ie.gmit.dip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapSorter {

	static List<Entry<String, Integer>> list;

	public List<Entry<String, Integer>> list() throws Exception {		
																	
		/**
		 * (O)n as the arraylist has to sort itself by comparing values. Similar to .contains()
		 * Method allows for simple comparison and sorting by value as key is in this case the strings that we are looking to use for the word map
		 * Source for this https://www.java67.com/2015/01/how-to-sort-hashmap-in-java-based-on.html
		 */
		Parser p = new Parser();
		Map wordMap = p.getWordMap();
		Set<Entry<String, Integer>> entries = wordMap.entrySet();
		Comparator<Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				Integer v1 = e1.getValue();
				Integer v2 = e2.getValue();
				return v1.compareTo(v2);
			}															
		};																

		list = new ArrayList<Entry<String, Integer>>(entries);
		Collections.sort(list, valueComparator);
		Collections.reverse(list);

		return list;
	}

	protected List<Entry<String, Integer>> getList() {
		/**
		 * (O)1: Constant time, no loops
		 * getter method for list
		 */
		return list;
	}																

	protected void setList(List<Entry<String, Integer>> list) {
		/**
		 * (O)1: Constant time, no loops
		 * setter method for list
		 */
		this.list = list;
	}

}
