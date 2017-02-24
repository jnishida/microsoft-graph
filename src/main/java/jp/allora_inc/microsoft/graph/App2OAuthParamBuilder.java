package jp.allora_inc.microsoft.graph;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class App2OAuthParamBuilder extends HttpParamBuilder {
	private App2OAuthParamBuilder() throws IOException {
		App2Config config = new App2Config();
		append("grant_type", "authorization_code");
		append("redirect_uri", config.getRedirectUri(), "UTF-8");
		append("client_id", config.getClientId(), "UTF-8");
	}

	public static App2OAuthParamBuilder withCode(String code) throws IOException {
		App2OAuthParamBuilder me = new App2OAuthParamBuilder();
		return me.code(code);
	}

	private App2OAuthParamBuilder code(String value) throws IOException {
		append("code", value);
		return this;
	}
}
