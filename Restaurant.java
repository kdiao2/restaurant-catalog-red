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
		this.rank = Integer.parseInt(rank);
		this.name = name;
		this.sales = Integer.parseInt(sales);
		this.avgCheck = Integer.parseInt(avgCheck);
		this.city = city;
		this.state = state;
		this.mealsServed = Integer.parseInt(mealsServed);
	}
	
	/**
	 * this method compares two RestaurantInterface objects by their ranks
	 * @return a positive number if this rank is higher, a negative number if the other rank is higher, and zero if the two are equal
	 */
	@Override
	public int compareTo(RestaurantInterface o) {
		return o.getRank() - getRank();
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
