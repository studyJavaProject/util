package rui.util.jdom;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import rui.util.reflex.ReflexUtil;
import rui.util.string.StringUtil;

public class JdomUtil {
	public static Map<String, Object> jdom(String xml,String packagePath){
		Map<String , Object> map=null;
		try {
			StringReader reader=new StringReader(xml);
			InputSource inputSource=new InputSource(reader);
			SAXBuilder builder=new SAXBuilder();
			Document document=builder.build(inputSource);
			Element root=document.getRootElement();
			map=dealElement(root, packagePath);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	private static  Map<String, Object> dealElement(Element root,String packagePath){
		Map<String, Object> map=new HashMap<String, Object>();
		List<?> list=root.getChildren();
		for (int i = 0; i < list.size(); i++) {
			Element element=(Element) list.get(i);
			String name=element.getName();
			@SuppressWarnings("unchecked")
			List<Attribute> attributes=element.getAttributes();
			if(attributes.size()==0){
				Map<String, Object> params=getParamvalues(element, packagePath);
				map.put(name, params.get(name));
			}else if(attributes.size()==1){
				Object object=putElementToObject(attributes, element, packagePath);
				map.put(name, object);
			}else if(attributes.size()==2){
				Object[] objects=putElementsToObjectArray(attributes, element, packagePath);
				map.put(name, objects);
			}
		}
		
		return map;
	}
	
	public static Map<String, Object> getParamvalues(Element element,String packagePath){
		Map<String, Object>paramMap=new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		List<Element> children=element.getChildren();
		if(children.size()==0){
			paramMap.put(element.getName(),element.getText());
		}else{
			paramMap.put(element.getName(), dealElement(element, packagePath));
		}
		return paramMap;
	}
	
	
	/**
	 * 
	 * <p>将jdom单元元素转换为对象</p>
	 * 
	 * @param attributes
	 * @param element
	 * @param map
	 * @param packagePath
	 * @return Object
	 * @author: 赵睿
	 * @date: Created on 2016年4月18日 下午4:28:36
	 */
	public static Object putElementToObject(List<Attribute> attributes,
			Element element,String packagePath){
		Object object=null;
		if("class".equalsIgnoreCase(attributes.get(0).getName())){
			String className=StringUtil.deleteSemicolon(attributes.get(0).getValue());
			Map<String, Object> params=dealElement(element, packagePath);
			object=ReflexUtil.reflexClass(packagePath+"."+className, params);
		}
		return object;
	}
	/**
	 * 
	 * <p>将多个jdom单元转换为对象数组</p>
	 * 
	 * @param map
	 * @param attributes
	 * @param element
	 * @param packagePath
	 * @return Object[]
	 * @author: 赵睿
	 * @date: Created on 2016年4月18日 下午5:02:55
	 */
	public static Object[] putElementsToObjectArray(List<Attribute> attributes,Element element,String packagePath){
		Object[] objects=null;
		if("size".equalsIgnoreCase(attributes.get(1).getName())){
			int size=Integer.valueOf(attributes.get(1).getValue());
			@SuppressWarnings("rawtypes")
			Class clazz=ReflexUtil.reflexClass(packagePath+"."+StringUtil.deleteSemicolon(attributes.get(0).getValue()));
			objects=(Object[]) Array.newInstance(clazz, size);
			for (int i = 0; i < size; i++) {
				Object object=putElementToObject(attributes, (Element) element.getChildren().get(i), packagePath);
				Array.set(objects, i, object);
			}
		}
		return objects;
	}
}
