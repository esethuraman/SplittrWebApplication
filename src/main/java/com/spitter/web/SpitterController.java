package com.spitter.web;

import com.spitter.app.Spitter;
import com.spitter.app.Spittle;
import com.spitter.app.SpittleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// renders the register form

@Controller
@RequestMapping("/spittler")
public class SpitterController {

    private SpittleRepository spittleRepository;

    // render the registration form
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(){
        // the view named "registerForm.jsp" view will be searched for this string
        return "registerForm";
    }

    //
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegisterForm(Spitter spitter){
//        spittleRepository.save();

        // redirect: makes Spring to interpret that this is not just a simple view but a redirected view
        return "redirect:/spittler/" + spitter.getUserName();

    }
}
