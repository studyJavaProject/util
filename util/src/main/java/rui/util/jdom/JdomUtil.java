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
		try {
			StringReader reader=new StringReader(xml);
			InputSource inputSource=new InputSource(reader);
			SAXBuilder builder=new SAXBuilder();
			Document document=builder.build(inputSource);
			Element root=document.getRootElement();
			Map<String, Object> map=null;
			dealElement(map,root, packagePath);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private static  Map<String, Object> dealElement(Map<String, Object> map,Element root,String packagePath){
		List<?> list=root.getChildren();
		for (int i = 0; i < list.size(); i++) {
			Element element=(Element) list.get(i);
			List<Attribute> attributes=element.getAttributes();
			if(attributes.size()==0){
				Map<String, Object> params=getParamvalues(map, element, packagePath);
				params.entrySet().iterator().next().getValue();
			}else if(attributes.size()==1){
				Object object=putElementToObject(map,attributes, element, packagePath);
				map.put(element.getName(), object);
			}else if(attributes.size()==2){
				Object[] objects=putElementsToObjectArray(map,attributes, element, packagePath);
				map.put(element.getName(), objects);
			}
			
		}
		
		return map;
	}
	
	public static Map<String, Object> getParamvalues(Map<String, Object> map,Element element,String packagePath){
		Map<String, Object>paramMap=new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		List<Element> children=element.getChildren();
		if(children.size()==0){
			paramMap.put(element.getName(),element.getText());
		}else{
			paramMap.put(element.getName(), dealElement(map, element, packagePath));
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
	public static Object putElementToObject(Map<String, Object> map,List<Attribute> attributes,
			Element element,String packagePath){
		Object object=null;
		if("class".equalsIgnoreCase(attributes.get(0).getName())){
			String className=StringUtil.deleteSemicolon(attributes.get(0).getValue());
			Map<String, Object> params=dealElement(map,element, packagePath);
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
	public static Object[] putElementsToObjectArray(Map<String, Object> map,List<Attribute> attributes,Element element,String packagePath){
		Object[] objects=null;
		if("size".equalsIgnoreCase(attributes.get(1).getName())){
			int size=Integer.valueOf(attributes.get(1).getValue());
			@SuppressWarnings("rawtypes")
			Class clazz=ReflexUtil.reflexClass(packagePath+"."+StringUtil.deleteSemicolon(attributes.get(0).getValue()));
			objects=(Object[]) Array.newInstance(clazz, size);
			for (int i = 0; i < size; i++) {
				Object object=putElementToObject(map,attributes, (Element) element.getChildren().get(i), packagePath);
				Array.set(objects, i, object);
			}
		}
		return objects;
	}
}
