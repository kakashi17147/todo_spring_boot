package come.try3.demo.controller;


import come.try3.demo.domain.ToDo;
import come.try3.demo.domain.UserLogin;
import come.try3.demo.repo.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ToDoController {

       @Autowired
       private ToDoRepository repo;

       private int user_id=0 ;

       @RequestMapping({"/home"})
       public String home(Model model)
       {
           //List<ToDo> ListToDo = repo.findAll();
           List<ToDo> ListToDo = repo.findByUid(user_id);
           model.addAttribute("ListToDo",ListToDo);

           System.out.println(" IN ListTodDo ........");
           return "alltask";
       }

    @GetMapping("/new/{uid}")
    public String add(@PathVariable(name = "uid") int uid,Model model) {

        ToDo todo = new ToDo();
        todo.setUid(uid);
        user_id = uid;
        //System.out.println(todo.toString());
        model.addAttribute("todo", todo);
        return "new";
    }

    @RequestMapping(value = "/save/{uid}", method = RequestMethod.POST)
    public String SaveTask(@ModelAttribute("todo") ToDo obj,@PathVariable(name = "uid") int uid) {

        obj.setUid(uid);
        System.out.println(obj.toString());
        repo.save(obj);

        return "redirect:/home";
    }

    @RequestMapping("/edit/{tid}")
    public ModelAndView editTask(@PathVariable(name = "tid") int tid) {
        ModelAndView mav = new ModelAndView("new");
        ToDo td = repo.getById(tid);
        mav.addObject("todo", td);
        return mav;

    }
    @RequestMapping("/delete/{tid}")
    public String deleteEmployeePage(@PathVariable(name = "tid") int tid) {
        repo.deleteById(tid);
        return "redirect:/home";
    }


}
