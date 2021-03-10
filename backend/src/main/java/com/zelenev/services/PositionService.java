package com.zelenev.services;

import com.zelenev.data.dao.PositionRepository;
import com.zelenev.data.entities.Position;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position readOrCreateByTitle(String position) {
        Optional<Position> positionOptional = positionRepository.findByTitle(position);
        if (positionOptional.isPresent()) {
            return positionOptional.get();
        } else
            positionRepository.save(new Position(position));
        return positionRepository.findByTitle(position).get();
    }
}
