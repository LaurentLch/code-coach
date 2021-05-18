package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.service.dto.request.CreateUserDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @InjectMocks
    public UserMapper userMapper;

    @Nested
    public class InputValidation {

        @Test
        void fromDto_givenCreateUserDtoWithNullField_throwsIllegalArgumentException() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(generateDefaultCreateUserDTO().setFirstName(null)));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(generateDefaultCreateUserDTO().setLastName(null)));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(generateDefaultCreateUserDTO().setEmail(null)));
//            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(generateDefaultCreateUserDTO().setPassword(null)));
        }

        @Test
        void fromDto_givenCreateUserDtoWithBlankField_throwsIllegalArgumentException() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(generateDefaultCreateUserDTO().setFirstName("   ")));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(generateDefaultCreateUserDTO().setLastName("   ")));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(generateDefaultCreateUserDTO().setEmail("   ")));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(generateDefaultCreateUserDTO().setPassword("   ")));
        }

        @Test
        void fromDto_givenCreateUserDtoWithoutEmailOrPassword() {
            //GIVEN
            CreateUserDTO createUserDTO1 = generateDefaultCreateUserDTO().setEmail(null);
//            CreateMemberDTO createMemberDTO2 = generateDefaultCreateUserDTO().setPassword(null);
            CreateUserDTO createUserDTO3 = generateDefaultCreateUserDTO().setEmail("   ");
            CreateUserDTO createUserDTO4 = generateDefaultCreateUserDTO().setPassword("   ");
            //THEN
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(createUserDTO1));
//            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(createUserDTO2));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(createUserDTO3));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> userMapper.fromDto(createUserDTO4));
        }
    }

    private CreateUserDTO generateDefaultCreateUserDTO() {
        return new CreateUserDTO()
                .setFirstName("DefaultFirstName")
                .setLastName("DefaultLastName")
                .setEmail("default@email.com")
                .setPassword("Password007");
    }

}
