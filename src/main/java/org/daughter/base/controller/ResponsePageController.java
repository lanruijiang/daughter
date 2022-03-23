package org.daughter.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/from")
public class ResponsePageController {
    @RequestMapping("/main/{path}")
    public String toIndex(@PathVariable("path") String path) {
        return "main/" + path;
    }

    @RequestMapping("/users/{path}")
    public String toUsers(@PathVariable("path") String path) {
        return "users/" + path;
    }

    @RequestMapping("/reply/{path}")
    public String toReply(@PathVariable("path") String path) {
        return "reply/" + path;
    }

    @RequestMapping("/article/{path}")
    public String toArticle(@PathVariable("path") String path) {
        return "article/" + path;
    }
}
