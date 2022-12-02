package com.bhawna.xharktank.service;

import com.bhawna.xharktank.Domain.OfferRequest;
import com.bhawna.xharktank.entity.OfferEntity;

import java.util.List;
import java.util.Map;

public interface OfferService {
    Map<String, String> addOffer(OfferRequest offerRequest, String pitch_id);

    List<OfferEntity> getOfferByPitchId(String pitch_id);

}
