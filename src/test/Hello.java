package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Hello {
	
	public static void main(String[] args) {
		
		String[] arr=new String[]{"xabcefg","sabceexxxfuck","abce","abce","abcexxx"};
		System.out.println(getLongestPrefix(arr));
	}
	
	
	public static String getLongestPrefix(String[] arr){
		String str1=arr[0];
		String longestPrefix = null;
		for(int i=1;i<str1.length()+1;i++){
			longestPrefix=str1.substring(0, i);
			boolean isOk=true;
			for(int j=1;j<arr.length;j++){
				String currStr=arr[j];
				if(!currStr.startsWith(longestPrefix)){
					isOk=false;
					break;
				}
			}
			if(!isOk){
				longestPrefix=longestPrefix.substring(0,longestPrefix.length()-1);
				break;
			}
		}
		return longestPrefix;
	}
	public static Integer[] getShuffer(Integer[] arr){
			Random r = new Random();
			Integer[] newArr=new Integer[arr.length];
			
			for(int i=0;i<arr.length;i++){
				int randomIndex = r.nextInt(arr.length-i);
				newArr[i]=arr[randomIndex];
				arr[randomIndex]=arr[arr.length-1-i];
			}
			return newArr;
	}
	
	public static void shuffer(Integer[] arr){
			Random r = new Random();
			for(int i=0;i<arr.length;i++){
				int randomIndex = r.nextInt(arr.length-i);
				Integer temp = arr[arr.length-1-i];
				arr[arr.length-1-i]=arr[randomIndex];
				arr[randomIndex]=temp;
			}
	}
	
	
	public static void printArr(Integer[] arr){
		System.out.println(Arrays.asList(arr));
	}
	
	
	
	public static HashMap<String, Integer> getLargestAndSecondLargestNumber(Integer[] arr){
		HashMap<String, Integer> r = new HashMap<String,Integer>();
		
		Integer feizi_huangdi=arr[0];
		Integer feizi_taizi=arr[1];
		
		if(feizi_taizi>feizi_huangdi){
			feizi_taizi=arr[0];
			feizi_huangdi=arr[1];
		}
		
		for(int i=2;i<arr.length;i++){
			int feizi_curr=arr[i];
			if(feizi_curr>feizi_huangdi){//如果皇帝相中了，就把皇帝当前被pass掉的妃子让太子看文太子是否愿意要
				if(feizi_huangdi>feizi_taizi){
					feizi_taizi=feizi_huangdi;
				}
				feizi_huangdi=feizi_curr;
			}else{//如果皇帝相不中，则让太子看是否相中
				if(feizi_curr>feizi_taizi){
					feizi_taizi=feizi_curr;
				}
			}
		}
		r.put("largestNumber", feizi_huangdi);
		r.put("secondLargestNumber", feizi_taizi);
		return r;
	}
}
