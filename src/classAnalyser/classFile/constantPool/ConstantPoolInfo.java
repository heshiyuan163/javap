package classAnalyser.classFile.constantPool;

public abstract class ConstantPoolInfo {
	
	/**
	 * cp_info {
	 * 	 u1 tag; 
	 *   u1 info[];
	 * }
	 */
	private byte tag;

	public byte getTag() {
		return tag;
	}

	public void setTag(byte tag) {
		this.tag = tag;
	}
	

}
