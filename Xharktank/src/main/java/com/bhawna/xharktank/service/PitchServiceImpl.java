package com.bhawna.xharktank.service;

import com.bhawna.xharktank.Domain.PitchRequest;
import com.bhawna.xharktank.entity.PitchEntity;
import com.bhawna.xharktank.repository.PitchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class PitchServiceImpl implements PitchService{
    private final PitchRepository pitchrepository;
    @Autowired
    public PitchServiceImpl(PitchRepository pitchrepository) {
        this.pitchrepository = pitchrepository;
    }

    @Override
    public Map<String, String> addPitch(PitchRequest pitchRequest) {
      PitchEntity pitchEntity = new PitchEntity();
      pitchEntity.setEntrepreneur(pitchRequest.getEntrepreneur());
      pitchEntity.setPitchTitle(pitchRequest.getPitchTitle());
      pitchEntity.setPitchIdea(pitchRequest.getPitchIdea());
      pitchEntity.setAskAmount(pitchRequest.getAskAmount());
      pitchEntity.setEquity(pitchRequest.getEquity());
      pitchrepository.save(pitchEntity);
      HashMap<String, String> map = new HashMap<>();
      map.put("id",String.valueOf(pitchEntity.getId()));
      return map;
    }

    @Override
    public List<PitchEntity> getAllPitch() {
        return pitchrepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Optional<PitchEntity> getPitchById(Long pitch_id) {
        return  pitchrepository.findById(pitch_id);
    }



}
