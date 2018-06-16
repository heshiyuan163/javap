package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.print.attribute.standard.MediaSize.NA;

public class ClassAnalyser {
	
	public static HashMap<Integer, String> constantPoolMap=new HashMap<Integer, String>();
		
	
	public static void main1(String[] args) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("E:\\171208\\javaproj_1.7\\bin\\Xxx.class");
			
			int oneByte = fis.read();
			int count=1;
			while(oneByte!=-1){
				String hexStr = getHexStringOfInt(oneByte);
				hexStr=hexStr.length()==1?("0"+hexStr):hexStr;
				System.out.print(hexStr);
				if(count%2==0){
					System.out.print(" ");
				}
				if(count%16==0){
					System.out.println();
				}
				oneByte = fis.read();
				count++;
			}
			System.out.println();
			System.out.println("over");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getBinaryStringOfInt(int num){
		return Integer.toBinaryString(num);
	}
	public static String getHexStringOfInt(int num){
		String hexString = Integer.toHexString(num);
		if(hexString.length()==1){
			return "0"+hexString;
		}
		return hexString;
	}
	
	public static void main(String[] args) {
		analysisClassFile("E:\\171208\\javaproj_1.7\\bin\\Xxx.class");
	}
	public static void analysisClassFile(String classFilePath){
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(classFilePath);
			//1.maginc number
			String magicNumber=getHexStringOfInt(fis.read())+
							   getHexStringOfInt(fis.read())+
							   getHexStringOfInt(fis.read())+
							   getHexStringOfInt(fis.read());
			System.out.println("0x"+magicNumber+"\t//.class文件标志 ");
			
			//2.version
			int num1=fis.read();//high byte of minor version
			int num2=fis.read();//low byte of minor version
			System.out.println("0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//minor version "+((num1<<8)+num2 ));
			
			num1=fis.read();//high byte of major version
			num2=fis.read();//low byte of major version
			System.out.println("0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//major version "+((num1<<8)+num2));
			
			//3.constant pool
			handelConstantPool(fis);
			
			//4.Access_Flag(访问标志,访问标志信息包括该Class文件是类还是接口，是否被定义成public，是否是abstract，如果是类，是否被声明成final。通过上面的源代码，我们知道该文件是类并且是public)
			handleAccessFlag(fis);
			
			//5.this class name
			handleClassName(fis);
			
			//6.super class name
			handleSuperClassName(fis);
			
			//7.interfaces
			handleInterfaces(fis);
			
			//8.fields
			handleFields(fis);
			
			//9.methods
			handleMethods(fis);
			
			//10.attributes
			//TODO
			
			System.out.println("*******************************over*****************************");
		}catch (Exception e) {
			e.printStackTrace();
			try {
				fis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static void handleMethods(FileInputStream fis) throws IOException {
		System.out.println("*****************methods begin**************************");
		int num1=fis.read();//high byte of methods_count
		int num2=fis.read();//low byte of methods_count
		int methods_count=(num1<<8)+num2;
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t"+methods_count+"\t//methods_count="+methods_count+"个");
		System.out.println();
		for(int i=1;i<=methods_count;i++){
			System.out.println("\t*********method "+i+"*****************");
			handleMethodInfo(fis);
			System.out.println();
		}
		System.out.println("*****************methods end**************************");
		System.out.println();
	}

	private static void handleMethodInfo(FileInputStream fis) throws IOException {
		//access_flags
		int num1=fis.read();//high byte of access_flags
		int num2=fis.read();//low byte of access_flags
		int access_flags=(num1<<8)+num2;
		StringBuilder sb=new StringBuilder(""); 
		if((access_flags&1)!=0){
			sb.append("ACC_PUBLIC,");
		}
		if((access_flags&2)!=0){
			sb.append("ACC_PRIVATE,");
		}
		if((access_flags&4)!=0){
			sb.append("ACC_PROTECTED,");
		}
		if((access_flags&8)!=0){
			sb.append("ACC_STATIC,");
		}
		if((access_flags&16)!=0){
			sb.append("ACC_FINAL,");
		}
		if((access_flags&32)!=0){
			sb.append("ACC_SYNCHRONIZE,");
		}
		if((access_flags&64)!=0){
			sb.append("ACC_BRIDGE,");//表示是否是编译器生成的桥接方法
		}
		if((access_flags&128)!=0){
			sb.append("ACC_VARARGS,");//表示是否接受不定参数
		}
		if((access_flags&256)!=0){
			sb.append("ACC_NATIVE,");//表示是否是本地方法
		}
		if((access_flags&1024)!=0){
			sb.append("ACC_ABSTRACT,");
		}
		if((access_flags&2048)!=0){
			sb.append("ACC_STRICT,");//该方法是否是strctfp类型
		}
		if((access_flags&4096)!=0){
			sb.append("ACC_SYNTHETIC,");//表示方法是否是用户代码生成的
		}
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//access_flags="+sb.toString());
		
		//name_index
		num1=fis.read();//high byte of name_index
		num2=fis.read();//low byte of name_index
		int name_index=(num1<<8)+num2;
		String uft8name=constantPoolMap.get(name_index);
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t#"+name_index+"\t//"+uft8name);
		
		//descriptor_index(即返回值类型类型的索引)		
		num1=fis.read();//high byte of descriptor_index
		num2=fis.read();//low byte of descriptor_index
		int descriptor_index=(num1<<8)+num2;
		String uft8descriptor=constantPoolMap.get(descriptor_index);
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t#"+descriptor_index+"\t//"+uft8descriptor);
		
		//attribute_count
		num1=fis.read();//high byte of attribute_count
		num2=fis.read();//low byte of attribute_count
		int attribute_count=(num1<<8)+num2;
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t"+attribute_count+"\t//attribute_count="+attribute_count+"个");
		
		//attribute_info(attribute_count个)
		for(int i=1;i<=attribute_count;i++){
			System.out.println("\t\t**********attribute "+i+"*******************");
			//attribute_info
			//1.attribute_name_index(2 bytes)
			num1=fis.read();//high byte of attribute_name_index
			num2=fis.read();//low byte of attribute_name_index
			int attribute_name_index=(num1<<8)+num2;
			String utf8_attribute_name=constantPoolMap.get(attribute_name_index);
			
			//2.attribute_length(4 bytes)
			num1=fis.read();
			num2=fis.read();
			int num3=fis.read();
			int num4=fis.read();
			int attribute_length=(num1<<24)+(num2<<16)+(num3<<8)+num4;
			
			System.out.println("\t\t"+utf8_attribute_name+":\t//一共"+attribute_length+" bytes");
			
			//3.attribute_value(attribute_length bytes)
			//attribute_name_index指向constant pool中的UTF-8字符串一共有4种值(1.Code、2.Exceptions、3.Deprecated、4.Synthetic)
			switch (utf8_attribute_name) {
				case "Code":
					handleMethodCodeAttributeInfo(fis);
					break;
				case "Exceptions":
					handleMethodExceptionsAttributeInfo(fis);
					break;
				case "Deprecated":
					handleMethodDeprecatedAttributeInfo(fis);
					break;
				case "Synthetic":
					handleMethodSyntheticAttributeInfo(fis);
					break;
			}
			
			boolean test=true;
			if(test){
				break;
			}
			System.out.println("\t\t");
		}
		
		System.out.println();
	}

	private static void handleMethodSyntheticAttributeInfo(FileInputStream fis) {
		// TODO Auto-generated method stub
		
	}

	private static void handleMethodDeprecatedAttributeInfo(FileInputStream fis) {
		// TODO Auto-generated method stub
		
	}

	private static void handleMethodExceptionsAttributeInfo(FileInputStream fis) {
		// TODO Auto-generated method stub
		
	}

	//即attribute_value
	private static void handleMethodCodeAttributeInfo(FileInputStream fis) throws IOException {
		//max_stack(2 bytes)
		int num1=fis.read();//high byte of max_stack
		int num2=fis.read();//low byte of max_stack
		int max_stack=(num1<<8)+num2;
		
		//max_locals(2 bytes)
		num1=fis.read();//high byte of max_locals
		num2=fis.read();//low byte of max_locals
		int max_locals=(num1<<8)+num2;
		System.out.println("\t\t\tmax_stack\tmax_locals");
		System.out.println("\t\t\t"+max_stack+"\t\t"+max_locals);
		//机器指令begin
		//code_length(4 bytes)  指令个数
		num1=fis.read();
		num2=fis.read();
		int num3=fis.read();
		int num4=fis.read();
		int code_length=(num1<<24)+(num2<<16)+(num3<<8)+num4;
		System.out.println("\t\t\tinstructions:\t//一共"+code_length+" bytes");
		
		//code[code_length](1 bytes)  依次遍历code_length个指令中的每一个指令
		for(int i=0;i<code_length;i++){
			num1=fis.read();//one byte represents one instruction
			System.out.println("\t\t\t\t0x"+getHexStringOfInt(num1)+"\t"+num1+"\t//instruction "+i+":"+num1);
		}
		//机器指令end
		
		//异常处理跳转信息表begin
		//exception_table_length(2 bytes)  "异常跳转信息"条数
		num1=fis.read();//high byte of exception_table_length
		num2=fis.read();//low byte of exception_table_length
		int exception_table_length=(num1<<8)+num2;
		System.out.println("\t\t\tException table:\t//一共"+exception_table_length+"行");
		//exception_table[exception_table_length]  依次遍历每一个"异常跳转信息"
		if(exception_table_length>0){
			System.out.println("\t\t\t\tfrom\tto\ttarget\ttype");
			for(int i=1;i<=exception_table_length;i++){
				//start_pc(2 bytes)
				num1=fis.read();//hign byte of start_pc
				num2=fis.read();//low byte of start_pc
				int start_pc=(num1<<8)+num2;
				//end_pc(2 bytes)
				num1=fis.read();//hign byte of end_pc
				num2=fis.read();//low byte of end_pc
				int end_pc=(num1<<8)+num2;
				//handler_pc(2 bytes)
				num1=fis.read();//hign byte of handler_pc
				num2=fis.read();//low byte of handler_pc
				int handler_pc=(num1<<8)+num2;
				//catch_type(2 bytes)
				num1=fis.read();//hign byte of catch_type
				num2=fis.read();//low byte of catch_type
				int catch_type_index=(num1<<8)+num2;
				int utf8_catch_type_name_index = Integer.parseInt(constantPoolMap.get(catch_type_index));
				String utf8_catch_type_name = constantPoolMap.get(utf8_catch_type_name_index);
				System.out.println("\t\t\t\t#"+start_pc+"\t#"+end_pc+"\t#"+handler_pc+"\t"+utf8_catch_type_name);
			}
		}
		//异常处理跳转信息表end
		
		//"java源码行号和机器码对应关系(即LineNumberTable)"+"局部变量表描述信息(即LocalVariableTable)" begin
		//attributes_count(2 bytes)
		num1=fis.read();//high byte of attribute_count
		num2=fis.read();//low byte of attribute_count
		int attribute_count=(num1<<8)+num2;
		System.out.println("\t\t\tAttributes:\t//"+attribute_count+"个");
		//attributes[attributes_count]
		for(int i=1;i<=attribute_count;i++){
			num1=fis.read();//high byte of attribute_name_index
			num2=fis.read();//low byte of attribute_name_index
			int attribute_name_index=(num1<<8)+num2;
			String uft8_attribute_name=constantPoolMap.get(attribute_name_index);
			switch (uft8_attribute_name) {
				case "LineNumberTable":
					handleLineNumberTable(fis);
					break;
				case "LocalVariableTable":
					handleLocalVariableTable(fis);
					break;
				case "StackMapTable":
					handleStackMapTable(fis);
					break;
			}
		}
		//"java源码行号和机器码对应关系(即LineNumberTable)"+"局部变量表描述信息(即LocalVariableTable)" end
	}

	private static void handleStackMapTable(FileInputStream fis) throws IOException {
			//attribute_length
			int num1=fis.read();
			int num2=fis.read();
			int num3=fis.read();
			int num4=fis.read();
			int attribute_length=(num1<<24)+(num2<<16)+(num3<<8)+num4;
			
			//number_of_entries
			num1=fis.read();
			num2=fis.read();
			int number_of_entries=(num1<<8)+num2;//栈映射帧个数
			System.out.println("\t\t\t\tStackMapTable:\t// 一共"+attribute_length+" bytes,number_of_entries = "+number_of_entries+"个");
			if(number_of_entries>0){
				for(int i=0;i<number_of_entries;i++){
					//stack_map_frame
					//1.frame_type
					int frame_type=fis.read();
					System.out.println("\t\t\t\t\tframe_type ="+frame_type);
					if(frame_type>=0&&frame_type<=63){//帧类型为same_frame
						//1.1.same_frame
						/*same_frame { u1 frame_type = SAME; }
						 * 表明当前帧拥有和前一个栈映射帧完全相同的locals[]数组，并且对应的stack项的成员个数为0。
						 * 当前帧的offset_delta值就使用frame_type项的值来表示①。*/
						int offset_delta=frame_type;
					}else if(frame_type>=64&&frame_type<=127){//帧类型为same_locals_1_stack_item_frame
						//1.2.same_locals_1_stack_item_frame
						/*same_locals_1_stack_item_frame { 
						 * 		u1 frame_type = SAME_LOCALS_1_STACK_ITEM;
						 * 		verification_type_info stack[1]; 
						 *}说明当前帧拥有和前一个栈映射帧完全相同的locals[]数组，同时对应的stack[]数组的成员个数为1。
						 * 当前帧的offset_delta值为frame_type-64。并且有一个verification_type_info
						 * 项跟随在此帧类型之后|，用于表示那一个stack项的成员。 */
						int offset_delta=frame_type-64;
					}else if(frame_type>=128&&frame_type<=246){
						//范围在128至246的类型标记值是为未来使用而预留的。
					}else if(frame_type==247){
						//1.3.same_locals_1_stack_item_frame_extended; 
						/* 表明当前帧拥有和前一个栈映射帧完全相同的locals[]数组，同时对应的stack[]数组的成员个数为1。
						 * 当前帧的offset_delta的值需要由offset_delta项明确指定。有一个stack[]数组的成员跟随
						 * 在offset_delta项之后。
						 */
						/**
						 * same_locals_1_stack_item_frame_extended { u1 frame_type = SAME_LOCALS_1_STACK_ITEM_EXTENDED;
						 * 										     u2 offset_delta; 
						 * 											 verification_type_info stack[1]; 
						 * }
						 */
						num1=fis.read();
						num2=fis.read();
						int offset_delta=(num1<<8)+num2;
					}else if(frame_type>=248&&frame_type<=250){
						//1.4.chop_frame;
						/**
						 * 说明对应的操作数栈为空，并且拥有和前一个栈映射帧相同的locals[]数组，不过其中的第k个之后的locals项是不存在的。
						 * k的值由251-frame_type确定。 
						 * chop_frame { u1 frame_type = CHOP;
						 * 				u2 offset_delta;
						 *  }
						 */
						num1=fis.read();
						num2=fis.read();
						int offset_delta=(num1<<8)+num2;
					}else if(frame_type==251){
						//1.5.same_frame_extended;
						/**
						 * 说明当前帧有拥有和前一个栈映射帧的完全相同的locals[]数组，同时对应的stack[]数组的成员数量为0。
						 *  same_frame_extended { u1 frame_type = SAME_FRAME_EXTENDED;  
						 *  					  u2 offset_delta; 
						 *  }
						 */
						num1=fis.read();
						num2=fis.read();
						int offset_delta=(num1<<8)+num2;
					}else if(frame_type>=252&&frame_type<=254){
						//1.6.append_frame;
						/**
						 * 说明对应操作数栈为空，并且包含和前一个栈映射帧相同的locals[]数组，不过还额外附加k个的locals项。
						 * k值为frame_type-251。
						 *  append_frame { u1 frame_type = APPEND;  
						 *  			   u2 offset_delta; 
						 *  			   verification_type_info locals[frame_type - 251];
						 *   }
						 */
						num1=fis.read();
						num2=fis.read();
						int offset_delta=(num1<<8)+num2;
					}else if(frame_type==255){
						//1.7.full_frame;
						/*full_frame {  
						    u1 frame_type = FULL_FRAME;  255   
						    u2 offset_delta;  
						    u2 number_of_locals;  
						    verification_type_info locals[number_of_locals];  
						    u2 number_of_stack_items;  
						    verification_type_info stack[number_of_stack_items];  
						}  */
					}
						
				}
			}
	}

	private static void handleLineNumberTable(FileInputStream fis) throws IOException {
		//总字节数(4 bytes)
		int num1=fis.read();
		int num2=fis.read();
		int num3=fis.read();
		int num4=fis.read();
		int totalBytes=(num1<<24)+(num2<<16)+(num3<<8)+num4;
		//个数(2bytes)
		num1=fis.read();
		num2=fis.read();
		int linesCount=(num1<<8)+num2;
		System.out.println("\t\t\t\tLineNumberTable:\t//一共"+totalBytes+" bytes,一共"+linesCount+"行");
		if(linesCount>0){
			System.out.println("\t\t\t\t\t源码行号\t指令索引");
			for(int j=1;j<=linesCount;j++){
				//字节码指令号(2bytes)
				num1=fis.read();
				num2=fis.read();
				//源码行号(2bytes)
				num3=fis.read();
				num4=fis.read();
				System.out.println("\t\t\t\t\t#"+((num3<<8)+num4)+"\t#"+((num1<<8)+num2));
			}
		}
	}

	private static void handleLocalVariableTable(FileInputStream fis) throws IOException {
		//1.attribute_length
		int num1=fis.read();
		int num2=fis.read();
		int num3=fis.read();
		int num4=fis.read();
		int attribute_length=(num1<<24)+(num2<<16)+(num3<<8)+num4;
		
		//2.local_variable_table_length
		num1=fis.read();//high byte of local_variable_table_length
		num2=fis.read();//low byte of local_variable_table_length
		int local_variable_table_length=(num1<<8)+num2;
		
		//3.local_variable_table
		System.out.println("\t\t\t\tLocalVariableTable:\t//一共"+attribute_length+" bytes,一共"+local_variable_table_length+"行");
		if(local_variable_table_length>0){
			System.out.println("\t\t\t\t\tstart_pc\tlength\tname\tindex\tdescriptor");
			for(int i=0;i<local_variable_table_length;i++){
				//3.1.each local_variable_item
				//start_pc
				num1=fis.read();//high byte of start_pc
				num2=fis.read();//low byte of start_pc
				int start_pc=(num1<<8)+num2;
				
				//length
				num1=fis.read();//high byte of length
				num2=fis.read();//low byte of length
				int length=(num1<<8)+num2;
				
				//name_index
				num1=fis.read();//high byte of name_index
				num2=fis.read();//low byte of name_index
				int name_index=(num1<<8)+num2;
				String uft8name=constantPoolMap.get(name_index);
				
				//descriptor_index(即type_index)
				num1=fis.read();//high byte of descriptor_index
				num2=fis.read();//low byte of descriptor_index
				int descriptor_index=(num1<<8)+num2;
				String uft8descriptor=constantPoolMap.get(descriptor_index);
				
				//index
				num1=fis.read();//high byte of index
				num2=fis.read();//low byte of index
				int index=(num1<<8)+num2;
				System.out.println("\t\t\t\t\t"+start_pc+"\t\t"+length+"\t"+uft8name+"\t"+index+"\t"+uft8descriptor);
			}
		}
		System.out.println();
	}

	private static void handleFields(FileInputStream fis) throws IOException {
		System.out.println("************fields begin*********************");
		int num1=fis.read();//high byte of fields number
		int num2=fis.read();//low byte of fields number
		int fieldsNumber=(num1<<8)+num2;
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t"+fieldsNumber+"\t//一共"+fieldsNumber+"个字段");
		for(int i=1;i<=fieldsNumber;i++){
			System.out.println("\t*************fileld "+i+"***********************");
			//access_flags
			num1=fis.read();//high byte of access_flags of current field
			num2=fis.read();//low byte of access_flags of current field
			int access_flags=(num1<<8)+num2;
			StringBuilder sb=new StringBuilder("");
			if((access_flags&1)!=0){
				sb.append("ACC_PUBLIC,");
			}
			if((access_flags&2)!=0){
				sb.append("ACC_PRIVATE,");
			}
			if((access_flags&4)!=0){
				sb.append("ACC_PROTECTED,");
			}
			if((access_flags&8)!=0){
				sb.append("ACC_STATIC,");
			}
			if((access_flags&16)!=0){
				sb.append("ACC_FINAL,");
			}
			if((access_flags&64)!=0){
				sb.append("ACC_VOLATILE,");
			}
			if((access_flags&128)!=0){
				sb.append("ACC_TRANSIENT,");
			}
			if((access_flags&4096)!=0){
				sb.append("ACC_SYNTHETIC,");
			}
			if((access_flags&16384)!=0){
				sb.append("ACC_ENUM,");
			}
			System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//access_flags="+sb.toString());
			//name_index
			num1=fis.read();//high byte of name_index
			num2=fis.read();//low byte of name_index
			int nameIndex=(num1<<8)+num2;
			String utf8name=constantPoolMap.get(nameIndex);
			System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t#"+nameIndex+"\t//"+utf8name);
			
			//descriptor_index(即类型，如I表示int,F表示float,D表示double...)
			num1=fis.read();//high byte of descriptor_index
			num2=fis.read();//low byte of descriptor_index
			int descriptorIndex=(num1<<8)+num2;
			String utf8descriptor=constantPoolMap.get(descriptorIndex);
			System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t#"+descriptorIndex+"\t//"+utf8descriptor);
			
			//attribute_count
			num1=fis.read();//high byte of attribute_count
			num2=fis.read();//low byte of attribute_count
			int attribute_count=(num1<<8)+num2;
			System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t"+attribute_count+"\t//一共"+attribute_count+"个属性");
			for(int j=1;j<=attribute_count;j++){
				System.out.println("\t\t********attribute "+j+"************");
				//attribute_name_index
				num1=fis.read();//high byte of attribute_name_index
				num2=fis.read();//low byte of attribute_name_index
				int attribute_name_index=(num1<<8)+num2;
				String utf8_attribute_name=constantPoolMap.get(attribute_name_index);
				System.out.println("\t\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t#"+attribute_name_index+"\t//"+utf8_attribute_name);
				//attribute_length(4 bytes,值固定为2)
				num1=fis.read();
				num2=fis.read();
				int num3=fis.read();
				int num4=fis.read();
				int attribute_length=(num1<<24)+(num2<<16)+(num3<<8)+num4;
				System.out.println("\t\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+getHexStringOfInt(num3)+getHexStringOfInt(num4)+"\t"+attribute_length+"\t//attribute_length="+attribute_length);
				//constant_value_index
				num1=fis.read();//high byte of constant_value_index
				num2=fis.read();//low byte of constant_value_index
				int constant_value_index=(num1<<8)+num2;
				System.out.println("\t\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t#"+constant_value_index+"\t//constant_value_index=#"+constant_value_index);
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("************fields end***********************");
		System.out.println();
	}

	private static void handleInterfaces(FileInputStream fis) throws IOException {
		System.out.println("*************interfaces**********************");
		int num1=fis.read();//high byte of interfaces number
		int num2=fis.read();//low byte of interfaces number
		int interfacesNum=(num1<<8)+num2;
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t"+interfacesNum+"\t//一共实现了"+interfacesNum+"个接口");
		for(int i=1;i<=interfacesNum;i++){
			num1=fis.read();//high byte of current interface class index
			num2=fis.read();//low byte of current interface class index
			int interfaceClassIndex=(num1<<8)+num2;
			int utf8index_interfaceClass = Integer.parseInt(constantPoolMap.get(interfaceClassIndex));
			String interfaceClassUtf8Name=constantPoolMap.get(utf8index_interfaceClass);
 			System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t#"+interfaceClassIndex+"\t//"+interfaceClassUtf8Name);
		}
		System.out.println();
	}

	private static void handleSuperClassName(FileInputStream fis) throws IOException {
		System.out.println("***********super class name**************");
		int num1=fis.read();//high byte of super class  index
		int num2=fis.read();//low byte of super class  index
		int superClassIndex=(num1<<8)+num2;
		int index_uft8name_superClass=Integer.parseInt(constantPoolMap.get(superClassIndex));
		String uft8name_superClass=constantPoolMap.get(index_uft8name_superClass);
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t#"+superClassIndex+"\t//"+uft8name_superClass);
		System.out.println();
	}

	private static void handleClassName(FileInputStream fis) throws IOException {
		System.out.println("***********class name**************");
		int num1=fis.read();//high byte of class  index
		int num2=fis.read();//low byte of class  index
		int classIndex=(num1<<8)+num2;
		int index_uft8name_class = Integer.parseInt(constantPoolMap.get(classIndex));
		String uft8name_class=constantPoolMap.get(index_uft8name_class);
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t#"+classIndex+"\t//"+uft8name_class);
		System.out.println();
	}

	private static void handleAccessFlag(FileInputStream fis) throws IOException {
		System.out.println("**********Access_Flag 访问标志**************");
		int num1 = fis.read();//high byte of Access_Flag 
		int num2 = fis.read();//low byte of Access_Flag 
		int accessFlag=(num1<<8)+num2;
		StringBuilder sb=new StringBuilder("");
		if((accessFlag&1)!=0){
			sb.append("ACC_PUBLIC,");
		}
		if((accessFlag&16)!=0){
			sb.append("ACC_FINAL,");
		}
		if((accessFlag&32)!=0){
			sb.append("ACC_SUPER,");
		}
		if((accessFlag&512)!=0){
			sb.append("ACC_INTERFACE,");
		}
		if((accessFlag&1024)!=0){
			sb.append("ACC_ABSTRACT,");
		}
		if((accessFlag&4096)!=0){
			sb.append("ACC_SYNTHETIC,");
		}
		if((accessFlag&8192)!=0){
			sb.append("ACC_ANNOTATION,");
		}
		if((accessFlag&16384)!=0){
			sb.append("ACC_ENUM,");
		}
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//Access_Flag="+sb.toString());
		System.out.println();
	}

	private static void handelConstantPool(FileInputStream fis) throws IOException {
		System.out.println("***************constant poool begin**************************************");
		int num1=fis.read();//high byte of constant pool size 
		int num2=fis.read();//low byte of constant pool size 
		int constantPoolSize=(num1<<8)+num2-1;//constant pool size 
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//="+constantPoolSize+"(constant_pool_size="+constantPoolSize+")");
		System.out.println();
		
		for(int i=1;i<=constantPoolSize;i++){
			System.out.println("\t*********constant #"+i+"*********");
			int constantTag=fis.read();
			switch (constantTag) {
			case 1://CONSTANT_Utf8_info
				System.out.println("\t0x"+getHexStringOfInt(1)+"\t//tag=1(Utf8)");
				tagU1_lengthU2_bytesUx(1,fis,i);
				break;
			case 3://CONSTANT_Integer_info
				System.out.println("\t0x"+getHexStringOfInt(3)+"\t//tag=3(Integer)");
				tagU1_bytesU4(fis);
				break;
			case 4://CONSTANT_Float_info
				System.out.println("\t0x"+getHexStringOfInt(4)+"\t//tag=4(Float)");
				tagU1_bytesU4(fis);
				break;
			case 5://CONSTANT_Long_info
				System.out.println("\t0x"+getHexStringOfInt(5)+"\t//tag=5(Long)");
				tagU1_bytesU8(fis);
				break;
			case 6://CONSTANT_Double_info
				System.out.println("\t0x"+getHexStringOfInt(6)+"\t//tag=6(Double)");
				tagU1_bytesU8(fis);
				break;
			case 7://CONSTANT_Class_info
				System.out.println("\t0x"+getHexStringOfInt(7)+"\t//tag=7(Class)");
				tagU1_indexU2(7,fis,i);
				break;
			case 8://CONSTANT_String_info
				System.out.println("\t0x"+getHexStringOfInt(8)+"\t//tag=8(String)");
				tagU1_indexU2(8,fis,i);
				break;
			case 9://CONSTANT_Fieldref_info
				System.out.println("\t0x"+getHexStringOfInt(9)+"\t//tag=9(Fieldref)");
				tagU1_indexU2_indexU2(fis);    
				break;
			case 10://CONSTANT_Methodref_info
				System.out.println("\t0x"+getHexStringOfInt(10)+"\t//tag=10(Methodref)");
				tagU1_indexU2_indexU2(fis);     
				break;
			case 11://CONSTANT_InterfaceMethodref_info
				System.out.println("\t0x"+getHexStringOfInt(11)+"\t//tag=11(InterfaceMethodref)");
				tagU1_indexU2_indexU2(fis);
				break;
			case 12://CONSTANT_NameAndType_info
				System.out.println("\t0x"+getHexStringOfInt(12)+"\t//tag=12(NameAndType)");
				tagU1_indexU2_indexU2(fis);
				break;
			}
			System.out.println();
		}
		System.out.println("***************constant poool end**************************************");
		System.out.println();
	}


	private static void tagU1_lengthU2_bytesUx(int tag,FileInputStream fis,int index) throws IOException {
		int num1=fis.read();
		int num2=fis.read();
		int bytesNum=(num1<<8)+num2;
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//UTF-8编码的字符串长度为"+bytesNum);
		
		StringBuilder sb=new StringBuilder("");
		byte[] bytes=new byte[bytesNum];
		for(int i=0;i<bytesNum;i++){
			num1=fis.read();
			bytes[i]=(byte) num1;
			sb.append(getHexStringOfInt(num1));
		}
		String utf8=new String(bytes, "utf-8");
		System.out.println("\t0x"+sb.toString()+"\t//长度为的UTF-8编码的字符串为"+utf8);
		constantPoolMap.put(index, utf8);
	}

	private static void tagU1_bytesU4(FileInputStream fis) throws IOException {
		int num1=fis.read();
		int num2=fis.read();
		int num3=fis.read();
		int num4=fis.read();
		System.out.println("\t0x"+getHexStringOfInt(num1)+
								getHexStringOfInt(num2)+
								getHexStringOfInt(num3)+
								getHexStringOfInt(num4)+"\t//value is "+((num1<<24)
																		 +(num2<<16)
																		 +(num3<<8)
																		 +num4));
	}

	private static void tagU1_bytesU8(FileInputStream fis) throws IOException {
		int num1=fis.read();
		int num2=fis.read();
		int num3=fis.read();
		int num4=fis.read();
		int num5=fis.read();
		int num6=fis.read();
		int num7=fis.read();
		int num8=fis.read();
		System.out.println("\t0x"+getHexStringOfInt(num1)+
								getHexStringOfInt(num2)+
								getHexStringOfInt(num3)+
								getHexStringOfInt(num4)+
								getHexStringOfInt(num5)+
								getHexStringOfInt(num6)+
								getHexStringOfInt(num7)+
								getHexStringOfInt(num8)+"\t//value is "+((num1<<56)
																		 +(num2<<48)
																		 +(num3<<40)
																		 +(num4<<32)
																		 +(num5<<24)
																		 +(num6<<16)
																		 +(num7<<8)
																		 +num8));
	}

	private static void tagU1_indexU2(int tag,FileInputStream fis,int index_) throws IOException {
		int num1=fis.read();
		int num2=fis.read();
		int index=(num1<<8)+num2;
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//index=#"+index);
		if(tag==7){//表示是Class
			constantPoolMap.put(index_, index+"");
		}
	}

	private static void tagU1_indexU2_indexU2(FileInputStream fis) throws IOException {
		int num1=fis.read();
		int num2=fis.read();
		int index=(num1<<8)+num2;
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//index=#"+index);
		
		num1=fis.read();
		num2=fis.read();
		index=(num1<<8)+num2;
		System.out.println("\t0x"+getHexStringOfInt(num1)+getHexStringOfInt(num2)+"\t//index=#"+index);
	}
}
