package fastcampus.GetInLine.controller.viewController;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * View Test
 */
@SpringBootTest
@AutoConfigureMockMvc
class BaseControllerTest {

    private final MockMvc mvc;

    public BaseControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][Get] 기본 페이지 요청")
    @Test
    void basePage_getRequestTest_success() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/"))   // '/' 로 GET 요청
                .andExpect(status().isOk()) // status 확인
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))  // HTML 인지 확인
                .andExpect(content().string(CoreMatchers.containsString("Test Page."))) // 내용 확인
                .andExpect(view().name("index"))    // View 이름 확인
                .andDo(print());


    }

}