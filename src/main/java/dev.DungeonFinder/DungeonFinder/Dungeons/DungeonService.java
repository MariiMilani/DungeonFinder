package dev.DungeonFinder.DungeonFinder.Dungeons;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DungeonService {

    private final DungeonRepository dungeonRepository;
    private final DungeonMapper dungeonMapper;

    public DungeonService(DungeonRepository dungeonRepository, DungeonMapper dungeonMapper) {
        this.dungeonRepository = dungeonRepository;
        this.dungeonMapper = dungeonMapper;
    }

    public List<DungeonDTO> showDungeons(){
        List<DungeonModel> dungeon = dungeonRepository.findAll();
        return dungeon.stream()
                .map(dungeonMapper::map)
                .collect(Collectors.toList());
    }

    public DungeonDTO showDungeonID(Long id){
        Optional<DungeonModel> dungeonID = dungeonRepository.findById(id);
        return dungeonID.map(dungeonMapper::map).orElse(null);
    }

    public DungeonDTO addDungeon(DungeonDTO dungeonDTO){
        DungeonModel dungeon = dungeonMapper.map(dungeonDTO);
        dungeon = dungeonRepository.save(dungeon);
        return dungeonMapper.map(dungeon);
    }

    public void deleteDungeon (Long id){
        dungeonRepository.deleteById(id);
    }
}
