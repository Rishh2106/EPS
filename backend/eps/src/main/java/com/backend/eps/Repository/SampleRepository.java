package com.backend.eps.Repository;

import com.backend.eps.Entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample,Integer> {
    Sample findByUsernameAndPwd(String username,String pwd);
}
