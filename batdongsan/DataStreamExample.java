package bài4;
import java.io.*;
public class DataStreamExample {
	public static void main(String[] avgs) {
		int[] numbers = {10,20, 30, 40, 50};
		try (DataOutputStream dos = new
DataOutputStream(new
FileOutputStream("number.dat"))) {
			for (int num : numbers) {
			dos.writeInt(num);
			}System.out.println("Ghi danh sách số nguyên thành công. ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (DataInputStream dis = new
DataInputStream(new
FileInputStream("number.dat"))) {
			System.out.println("Danh sách số nguyên từ file: ");
			while (dis.available() > 0) {
				System.out.println(dis.readInt()+ " ");
		}
	}catch (IOException e) {
		e.printStackTrace();
	}
  }
}