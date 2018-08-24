package demo;

class GetSet {
	private volatile int value = 0;

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

public class TestDemo12 {

	public static void main(String[] args) throws InterruptedException {
		String str = "abcd";
		System.out.println(str.charAt(str.length()-1));
	}

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
