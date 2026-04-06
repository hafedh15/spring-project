package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.tpfoyer.dto.BlocDto;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlocMapper {

    @Mapping(source = "capaciteBloc", target = "capacite")
    BlocDto toDto(Bloc bloc);

    @Mapping(source = "capacite", target = "capaciteBloc")
    Bloc toEntity(BlocDto dto);

    List<BlocDto> toDtoList(List<Bloc> blocs);
}