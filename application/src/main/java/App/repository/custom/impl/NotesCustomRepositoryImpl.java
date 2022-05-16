package App.repository.custom.impl;

import App.model.Notes;
import App.repository.custom.NotesCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@RequiredArgsConstructor
public class NotesCustomRepositoryImpl implements NotesCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Notes removeTheLastRow() {
        final Query id = new Query().limit(1).with(Sort.by(Sort.Direction.DESC, "order"));
        return mongoTemplate.findAndRemove(id, Notes.class);
    }

    @Override
    public void updateNoteById(String text, Long id) {
        Query query = new Query().addCriteria(Criteria.where("order").is(id));
        Update set = new Update().set("note", text);
        mongoTemplate.updateFirst(query, set, Notes.class);
    }

    @Override
    public void switchNoteStatusById(Boolean status, Long id) {
        Query query = new Query().addCriteria(Criteria.where("order").is(id));
        Update is_done = new Update().set("is_Done", status);
        mongoTemplate.updateFirst(query, is_done, Notes.class);
    }

}
