package rui.util.reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

import rui.util.string.StringUtil;

public class ReflexUtil {
	
	/**
	 * 
	 * <p>根据类路径反射创建该类</p>
	 * 
	 * @param classPath
	 * @return Object
	 * @author: 赵睿
	 * @date: Created on 2016年4月18日 下午2:49:47
	 */
	@SuppressWarnings("rawtypes")
	public static Class reflexClass(String classPath){
		Class clazz = null;
		try {
			clazz = Class.forName(classPath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clazz;
	}
	
	/**
	 * 
	 * <p>根据类路径和参数，通过set的方式，将参数放入反射创建的对象中</p>
	 * 
	 * @param classPath
	 * @param map
	 * @return Object
	 * @author: 赵睿
	 * @date: Created on 2016年4月18日 下午2:49:42
	 */
	public static Object reflexClass(String classPath,Map<String, Object> map){
		Object object=null;	
		try {
				@SuppressWarnings("rawtypes")
				Class clazz=reflexClass(classPath);
				object=clazz.newInstance();
				for(Entry<String, Object> entry:map.entrySet()){
					String methodName="set"+StringUtil.upperFirst(entry.getKey());
					@SuppressWarnings("unchecked")
					Method method=clazz.getDeclaredMethod(methodName,new Class[]{String.class});
					method.invoke(object, entry.getValue());
				}
				return object;
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.out.println("该方法不存在："+e.getMessage());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		return object;
	}
}
