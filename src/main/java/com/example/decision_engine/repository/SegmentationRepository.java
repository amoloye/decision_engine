package com.example.decision_engine.repository;

import com.example.decision_engine.entity.Segmentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentationRepository extends JpaRepository<Segmentation,Integer> {

}
