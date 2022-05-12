package App.events;

import App.model.Notes;
import App.service.DefaultValueGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotesModelListener extends AbstractMongoEventListener<Notes> {

    private final DefaultValueGeneratorService generatorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Notes> event) {
        if (event.getSource().getOrder() < 1) {
            event.getSource().setOrder(generatorService.generateSequence(Notes.SEQUENCE_NAME));
        }
    }



}
