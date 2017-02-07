package jp.allora_inc.microsoft.graph;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class MicrosoftGraphRequest {
	public String execute() throws ClientProtocolException, IOException {
		String URL = "https://graph.microsoft.com/v1.0/me/";
		HttpGet request = new HttpGet(URL);

		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
			CloseableHttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		}
	}

	public String authToken(String code) throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

		String params = new HttpParamBuilder()
			.append("grant_type", "authorization_code")
			.append("code", code)
			.append("redirect_uri", "http://localhost:8088/app2", "UTF-8")
			.append("client_id", "245d6858-a76e-4a80-8afa-9283c90274a3")
			.toString();

		RequestBody body = RequestBody.create(mediaType, params);

		Request request = new Request.Builder().url("https://login.windows.net/common/oauth2/token/").post(body)
				.addHeader("content-type", "application/x-www-form-urlencoded").addHeader("cache-control", "no-cache")
				.build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}