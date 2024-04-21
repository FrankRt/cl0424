package org.example.test4.repository;

import org.example.test4.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Integer> {
    public List<Tool> findByToolCode(String chns);
}
