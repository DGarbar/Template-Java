package com.dharbar.template.repository;

import com.dharbar.template.repository.enitty.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface TestRepository extends JpaRepository<Test, UUID> {

    Optional<Test> findByField(String field);

    @Query("select t from Test t left join fetch t.testInners where t.id = :id")
    Optional<Test> findByIdWithTestInner(UUID id);
}
