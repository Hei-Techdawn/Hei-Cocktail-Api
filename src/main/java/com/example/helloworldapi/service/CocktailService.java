package com.example.helloworldapi.service;

import com.example.helloworldapi.model.Cocktail;
import com.example.helloworldapi.model.Drink;
import com.example.helloworldapi.repository.CocktailRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class CocktailService {
    private CocktailRepository cocktailRepository;

    public List<Cocktail> getAllCocktails(int page, int size) {
        List<Cocktail> cocktailsList = cocktailRepository.findAll(PageRequest.of(page, size)).toList();
        for (Cocktail cocktails : cocktailsList) {
            cocktails.setPrice(sumPriceDrinks(cocktails.getDrinks()));
        }
        return cocktailsList;
    }

    public double sumPriceDrinks(List<Drink> drinkList) {
        double sum = 0;
        for (Drink drink : drinkList) {
            sum += drink.getPrice();
        }
        return sum;
    }

    @Transactional
    public List<Cocktail> createCocktails(List<Cocktail> cocktailsList) {
        return cocktailRepository.saveAll(cocktailsList);
    }

    public Cocktail findCocktail(int id) {
        return cocktailRepository.findById(id).get();
    }

    public void deleteCocktailById(int id) {
        cocktailRepository.deleteById(id);
    }

    public Cocktail updateCocktail(int id, Cocktail cocktail) {
        Cocktail oldCocktail = cocktailRepository.findById(id).get();
        if (cocktail.getName() != null) {
            oldCocktail.setName(cocktail.getName());
        }
        if (cocktail.getDescription() != null) {
            oldCocktail.setDescription(cocktail.getDescription());
        }
        if (cocktail.getDrinks() != null) {
            oldCocktail.setDrinks(cocktail.getDrinks());
        }
        return cocktailRepository.save(oldCocktail);
    }
}
