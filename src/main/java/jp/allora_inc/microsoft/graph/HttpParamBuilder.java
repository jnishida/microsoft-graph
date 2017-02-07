package jp.allora_inc.microsoft.graph;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpParamBuilder {
	Map<String, String> params = new LinkedHashMap<>();
	
	public HttpParamBuilder append(String key, String value) {
		params.put(key, value);
		return this;
	}

	@Override
	public String toString() {
		return params.entrySet().stream()
			.map(e -> e.getKey() + "="+ e.getValue())
			.collect(Collectors.toList())
			.stream()
			.collect(Collectors.joining("&"));
	}
}
