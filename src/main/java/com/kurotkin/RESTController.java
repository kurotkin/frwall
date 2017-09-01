package com.kurotkin;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//@RestController
//@RequestMapping("/apiii")
public class RESTController {
    final SitesRepository sitesRepository;
    public RESTController(SitesRepository sitesRepository) {
        this.sitesRepository = sitesRepository;
    }

    //@GetMapping("/sites")
    public Iterable<Site> getVisits() {
        return sitesRepository.findAll();
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE})
//    public SiteList getAllEmployees() {
//        SiteList list = new SiteList();
//        System.out.println("Working...");
//
//        for(int i = 1; i <= Main.num; i++) {
//            Site w = new Site(i, i, Main.torque, dateFormat.format(new Date()), Main.serno, Main.name);
//            list.getFasteners().add(w);
//        }
//        return list;
//    }
//
//    @RequestMapping(value = "/get", method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE})
//    public SiteList getting(@RequestParam(value="num", required=false, defaultValue="12") String arg_0,
//                            @RequestParam(value="torque", required=false, defaultValue="8.1") String arg_1,
//                            @RequestParam(value="serno", required=false, defaultValue="0000000") String serno,
//                            @RequestParam(value="name", required=false, defaultValue="") String name) {
//        int num = Integer.parseInt(arg_0);
//        double torque = Double.parseDouble(arg_1);
//        SiteList list = new SiteList();
//        for(int i = 1; i <= num; i++) {
//            Site w = new Site(i, i, torque, dateFormat.format(new Date()), serno, name);
//            list.getFasteners().add(w);
//        }
//        return list;
//    }

//    @RequestMapping(value = "/employees")
//    public EmployeeListVO getAllEmployees() {
//        EmployeeListVO employees = new EmployeeListVO();
//
//        EmployeeVO empOne = new EmployeeVO(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
//        EmployeeVO empTwo = new EmployeeVO(2,"Amit","Singhal","asinghal@yahoo.com");
//        EmployeeVO empThree = new EmployeeVO(3,"Kirti","Mishra","kmishra@gmail.com");
//
//
//        employees.getEmployees().add(empOne);
//        employees.getEmployees().add(empTwo);
//        employees.getEmployees().add(empThree);
//
//        return employees;
//    }
//
//    @RequestMapping(value = "/employees/{id}")
//    public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id)
//    {
//        if (id <= 3) {
//            EmployeeVO employee = new EmployeeVO(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
//            return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
//        }
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
}
