package fr.ensai.running.repository;

import org.springframework.data.repository.CrudRepository;

import fr.ensai.running.model.Athlete;

public interface AthleteRepository extends CrudRepository<Athlete, Long> {
}