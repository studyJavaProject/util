package rui.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
	public static String ioToString(InputStream io) {
		try {
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			
			int i=-1;
			while((i=io.read())!=-1){
				baos.write(i);
			}
			return baos.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
