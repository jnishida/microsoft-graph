package jp.allora_inc.microsoft.graph;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Value;

public class App1OAuthParamBuilder extends HttpParamBuilder {
	@Value("${app1.redirect.uri}")
	private String redirectUri;

	@Value("${qpp1.client.id}")
	private String clientId;

	@Value("${app1.client.secret}")
	private String clientSecret;

	public App1OAuthParamBuilder(String code) throws UnsupportedEncodingException {
		this();
		code(code);
	}

	private App1OAuthParamBuilder() throws UnsupportedEncodingException {
		append("grant_type", "authorization_code");
		append("redirect_uri", redirectUri);
		append("client_id", clientId);
		append("client_secret", clientSecret);
	}

	public static App1OAuthParamBuilder withCode(String code) throws UnsupportedEncodingException {
		return new App1OAuthParamBuilder().code(code);
	}

	private App1OAuthParamBuilder code(String value) {
		append("code", value);
		return this;
	}
}
