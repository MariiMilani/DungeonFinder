package dev.DungeonFinder.DungeonFinder.Players;

import dev.DungeonFinder.DungeonFinder.Dungeons.DungeonModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayersDTO {
    private Long id;

    private String name;

    private int lvl;

    private DungeonModel dungeon;
}
