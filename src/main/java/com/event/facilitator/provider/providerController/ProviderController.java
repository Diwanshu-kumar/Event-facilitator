package com.event.facilitator.provider.providerController;


import com.event.facilitator.provider.Dto.ProviderDTO;
import com.event.facilitator.provider.Dto.LoginDTO;
import com.event.facilitator.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/events/admin")
public class ProviderController {

    @Autowired
    private ProviderService providerService;


    @PostMapping("/save")
    public int addProvider(@RequestBody ProviderDTO providerDTO) {
        int id = providerService.addProvider(providerDTO);
        return id;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return providerService.login(loginDTO);
    }
}
