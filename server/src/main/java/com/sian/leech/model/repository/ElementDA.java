package com.sian.leech.model.repository;

import com.sian.leech.model.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementDA extends JpaRepository<Element,Long> {

}
