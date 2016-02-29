package exer.serg.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IODecTest {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			int c;
			InputStream in = new IODecorators(new BufferedInputStream(
				new FileInputStream("/home/smac/git/DesignPatterns/DesignPatterns/src/test.txt")));
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			} 
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
