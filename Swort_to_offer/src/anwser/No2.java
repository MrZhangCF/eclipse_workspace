package anwser;

public class No2 {
	public String replaceSpace(StringBuffer str) {
		StringBuffer str_new = new StringBuffer();
		for(int i = 0;i<str.length();++i){
			if(str.charAt(i) == ' '){
				str_new.append("%20");
			}else{
				str_new.append(str.charAt(i));
			}
		}
		return str_new.toString();
	}
}
