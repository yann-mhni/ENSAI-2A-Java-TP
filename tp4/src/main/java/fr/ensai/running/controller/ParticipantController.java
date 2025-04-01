package fr.ensai.running.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ensai.running.model.Participant;
import fr.ensai.running.service.ParticipantService;

@Controller
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("participants", participantService.findAll());
        return "allparticipants";
    }

    @GetMapping("/addNew")
    public String addNewEmployee(Model model) {
        Participant participant = new Participant();
        model.addAttribute("participant", participant);
        return "createParticipant";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("participant") Participant participant) {
        participantService.save(participant);
        return "redirect:/participant";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") long id) {
        participantService.deleteById(id);
        return "redirect:/participant";

    }
}