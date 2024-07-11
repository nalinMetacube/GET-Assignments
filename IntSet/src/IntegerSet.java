import java.util.ArrayList;
import java.util.Collections;

public final class IntegerSet {
	public final ArrayList<Integer> setOfIntegers;
	public final ArrayList<Integer> complementSet;
	
	/**
	 * Constructor to initialize the instance variables
	 * @param listOfIntegers
	 */
	public IntegerSet(ArrayList<Integer> listOfIntegers) {
		setOfIntegers = new ArrayList<>();
		complementSet = new ArrayList<>();
		for(int num : listOfIntegers) {
			setOfIntegers.add(num);
		}
		Collections.sort(setOfIntegers);
		
		for(int i = 1; i <= 1000; i++) {
			if(this.setOfIntegers.indexOf(i) == -1) this.complementSet.add(i);
		}
	}	
	
	/**
	 * Method to check if a value is member of the set or not
	 * @param number
	 * @return
	 */
	public boolean isMember(int number) {
		try {
			int l = 0, r = this.setOfIntegers.size() - 1;
			while(l <= r) {
				int mid = l + (r - l) / 2;
				if(this.setOfIntegers.get(mid) == number) return true;
				if(this.setOfIntegers.get(mid) < number) l = mid + 1;
				else r = mid - 1;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in isMember method");
		}
		return false;
	}
	
	/**
	 * Method to get size of the set
	 * @return
	 */
	public int getSize() {
		return setOfIntegers.size();
	}
	
	/**
	 * Method to check if a set is subset of the set or not
	 * @param otherSet
	 * @return
	 */
	public boolean isSubset(IntegerSet otherSet) {
		try {
			int l, r, pos;
			for(int number : otherSet.setOfIntegers) {
				l = 0;
				r = this.setOfIntegers.size() - 1;
				pos = -1;
				while(l <= r) {
					int mid = l + (r - l) / 2;
					if(this.setOfIntegers.get(mid) == number) {
						pos = mid;
						break;
					}
					if(this.setOfIntegers.get(mid) < number) l = mid + 1;
					else r = mid - 1;
				}
				if(pos == -1) return false;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in isSubset method");
		}
		return true;
	}
	
	/**
	 * Method to get Union of two sets
	 * @param otherSet
	 * @return
	 */
	public ArrayList<Integer> getUnion(IntegerSet otherSet) {
		ArrayList<Integer> result = new ArrayList<>(this.setOfIntegers);
		try {
			int l, r, pos;
			for(int number : otherSet.setOfIntegers) {
				l = 0;
				r = this.setOfIntegers.size() - 1;
				pos = -1;
				while(l <= r) {
					int mid = l + (r - l) / 2;
					if(this.setOfIntegers.get(mid) == number) {
						pos = mid;
						break;
					}
					if(this.setOfIntegers.get(mid) < number) l = mid + 1;
					else r = mid - 1;
				}
				if(pos == -1) result.add(number);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getUnion method");
		}
		return result;
	}
	
	/**
	 * Method to get Intersection of two sets
	 * @param otherSet
	 * @return
	 */
	public ArrayList<Integer> getIntersection(IntegerSet otherSet) {
		ArrayList<Integer> result = new ArrayList<>();
		try {
			int l, r, pos;
			for(int number : otherSet.setOfIntegers) {
				l = 0;
				r = this.setOfIntegers.size() - 1;
				pos = -1;
				while(l <= r) {
					int mid = l + (r - l) / 2;
					if(this.setOfIntegers.get(mid) == number) {
						pos = mid;
						break;
					}
					if(this.setOfIntegers.get(mid) < number) l = mid + 1;
					else r = mid - 1;
				}
				if(pos != -1) result.add(number);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getIntersection method");
		}
		return result;
	}
	
	/**
	 * Method to get Difference of two sets
	 * @param otherSet
	 * @return
	 */
	public ArrayList<Integer> getDifference(IntegerSet otherSet) {
		ArrayList<Integer> result = new ArrayList<>(this.setOfIntegers);
		try {
			int l, r, pos;
			for(int number : otherSet.setOfIntegers) {
				l = 0;
				r = result.size() - 1;
				pos = -1;
				while(l <= r) {
					int mid = l + (r - l) / 2;
					if(result.get(mid) == number) {
						pos = mid;
						break;
					}
					if(result.get(mid) < number) l = mid + 1;
					else r = mid - 1;
				}
				if(pos != -1) result.remove(pos);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getDifference method");
		}
		return result;
	}
	
	/**
	 * Method to get Complement of the set
	 * @return
	 */
	public ArrayList<Integer> getComplement() {
		ArrayList<Integer> result = new ArrayList<>();
		try {
			for(int number : complementSet) {
				result.add(number);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getComplement method");
		}
		return result;
	}
}
