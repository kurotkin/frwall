package com.kurotkin;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    final SitesRepository sitesRepository;

    public IndexController(SitesRepository sitesRepository) {
        this.sitesRepository = sitesRepository;
    }

    @GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "систему контроля - FireWall");
        return new ModelAndView("index", model);
    }

}
