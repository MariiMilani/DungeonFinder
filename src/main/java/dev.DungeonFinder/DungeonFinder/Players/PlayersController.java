package dev.DungeonFinder.DungeonFinder.Players;

import dev.DungeonFinder.DungeonFinder.Dungeons.DungeonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("player")
public class PlayersController {

    private final PlayersService playersService;

    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping("/listar")
    @Operation (summary = "Lista todos os players",
            description = "Lista todos os players cadastrados no banco de dados")
    public ResponseEntity<List<PlayersDTO>> showPlayer(){
        List<PlayersDTO> player = playersService.showPlayer();
        return ResponseEntity.ok(player);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o player selecionado no ID",
            description = "Rota lista o player selecionado no ID conforme banco de dados")
    public ResponseEntity<?>  showPlayerID (
            @Parameter(description = "User sends ID in the requisition path") @PathVariable Long id)
    {
        PlayersDTO player = playersService.showPlayerID(id);

        if (player != null){
            return ResponseEntity.ok(player);
        }
         return ResponseEntity.status(HttpStatus.NOT_FOUND)
                 .body("Player not found");
    }

    @PostMapping("/add")
    @Operation(summary = "Adds a new player",
            description = "Adds a new player in the database")
    public ResponseEntity<?> addPlayer(
            @Parameter(description = "User sends player data in the requisition path ") @RequestBody PlayersDTO playersDTO) {
        PlayersDTO player = playersService.addPlayer(playersDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Player " + player.getName() + " sucessfully created!");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a player",
        description = "Delete a player from database")
    public ResponseEntity<String> deletePlayer (
            @Parameter (description = "User sends ID in the requisition path") @PathVariable Long id)
    {
        if(playersService.showPlayerID(id) != null){
            playersService.deletePlayer(id);
            return ResponseEntity.ok("Player's ID " + id + " sucessfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Player not found");
    }
}
