package jp.allora_inc.microsoft.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HttpParamBuilderTest {

	@Test
	public void test() {
		String actual = new HttpParamBuilder()
			.append("C101", "ZZ12345")
			.append("A", "XX12345")
			.append("B", "CCC12345")
			.append("A00", "LL12345")
			.append("A", "UU12345")
			.toString();

		assertThat(actual).isEqualTo("C101=ZZ12345&A=UU12345&B=CCC12345&A00=LL12345");
	}

}
