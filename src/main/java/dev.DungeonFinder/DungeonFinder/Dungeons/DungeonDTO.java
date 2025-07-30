package dev.DungeonFinder.DungeonFinder.Dungeons;

import dev.DungeonFinder.DungeonFinder.Players.PlayersModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DungeonDTO {
    Long id;

    private String name;

    private int minimumLvl;

    private int bossesNumber;

    private String bosses;

    private List<PlayersModel> players;
}
