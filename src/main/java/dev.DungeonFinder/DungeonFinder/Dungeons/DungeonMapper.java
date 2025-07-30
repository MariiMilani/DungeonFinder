package dev.DungeonFinder.DungeonFinder.Dungeons;

import org.springframework.stereotype.Component;

@Component
public class DungeonMapper {
    public DungeonModel map(DungeonDTO dungeonDTO){
        DungeonModel dungeonModel = new DungeonModel();

        dungeonModel.setId(dungeonDTO.getId());
        dungeonModel.setName(dungeonDTO.getName());
        dungeonModel.setMinimumLvl(dungeonDTO.getMinimumLvl());
        dungeonModel.setBossesNumber(dungeonDTO.getBossesNumber());
        dungeonModel.setBosses(dungeonDTO.getBosses());
        dungeonModel.setPlayers(dungeonDTO.getPlayers());

        return dungeonModel;
    }

    public DungeonDTO map(DungeonModel dungeonModel){
        DungeonDTO dungeonDTO = new DungeonDTO();

        dungeonDTO.setId(dungeonModel.getId());
        dungeonDTO.setName(dungeonModel.getName());
        dungeonDTO.setMinimumLvl(dungeonModel.getMinimumLvl());
        dungeonDTO.setBossesNumber(dungeonModel.getBossesNumber());
        dungeonDTO.setBosses(dungeonModel.getBosses());
        dungeonDTO.setPlayers(dungeonModel.getPlayers());

        return dungeonDTO;
    }
}
