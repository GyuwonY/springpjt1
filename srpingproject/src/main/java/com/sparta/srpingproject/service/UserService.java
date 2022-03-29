package com.sparta.srpingproject.service;

import com.sparta.srpingproject.dto.SignupRequestDto;
import com.sparta.srpingproject.model.User;
import com.sparta.srpingproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;


@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto) throws IllegalArgumentException {
// 회원 ID 중복 확인
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        signupValidate(username, password);

        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 ID 가 존재합니다.");
        }
// 패스워드 암호화
        password = passwordEncoder.encode(password);

        User user = new User(username, password);
        userRepository.save(user);
    }

    public static void signupValidate(String username, String password) {
        if(username.length()<3){
            throw new IllegalArgumentException("ID는 최소 3자 이상이여야 합니다.");
        }
        if(!Pattern.matches("^[a-zA-Z0-9]*$", username)){
            throw new IllegalArgumentException("ID는 알파벳과 숫자만 입력이 가능합니다.");
        }
        if(password.length()<4){
            throw new IllegalArgumentException("비밀번호는 최소 4자 이상이여야 합니다.");
        }
        if(password.contains(username)){
            throw new IllegalArgumentException("ID가 포함되지 않은 비밀번호를 사용해주세요.");
        }

    }
}
