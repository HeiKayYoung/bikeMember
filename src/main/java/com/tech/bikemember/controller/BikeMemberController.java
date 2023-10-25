package com.tech.bikemember.controller;

import com.tech.bikemember.exception.ResourceNotFoundException;
import com.tech.bikemember.model.BikeMember;
import com.tech.bikemember.repository.BikeMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/bikemembers")
public class BikeMemberController {

    @Autowired
    private BikeMemberRepository bikeMemberRepository;
    //DB와 연결시켜서 사용하겠다는 의미

    @GetMapping
    public List<BikeMember> getAllBikeMembers(){
        System.out.println("List<BikeMember> getAllBikeMembers");
        return bikeMemberRepository.findAll();
    }
    @PostMapping
    public BikeMember createBikeMember(@RequestBody BikeMember bikeMember){
//        Object BikeMember 로 받으면 bikeMember 이름으로 쓰겠다
//        Post방식으로 보낸것이 알아서 PostMapping 찾아서
        System.out.println("BikeMember createBikeMember db save");

        return bikeMemberRepository.save(bikeMember);
    }

    @GetMapping("{id}")
    public ResponseEntity<BikeMember> getBikeMemberById(@PathVariable long id){
        System.out.println("ResponseEntity<BikeMember> getBikeMemberById");
        BikeMember bikeMember=bikeMemberRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("BikeMember not exist with id:"+id));

        return ResponseEntity.ok(bikeMember);
    }

    @PutMapping("{id}")
    public ResponseEntity<BikeMember> updateBikeMember(@PathVariable long id,
                                                       @RequestBody BikeMember bikeMember){
        System.out.println("ResponseEntity<BikeMember> updateBikeMember");
        BikeMember updateBikeMember=bikeMemberRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("BikeMember not exist with id:"+id));
        updateBikeMember.setFirstName(bikeMember.getFirstName());
        updateBikeMember.setLastName(bikeMember.getLastName());
        updateBikeMember.setEmailId(bikeMember.getEmailId());
        bikeMemberRepository.save(updateBikeMember);

        return ResponseEntity.ok(updateBikeMember);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BikeMember> deleteMember(@PathVariable long id){
        System.out.println("ResponseEntity<BikeMember> deleteBikeMember");
        BikeMember bikeMember=bikeMemberRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("BikeMember not exist with id:"+id));
        bikeMemberRepository.delete(bikeMember);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
