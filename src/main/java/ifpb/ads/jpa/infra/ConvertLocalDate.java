package ifpb.ads.jpa.infra;

import java.sql.Date;
//import java.time.Instant;
import java.time.LocalDate;
//import java.util.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 14/08/2017, 07:27:05
 */
@Converter(autoApply = true)
public class ConvertLocalDate implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        if (attribute == null) {
            return null;
        }
        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData.toLocalDate();
    }

}
