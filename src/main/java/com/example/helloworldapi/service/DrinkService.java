package com.example.helloworldapi.service;

import com.example.helloworldapi.model.Drink;
import com.example.helloworldapi.repository.CategoryRepository;
import com.example.helloworldapi.repository.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class DrinkService {
    private DrinkRepository drinkRepository;
    private CategoryRepository categoryRepository;

    public DataFormat<Drink> findAllDrinks(int page, int size) {
        DataFormat<Drink> res = new DataFormat<>();
        res.setData(ManualPagination
                .getPage(drinkRepository.findAll(), page)
        );
        res.setLastPage(drinkRepository.findAll().size() / 10);
        res.setCurrentPage(page + 1);
        return res;
    }

    @Transactional
    public List<Drink> createDrinks(List<Drink> drinkList) {
        return drinkRepository.saveAll(drinkList);
    }

    public Drink updateDrinks(int id, Drink drink) {
        Drink oldDrink = drinkRepository.getReferenceById(id);
        if (drink.getName() != null) {
            oldDrink.setName(drink.getName());
        }
        if (drink.getPrice() != 0) {
            oldDrink.setPrice(drink.getPrice());
        }
        if (drink.getCategory() != null) {
            oldDrink.setCategory(drink.getCategory());
        }
        return drinkRepository.save(oldDrink);
    }

    public void removeDrinks(int id) {
        drinkRepository.deleteById(id);
    }

    public Drink findDrinks(int id) {
        return drinkRepository.findById(id).get();
    }

    public List<Drink> findDrinksByIdCategory(int id) {
        return drinkRepository.getDrinksByCategory(
                categoryRepository.findById(id).get()
        );
    }
}
