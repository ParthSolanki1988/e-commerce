package com.simform.ecommerceapi.controller;

import com.simform.ecommerceapi.entity.Membership;
import com.simform.ecommerceapi.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membership")
public class MembershipController {
    @Autowired
    MembershipService membershipService;

    @GetMapping
    public List<Membership> getAllMembership() {
        return membershipService.getAllMembership();
    }

    @GetMapping("/{id}")
    public Membership getMembershipById(@PathVariable int id) {
        return membershipService.getMembershipById(id);
    }

    @PostMapping
    public Membership addMembership(@RequestBody Membership membership) {
        return membershipService.addMembership(membership);
    }

    @PutMapping
    public Membership updateMembership(@RequestBody Membership membership) {
        return membershipService.updateMembership(membership);
    }

    @DeleteMapping("/{id}")
    public void deleteMembershipById(@PathVariable int id) {
        membershipService.deleteMembershipById(id);
    }

}
