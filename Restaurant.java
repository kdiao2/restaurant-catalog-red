// --== CS400 File Header Information ==--
// Name: <Kenneth Diao>
// Email: <kdiao2@wisc.edu>
// Team: <Red>
// Group: <KF>
// TA: <Keren Chen>
// Lecturer: <Gary Dahl>
// Notes to Grader: none

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.LinkedList;

public class Restaurant implements RestaurantInterface {

	private Integer rank;
	private String name;
	private Integer sales;
	private Integer avgCheck;
	private String city;
	private String state;
	private Integer mealsServed;
	
	public Restaurant(String rank, String name, String sales, String avgCheck, String city, String state, String mealsServed) {
		this.rank = parseInt(rank);
		this.name = name;
		this.sales = parseInt(sales);
		this.avgCheck = parseInt(avgCheck);
		this.city = city;
		this.state = state;
		this.mealsServed = parseInt(mealsServed);
	}
	
	private int parseInt(String str) {
		if(str.contains("e")) {
			String num = str.substring(0, str.indexOf("e"));
			String pow = str.substring(str.indexOf("e") + 1);
			int realInteger = (int) (Double.parseDouble(num) * Math.pow(10.0, Double.parseDouble(pow)));
			return realInteger;
		}
		return Integer.parseInt(str);
	}
	
	/**
	 * this method compares two RestaurantInterface objects by their ranks
	 * @return a positive number if this rank is higher, a negative number if the other rank is higher, and zero if the two are equal
	 */
	@Override
	public int compareTo(RestaurantInterface o) {
		return o.getRank() - getRank();
	}
	
	public boolean equals(RestaurantInterface o) {
		if(getRank().equals(o.getRank()) &&
				getRestaurantName().equals(o.getRestaurantName()) &&
				getNumSales().equals(o.getNumSales()) &&
				getAvgCheck().equals(o.getAvgCheck()) &&
				getCity().equals(o.getCity()) &&
				getState().equals(o.getState()) &&
				numMealsServed().equals(o.numMealsServed())) {
			return true;
		}
		return false;
	}

	@Override
	public Integer getRank() {
		return rank;
	}
	@Override
	public String getRestaurantName() {
		return name;
	}

	@Override
	public Integer getNumSales() {
		return sales;
	}

	@Override
	public Integer getAvgCheck() {
		return avgCheck;
	}
	
	@Override
	public String getCity() {
		return city;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public Integer numMealsServed() {
		return mealsServed;
	}

}
