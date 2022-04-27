package zandi.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import zandi.server.dto.SubwayReqDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SubwayController.class)
class SubwayControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void findSubwayInfo() throws Exception {

        String content = objectMapper.writeValueAsString(new SubwayReqDto())

        mockMvc.perform(MockMvcRequestBuilders.post("/subway").
                with(request -> {
                    request.addParameter("startStation", "공릉");
                    request.addParameter("endStation", "태릉입구");
                    request.addParameter("trainNum", String.valueOf(4241));
                    request.addParameter("transferStation", "건대입구");
                    request.addParameter("startTime", "16:32:24");
                    return request;
                })).andDo(print());
    }
}