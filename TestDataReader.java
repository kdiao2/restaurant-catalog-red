import java.io.File;
import java.io.FileReader;
import java.util.List;

public class TestDataReader {
	public static void main(String[] args) {
		DataReader test = new DataReader();
		try {
			List<RestaurantInterface> testList = test.readDataSet(new FileReader("Independence100.csv"));
			RestaurantInterface r1 = new Restaurant("1", "Carmine's (Times Square)", "39080335", "40", "New York", "N.Y.", "469803");
			RestaurantInterface r50 = new Restaurant("50", "Frankenmuth Bavarian Inn", "17388751", "19", "Frankenmuth", "Mich.", "899284");
			RestaurantInterface r66 = new Restaurant("66", "Swan", "1.50e07", "78", "Miami", "Fla.", "225000");
			RestaurantInterface r100 = new Restaurant("100", "Virgil's Real Barbecue", "11391678", "27", "Las Vegas", "Nev.", "208276");
			if(testList.get(0).equals(r1)) {
				System.out.println("pass 1");
			} else {
				System.out.println("fail 1");
			}
			if(testList.get(49).equals(r50)) {
				System.out.println("pass 50");
			} else {
				System.out.println("fail 50");
			}
			if(testList.get(65).equals(r66)) {
				System.out.println("pass 66");
			} else {
				System.out.println("fail 66");
			}
			if(testList.get(99).equals(r100)) {
				System.out.println("pass 100");
			} else {
				System.out.println("fail 100");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
