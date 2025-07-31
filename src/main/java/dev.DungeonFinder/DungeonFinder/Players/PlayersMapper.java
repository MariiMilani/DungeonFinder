package dev.DungeonFinder.DungeonFinder.Players;

import org.springframework.stereotype.Component;

@Component
public class PlayersMapper {

    public PlayersModel map(PlayersDTO playersDTO){
        PlayersModel playersModel = new PlayersModel();

        playersModel.setId(playersDTO.getId());
        playersModel.setName(playersDTO.getName());
        playersModel.setLvl(playersDTO.getLvl());
        playersModel.setClassType(playersDTO.getClassType());
        playersModel.setDungeon(playersDTO.getDungeon());

        return playersModel;
    }

    public PlayersDTO map(PlayersModel playersModel){
        PlayersDTO playersDTO = new PlayersDTO();

        playersDTO.setId(playersModel.getId());
        playersDTO.setName(playersModel.getName());
        playersDTO.setLvl(playersModel.getLvl());
        playersDTO.setClassType(playersModel.getClassType());
        playersDTO.setDungeon(playersModel.getDungeon());

        return playersDTO;
    }
}
