package com.group15.msm.controllers;

import com.group15.msm.model.DestinationModel;
import com.group15.msm.model.Source2;
import com.group15.msm.model.SourceModel;
import com.group15.msm.security.IsUser;
import com.group15.msm.util.BeanMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 20-11-2019
 * Time: 22:34
 */
@RestController
@RequestMapping("/api")
public class TestController {
    @PostMapping("/test")
    public void testController(@Valid @RequestBody SourceModel sourceModel) {
        System.out.println("source: " + sourceModel.getId() + sourceModel.getName() + sourceModel.getScore());
        DestinationModel destinationModel = new DestinationModel();
        BeanMapper.BeanCoppy(sourceModel, destinationModel);
        System.out.println("destination: " + destinationModel.getId() + destinationModel.getName1()
                + destinationModel.getScore() + destinationModel.getAddress() + destinationModel.getAge());
//        Source2 source2=new Source2();
//        source2.setAddress("Ha noi");
//        source2.setAge(24);
//        BeanMapper.BeanCoppy(source2, destinationModel);
//
//        System.out.println("destination 2: " + destinationModel.getId() + destinationModel.getName1()
//                + destinationModel.getScore() + destinationModel.getAddress() + destinationModel.getAge());
    }
}
