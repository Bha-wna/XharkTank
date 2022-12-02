package util;

import com.bhawna.xharktank.Domain.PitchResponse;
import com.bhawna.xharktank.entity.PitchEntity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Mapper {
    public static PitchResponse mapResponse(PitchEntity pitchEntity){
        if(!pitchEntity.getAskAmount().contains(".")){
            PitchResponse<BigInteger, BigDecimal> response = new PitchResponse<>();
            response.setEntrepreneur(pitchEntity.getEntrepreneur());
            response.setPitchTitle(pitchEntity.getPitchTitle());
            response.setId(String.valueOf(pitchEntity.getId()));
            response.setPitchIdea(pitchEntity.getPitchIdea());
            response.setOffers(pitchEntity.getOffers());
            response.setAskAmount(new BigInteger(pitchEntity.getAskAmount()));
            response.setEquity(pitchEntity.getEquity());
            return  response;
        }
        PitchResponse<BigDecimal,BigDecimal> response = new PitchResponse<>();
        response.setEntrepreneur(pitchEntity.getEntrepreneur());
        response.setPitchTitle(pitchEntity.getPitchTitle());
        response.setId(String.valueOf(pitchEntity.getId()));
        response.setPitchIdea(pitchEntity.getPitchIdea());
        response.setOffers(pitchEntity.getOffers());
        response.setAskAmount(new BigDecimal(pitchEntity.getAskAmount()));
        response.setEquity(pitchEntity.getEquity());
        return response;
    }

}
