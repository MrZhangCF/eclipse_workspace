package anwser;

import java.util.ArrayList;
import java.util.Arrays;

public class No27 {
	public ArrayList<String> Permutation(String str) {
	       if (str == null)
	           return null;
	           //return new ArrayList<String>();
	       ArrayList<String> arrayList = new ArrayList<String>();
	       StringBuffer stringBuffer = new StringBuffer(str);
	       Permutation(arrayList, stringBuffer, 0);
	       String[] strArray = new String[arrayList.size()];
	       arrayList.toArray(strArray);
	       Arrays.sort(strArray);
	       for (int i=0; i<arrayList.size(); i++) {
	           arrayList.set(i, strArray[i]);
	       }
	       return arrayList;
	    }

	    public void Permutation(ArrayList<String> arrayList, StringBuffer stringBuffer, int ind) {
	        if (ind == stringBuffer.length()-1) {
	            if (!arrayList.contains(stringBuffer.toString())) {
	                arrayList.add(stringBuffer.toString());
	                System.out.println(stringBuffer.toString());
	            }
	        } else {
	            for (int i=ind; i<stringBuffer.length(); i++) {
	                char temp = stringBuffer.charAt(i);
	                stringBuffer.setCharAt(i, stringBuffer.charAt(ind));
	                stringBuffer.setCharAt(ind, temp);

	                Permutation(arrayList, stringBuffer, ind+1);

	                temp = stringBuffer.charAt(i);
	                stringBuffer.setCharAt(i, stringBuffer.charAt(ind));
	                stringBuffer.setCharAt(ind, temp);
	            }
	        }
	    }

	    public static void main (String[] args) {
	        No27 solution = new No27();
	        ArrayList<String> arrayList = new ArrayList<String>();
	        arrayList = solution.Permutation("abcd");

	        //System.out.println(arrayList.size());
//	        for (String item : arrayList) {
//	            System.out.println(item);
//	        }
	    }

}
