package com.bhawna.xharktank.repository;
import com.bhawna.xharktank.entity.PitchEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PitchRepository extends CrudRepository<PitchEntity, Long> {
    public List<PitchEntity> findAll();
    Optional<PitchEntity> findById(Long pitch_id);

    List<PitchEntity> findAll(Sort id);
}
