package com.event.facilitator.userManagement;

import com.event.facilitator.provider.Dto.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int addUser(User user);

    String login(LoginDTO loginDTO);
}
