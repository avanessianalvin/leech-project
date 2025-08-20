package com.sian.leech.model.repository;

import com.sian.leech.model.entity.Chain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainDA extends JpaRepository<Chain,Long> {
}
