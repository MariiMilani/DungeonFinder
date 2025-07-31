package dev.DungeonFinder.DungeonFinder.Players;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/player/ui")
public class PlayersControllerUI {

    private final PlayersService playersService;

    public PlayersControllerUI(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping("/show")
    public String showPlayer(Model model){
        List<PlayersDTO> players = playersService.showPlayer();
        model.addAttribute("player", players);
        return "showPlayer";
    }

    @GetMapping("/show/{id}")
    public String showPlayerID(@PathVariable Long id, Model model){
        PlayersDTO playerID = playersService.showPlayerID(id);

        if(playerID != null){
            model.addAttribute("player", playerID);
            return "showPlayer";
        }
        model.addAttribute("menssage", "Player não encontrado");
        return "showPlayer";
    }
}
