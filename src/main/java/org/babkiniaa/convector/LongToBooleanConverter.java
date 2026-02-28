package org.babkiniaa.convector;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LongToBooleanConverter implements AttributeConverter<Boolean, Long> {

    @Override
    public Long convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean.equals(Boolean.TRUE) ? 1L : 0L;
    }

    @Override
    public Boolean convertToEntityAttribute(Long aLong) {
        return aLong == 1;
    }
}
