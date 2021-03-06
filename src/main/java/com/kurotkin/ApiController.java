package com.kurotkin;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {
    final SitesRepository sitesRepository;
    final UsersRepository usersRepository;

    public ApiController(SitesRepository sitesRepository, UsersRepository usersRepository) {
        this.sitesRepository = sitesRepository;
        this.usersRepository = usersRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE})
    public Site add(@RequestParam(value="url", required=true) String url,
                    @RequestParam(value="rate", required=false, defaultValue="18") String rateString,
                    @RequestParam(value="type", required=false, defaultValue="n/a") String type,
                    @RequestParam(value="userid", required=false, defaultValue="n/a") String userid) {
        int rate = Integer.parseInt(rateString);
        Site site = new Site(url, rate, type, userid, LocalDate.now());
        sitesRepository.save(site);
        return site;
    }

    @GetMapping("/sites")
    public Iterable<Site> getSites() {
        return sitesRepository.findAll();
    }

    @GetMapping("/users")
    public Iterable<UserCurrent> getUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/lite")
    public List<String> getSitesLite() {
        List<String> list = new ArrayList<>();
        Iterator<Site> iter = sitesRepository.findAll().iterator();
        while (iter.hasNext()){
            list.add(iter.next().getUrl());
        }
        return list;
    }

}
