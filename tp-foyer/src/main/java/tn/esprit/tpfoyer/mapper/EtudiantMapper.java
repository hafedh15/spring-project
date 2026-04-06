package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
// ⚠️ No need for @Mapping here because the field names in Etudiant Entity
// and EtudiantDto are identical (nomEtudiant, prenomEtudiant, cin).
// MapStruct will map them automatically.
import tn.esprit.tpfoyer.dto.EtudiantDto;
import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {

    EtudiantDto toDto(Etudiant etudiant);

    Etudiant toEntity(EtudiantDto dto);

    List<EtudiantDto> toDtoList(List<Etudiant> etudiants);
}
