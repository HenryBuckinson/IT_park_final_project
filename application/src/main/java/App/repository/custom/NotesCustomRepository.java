package App.repository.custom;

import App.model.Notes;

public interface NotesCustomRepository {
    Notes customDeleteTheLastRow();

    void customUpdateNoteById(String text, Long id);

    void updateNoteStatusById(Boolean status, Long id);

    void  updateNumeration();
}
