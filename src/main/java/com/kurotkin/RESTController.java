package com.kurotkin;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class RESTController {
    public static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @RequestMapping(value = "/", method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE})
    public StahlwilleList getAllEmployees() {
        StahlwilleList list = new StahlwilleList();
        System.out.println("Working...");

        for(int i = 1; i <= Main.num; i++) {
            Stahlwille w = new Stahlwille(i, i, Main.torque, dateFormat.format(new Date()), Main.serno, Main.name);
            list.getFasteners().add(w);
        }
        return list;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE})
    public StahlwilleList getting(@RequestParam(value="num", required=false, defaultValue="12") String arg_0,
                                  @RequestParam(value="torque", required=false, defaultValue="8.1") String arg_1,
                                  @RequestParam(value="serno", required=false, defaultValue="0000000") String serno,
                                  @RequestParam(value="name", required=false, defaultValue="") String name) {
        int num = Integer.parseInt(arg_0);
        double torque = Double.parseDouble(arg_1);
        StahlwilleList list = new StahlwilleList();
        for(int i = 1; i <= num; i++) {
            Stahlwille w = new Stahlwille(i, i, torque, dateFormat.format(new Date()), serno, name);
            list.getFasteners().add(w);
        }
        return list;
    }

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
