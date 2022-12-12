package com.raimondas.bites.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, String> {

    @Override
    public String convertToDatabaseColumn(Type type) {
        if (type == null) {
            return null;
        }
        return type.getLabel();
    }

    @Override
    public Type convertToEntityAttribute(String label) {
        if (label == null) {
            return null;
        }

        return Stream.of(Type.values())
                .filter(c -> c.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}


