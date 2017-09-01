package com.kurotkin;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api")
public class AddController {
    final SitesRepository sitesRepository;

    public AddController(SitesRepository sitesRepository) {
        this.sitesRepository = sitesRepository;
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
    public Iterable<Site> getVisits() {
        return sitesRepository.findAll();
    }

}
