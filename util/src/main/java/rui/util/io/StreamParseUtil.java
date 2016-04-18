package rui.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamParseUtil {
	
	public static String toString(InputStream inputStream){
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		int i=-1;
		try {
			while((i=inputStream.read())!=-1){
				baos.write(i);
			}
			return baos.toString("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(baos!=null){
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
