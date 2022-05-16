package App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotesDto {
    @NotNull
    private Long order;

    private String note;

    private String date;

    private Boolean is_Done;
}