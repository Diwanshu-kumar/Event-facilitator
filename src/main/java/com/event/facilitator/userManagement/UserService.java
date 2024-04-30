package com.event.facilitator.userManagement;

import com.event.facilitator.provider.Dto.LoginDTO;
import com.event.facilitator.provider.Dto.LoginResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<String > addUser(User user);

    LoginResponseDTO login(LoginDTO loginDTO);
}
