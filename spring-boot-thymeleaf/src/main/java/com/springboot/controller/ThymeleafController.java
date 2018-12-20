package com.springboot.controller;

import com.springboot.model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 用于映射HTTP与页面的跳转
 */
@Controller
@RequestMapping
public class ThymeleafController {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("title","我的第一个WEB页面");
        Author author =new Author();
        author.setAge(22);
        author.setEmail("112sdss@qq.com");
        author.setName("dfsf");
        view.addObject("author",author);

        return view;

    }

    @GetMapping("/index1")
    public String index1(HttpServletRequest request){
        // TODO 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title","我的第一个WEB页面");
        request.setAttribute("desc","欢迎静茹battcn-web");
        Author author = new Author();
        author.setAge(33);
        author.setEmail("112sdss@qq.com");
        author.setName("dfsf");
        request.setAttribute("author", author);
        // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html

        return "index";
    }

}
