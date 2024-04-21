package org.example.test4.repository;

import org.example.test4.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
    public List<Holiday> findByYrOrderByDate(int year);
}
