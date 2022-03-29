package com.sparta.srpingproject.service;

import com.sparta.srpingproject.dto.SignupRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    String username;
    String password;
    @Test
    @DisplayName("ID 1글자")
    void validator1() {
// given
        username="a";
        password="ssss";
// when
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            UserService.signupValidate(username, password);
        });
// then
        assertEquals("ID는 최소 3자 이상이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("ID 2글자")
    void validator2() {
// given
        username="aa";
        password="ssss";
// when
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            UserService.signupValidate(username, password);
        });
// then
        assertEquals("ID는 최소 3자 이상이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("한글 포함")
    void validator3() {
// given
        username="aㅁa";
        password="ssss";
// when
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            UserService.signupValidate(username, password);
        });
// then
        assertEquals("ID는 알파벳과 숫자만 입력이 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("한글포함")
    void validator4() {
// given
        username="aAaㄴ12";
        password="ssss";
// when
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            UserService.signupValidate(username, password);
        });
// then
        assertEquals("ID는 알파벳과 숫자만 입력이 가능합니다.", exception.getMessage());
    }


    @Test
    @DisplayName("비밀번호 2글자")
    void validator5() {
// given
        username="aAbb";
        password="ss";
// when
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            UserService.signupValidate(username, password);
        });
// then
        assertEquals("비밀번호는 최소 4자 이상이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("비밀번호 3글자")
    void validator6() {
// given
        username="aAaB";
        password="ss~";
// when
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            UserService.signupValidate(username, password);
        });
// then
        assertEquals("비밀번호는 최소 4자 이상이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("비밀번호에 닉네임 포함")
    void validator7() {
// given
        username="asd";
        password="aasdaaa";
// when
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            UserService.signupValidate(username, password);
        });
// then
        assertEquals("ID가 포함되지 않은 비밀번호를 사용해주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("비밀번호에 닉네임 포함")
    void validator8() {
// given
        username="qwer";
        password="aa11qweraaa";
// when
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            UserService.signupValidate(username, password);
        });
// then
        assertEquals("ID가 포함되지 않은 비밀번호를 사용해주세요.", exception.getMessage());
    }
}