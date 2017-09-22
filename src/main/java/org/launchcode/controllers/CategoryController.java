package org.launchcode.controllers;


import org.launchcode.models.Category;
import org.launchcode.models.Cheese;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    // TODO #1: Create an index handler that retrieves a list of categories and passes it to the veiw
    //DONE

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Categories");
        model.addAttribute("categories", categoryDao.findAll());

        return "category/index";
    }

    // TODO #2: Create a view/template for index that iterates through the category list and displays each one
    // DONE


    // TODO #3: Create an add handler that is a form that allows the user to add a category
    //DONE

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCatForm(Model model) {
        model.addAttribute("title", "Add a Category");
        model.addAttribute(new Category());

        return "category/add";
    }


    // TODO #4: Create an add form view/template
    // DONE


    // TODO #5: Create an add handler that processes the form and validates form input
    // DONE

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCatForm(@ModelAttribute @Valid Category newCategory,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Category");
            return "category/add";
        }

        categoryDao.save(newCategory);
        return "redirect:";
    }


    // TODO #6: Add navigation links that link to the main category page
    // DONE
}
