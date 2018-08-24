package offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author zhangcf
 */

public class No2 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("We are happy  ");
		System.out.println(resplaceSpace(sb));
	}
	
	public static String resplaceSpace(StringBuffer str){
		String newStr = str.toString();
		String strs[] = newStr.split("");
		StringBuffer sb = new StringBuffer();
		for(int x=0;x<strs.length;x++){
			if(strs[x].equals(" ")){
				sb.append("%20");
			}else{
				sb.append(strs[x]);
			}
		}
		return sb.toString();
	}
}
