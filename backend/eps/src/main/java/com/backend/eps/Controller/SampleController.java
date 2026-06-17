package com.backend.eps.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.eps.DTO.SampleRequestDTO;
import com.backend.eps.Entity.Sample;
import com.backend.eps.Repository.SampleRepository;

@RestController
@CrossOrigin
@RequestMapping("/")
public class SampleController {
    private SampleRepository repository;
    public SampleController(SampleRepository repository){
        this.repository=repository;
    }
    @PostMapping("/signup")
    public String signUp(@RequestBody SampleRequestDTO requestDTO){
        Sample sample=new Sample();
        sample.setUsername(requestDTO.getName());
        sample.setPwd(requestDTO.getPwd());
        // persist the new user
        repository.save(sample);
        return "The user has signed successfully";
    }
    @PostMapping("/signin")
    public String signIn(@RequestBody SampleRequestDTO requestDTO){
       Sample sample= repository.findByUsernameAndPwd(requestDTO.getName(),requestDTO.getPwd());
        if(sample==null){
            return "invalid username";
        }
        else if(!sample.getPwd().equals(requestDTO.getPwd())){
            return "invalid password";
        }
        return "User signed in successfully";
    }
}
