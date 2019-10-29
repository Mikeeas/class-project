package com.example.demo.Controllers;

        import com.example.demo.Models.User;
        import com.example.demo.Models.data.UserDao;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.Errors;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("title", "Inven");
        return "index";
    }

    @RequestMapping(value = "login")
    public String login(Model model){
        model.addAttribute("title", "Login" );
        return "login";
    }

    @RequestMapping(value = "signup")
    public String displaysignup(Model model) {
        model.addAttribute("title", "Create A New Account");

        return "signup";
    }

    @RequestMapping(value="signup", method = RequestMethod.POST)
    public String processsignup(@Valid @ModelAttribute UserDao newUser, Model model, Errors errors){
        if (errors.hasErrors()){
            model.addAttribute("title", "Create A New Account");
        }
        userDao.save(newUser);
        return "index";
    }
}
