package com.sian.leech.model.repository;

import com.sian.leech.model.entity.ActiveChain;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ActiveChainDA extends JpaRepository<ActiveChain,Long> {

    @Query("SELECT a FROM ActiveChain a WHERE a.confirmTime =0")
    List<ActiveChain> findAllActive();


    List<ActiveChain> findByConfirmTimeGreaterThan(long value, Pageable pageable);

}
