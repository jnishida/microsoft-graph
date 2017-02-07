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

	public String authToken() throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType,
				"grant_type=authorization_code&code=AQABAAAAAADRNYRQ3dhRSrm-4K-adpCJ1lVRg9HJoP9m1RYrAHXaTVLk79aqqpvF9AhYDHS25hCSeBYOgalvT8NmeXAqm4zCpq-6dfvcZaEmlZKzRypqmccm0WgTHFWVOPH1WYoGrXcM4IUQ_5ECxhyM3FR9y5RlwNaTxt1n1joZFvaHcIkYk2RPazeQ0jptADLIrrGoCXjzwj3HkOx5i8qVMgBxc8eAOcWCwYbYuCendPA5Q6QQ2Nrmn_7B-VR2lcy46yUTFYraQbVA_c_MjET46xYhj_W021xGqblfLsBBo-0xX1n4e_svSZ0PeWnK3R1nHCC2fg5bq0zczf5FkXOZ15x5OQwF2I2fidmNJrvLyiW-j0vb2h1zU6ZFUyjch440HK05Y3OZwNx7pWSfSXRdkgZXUSVqghrt5009gIxFouINw26gYqGtXIfWgGcXYzVslhX8hKSvJzGowfh_2oSZkTlzbd_7ijESN1c6ezBPwTDYxSY6KR0eW4yJWGldNdq52h7QLgSB5DvluXZTzCt8sYiQaDgRvPp7-DtSSwJ8HoejKiXrgg09KJEm3RtvxRApvUAMcOKux84yRxigwoZqa6x2n8IBSvv38G-wt9fL_wtXYqW7VpjlIypPetSGNljU3OJtyoqQXur-4P3F_QPIC711Ihmjxet3AvXKaFayOc-TdSipllUa8lDITVEdrAbTESXOLKUnuwTPb4xgY237j7JBIN235i442gYCiEarTEDszhUDtL3X40IKsBDkS8s9NChxgk2V_8oBMMPIyUdVoD0KwXCY4sFq54iJabgY-1tIkfYgJn3nPhzzSTV7WHdcD_Z35jggAA%26session_state%3Da8c2b8d6-35df-4f92-a1b5-a21a4c18ee4f&redirect_uri=http%3A%2F%2Flocalhost%2Fapp2&client_id=245d6858-a76e-4a80-8afa-9283c90274a3");
		Request request = new Request.Builder()
				.url("https://login.windows.net/common/oauth2/token/")
				.post(body)
				.addHeader("content-type", "application/x-www-form-urlencoded")
				.addHeader("cache-control", "no-cache")
				.build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}