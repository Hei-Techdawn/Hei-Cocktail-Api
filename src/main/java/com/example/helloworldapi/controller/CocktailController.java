package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.Cocktail;
import com.example.helloworldapi.service.CocktailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/coktails")
public class CocktailController {
    private CocktailService cocktailsService;

    @GetMapping(value = "")
    public List<Cocktail> getAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        return cocktailsService.getAllCocktails(page, size);
    }

    @PostMapping(value = "")
    public List<Cocktail> postCocktails(@RequestBody List<Cocktail> cocktailsList) {
        return cocktailsService.createCocktails(cocktailsList);
    }

    @GetMapping(value = "/{id}")
    public Cocktail getCocktail(@PathVariable int id) {
        return cocktailsService.findCocktail(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCocktail(@PathVariable int id) {
        cocktailsService.deleteCocktailById(id);
    }

    @PutMapping(value = "/{id}")
    public Cocktail putCocktail(
            @PathVariable int id,
            @RequestBody Cocktail cocktail
    ) {
        return cocktailsService.updateCocktail(id, cocktail);
    }

}
