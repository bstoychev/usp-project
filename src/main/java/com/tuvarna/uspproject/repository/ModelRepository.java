package com.tuvarna.uspproject.repository;

import com.tuvarna.uspproject.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {
    @Query("FROM Model WHERE name = ?1")
    Model findByName(String name);
}
