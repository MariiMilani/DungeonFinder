package dev.DungeonFinder.DungeonFinder.Players;

import dev.DungeonFinder.DungeonFinder.Dungeons.DungeonModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_player")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int lvl;

    @Column(name = "class")
    private String classType;

    @ManyToOne
    @JoinColumn(name = "dungeon_id")
    private DungeonModel dungeon;
}
