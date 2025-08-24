package com.sian.leech.model.repository;

import com.sian.leech.model.entity.MessageElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageElementDA extends JpaRepository<MessageElement,Long> {
}
