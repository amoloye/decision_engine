package com.example.decision_engine.service.impl;

import com.example.decision_engine.entity.Segmentation;
import com.example.decision_engine.repository.SegmentationRepository;
import com.example.decision_engine.service.SegmentationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SegmentationServiceImpl implements SegmentationService {
    private final SegmentationRepository segmentationRepository;

    @Override
    public Segmentation createSegmentation (Segmentation segmentation) {
        return segmentationRepository.save(segmentation);
    }

    @Override
    public Optional<Segmentation> fetchSegmentationById (Integer segmentationId) {
        return segmentationRepository.findById(segmentationId);
    }

    @Override
    public Segmentation updateSegmentation (Integer segmentationId, Segmentation segmentation) {
         Segmentation segDB= segmentationRepository.findById(segmentationId).get();

        if (Objects.nonNull(segmentation.getSegmentationName())&&
                !"".equalsIgnoreCase(segmentation.getSegmentationName())){
            segDB.setSegmentationName(segmentation.getSegmentationName());
        }

        segDB.setSegmentationName(segmentation.getSegmentationName());

        return segmentationRepository.save(segDB);
    }

    @Override
    public void deleteSegmentationById (Integer segmentationId) {
        segmentationRepository.deleteById(segmentationId);
        //System.out.println("segmentation deleted succesffuly");

    }
}
