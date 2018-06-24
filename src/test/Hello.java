package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Hello {
	
	public static void main(String[] args) {
		int length=100000;
		for(int i=1;i<=20;i++){
			Integer[] arr=new Integer[length];
			for(int j=0;j<length;j++){
				arr[j]=j+1;
			}
			shuffer(arr);
			quickSort(arr);
			
			arr=new Integer[length];
			for(int j=0;j<length;j++){
				arr[j]=j+1;
			}
			shuffer(arr);
			//bubbleSort(arr);
			myBubbleSort(arr);
		}
	}
	
	
	
	public static void myBubbleSort(Integer[] arr){
		long t1 = System.currentTimeMillis();
		int length=arr.length;
		for(int i=0;i<=length-1;i++){
			int currMaxIndex=0;
			for(int j=1;j<=length-i-1;j++){
				if(arr[j]>arr[currMaxIndex]){
					currMaxIndex=j;
				}
			}
			int temp=arr[length-i-1];
			arr[length-i-1]=arr[currMaxIndex];
			arr[currMaxIndex]=temp;
		}
		System.out.println("我的冒泡排序耗时："+(System.currentTimeMillis()-t1)+"毫秒！");
	}
	
	public static void quickSort(Integer[] arr){
		long t1 = System.currentTimeMillis();
		quickSort2(arr, 0, arr.length-1);
		System.out.println("快速排序耗时："+(System.currentTimeMillis()-t1)+"毫秒！");
	}
	
	public static void bubbleSort(Integer[] arr){
			int length=arr.length;
			long t1 = System.currentTimeMillis();
			for(int i = 0;i < length-1;i++){
				    for(int j = 0;j < length - 1 - i;j++){
				        if(arr [j] > arr[j + 1]){
				            int temp = arr[j];
				            arr[j] = arr [j + 1];
				            arr[j+1] = temp;
				        }
				    }
			}
			System.out.println("冒泡排序耗时："+(System.currentTimeMillis()-t1)+"毫秒！");
	}
	
	
	private static void quickSort2(Integer[] arr,int fromIndex,int toIndex){
		if(fromIndex>=toIndex){
			return;
		}
		
		//	200		100		10		5       40		50     		3      900      30      60		
		//	0		1  		2  		3  		4  		[5]  		6  		7 		8 		9  
		//	0																	length-1
		
		//0 1 2 3 4 5 6
		
		int middleNum=arr[fromIndex];//50
		int num_smaller=0;//定义为小于等于标出数的数字的个数
		for(int i=fromIndex;i<=toIndex;i++){
			if(arr[i]<=middleNum){
				num_smaller++;
			}
		}
		//middleNum    			middleNum[最后在赋值]
		//fromIndex  ...  fromIndex+num_smaller-1 	... toIdex
		//则middleNum最终的角标就是fromIndex+num_smaller-1
		//交换fromIndex和fromIndex+num_smaller-1角标处的元素
		arr[fromIndex]=arr[fromIndex+num_smaller-1];
		arr[fromIndex+num_smaller-1]=middleNum;
		
		int offset=0;
		for(int i=fromIndex;i<(fromIndex+num_smaller-1);i++){
			if(arr[i]>middleNum){
				for(int j=fromIndex+num_smaller+offset;j<=toIndex;j++){
					offset++;
					if(arr[j]<=middleNum){
						int temp=arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
						break;
					}
				}
			}
		}
		quickSort2(arr, fromIndex, fromIndex+num_smaller-2);
		quickSort2(arr, fromIndex+num_smaller, toIndex);
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
