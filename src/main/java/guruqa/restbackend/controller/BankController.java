package guruqa.restbackend.controller;

import guruqa.restbackend.controller.exception.InvalidUserNameException;
import guruqa.restbackend.domain.LoginInfo;
import guruqa.restbackend.domain.UserInfo;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.jfr.Description;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {

    private Map<String, UserInfo> users = Map.of(
            "Dima", UserInfo.builder().userName("Dima").build(),
            "Olga", UserInfo.builder().userName("Olga").build(),
            "Ivan", UserInfo.builder().userName("Ivan").build()
    );



    @PostMapping("user/login")
    @ApiOperation("auth")

    public UserInfo doLogin (@RequestBody LoginInfo LoginInfo) {
        if (LoginInfo.getUserName().equals("Dima")) {
            return UserInfo.builder()
                    .LoginDate(new Date())
                    .userName(LoginInfo.getUserName())
                    .build();
        } else {
            throw new InvalidUserNameException();
        }
    }
    @GetMapping("user/getall")
    @ApiOperation("auth all users")
    public List<UserInfo> getAllUserInfo() {
        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
