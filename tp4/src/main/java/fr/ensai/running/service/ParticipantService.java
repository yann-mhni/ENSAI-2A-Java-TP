package fr.ensai.running.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ensai.running.model.Participant;
import fr.ensai.running.repository.ParticipantRepository;

@Service
public class ParticipantService {

    private static final Logger log = LoggerFactory.getLogger(ParticipantService.class);

    @Autowired
    private ParticipantRepository participantRepository;

    public Optional<Participant> findById(Long id) {
        return participantRepository.findById(id);
    }

    public List<Participant> findAll() {
        List<Participant> participantsList = new ArrayList<>();
        Iterable<Participant> participantsIterable = participantRepository.findAll();
        participantsIterable.forEach(participantsList::add);
        return participantsList;
    }

    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    public void deleteById(Long id) {
        participantRepository.deleteById(id);
        log.warn("Participant {} deleted", id);
    }
}