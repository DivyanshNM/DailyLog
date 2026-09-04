package com.DailyLog.retrieval.User;


import com.DailyLog.retrieval.DTOs.CreateUserDto;
import com.DailyLog.retrieval.DTOs.ResponseUserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping
    public ResponseEntity<ResponseUserDto> createUser(@Valid @RequestBody CreateUserDto userDto){
        Optional<ResponseUserDto> responseUserDto= userService.createUser(userDto);
        if(responseUserDto.isPresent()) return new ResponseEntity<>(responseUserDto.get(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
