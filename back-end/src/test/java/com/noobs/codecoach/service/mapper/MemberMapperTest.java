package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.service.dto.request.CreateMemberDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberMapperTest {

    @InjectMocks
    public MemberMapper memberMapper;

    @Nested
    public class InputValidation {

        @Test
        void fromDto_givenCreateMemberDtoWithNullField_throwsIllegalArgumentException() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(generateDefaultCreateMemberDTO().setFirstName(null)));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(generateDefaultCreateMemberDTO().setLastName(null)));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(generateDefaultCreateMemberDTO().setEmail(null)));
//            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(generateDefaultCreateMemberDTO().setPassword(null)));
        }

        @Test
        void fromDto_givenCreateMemberDtoWithBlankField_throwsIllegalArgumentException() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(generateDefaultCreateMemberDTO().setFirstName("   ")));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(generateDefaultCreateMemberDTO().setLastName("   ")));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(generateDefaultCreateMemberDTO().setEmail("   ")));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(generateDefaultCreateMemberDTO().setPassword("   ")));
        }

        @Test
        void fromDto_givenCreateMemberDtoWithoutEmailOrPassword() {
            //GIVEN
            CreateMemberDTO createMemberDTO1 = generateDefaultCreateMemberDTO().setEmail(null);
//            CreateMemberDTO createMemberDTO2 = generateDefaultCreateMemberDTO().setPassword(null);
            CreateMemberDTO createMemberDTO3 = generateDefaultCreateMemberDTO().setEmail("   ");
            CreateMemberDTO createMemberDTO4 = generateDefaultCreateMemberDTO().setPassword("   ");
            //THEN
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(createMemberDTO1));
//            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(createMemberDTO2));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(createMemberDTO3));
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> memberMapper.fromDto(createMemberDTO4));
        }
    }

    private CreateMemberDTO generateDefaultCreateMemberDTO() {
        return new CreateMemberDTO()
                .setFirstName("DefaultFirstName")
                .setLastName("DefaultLastName")
                .setEmail("default@email.com")
                .setPassword("Password007");
    }

}
