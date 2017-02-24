package jp.allora_inc.microsoft.graph;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class MicrosoftGraphRequest {
	public String me() throws ClientProtocolException, IOException {
		Request request = new Request.Builder()
			.url("https://graph.microsoft.com/v1.0/me/")
			.get()
			.addHeader("content-type", "application/x-www-form-urlencoded")
			.addHeader("cache-control", "no-cache")
			.build();

		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public String authToken(String code) throws IOException {
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

		String params = App2OAuthParamBuilder
			.withCode(code)
			.toString();
		System.out.println(params);

		RequestBody body = RequestBody.create(mediaType, params);

		Request request = new Request.Builder()
			.url("https://login.windows.net/common/oauth2/token/")
			.post(body)
			.addHeader("content-type", "application/x-www-form-urlencoded")
			.addHeader("cache-control", "no-cache")
			.build();

		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
