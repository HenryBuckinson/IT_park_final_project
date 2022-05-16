package App.mvc.rest;

import App.controller.rest.NotesRestController;
import App.service.NotesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotesRestController.class)
@DisplayName("REST-Контроллер должен уметь:")
public class NotesRestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    private NotesService notesService;

    @Test
    @DisplayName("Передавать JSON-строку в метод сервиса, чтобы обновить запись по её идентификатору")
    public void shouldUpdateNoteById() throws Exception {
        String text = "{\"note\":\"updateable text\"}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/notes/update/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(text))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(200);
    }

    @Test
    @DisplayName("Удалить заметку с пустым текстовым полем")
    public void shouldDeleteEmptyNote() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/notes/delete/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(200);
    }

    @Test
    @DisplayName("Переключать статус заметки")
    public void shouldSwitchNotesStatus() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/notes/set-status/1")
                        .param("status","true"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(200);
    }

}
