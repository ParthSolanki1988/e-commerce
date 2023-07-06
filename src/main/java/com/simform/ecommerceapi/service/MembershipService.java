package com.simform.ecommerceapi.service;

import com.simform.ecommerceapi.entity.Membership;
import com.simform.ecommerceapi.repository.MembershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepo membershipRepo;
//    @Autowired
//    private ModelMapper modelMapper;

    public Membership addMembership(Membership membership) {
        return membershipRepo.save(membership);
    }


    public List<Membership> getAllMembership() {
        Optional<List<Membership>> allMembership = Optional.of(membershipRepo.findAll());
        if (allMembership.isPresent()) {
            return allMembership.get();
        } else {
            throw new RuntimeException("All membership List is empty");
        }
    }

    public Membership getMembershipById(int id) {
        Optional<Membership> membership = membershipRepo.findById(id);
        if (membership.isPresent()) {
            return membership.get();
        } else {
            throw new RuntimeException("Membership id is invalid");
        }
    }

    public void deleteMembershipById(int id) {
        membershipRepo.deleteById(id);
    }

    public Membership updateMembership(Membership membership) {
        return membershipRepo.save(membership);
    }
}
