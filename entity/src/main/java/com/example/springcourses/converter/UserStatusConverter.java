package com.example.springcourses.converter;

import com.example.springcourses.entity.UserStatus;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class UserStatusConverter implements AttributeConverter<UserStatus, String> {
    @Override
    public String convertToDatabaseColumn(UserStatus attribute) {
        if (Objects.isNull(attribute)) {
            attribute = UserStatus.ACTIVE;
        }
        return attribute.getValue();
    }

    @Override
    public UserStatus convertToEntityAttribute(String dbData) {
        return UserStatus.getByValue(dbData);
    }
}
