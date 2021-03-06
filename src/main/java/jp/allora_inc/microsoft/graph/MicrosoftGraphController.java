package jp.allora_inc.microsoft.graph;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicrosoftGraphController {
	// http://localhost:8088/me
	@GetMapping("me")
	public String me(Model model) throws IOException {
		MicrosoftGraphRequest request = new MicrosoftGraphRequest();
		return request.me();
	}

	// http://localhost:8088/app1
	@GetMapping("app1")
	public String app1(Model model, @RequestParam String code) throws IOException {
		return new MicrosoftGraphRequest().authToken(code);
	}

	// http://localhost:8088/app2
	@GetMapping("app2")
	public String app2(Model model, @RequestParam String code) throws IOException {
		return new MicrosoftGraphRequest().authToken(code);
	}
}
