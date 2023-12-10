package Controller;

import Modal.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("Hello this is home page");
        return "index";
    }

    @RequestMapping(path = "/processData", method = RequestMethod.POST)
    public ModelAndView processData(@RequestParam("name") String name,
                              @RequestParam("company") String company){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.addObject("company", company);
        modelAndView.setViewName("Details");
        return modelAndView;
    }

    @RequestMapping(path = "/processDataNew", method = RequestMethod.POST)
    public String processData1(@ModelAttribute UserDetails userDetails, Model model){
        System.out.println(model);
        System.out.println(userDetails);
        return "Details";
    }
}
