package com.event.facilitator.provider.providerController;


import com.event.facilitator.provider.Dto.LoginResponseDTO;
import com.event.facilitator.provider.Dto.ProviderDTO;
import com.event.facilitator.provider.Dto.LoginDTO;
import com.event.facilitator.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/venue/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;


    @PostMapping("/save")
    public int addProvider(@RequestBody ProviderDTO providerDTO) {
        int id = providerService.addProvider(providerDTO);
        return id;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginDTO loginDTO) {
        return providerService.login(loginDTO);
    }
}
