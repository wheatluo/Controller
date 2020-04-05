package co.commit.wheat.wheat.controller;

import co.commit.wheat.wheat.Provide.GithubProvide;
import co.commit.wheat.wheat.dto.AccesstokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {



    @GetMapping("/")
    public String index(){
        return "index";
    }

}
