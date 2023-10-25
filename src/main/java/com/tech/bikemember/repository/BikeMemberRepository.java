package com.tech.bikemember.repository;

import com.tech.bikemember.model.BikeMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeMemberRepository extends JpaRepository<BikeMember,Long> {
    //all crud data
}
