import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;

// --== CS400 File Header Information ==--
// Name: <Kenneth Diao>
// Email: <kdiao2@wisc.edu>
// Team: <Red>
// Group: <KF>
// TA: <Keren Chen>
// Lecturer: <Gary Dahl>
// Notes to Grader: none

public class DataReader implements DataReaderInterface {
	
	private String header[] = new String[] {"Rank", "Restaurant", "Sales", "Average Check", "City", "State", "Meals Served"};

	@Override
	public List<RestaurantInterface> readDataSet(Reader inputFileReader) throws IOException, DataFormatException {
		// TODO Auto-generated method stub
		LinkedList<LinkedList<String>> processedData = new LinkedList<LinkedList<String>>();
		for (int i = 0; i < header.length; i++) {
			processedData.add(new LinkedList<String>());
		}
		List<String> rawData = readData(inputFileReader);
		for(int i = 0; i < rawData.size(); i++) {
			try {
				processedData.get(i % header.length).add(rawData.get(i));
			} catch (Exception e) {
				throw new DataFormatException("Improper data format:" + e.getMessage());
			}
		}
		return createRestaurantList(processedData);
	}
	
	private List<String> readData(Reader inputFileReader) throws IOException{
		LinkedList<String> rawData = new LinkedList<String>();
		char nextChar;
		try {
			nextChar = (char)inputFileReader.read();
		} catch (Exception e) {
			throw new IOException("Invalid input: " + e.getMessage());
		}
		String nextStr = "";
		boolean quotationLock = false;
		while(!isEndCharacter(nextChar)) {
			nextChar = (char) inputFileReader.read();
		}
		nextChar = (char) NextParsableCharacter(inputFileReader);
		while((int)nextChar < 65535) {
			while(!isEndCharacter(nextChar)) {
				if (nextChar == '"') {
					quotationLock = !quotationLock;
				}
				else if(nextChar == ',' && !quotationLock) {
					rawData.add(nextStr);
					nextStr = "";
				} else {
					nextStr = nextStr + nextChar;
				}
				nextChar = (char)inputFileReader.read();
			}
			rawData.add(nextStr);
			nextStr = "";
			nextChar = (char)NextParsableCharacter(inputFileReader);
		}
		inputFileReader.close();
		return rawData;
	}
	
	private boolean isEndCharacter(char character) throws IOException {
		if(character == '\n' || character == '\r') {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the next character from the reader that is not BS, NL, or CR.
	 * @param reader the reader to read from
	 * @return the next readable character's int
	 * @throws IOException if there is an issue with the reader
	 */
	private int NextParsableCharacter(Reader reader) throws IOException {
		int next = reader.read();
		
		// while it's not BS, NL, CR
		while(next == (int)'\r' || next == (int)'\n' || next == 10) {
			next = reader.read();
		}
		
		return next;
	}
	
	private List<RestaurantInterface> createRestaurantList(LinkedList<LinkedList<String>> processedData) {
		LinkedList<RestaurantInterface> RestaurantList = new LinkedList<RestaurantInterface>();
		for (int i = 0; i < processedData.get(0).size(); i++) {
			RestaurantList.add(new Restaurant(processedData.get(0).get(i), processedData.get(1).get(i), processedData.get(2).get(i), processedData.get(3).get(i), processedData.get(4).get(i), processedData.get(5).get(i), processedData.get(6).get(i)));
		}
		return RestaurantList;
	}

}
