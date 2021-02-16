/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controller.ui;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JOrtiz
 */
@Controller
public class HomeController {

    @RequestMapping("home")
    public String home(HttpServletRequest request) {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        System.out.println("" + name);
        return "home";
    }

    @RequestMapping("home1")
    public String home1(String name, HttpSession httpSession) {
        httpSession.setAttribute("name", name);
        System.out.println("" + name);
        return "home";
    }

    @RequestMapping("home2")
    public ModelAndView home2(String name, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.setViewName("home2");
        System.out.println("" + name);
        return modelAndView;
    }
    
     @RequestMapping("home3")
    public ModelAndView home3(Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView();
        model.put("name", "nene");
        return modelAndView;
    }

}
