package com.company.lc_managment.controller;

import com.company.lc_managment.dto.LoginDTO;
import com.company.lc_managment.dto.RegisterDTO;
import com.company.lc_managment.dto.TokenDTO;
import com.company.lc_managment.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private  final AuthService authService;
    @Override
    public HttpEntity<TokenDTO> login(LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }



    @Override
    public HttpEntity<TokenDTO> register(RegisterDTO registerDTO) {
        return ResponseEntity.ok(authService.register(registerDTO));
    }

    @Override
    public HttpEntity<TokenDTO> refreshToken(String accessToken, String refreshToken) {
        return ResponseEntity.ok(authService.refreshToken(accessToken,refreshToken));
    }


}
