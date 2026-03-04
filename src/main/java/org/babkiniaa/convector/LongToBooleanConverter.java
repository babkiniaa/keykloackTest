package org.babkiniaa.convector;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LongToBooleanConverter implements AttributeConverter<Boolean, Long> {

    @Override
    public Long convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute ? 1L : 0L;
    }

    @Override
    public Boolean convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData != 0L;
    }
}
