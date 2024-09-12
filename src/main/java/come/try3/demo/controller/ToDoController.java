package come.try3.demo.controller;


import come.try3.demo.domain.ToDo;
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

       @RequestMapping({"/home","/"})
       public String home(Model model)
       {
           List<ToDo> ListToDo = repo.findAll();
           model.addAttribute("ListToDo",ListToDo);

           System.out.println("in get all ...");
           return "home";
       }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("todo", new ToDo());

        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String SaveTask(@ModelAttribute("todo") ToDo obj) {
        repo.save(obj);
        return "redirect:/";
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
        return "redirect:/";
    }


}
