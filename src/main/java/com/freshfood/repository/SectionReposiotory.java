package com.freshfood.repository;

import com.freshfood.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionReposiotory extends JpaRepository<Section, Long> {
    
}
