package org.example.test4.repository;

import org.example.test4.model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Integer> {
//    List<Tutorial> findByPublished(boolean published);
//    List<Tutorial> findByTitleContaining(String title);
}
