package com.example.actor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

  @Query("select a from Actor a where a.name like %:keyword% order by a.id asc")
  List<Actor> findActors(@Param("keyword") String keyword);

}
