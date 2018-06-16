package classAnalyser;

import classAnalyser.classFile.AccessFlags;
import classAnalyser.classFile.ConstantPool;
import classAnalyser.classFile.Fields;
import classAnalyser.classFile.Interfaces;
import classAnalyser.classFile.Magic;
import classAnalyser.classFile.MajorVersion;
import classAnalyser.classFile.MinorVersion;
import classAnalyser.classFile.SuperClass;
import classAnalyser.classFile.ThisClass;

public class ClassFile {
	
	private Magic magic;
	private MinorVersion minorVersion;
	private MajorVersion majorVersion;
	private ConstantPool constantPool;
	private AccessFlags accessFlags;
	private ThisClass thisClass;
	private SuperClass superClass;
	private Interfaces interfaces;
	private Fields fields;
	/**
	 *   u2 methods_count; 
	 *   method_info methods[methods_count]; 
	 *   u2 attributes_count; 
	 *   attribute_info attributes[attributes_count];
	 */

}
