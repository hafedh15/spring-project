package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import tn.esprit.tpfoyer.dto.UniversiteDto;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniversiteMapper {

    UniversiteDto toDto(Universite universite);

    Universite toEntity(UniversiteDto dto);

    List<UniversiteDto> toDtoList(List<Universite> universites);
}