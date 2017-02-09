package jp.allora_inc.microsoft.graph;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Value;

public class App2OAuthParamBuilder extends HttpParamBuilder {
	@Value("${app2.redirect.uri}")
	private String redirectUri;

	@Value("${qpp2.client.id}")
	private String clientId;

	private App2OAuthParamBuilder() throws UnsupportedEncodingException {
		append("grant_type", "authorization_code");
		append("redirect_uri", redirectUri);
		append("client_id", clientId);
	}

	public static App2OAuthParamBuilder withCode(String code) throws UnsupportedEncodingException {
		return new App2OAuthParamBuilder().code(code);
	}

	private App2OAuthParamBuilder code(String value) {
		append("code", value);
		return this;
	}
}
