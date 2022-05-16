package App.repository;

import App.model.Notes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@DisplayName("Репозиторий на основе MongoDB должен уметь: ")
class ExampleDataMongoTest {

    @Autowired
    private NotesRepository repository;

    @Test
    @DisplayName("Добавлять запись, и удалять её по уникальному идентификатору.")
    public void shouldSaveAndFindByCode() {
        Notes notes = repository.save(new Notes());//По умолчаниию создается new Notes(0L,"New notes...",{аактуальная дата},false)
        Long order = notes.getOrder();
        assertThat(notes.getNote()).isNotEmpty();
        assertThat(repository.findAll()).isNotNull();
        repository.deleteById(order);
        assertThat(repository.findById(order)).isEmpty();
    }

    @Test
    @DisplayName("Переключать статус записи")
    public void shouldSwitchStatusOfNote() {
        Notes switchable_note = repository.save(new Notes());//По умолчаниию создается new Notes(0L,"New notes...",{аактуальная дата},false)
        Boolean is_done = switchable_note.getIs_Done();
        repository.switchNoteStatusById(true, 0L);
        assertThat("true").isEqualTo("true");
        repository.deleteById(0L);
    }

    @Test
    @DisplayName("Удалять заметку с пустым текстовым полем")
    public void shouldDeleteEmptyNote() {
        Notes note = repository.save(new Notes(0L, "", "{2022/05/13 10:10:10}", false));
        assertThat("").isEqualTo(note.getNote());
        repository.deleteById(0L);
        assertThat(note.getNote()).isEmpty();
    }
}
