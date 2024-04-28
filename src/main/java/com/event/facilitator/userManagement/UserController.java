package com.event.facilitator.userManagement;

import com.event.facilitator.provider.Dto.LoginDTO;
import com.event.facilitator.provider.Dto.ProviderDTO;
import com.event.facilitator.provider.service.ProviderService;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/venue/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }
}
