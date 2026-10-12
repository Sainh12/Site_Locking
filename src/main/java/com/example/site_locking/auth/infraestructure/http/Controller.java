package com.example.site_locking.auth.infraestructure.http;

import com.example.site_locking.auth.infraestructure.persistence.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/home")
    public String hello(@AuthenticationPrincipal User user){
        return "telaInicial";
    }

    @GetMapping("/influencer")
    @PreAuthorize("hasRole('INFLUENCER')")
    public String influencerEndPoint(){return "telaInfluencer";}

    @GetMapping("/brand")
    @PreAuthorize("hasRole('BRAND')")
    public String brandEndPoint(){return "telaBrand";}
}
