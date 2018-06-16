package classAnalyser.classFile;

import classAnalyser.struct.U2Struct;

/*
 * minor_version和major_version的值分别表示Class文件的副、主版本。
 * 它们共同构成了Class文件的格式版本号。
 * 譬如某个Class文件的主版本号为M，副版本号为m，那么这个Class文件的格式版本号就确定为M.m。
 * Class文件格式版本号大小的顺序为：1.5 < 2.0 < 2.1。
一个Java虚拟机实例只能支持特定范围内的主版本号（Mi至Mj）和0至特定范围内（0至m）的副版本号。
假设一个Class文件的格式版本号为V，仅当Mi.0 ≤ v ≤ Mj.m成立时，这个Class文件才可以被此Java虚拟机支持。
不同版本的Java虚拟机实现支持的版本号也不同，高版本号的Java虚拟机实现可以支持低版本号的Class文件，反之则不成立①。

① Oracle 的JDK在1.0.2版本时，支持的Class格式版本号范围是45.0至45.3；JDK版本在1.1.x时，
	支持的Class格式版本号范围扩展至45.0至45.65535；JDK版本为1. k时（k ≥2）时，
	对应的Class文件格式版本号的范围是45.0至44+k.0
 */
public class MinorVersion extends U2Struct{
	
}
