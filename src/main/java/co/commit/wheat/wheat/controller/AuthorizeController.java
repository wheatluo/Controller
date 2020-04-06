package co.commit.wheat.wheat.controller;

import co.commit.wheat.wheat.Provide.GithubProvide;
import co.commit.wheat.wheat.dto.AccesstokenDTO;
import co.commit.wheat.wheat.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvide githubProvide;

    @Value("${github.client.id}")
    private String clien_id;

    @Value("${github.redirect_url")
    private String redirect_url;

    @Value("@{github.client.secret}")
    private String clien_secret;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setClient_id(clien_id);
        accesstokenDTO.setCode("code");
        accesstokenDTO.setRedirect_url(redirect_url);
        accesstokenDTO.setState("state");
        accesstokenDTO.setClient_secret(clien_secret);
        String accessToken = githubProvide.getAccessToken(accesstokenDTO);
        GithubUser githubUser = githubProvide.githubUser(accessToken);
        System.out.println(githubUser.getName());
        return "index";
    }
}
