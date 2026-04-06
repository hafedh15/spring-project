package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tpfoyer.dto.ChambreDto;
import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChambreMapper {

    @Mapping(source = "capaciteChambre", target = "capacite")
    ChambreDto toDto(Chambre chambre);

    @Mapping(source = "capacite", target = "capaciteChambre")
    Chambre toEntity(ChambreDto dto);

    List<ChambreDto> toDtoList(List<Chambre> chambres);
}