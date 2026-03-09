package fi.metropolia.jarmoil.Spring_API.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class KyllaEiBooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        // Java Boolean -> DB CHAR(1): 'k' tai 'e'
        if (attribute == null) {
            return "k"; // oletus
        }
        return attribute ? "k" : "e";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        // DB CHAR(1) -> Java Boolean
        if (dbData == null) {
            return false; // oletus
        }

        if ("k".equalsIgnoreCase(dbData)) return true;
        if ("e".equalsIgnoreCase(dbData)) return false;

        throw new IllegalArgumentException("Virheellinen k/e-arvo tietokannassa: '" + dbData + "'");
    }
}
