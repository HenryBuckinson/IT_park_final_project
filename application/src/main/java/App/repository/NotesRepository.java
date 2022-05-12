package App.repository;

import App.model.Notes;
import App.repository.custom.NotesCustomRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface NotesRepository extends MongoRepository<Notes, Long>, NotesCustomRepository {
}
