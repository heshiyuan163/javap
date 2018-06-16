package classAnalyser;

import classAnalyser.classFile.AccessFlags;
import classAnalyser.classFile.ConstantPool;
import classAnalyser.classFile.Fields;
import classAnalyser.classFile.Interfaces;
import classAnalyser.classFile.Magic;
import classAnalyser.classFile.MajorVersion;
import classAnalyser.classFile.Methods;
import classAnalyser.classFile.MinorVersion;
import classAnalyser.classFile.SuperClass;
import classAnalyser.classFile.ThisClass;

/*
 * A class file consists of a single ClassFile structure:

	ClassFile {
	    u4             magic;
	    u2             minor_version;
	    u2             major_version;
	    u2             constant_pool_count;
	    cp_info        constant_pool[constant_pool_count-1];
	    u2             access_flags;
	    u2             this_class;
	    u2             super_class;
	    u2             interfaces_count;
	    u2             interfaces[interfaces_count];
	    u2             fields_count;
	    field_info     fields[fields_count];
	    u2             methods_count;
	    method_info    methods[methods_count];
	    u2             attributes_count;
	    attribute_info attributes[attributes_count];
	}

 */
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
	private Methods methods;
	/**
	 *   u2 attributes_count; 
	 *   attribute_info attributes[attributes_count];
	 */

}
