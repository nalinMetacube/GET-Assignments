import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Pair {
	public int power;
	public int coefficient;
	
	/**
	 * Constructor to set the instance variables
	 * @param power
	 * @param coefficient
	 */
	public Pair(int power, int coefficient) {
		this.power = power;
		this.coefficient = coefficient;
	}
}

public final class Polynomial {
	private final ArrayList<Pair> polyElements;
	
	/**
	 * Method to calculate power of a value
	 * @param a
	 * @param b
	 * @return
	 */
	private double powerCalculate(double a, int b) {
		double result = 1;
		try {
			while(b > 0) {
				if((b & 1) != 0) result = (result * a);
				a = (a * a);
				b >>= 1;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in powerCalculate method");
		}
		return result;
	}
	
	/**
	 * Constructor to set the instance variables
	 * @param elementsList
	 */
	public Polynomial(ArrayList<Pair> elementsList) {
		
		Comparator<Pair> com = new Comparator<Pair>() {
			
			public int compare(Pair p1, Pair p2) {
				return (p1.power < p2.power) ? -1 : 1;
			}
		};
		
		polyElements = new ArrayList<>();
		
		for(Pair p : elementsList) {
			Pair p0 = new Pair(p.power, p.coefficient);
			polyElements.add(p0);
		}
		
		Collections.sort(polyElements, com);
	}
	
	/**
	 * Method to evaluate value of the polynomial
	 * for a given value of the variable
	 * @param X
	 * @return
	 */
	public double evaluateValue(double X) {
		double ans = 0;
		try {
			for(Pair p : polyElements) {
				ans += (p.coefficient * powerCalculate(X, p.power));
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in evaluateValue method");
		}
		return ans;
	}
	
	/**
	 * Method to return degree of the polynomial
	 * @return
	 */
	public int degreeOfPolynomial() {
		int degree = 0;
		try {
			for(Pair p : polyElements) {
				degree = Math.max(degree, p.power);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in degreeOfPolynomial method");
		}
		return degree;
	}
	
	/**
	 * Method to add two polynomials
	 * @param otherPoly
	 * @return
	 */
	public ArrayList<Pair> addPolynomial(Polynomial otherPoly) {
		ArrayList<Pair> result = new ArrayList<>();
		try {
			for(Pair p : this.polyElements) {
				Pair p0 = new Pair(p.power, p.coefficient);
				result.add(p0);
			}
			int N = this.polyElements.size() - 1;
			int l, r, pos;
			for(Pair p : otherPoly.polyElements) {
				l = 0;
				r = N;
				pos = -1;
				while(l <= r) {
					int mid = l + (r - l) / 2;
					if(this.polyElements.get(mid).power == p.power) {
						pos = mid;
						break;
					}
					if(this.polyElements.get(mid).power < p.power) l = mid + 1;
					else r = mid - 1;
				}
				if(pos == -1) {
					Pair p0 = new Pair(p.power, p.coefficient);
					result.add(p0);
				}
				else result.get(pos).coefficient += p.coefficient;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in addPolynomial method");
		}
		return result;
	}
	
	/**
	 *  Method to multiply two polynomials
	 * @param otherPoly
	 * @return
	 */
	public ArrayList<Pair> multiplyPolynomial(Polynomial otherPoly) {
		ArrayList<Pair> result = new ArrayList<>();
		try {
			for(Pair p1 : this.polyElements) {
				for(Pair p2 : otherPoly.polyElements) {
					int coeff = p1.coefficient * p2.coefficient;
					int power = p1.power * p2.power;
					boolean flag = true;
					for(Pair p : result) {
						if(p.power == power) {
							p.coefficient += coeff;
							flag = false;
							break;
						}
					}
					if(flag) {
						Pair p0 = new Pair(power, coeff);
						result.add(p0);
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in multiplyPolynomial method");
		}
		return result;
	}
	
	/**
	 * Method to return the polynomial
	 * @return
	 */
	public ArrayList<Pair> getPolynomial() {
		ArrayList<Pair> temp = new ArrayList<>();
		try {
			for(Pair p : this.polyElements) {
				Pair p0 = new Pair(p.power, p.coefficient);
				temp.add(p0);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getPolynomial method");
		}
		return temp;
	}
}
