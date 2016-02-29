package exer.serg.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IODecorators extends FilterInputStream{

	protected IODecorators(InputStream in) {
		super(in);
	}
	
	public int read() throws IOException {
		int ch = super.read();
		return (ch == -1 ? ch : Character.toLowerCase((char) ch));
	}
	

	public int read(byte b[], int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset + result; i++) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}
		return result;
		
	}
}
