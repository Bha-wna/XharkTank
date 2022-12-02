package com.bhawna.xharktank.service;

import com.bhawna.xharktank.Domain.PitchRequest;
import com.bhawna.xharktank.Domain.PitchResponse;
import com.bhawna.xharktank.entity.PitchEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PitchService {
    public Map<String, String> addPitch(PitchRequest pitchRequest);
    public List<PitchResponse> getAllPitch();

    public Optional<PitchEntity> getPitchById(Long pitch_id);


}
