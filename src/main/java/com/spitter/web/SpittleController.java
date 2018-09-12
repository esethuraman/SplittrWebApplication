package com.spitter.web;

import com.spitter.app.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spitters")
public class SpittleController {

    private SpittleRepository spittleRepository;

    // injecting spittleRepository object
    @Autowired
    SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        // adding the first 20 spittles to the model object for rendering in the view
        //   model object is the Spring's way of representing maps
        // if we dont supply the attribute name, then spring generates one based on the
        //   requestMapping path parameter
        model.addAttribute(
                "spittleList",
                spittleRepository.findSpittles(Long.MAX_VALUE, 20));

        // the view name called "spittles" is returned
        return "spittles";

    }
}
