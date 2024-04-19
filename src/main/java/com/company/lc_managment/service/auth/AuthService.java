package com.company.lc_managment.service.auth;
import com.company.lc_managment.dto.LoginDTO;
import com.company.lc_managment.dto.RegisterDTO;
import com.company.lc_managment.dto.TokenDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    TokenDTO login(LoginDTO loginDTO);

    TokenDTO refreshToken(String accessToken,String refreshToken);

    TokenDTO register(RegisterDTO registerDTO);
}
