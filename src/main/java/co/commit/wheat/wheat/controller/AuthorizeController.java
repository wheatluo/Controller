package co.commit.wheat.wheat.controller;

import co.commit.wheat.wheat.Provide.GithubProvide;
import co.commit.wheat.wheat.dto.AccesstokenDTO;
import co.commit.wheat.wheat.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvide githubProvide;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String name,
                           @RequestParam(name = "state")String state){
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setClient_id("2a4368b3f7e48a6e826a");
        accesstokenDTO.setCode("code");
        accesstokenDTO.setRedirect_url("http://localhost:8888/callback");
        accesstokenDTO.setState("state");
        accesstokenDTO.setClient_secret("dbbb510291a7ed8f743870eeb67b621f306e06aa");
        String accessToken = githubProvide.getAccessToken(accesstokenDTO);
        GithubUser githubUser = githubProvide.githubUser(accessToken);
        System.out.println(githubUser);
        return "index";
    }
}
