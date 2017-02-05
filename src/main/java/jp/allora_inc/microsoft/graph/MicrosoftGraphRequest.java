package jp.allora_inc.microsoft.graph;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

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
}