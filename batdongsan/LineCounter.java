package bài3;
import java.io.*;
public class LineCounter {
	public static void main(String[] avgs) {
		int LineCount = 0;
		try (BufferedReader br = new
BufferedReader(new FileReader("C:\\Users\\LENOVO\\Documents\\input.txt"))) {
			while (br.readLine() != null) {
			LineCount++;
				}
			System.out.println("Số dòng trong file: "+ LineCount);
			} catch(IOException e) {
				e.printStackTrace();
		}
				
	}
}
	