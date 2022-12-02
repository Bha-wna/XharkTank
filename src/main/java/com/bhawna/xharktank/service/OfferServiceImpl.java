package com.bhawna.xharktank.service;

import com.bhawna.xharktank.Domain.OfferRequest;
import com.bhawna.xharktank.entity.OfferEntity;
import com.bhawna.xharktank.repository.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OfferServiceImpl implements OfferService{

    private final OfferRepository offerRepository;


    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }


    @Override
    public Map<String, String> addOffer(OfferRequest offerRequest, String pitch_id) {
        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setInvestor(offerRequest.getInvestor());
        offerEntity.setAmount(offerRequest.getAmount());
        offerEntity.setEquity(offerRequest.getEquity());
        offerEntity.setComment(offerRequest.getComment());
        offerEntity.setPitchId(Long.valueOf(pitch_id));
        offerRepository.save(offerEntity);
        HashMap<String, String> map = new HashMap<>();
        map.put("id",String.valueOf(offerEntity.getId()));
        return map;
    }

    @Override
    public List<OfferEntity> getOfferByPitchId(String pitch_id) {
        return offerRepository.findAllByPitchId(Long.valueOf(pitch_id));
    }


}
