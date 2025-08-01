package dev.DungeonFinder.DungeonFinder.Players;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/player/ui")
public class PlayersControllerUI {

    private final PlayersService playersService;

    public PlayersControllerUI(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping("/show")
    public String showPlayer(Model model) {
        List<PlayersDTO> players = playersService.showPlayer();
        model.addAttribute("player", players);
        return "showPlayer";
    }

    @GetMapping("/show/{id}")
    public String showPlayerID(@PathVariable Long id, Model model) {
        PlayersDTO playerID = playersService.showPlayerID(id);

        if (playerID != null) {
            model.addAttribute("player", playerID);
            return "playerDetails";
        }
        model.addAttribute("message", "Player não encontrado");
        return "showPlayer";
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playersService.deletePlayer(id);
        return "redirect:/player/ui/show";
    }

    @GetMapping("/add")
    public String addPlayer(Model model) {
        model.addAttribute("player", new PlayersDTO());
        return "addPlayer";
    }

    @PostMapping("/save")
    public String saveNewPlayer(@ModelAttribute PlayersDTO player, RedirectAttributes redirectAttributes) {
        playersService.addPlayer(player);
        redirectAttributes.addFlashAttribute("message", "Player created");
        return "redirect:/player/ui/show";
    }

    @GetMapping("/update/{id}")
    public String updatePlayer(@PathVariable Long id, Model model) {
        model.getAttribute("player");
        return "updatePlayer";
    }

    @PatchMapping("/change")
    public String changePlayer(@ModelAttribute PlayersDTO player, RedirectAttributes redirectAttributes) {
        playersService.updatePlayer(player.getId(),player);
        redirectAttributes.addFlashAttribute("message","Player updated");
        return "redirect:/player/ui/show";
    }
}
