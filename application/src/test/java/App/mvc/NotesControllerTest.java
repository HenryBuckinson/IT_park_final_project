package App.mvc;

import App.controller.NotesController;
import App.service.NotesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(NotesController.class)
@DisplayName("Контроллер должен уметь:")
public class NotesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotesService service;


    @Test
    @DisplayName("Загружать главную рабочую область приложениия")
    public void shouldReturnAllNotes() throws Exception {
        this.mockMvc.perform(get("/notes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("notes"));
    }

}
