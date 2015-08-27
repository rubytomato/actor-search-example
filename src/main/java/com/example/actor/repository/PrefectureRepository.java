package com.example.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefectureRepository extends JpaRepository<Prefecture, Integer> {

}
