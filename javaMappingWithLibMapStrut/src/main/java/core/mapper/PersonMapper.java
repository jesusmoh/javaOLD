/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mapper;

import core.person.Person;
import core.person.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author JOrtiz
 */
@Mapper
public interface PersonMapper {
    
     PersonMapper INSTANCIA= Mappers.getMapper(PersonMapper.class);
  
     @Mapping(source = "yearold", target = "yearsold")
     PersonDTO personaToPersonaDto(Person persona);
}
