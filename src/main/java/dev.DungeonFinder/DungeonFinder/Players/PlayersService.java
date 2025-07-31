package dev.DungeonFinder.DungeonFinder.Players;

import dev.DungeonFinder.DungeonFinder.Dungeons.DungeonModel;
import dev.DungeonFinder.DungeonFinder.Dungeons.DungeonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayersService {

    private final PlayersRepository playersRepository;
    private final PlayersMapper playersMapper;
    private final DungeonRepository dungeonRepository;

    public PlayersService(PlayersRepository playersRepository, PlayersMapper playersMapper, DungeonRepository dungeonRepository) {
        this.playersRepository = playersRepository;
        this.playersMapper = playersMapper;
        this.dungeonRepository = dungeonRepository;
    }

    public List<PlayersDTO> showPlayer(){
        List<PlayersModel> player = playersRepository.findAll();
        return player.stream()
                .map(playersMapper::map)
                .collect(Collectors.toList());
    }

    public PlayersDTO showPlayerID(Long id){
        Optional<PlayersModel> playerID = playersRepository.findById(id);
        return playerID.map(playersMapper::map).orElse(null);
    }

    public PlayersDTO addPlayer(PlayersDTO playersDTO){
        Long dungeonID = playersDTO.getDungeon().getId();
        Optional<DungeonModel> dungeonModel = dungeonRepository.findById(dungeonID);
        if(dungeonModel.get().lvlRequired() <= playersDTO.getLvl()){
            if(dungeonModel.get().qtdPlayers() < 5){
                PlayersModel player = playersMapper.map(playersDTO);
                player = playersRepository.save(player);
                return playersMapper.map(player);
            }
        }
        PlayersModel player = playersMapper.map(playersDTO);
        player.setDungeon(null);
        player = playersRepository.save(player);
        return playersMapper.map(player);

    }

    public void deletePlayer(Long id){
        playersRepository.deleteById(id);
    }
}
