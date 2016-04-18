package rui.util.string;

public class StringUtil {
	
	/**
	 * 
	 * <p>判断一个字符串是否为null，如果为null。返回空串</p>
	 * 
	 * @param str
	 * @return String
	 * @author: 赵睿
	 * @date: Created on 2016年4月18日 上午10:33:07
	 */
	public static String nullToEmpty(String str){
		return (str==null)?"":str;
	}
	
	/**
	 * 
	 * <p>删除字符串末尾分号</p>
	 * 
	 * @param str
	 * @return String
	 * @author: 赵睿
	 * @date: Created on 2016年4月18日 上午10:57:23
	 */
	public static String deleteSemicolon(String str){
		if(str.endsWith(";")){
			str=str.substring(0, str.length()-1);
		}
		return str;
	}
	
	/**
	 * 
	 * <p>字符串首字母大写</p>
	 * 
	 * @param str
	 * @return String
	 * @author: 赵睿
	 * @date: Created on 2016年4月18日 下午2:21:10
	 */
	public static String upperFirst(String str){
		char[] chars=str.toCharArray();
		if(Character.isLowerCase(chars[0])){
			chars[0]-=32;
		}
		return new String(chars);
	}
}
