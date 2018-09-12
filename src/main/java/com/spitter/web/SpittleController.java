package com.spitter.web;

import com.spitter.app.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spitters")
public class SpittleController {

    private SpittleRepository spittleRepository;
    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);

    // injecting spittleRepository object
    @Autowired
    SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        // adding the first 20 spittles to the model object for rendering in the view
        //   model object is the Spring's way of representing maps
        // if we don't supply the attribute name, then spring generates one based on the
        //   requestMapping path parameter
        model.addAttribute(
                "spittles",
                spittleRepository.findSpittles(Long.MAX_VALUE, 20));

        // the view name called "spittles" is returned
        return "spittles";
    }

    // this one is the same as the above but with query parameters
    public String spittlesWithQueryParams(Model model,
                                          @RequestParam("max") long max,
                                          @RequestParam("count") int count){

        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";
    }

    // same as the above method but with default values
    public String spittlesWithQueryParamsAndDefaultValues(
            Model model,
            @RequestParam(value = "max", defaultValue = "10987") long max,
            @RequestParam(value = "count", defaultValue = "20") int count){

        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";
    }

    // ****  PATH VARIABLE ***
    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
