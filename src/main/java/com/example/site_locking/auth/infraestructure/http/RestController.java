package com.example.site_locking.auth.infraestructure.http;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping
public class RestController {
/*
    @GetMapping("/home")
    @PreAuthorize("hasAnyRole('INFLUENCER','BRAND')")
    String hello(){
        return "telaInicial";
    }

    @GetMapping("/influencer")
    @PreAuthorize("hasRole('INFLUENCER')")
    String influencerEndPoint(){return "telaInfluencer";}

    @GetMapping("/brand")
    @PreAuthorize("hasRole('BRAND')")
    String brandEndPoint(){return "telaBrand";}

    @GetMapping("/login")
    String loginPage(){
        return "telaLogin";
    }

 */
}
