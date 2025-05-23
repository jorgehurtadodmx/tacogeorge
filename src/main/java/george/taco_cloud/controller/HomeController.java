package george.taco_cloud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    //getmapping indicates that this method can handle HTTP GET requests
    public String home() {
        return "home";
    }

}
