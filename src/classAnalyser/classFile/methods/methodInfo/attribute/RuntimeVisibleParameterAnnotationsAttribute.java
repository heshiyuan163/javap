package classAnalyser.classFile.methods.methodInfo.attribute;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.soap.InitParam;

import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import com.sun.tracing.dtrace.Attributes;

import classAnalyser.classFile.common.attribute.AttributeInfo;
import classAnalyser.classFile.methods.methodInfo.attribute.annotation.ParameterAnnotation;

/*
 * RuntimeVisibleParameterAnnotations属性是一个变长属性，位于method_info（§4.6）结构的属性表中。
 * 用于保存对应方法的参数的所有运行时可见Java语言注解。
 * 每个method_info结构最多只能包含一个RuntimeVisibleParameterAnnotations属性，用于保存当前方法的参数的所有可见的Java语言注解。
 * Java虚拟机必须保证这些注解可被反射的API使用。
 * 
 * The RuntimeVisibleParameterAnnotations attribute has the following format:

	RuntimeVisibleParameterAnnotations_attribute {
	    u2 attribute_name_index;
	    u4 attribute_length;
	    u1 num_parameters;//该方法带可见注解的参数的个数
	    {   u2         num_annotations;
	        annotation annotations[num_annotations];
	    } parameter_annotations[num_parameters];
	}
 */

public class RuntimeVisibleParameterAnnotationsAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“RuntimeVisibleParameterAnnotations”。
	 */
	
	/*
	 * attribute_length项的值给出了当前属性的长度，不包括开始的attribute_name_index+attribute_length的6个字节。
	 * attribute_length项的值由对应方法的参数数量，参数的运行时可见注解和它们的值所决定。
	 */
	
	/*
	 * num_parameters项的值给出了注解中出现的method_info（§4.6）结构表示的方法参数的数量（这些信息可以从方法描述符中获得）。
	 */
	private byte num_parameters;
	
	
	/*
	 * parameter_annotations[]数组中每个成员的值表示一个参数的所有的运行时可见注解。
	 * 它们的顺序和方法描述符表示的参数的顺序一致。
	 */
	private ParameterAnnotation[] parameter_annotations;//length=num_parameters
	
	/*public void xxx(@InitParam(name="theName",value="zhangsan") 
					@ProbeParam(value="zhangsan") 
					@WebParam(header=true,name="xxxName",partName="yyyName")
					String names,int age){
	}*/

}
