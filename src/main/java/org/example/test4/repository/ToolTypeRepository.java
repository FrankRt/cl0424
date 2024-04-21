package org.example.test4.repository;

import org.example.test4.entity.ToolType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolTypeRepository extends JpaRepository<ToolType, Integer> {
}
