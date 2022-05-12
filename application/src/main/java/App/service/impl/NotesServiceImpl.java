package App.service.impl;

import App.dto.NotesDto;
import App.mapper.NotesMapper;
import App.model.Notes;
import App.repository.NotesRepository;
import App.service.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesServiceImpl implements NotesService {

    private final NotesRepository repository;
    private final NotesMapper mapper;

    @Override
    @Transactional
    public List<NotesDto> findAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    @Transactional
    public Notes add(Notes note) {
        return repository.save(note);
    }

    @Override
    @Transactional
    public void deleteTheLastRow() {
        repository.customDeleteTheLastRow();
    }

    @Override
    @Transactional
    public void updateNoteById(String text, Long id) {
        repository.customUpdateNoteById(text, id);
    }

    @Override
    @Transactional
    public void deleteEmptyNoteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void switchStatusOfNoteById(Boolean status, Long id) {
        repository.updateNoteStatusById(status, id);
    }
}
