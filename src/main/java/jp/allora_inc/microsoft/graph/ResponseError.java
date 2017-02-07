package jp.allora_inc.microsoft.graph;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Response Error
 * 
 * <p>JSON Sample</p>
 * <pre>
 * {
 *   "error": {
 *     "code": "InvalidAuthenticationToken",
 *     "message": "Bearer access token is empty.",
 *     "innerError": {
 *       "request-id": "1ae4dbdc-d53d-4451-a404-af4436968adc",
 *       "date": "2017-02-05T07:51:32"
 *     }
 *   }
 * }
 * </pre>
 * 
 * @author jnishida
 */
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
			private String requestId;
			private Date date;
		}

	}
}
