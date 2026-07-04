package com.petsproducts.user.infrastructure.database.mapper;

import com.petsproducts.user.domain.User;
import com.petsproducts.user.infrastructure.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserEntityMapper {

    @Mapping(target = "authorities", ignore = true)
    UserEntity mapToUserEntity(User user);

    User mapToUser(UserEntity userEntity);
}
