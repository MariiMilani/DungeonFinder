package dev.DungeonFinder.DungeonFinder.Players;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlayersMapper {

    private final ModelMapper modelMapper;

    public PlayersMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlayersModel map(PlayersDTO playersDTO){
        return modelMapper.map(playersDTO, PlayersModel.class);
    }

    public PlayersDTO map(PlayersModel playersModel){
        return modelMapper.map(playersModel, PlayersDTO.class);
    }

    public void updateFromDTO(PlayersDTO playersDTO, PlayersModel playersModel){
        modelMapper.map(playersDTO, playersModel);
    }
}
