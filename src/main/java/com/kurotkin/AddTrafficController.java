package com.kurotkin;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/traffic")
public class AddTrafficController {
    final UsersRepository usersRepository;

    public AddTrafficController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces={MediaType.APPLICATION_XML_VALUE})
    public UserCurrent add(@RequestParam(value="userid", required=true) String userid,
                    @RequestParam(value="in", required=false, defaultValue="0") String inString,
                    @RequestParam(value="out", required=false, defaultValue="0") String outString) {
        long in = Long.parseLong(inString);
        long out = Long.parseLong(outString);
        String str = "user id = " + userid + " in = " + in + " out = " + out;
        System.out.println(str);

        InfluxDB influxDB = InfluxDBFactory.connect("http://:8086", "", "");
        influxDB.createDatabase("dbName");

        BatchPoints batchPoints = BatchPoints.database("dbName")
                .retentionPolicy("autogen")
                .consistency(InfluxDB.ConsistencyLevel.ALL)
                .build();
        Point point = Point.measurement(userid)
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField("in", in)
                .addField("out", out)
                .build();
        batchPoints.point(point);

        influxDB.write(batchPoints);
        UserCurrent user = new UserCurrent(userid);
        usersRepository.save(user);
        return user;
    }
}
