package com.example.decision_engine.service;

import com.example.decision_engine.entity.Segmentation;

import java.util.Optional;

public interface SegmentationService {

    Segmentation createSegmentation(Segmentation segmentation);
    Optional<Segmentation> fetchSegmentationById(Integer segmentationId);
    Segmentation updateSegmentation(Integer segmentationId, Segmentation segmentation);
    void deleteSegmentationById(Integer segmentationId);
}
