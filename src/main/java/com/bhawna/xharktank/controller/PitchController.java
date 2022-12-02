package com.bhawna.xharktank.controller;

import com.bhawna.xharktank.Domain.OfferRequest;
import com.bhawna.xharktank.Domain.PitchRequest;
import com.bhawna.xharktank.entity.OfferEntity;
import com.bhawna.xharktank.entity.PitchEntity;
import com.bhawna.xharktank.repository.OfferRepository;
import com.bhawna.xharktank.repository.PitchRepository;
import com.bhawna.xharktank.service.OfferService;
import com.bhawna.xharktank.service.PitchService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("pitches")
@Slf4j
public class PitchController {
    private final PitchService pitchService;

    private final PitchRepository pitchrepository;
    private final OfferService offerService;
    private final OfferRepository offerRepository;
    @Autowired
    public PitchController(OfferService offerService, PitchService pitchService, PitchRepository pitchrepository, OfferRepository offerRepository) {
        this.offerService = offerService;
        this.pitchService = pitchService;
        this.pitchrepository = pitchrepository;
        this.offerRepository = offerRepository;
    }


    @GetMapping
    public ResponseEntity getAllPitch(){
        List<PitchEntity> pitchEntities = pitchService.getAllPitch();
        for(PitchEntity it: pitchEntities){
            List<OfferEntity> offerEntities = offerService.getOfferByPitchId(String.valueOf(it.getId()));
            it.setOffers(offerEntities);
        }
        return new ResponseEntity<>(pitchEntities, HttpStatus.OK);
    }

    @GetMapping("{pitch_id}")
    public ResponseEntity getPitchById(@PathVariable String pitch_id) {
        Optional<PitchEntity> optionalPitchEntity = pitchService.getPitchById(Long.valueOf(pitch_id));
        if(optionalPitchEntity.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        PitchEntity pitchEntity = optionalPitchEntity.get();
        List<OfferEntity> offerEntities = offerService.getOfferByPitchId(pitch_id);
        pitchEntity.setOffers(offerEntities);
        pitchrepository.save(pitchEntity);
        return new ResponseEntity<>(pitchEntity, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity addPitch(@RequestBody @Validated PitchRequest pitchRequest)
    {
        if(pitchRequest.getEquity().intValue() < 0 || pitchRequest.getEquity().intValue() > 100 || pitchRequest.getAskAmount().intValue() < 0)

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Map<String, String> response = pitchService.addPitch(pitchRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("{pitch_id}/makeOffer")
    public ResponseEntity makeOffer(@PathVariable String pitch_id, @RequestBody @Validated OfferRequest offerRequest)
    {
        if(pitch_id.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<PitchEntity> optionalPitchEntity;
        try {
            optionalPitchEntity = pitchService.getPitchById(Long.valueOf(pitch_id));
        } catch (NumberFormatException nfe){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(optionalPitchEntity.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(offerRequest.getEquity().intValue() < 0 || offerRequest.getEquity().intValue() > 100 || offerRequest.getAmount().intValue() < 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Map<String, String> response = offerService.addOffer(offerRequest, pitch_id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}

