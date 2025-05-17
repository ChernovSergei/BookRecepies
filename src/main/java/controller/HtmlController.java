package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HtmlController {
    private RecepiesStorage recepiesStorage;

    public HtmlController(RecepiesStorage recepiesStorage) {
        this.recepiesStorage = recepiesStorage;
    }

    @GetMapping("/")
    public String index() {
        return "mainPage";
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

    @GetMapping("/addRecepie")
    public String getNewRecepie() {
        return "addRecepie";
    }

    @PostMapping("/submitRecipe")
    public String postRecepie(@RequestParam String recipeName,
                              @RequestParam String toolName,
                              @RequestParam String productName,
                              @RequestParam String productType,
                              @RequestParam String actionName) {
        /*System.out.println("message " +
                "Recipe submitted: " + recipeName +
                "with tool " + toolName +
                ", product" + productName +
                ", product type" + productType +
                ", action " + actionName);*/
        Recepie recepie = new Recepie(recipeName);
        Product product = new Product(productName, productType);
        Tool tool = new Tool(toolName);
        Action action = new Action(actionName);
        RecepieStep step = new RecepieStep(product,tool, action);
        List<RecepieStep> steps = new ArrayList<>();
        steps.add(step);
        recepie.setSteps(steps);
        recepiesStorage.save(recepie);
        return "redirect:/addRecepie";
    }
}