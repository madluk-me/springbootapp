package com.example.springjpadb.controller;

import com.example.springjpadb.model.UserFormData;
import com.example.springjpadb.service.UserFormDataRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserFormController {

    private UserFormDataRepo userFormDataRepo;

    public UserFormController(UserFormDataRepo userFormDataRepo) {
        this.userFormDataRepo = userFormDataRepo;
    }

    @GetMapping("/page1")
    public String pageGet(){
        return "userinputform";
    }
       String x = "test";

    @PostMapping("/addUserToDB")
    public String sendUserDataToDB(  Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {

            return "redirect:/";
        }
        UserFormData userFormData = new UserFormData();
        model.addAttribute("userFormData", userFormData);
        userFormDataRepo.save(userFormData);


        return "userinputform";
    }
}
