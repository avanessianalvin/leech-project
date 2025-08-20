package com.sian.leech.model.mapper;

import com.sian.leech.model.entity.Element;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ElementMapper {
    @Insert("INSERT INTO element(name,opposite) VALUES(#{name},#{opposite})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Element element);

    @Update("UPDATE element SET name=#{name}, opposite=#{opposite} WHERE id=#{id}" )
    void update(Element element);

    @Delete("DELETE FROM element WHERE id=#{id}")
    void delete(Element element);

    @Select("SELECT * FROM element WHERE id=#{id}")
    Element findOne(Long id);

    @Select("SELECT * FROM element")
    List<Element> findAll();

}
