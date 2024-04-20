package org.example.test4.repository;

import org.example.test4.model.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends JpaRepository<Holidays, Integer> {
//    List<Tutorial> findByPublished(boolean published);
//    List<Tutorial> findByTitleContaining(String title);
}
