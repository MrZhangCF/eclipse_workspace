package offer;

/**
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
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
