package App.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notes")
public class Notes {
    @Transient
    public static final String SEQUENCE_NAME = "notes_sequence";

    @Id
    private Long order = 0L;

    @Field
    private String note = "New note...";

    @Field
    private Date date = new Date(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));

    @Field
    private Boolean is_Done = false;
}