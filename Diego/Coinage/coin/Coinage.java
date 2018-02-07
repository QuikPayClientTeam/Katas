package coin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Coinage {
	private static final int[] DEFAULT =  {1, 5, 10, 25};
	
	private int[] denominations;
	private HashMap<Integer, List<List<Integer>>> storage;
	
	public Coinage() {
		this(DEFAULT);
	}
	
	public Coinage(int[] denominations) {
		this.denominations = denominations;
		storage = new HashMap<Integer, List<List<Integer>>>();
	}
	
	public int[] getDenominations() {
		return denominations;
	}

	public List<List<Integer>> getCombinations(int amount) {
		return reduce(amount, denominations.length - 1);
	}
	
	private List<List<Integer>> reduce(int amount, int index) {

		if (!storage.containsKey(amount)) {
			List<List<Integer>> lists = new ArrayList<List<Integer>>();
			
			if (amount - denominations[index] <  0) {
				lists.addAll(reduce(amount, index - 1));
			}
			else if (amount - denominations[index] == 0) {
				List<Integer> identity = new ArrayList<Integer>();
				identity.add(denominations[index]);
				lists.add(identity);
				if (index > 0 ) {
					lists.addAll(reduce(amount, index - 1));
				}
			}
			else if (amount - denominations[index] > 0) {
				lists.addAll(cross(reduce(denominations[index], index), reduce(amount - denominations[index], index)));
			}
			
			if (storage.containsKey(amount) && storage.get(amount).size() < lists.size()) {
				storage.put(amount, lists);
			}

			return lists;
		}
		else {
			return storage.get(amount);
		}
		
	}
	
	private List<List<Integer>> cross(List<List<Integer>> list1, List<List<Integer>> list2) {
		List<List<Integer>> crossProduct = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				List<Integer> list = copyOf(list1.get(i));
				list.addAll(copyOf(list2.get(j)));
				if (isNewCombination(crossProduct, list)) {
					crossProduct.add(list);
				}
			}	
		}
		return crossProduct;
	}

	private List<Integer> copyOf(List<Integer> list) {
		List<Integer> copy = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			copy.add(list.get(i));
		}
		
		return copy;
	}
	
	private boolean isNewCombination(List<List<Integer>> lists, List<Integer> combination) {
		Collections.sort(combination);
		Collections.reverse(combination);

		for (List<Integer> list : lists) {
			Collections.sort(list);
			Collections.reverse(list);

			if (list.size() == combination.size()) {
				if (compareLists(list, combination)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean compareLists(List<Integer> list1, List<Integer> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		
		return true;
	}
}
