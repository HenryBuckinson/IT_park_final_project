package App.repository.custom;

import App.model.Notes;

public interface NotesCustomRepository {
    Notes removeTheLastRow();

    void updateNoteById(String text, Long id);

    void switchNoteStatusById(Boolean status, Long id);

}
