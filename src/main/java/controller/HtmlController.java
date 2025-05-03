package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.Recepie;
import service.RecepiesStorage;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HtmlController {
    private RecepiesStorage recepiesStorage;

    public HtmlController(RecepiesStorage recepiesStorage) {
        this.recepiesStorage = recepiesStorage;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/recepies")
    public String getAllRecepies(Model model) {
        List<Recepie> recepiesValue = recepiesStorage.getAll();
        model.addAttribute("recepies", recepiesValue);
        return "recepies";
    }

    @GetMapping("/recepie/{recepieID}")
    public String getRecepie(Model model, @PathVariable String recepieID) {
        List<Recepie> recepiesValue = recepiesStorage.getAll();
        Recepie recepie = recepiesValue.stream().filter(r -> r.getName().equals(recepieID)).findFirst().orElseThrow();
        model.addAttribute("recepie", recepie);
        return "recepie";
    }
}
