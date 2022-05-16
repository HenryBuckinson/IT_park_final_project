package App.service;

import App.dto.NotesDto;
import App.model.Notes;

import java.util.List;

public interface NotesService {
    List<NotesDto> findAll();

    Notes add(Notes note);

    void deleteTheLastRow();

    void updateNoteById(String text, Long id);

    void deleteEmptyNoteById(Long id);

    void switchStatusOfNoteById(Boolean status, Long id);
}
