package App.mapper;

import App.dto.NotesDto;
import App.model.Notes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface NotesMapper {

    @Mappings({
            @Mapping(target = "order", source = "eNotes.order"),
            @Mapping(target = "note", source = "eNotes.note"),
            @Mapping(target = "date", source = "eNotes.date"),
            @Mapping(target = "is_Done", source = "eNotes.is_Done")
    })
    NotesDto toDto(Notes eNotes);

    @Mappings({
            @Mapping(target = "order", source = "dNotes.order"),
            @Mapping(target = "note", source = "dNotes.note"),
            @Mapping(target = "date", source = "dNotes.date"),
            @Mapping(target = "is_Done", source = "dNotes.is_Done")
    })
    Notes toEntity(NotesDto dNotes);

    default List<NotesDto> toDtos(List<Notes> eNotes) {
        return eNotes.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<NotesDto> toOptionalDtos(Optional<Notes> eNotes) {
        return eNotes.map(this::toDto);
    }

}
