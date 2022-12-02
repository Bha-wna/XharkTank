package com.bhawna.xharktank.repository;

import com.bhawna.xharktank.entity.OfferEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends CrudRepository<OfferEntity, Long> {
    List<OfferEntity> findAllByPitchId(Long pitch_id);

    List<OfferEntity> findAll();
}
