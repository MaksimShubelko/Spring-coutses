package com.example.springcourses.converter;

import com.example.springcourses.entity.UserRole;
import lombok.Builder;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<UserRole, String> {
    @Override
    public String convertToDatabaseColumn(UserRole attribute) {
        if (Objects.isNull(attribute)) {
            attribute = UserRole.STUDENT;
        }
        return attribute.getValue();
    }

    @Override
    public UserRole convertToEntityAttribute(String dbData) {
        return UserRole.getByValue(dbData);
    }
}
