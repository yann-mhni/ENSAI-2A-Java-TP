package fr.ensai.running.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.repository.AthleteRepository;

@Service
public class AthleteService {

    private static final Logger log = LoggerFactory.getLogger(AthleteService.class);

    @Autowired
    private AthleteRepository athleteRepository;

    public Optional<Athlete> findById(Long id) {
        return athleteRepository.findById(id);
    }

    public List<Athlete> findAll() {
        List<Athlete> athletesList = new ArrayList<>();
        Iterable<Athlete> athletesIterable = athleteRepository.findAll();
        athletesIterable.forEach(athletesList::add);
        return athletesList;
    }

    public Athlete save(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    public void deleteById(Long id) {
        athleteRepository.deleteById(id);
        log.warn("Athlete {} deleted", id);
    }
}