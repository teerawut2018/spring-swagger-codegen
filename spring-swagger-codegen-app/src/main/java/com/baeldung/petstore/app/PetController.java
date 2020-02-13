package com.baeldung.petstore.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baeldung.petstore.client.model.Pet;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PetController {
    
    @Autowired
    private PetService petService;
    

    @RequestMapping("/pets")
    @ResponseBody
    public String listAvailablePets() {
        StringBuilder sb = new StringBuilder("<h1>Available pets:</h1>");
        sb.append("<ul>");
        petService.findAvailablePets()
          .forEach( p -> sb.append("<li>" + p.getName() + "</li>"));
        sb.append("</ul>");
        return sb.toString();
    }
    
    @PostMapping("/employees")
    public void addNewPet(@RequestBody Pet body) {
    	petService.addNewPet(body);
    }
    
}