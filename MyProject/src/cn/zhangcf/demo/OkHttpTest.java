package cn.zhangcf.demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpTest {
	public static String callback = null;
	
	public static void main(String[] args) throws IOException {
		
		String apiKey="HIDDEN BY MODERATOR";
        double latitude=37.8267;
        double longitude= -122.423;
		
		String serverAddress = "https://api.forecast.io/forecast/"+apiKey+"/"+latitude+","+longitude;
		OkHttpClient okHttpClient = new OkHttpClient();

		Request request = new Request.Builder().url(serverAddress).method("GET", null).build();
		Call call = okHttpClient.newCall(request);
		
		call.enqueue(new Callback() {

			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				//print(arg1);
				callback = arg1.body().string();
			}

			@Override
			public void onFailure(Call arg0, IOException arg1) {
			}
		});

//		Response response = okHttpClient.newCall(request).execute();
//		System.out.println(response);
	}
	
	public static void print(Response res){
		System.out.println(res);
	}

}
