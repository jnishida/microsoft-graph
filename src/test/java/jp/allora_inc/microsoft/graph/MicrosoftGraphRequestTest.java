package jp.allora_inc.microsoft.graph;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MicrosoftGraphRequestTest {

	@Test
	public void トークンないからエラーになる() throws ClientProtocolException, IOException {
		String content = new MicrosoftGraphRequest().execute();
		System.out.println(content);

		ObjectMapper mapper = new ObjectMapper();
		ResponseError error = mapper.readValue(content, ResponseError.class);
		System.out.println(error);

		assertThat(error.getError().getCode()).isEqualTo("InvalidAuthenticationToken");
	}

	@Test
	public void 認証コード取得成功する() throws IOException  {
		String content = new MicrosoftGraphRequest().authToken();
		System.out.println(content);

		assertThat(content).doesNotContain("invalid_grant");
	}
}
