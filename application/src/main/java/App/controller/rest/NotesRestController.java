package App.controller.rest;

import App.dto.NotesDto;
import App.model.Notes;
import App.service.NotesService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NotesRestController {

    private final NotesService notesService;

    @Operation(summary = "Обновляет текстовое поле заметки по её индексу")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Notes updateNote(@RequestBody NotesDto notedDto, @PathVariable("id") Long id) {
        notesService.updateNoteById(notedDto.getNote(), id);
        return new Notes(id,
                "{Изменённый текст}",
                new Date(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())),
                false);
    }

    @Operation(summary = "Удаляет заметку с пустым текстовым полем по её индексу")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/update/{id}")
    public Notes deleteEmptyNote(@PathVariable("id") Long id) {
        notesService.deleteEmptyNoteById(id);
        return new Notes(id,
                "{Пустая строка}",
                new Date(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())),
                true);
    }

    @Operation(summary = "Переключатель статуса заметки")
    @PostMapping("/progress/{id}/{isDone}")
    public Notes noteInProgress(@PathVariable("id") Long id, @PathVariable("isDone") String isDone) {
        Boolean response = Boolean.parseBoolean(isDone);
        notesService.switchStatusOfNoteById(response, id);
        return new Notes(id,
                "Заметка или запись",
                new Date(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())),
                response);
    }

}
