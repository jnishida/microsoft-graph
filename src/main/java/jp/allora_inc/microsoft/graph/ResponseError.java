package jp.allora_inc.microsoft.graph;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseError {
	private Error error;

	@Data
	public class Error {

		private String code;
		private String Message;
		private InnerError innerError;

		@Data
		public class InnerError {
			@JsonProperty("request-id")
			private String request_id;
			private Date date;
		}

	}

}

