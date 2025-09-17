package dev.DungeonFinder.DungeonFinder.Dungeons;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dungeon")
public class DungeonController {

    private final DungeonService dungeonService;

    public DungeonController(DungeonService dungeonService) {
        this.dungeonService = dungeonService;
    }

    @GetMapping("/show")
    @Operation(summary = "Lista todas as Dungeons",
            description = "Rota lista todas as Dungeons cadastradas no banco de dados")
    public ResponseEntity<List<DungeonDTO>> showDungeons(){
        List<DungeonDTO> dungeons = dungeonService.showDungeons();
        return ResponseEntity.ok(dungeons);
    }

    @GetMapping("/show/{id}")
    @Operation(summary = "Lista a dungeon selecionada no ID",
    description = "Rota lista a dungeon selecionada no ID conforme banco de dados")
    public ResponseEntity<?> showDungeonID(
            @Parameter(description = "User sends ID in the requisition path") @PathVariable Long id)
    {
        DungeonDTO dungeon = dungeonService.showDungeonID(id);
        if(dungeon != null){
            return ResponseEntity.ok(dungeon);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Dungeon not found");
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Adds a new dungeon",
        description = "Adds a new dungeon in the database")
   public ResponseEntity<String> addDungeon(
          @Parameter(description = "User sends dungeon data in the requisition path ") @RequestBody DungeonDTO dungeonDTO)
    {
        DungeonDTO dungeon = dungeonService.addDungeon(dungeonDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Dungeon " + dungeon.getName() + " sucessfully created!");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a dungeon",
        description = "Delete a dungeon from database")
    public ResponseEntity<String> deleteDungeon (
            @Parameter(description = "User sends ID in the requisition path") @PathVariable Long id)
    {
        if(dungeonService.showDungeonID(id) != null){
            dungeonService.deleteDungeon(id);
            return ResponseEntity.ok("Dungeon's ID " + id + " deleted.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Dungeon not found");
    }
}
