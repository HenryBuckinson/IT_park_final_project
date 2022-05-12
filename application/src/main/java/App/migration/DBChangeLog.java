package App.migration;

import App.model.Notes;
import App.repository.NotesRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;

@ChangeLog
@RequiredArgsConstructor
public class DBChangeLog {


    @ChangeSet(order = "001", id = "dbCreation", author = "Henry")
    public void dropDb(MongoDatabase db) {
        db.createCollection("notes");
    }


    @ChangeSet(order = "002", id = "testInsert2", author = "Henry")
    public void insertMongoDBNote(NotesRepository repository) {
        repository.save(new Notes());
    }

    @ChangeSet(order = "003", id = "testInsert3", author = "Henry")
    public void insertMongoDBNote2(NotesRepository repository) {
        repository.save(new Notes());
    }

}
