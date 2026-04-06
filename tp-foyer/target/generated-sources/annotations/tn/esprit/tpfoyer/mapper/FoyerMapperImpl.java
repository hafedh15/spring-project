package tn.esprit.tpfoyer.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tn.esprit.tpfoyer.dto.FoyerDto;
import tn.esprit.tpfoyer.entity.Foyer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-05T10:25:38+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.17 (Microsoft)"
)
@Component
public class FoyerMapperImpl implements FoyerMapper {

    @Override
    public FoyerDto toDto(Foyer foyer) {
        if ( foyer == null ) {
            return null;
        }

        FoyerDto foyerDto = new FoyerDto();

        foyerDto.setCapacite( (int) foyer.getCapaciteFoyer() );
        foyerDto.setNomFoyer( foyer.getNomFoyer() );

        return foyerDto;
    }

    @Override
    public Foyer toEntity(FoyerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Foyer foyer = new Foyer();

        if ( dto.getCapacite() != null ) {
            foyer.setCapaciteFoyer( dto.getCapacite() );
        }
        foyer.setNomFoyer( dto.getNomFoyer() );

        return foyer;
    }

    @Override
    public List<FoyerDto> toDtoList(List<Foyer> foyers) {
        if ( foyers == null ) {
            return null;
        }

        List<FoyerDto> list = new ArrayList<FoyerDto>( foyers.size() );
        for ( Foyer foyer : foyers ) {
            list.add( toDto( foyer ) );
        }

        return list;
    }

    @Override
    public List<Foyer> toEntityList(List<FoyerDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Foyer> list = new ArrayList<Foyer>( dtos.size() );
        for ( FoyerDto foyerDto : dtos ) {
            list.add( toEntity( foyerDto ) );
        }

        return list;
    }
}
