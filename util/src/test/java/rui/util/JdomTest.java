package rui.util;

import java.io.InputStream;
import java.util.Map;

import org.junit.Test;

import rui.util.io.StreamParseUtil;
import rui.util.jdom.JdomUtil;

public class JdomTest {
	
	@Test
	public void testJdom(){
		InputStream is=JdomTest.class.getResourceAsStream("电商平台请求报文内层.txt");
		String xml=StreamParseUtil.toString(is);
		String packagePath="rui.bean";
		Map<String, Object> map=JdomUtil.jdom(xml, packagePath);
		
		
	}
}
