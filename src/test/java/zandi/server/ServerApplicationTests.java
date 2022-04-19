package zandi.server;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import zandi.server.domain.Subway;
import zandi.server.domain.SubwayImpl;

import java.io.IOException;

@SpringBootTest
class ServerApplicationTests {

	Subway subway = new SubwayImpl();

	@Test
	@DisplayName("실시간 도착정보 확인")
	public void realTimeInfo() throws IOException, ParseException {
		subway.getArriveInfoByName("경춘선");
	}

}
