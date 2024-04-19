package com.company.lc_managment.controller;

import com.company.lc_managment.dto.LoginDTO;
import com.company.lc_managment.dto.RegisterDTO;
import com.company.lc_managment.dto.TokenDTO;
import com.company.lc_managment.utils.AppConstants;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AuthController.BASE_PATH)
public interface AuthController {
    String BASE_PATH = AppConstants.AUTH_CONTROLLER_BASE_PATH;
    @PostMapping(AppConstants.AUTH_CONTROLLER_LOGIN_PATH)
    HttpEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO);

    @PostMapping(AppConstants.AUTH_CONTROLLER_REGISTER_PATH)
    HttpEntity<TokenDTO> register(@RequestBody RegisterDTO registerDTO);

    @PatchMapping(AppConstants.AUTH_CONTROLLER_REFRESH_TOKEN_PATH)
    HttpEntity<TokenDTO> refreshToken(String accessToken, String refreshToken);


}
