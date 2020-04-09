package co.commit.wheat.wheat.controller;

import co.commit.wheat.wheat.Provide.GithubProvide;
import co.commit.wheat.wheat.dto.AccesstokenDTO;
import co.commit.wheat.wheat.dto.GithubUser;
import co.commit.wheat.wheat.mapper.UserMapper;
import co.commit.wheat.wheat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request){//HttpServletRequest用来获取session
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setClient_id(clien_id);
        accesstokenDTO.setCode("code");
        accesstokenDTO.setRedirect_url(redirect_url);
        accesstokenDTO.setState("state");
        accesstokenDTO.setClient_secret(clien_secret);
        String accessToken = githubProvide.getAccessToken(accesstokenDTO);
        GithubUser githubUser = githubProvide.githubUser(accessToken);
        if(githubUser != null){
            User user = new User();
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setGmtCreate(System.currentTimeMillis());//获取当前时间的毫秒数
            user.setGmtModifieo(user.getGmtCreate());
            userMapper.insert(user);
            //登录成功，写cookie和session 记录cookie拿到session保存登录状态
            request.getSession().setAttribute("githubUser",githubUser);//setAttribute用来保存数据，获取githubUser的值，同时放到session里面，这时session已经创建成功
            return "redirect:/";//使用reirect前缀表示登录后跳转到根页面
        }else{
            return "redirect:/";
            //登录失败
        }//这时候需要怎么在网页去展示登录成功或者失败界面，要在index.html里设置
    }
}
