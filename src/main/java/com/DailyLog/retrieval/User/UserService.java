package com.DailyLog.retrieval.User;

import com.DailyLog.retrieval.DTOs.CreateUserDto;
import com.DailyLog.retrieval.DTOs.ResponseUserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService  {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<ResponseUserDto> createUser(@Valid CreateUserDto userDto){
        String email=userDto.getEmail();
        if(userRepository.existsByEmail(email)){
            return Optional.empty();
        }else{
            UserEntity user=new UserEntity();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());

            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(user);
            ResponseUserDto responseUserDto=new ResponseUserDto(userDto);
            return Optional.of(responseUserDto);
        }
    }

}
