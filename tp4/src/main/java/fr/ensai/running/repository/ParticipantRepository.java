package fr.ensai.running.repository;

import org.springframework.data.repository.CrudRepository;

import fr.ensai.running.model.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

}