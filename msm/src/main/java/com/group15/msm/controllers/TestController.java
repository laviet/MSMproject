package com.group15.msm.controllers;

import com.group15.msm.model.DestinationModel;
import com.group15.msm.model.Source2;
import com.group15.msm.model.SourceModel;
import com.group15.msm.model.TestModel;
import com.group15.msm.security.IsUser;
import com.group15.msm.util.BeanMapper;
import com.group15.msm.util.DateUtil;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 20-11-2019
 * Time: 22:34
 */
@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public void testController() {
        System.out.println("this is test");
        String str=DateUtil.convertDate(new Date());
        System.out.println("date la: "+str);
    }
}
