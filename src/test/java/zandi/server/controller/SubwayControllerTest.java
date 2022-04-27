package zandi.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(SubwayController.class)
class SubwayControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    String readJson(String fileRoute) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        Reader reader = new FileReader(fileRoute);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        return jsonObject.toJSONString();
    }

    @Test
    void API_요청_테스트() throws Exception {

        //given
        String requestBody = readJson("src/test/resources/requestTest.json");
        //when
        ResultActions resultActions = mockMvc.perform(post("/subway")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print());
        //then
        resultActions
                .andExpect(status().isOk());
    }
}