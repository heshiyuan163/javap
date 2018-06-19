package classAnalyser.classFile.methods.methodInfo.attribute.annotation;

import classAnalyser.classFile.common.attribute.Annotation;
import classAnalyser.struct.U2Struct;

/*
 * 对一个方法的某个参数上所有的注解的一个封装体，格式如下：
 * {   u2   		num_annotations;
	   annotation 	annotations[num_annotations];
	}
 */
public class ParameterAnnotation extends U2Struct{
	
	/*
	 * num_annotations项的值表示该参数上的所有可见注解的数量。
	 */
	private int num_annotations;
	
	/*
	 * annotations[]数组中的每个成员表示该参数的一个唯一的可见注解。
	 */
	private Annotation[] annotations;//length=num_annotations

}
