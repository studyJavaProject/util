package rui.util;

import java.io.InputStream;
import java.util.Map;

import org.junit.Test;

import rui.bean.COMMON_FPKJ_FPT;
import rui.util.io.StreamParseUtil;
import rui.util.jdom.JdomUtil;

public class JdomTest {
	
	@Test
	public void testJdom(){
		InputStream is=JdomTest.class.getResourceAsStream("电商平台请求报文内层.txt");
		String xml=StreamParseUtil.toString(is);
		String packagePath="rui.bean";
		Map<String, Object> map=JdomUtil.jdom(xml, packagePath);
		COMMON_FPKJ_FPT common_FPKJ_FPT=(COMMON_FPKJ_FPT) map.get("COMMON_FPKJ_FPT");
		System.out.println(common_FPKJ_FPT.getBZ());
	}
}
