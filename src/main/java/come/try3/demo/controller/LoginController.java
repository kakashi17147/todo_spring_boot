package come.try3.demo.controller;

import come.try3.demo.domain.UserLogin;
import come.try3.demo.repo.LoginRepository;
import come.try3.demo.service.RequestObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class LoginController {

      @Autowired
      private LoginRepository user_repo;


      @GetMapping({"/login","/"})
      public ModelAndView login()
      {
          ModelAndView mv = new ModelAndView("login");
          mv.addObject("user",new UserLogin());
          return mv;
      }

      ////////////Register new User///////////
      @GetMapping("/register")
      public ModelAndView register()
      {
          ModelAndView mv = new ModelAndView("register");
          mv.addObject("user",new UserLogin());
          return mv;
      }

      @PostMapping("/register")
      public String register(@ModelAttribute("user") UserLogin user)
      {
           user_repo.save(user);

          System.out.println("Registration Successfull....");
          return "redirect:/login";
      }

      ////////////////////////////////////////////


      @PostMapping("/login")
      public String login(@ModelAttribute("user") UserLogin user,Model model)
      {
          UserLogin  user_check =  user_repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());

          System.out.println("Authentic user...");

          if(Objects.nonNull(user_check))
          {
              System.out.println("Successfully logged in...");
              model.addAttribute("userObj",user_check);
              return "/home";

          }
          else
              {
              return "redirect:/login";
          }
      }


    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {
        return "redirect:/login";
    }


}
