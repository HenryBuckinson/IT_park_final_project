package App.controller;

import App.dto.NotesDto;
import App.model.Notes;
import App.repository.NotesRepository;
import App.service.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NotesController {

    private final NotesService service;

    @GetMapping
    public String index(Model model) {
        List<NotesDto> allNotes = service.findAll();
        model.addAttribute("allNotes", allNotes);
        return "notes";
    }

    @PostMapping("/add")
    public String addNote() {
        service.add(new Notes());
        return "redirect:/notes";
    }

    @PostMapping ("/delete")
    public String deleteRow() {
        service.deleteTheLastRow();
        return "redirect:/notes";
    }

}
