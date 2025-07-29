package dev.DungeonFinder.DungeonFinder.Dungeons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.DungeonFinder.DungeonFinder.Players.PlayersModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_dungeon")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DungeonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDungeon;

    private String name;

    private int minimumLvl;

    private int bossesNumber;

    private String bosses;

    @OneToMany(mappedBy = "dungeon")
    @JsonIgnore
    private List<PlayersModel> players;
}
