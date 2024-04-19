package com.company.lc_managment.service.auth;

import com.company.lc_managment.config.jwtFilter.JWTProvider;
import com.company.lc_managment.dto.LoginDTO;
import com.company.lc_managment.dto.RegisterDTO;
import com.company.lc_managment.dto.TokenDTO;
import com.company.lc_managment.entity.Attachment;
import com.company.lc_managment.entity.User;
import com.company.lc_managment.enums.Gender;
import com.company.lc_managment.enums.Roles;
import com.company.lc_managment.exception.RestException;
import com.company.lc_managment.repository.AttachmentRepository;
import com.company.lc_managment.repository.UserRepository;
import com.company.lc_managment.utils.AppConstants;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AttachmentRepository attachmentRepository;

    public AuthServiceImpl( UserRepository userRepository, @Lazy AuthenticationManager authenticationManager,
                           PasswordEncoder passwordEncoder, JWTProvider jwtProvider, AttachmentRepository attachmentRepository) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        User user1 = checkCredential(loginDTO.phoneNumber(), loginDTO.password());
        System.out.println(user1);
        return generateTokenDTO(user1);
    }

    @Override
    public TokenDTO refreshToken(String accessToken, String refreshToken) {
        if (!accessToken.startsWith(AppConstants.BEARER_TYPE))
            throw RestException.restThrow("not Bearer ");

        accessToken = accessToken.substring(AppConstants.BEARER_TYPE.length()).trim();
        refreshToken = refreshToken.substring(AppConstants.BEARER_TYPE.length()).trim();
        if (!jwtProvider.isExpired(accessToken))
            throw RestException.restThrow("Token not expired");

        if (!jwtProvider.validRefreshToken(refreshToken))
            throw RestException.restThrow("Refresh token not validation");

        String userId = jwtProvider.extractUserIdFromRefreshToken(refreshToken);
        User user = findUserById(Integer.valueOf(userId))
                .orElseThrow(() -> RestException.restThrow("User not found: " + userId, HttpStatus.NOT_FOUND));

        return generateTokenDTO(user);
    }

    @Override
    public TokenDTO register(RegisterDTO registerDTO) {

        Optional<User> byPhoneNumber = userRepository.findByPhoneNumber(registerDTO.phoneNumber());
        if (byPhoneNumber.isPresent())
           throw RestException.restThrow("already exist by number",HttpStatus.BAD_REQUEST);


        Attachment attachment = null;
        if (registerDTO.attachmentId()!=null){
             attachment = attachmentRepository.findById(Long.valueOf(registerDTO.attachmentId())).orElseThrow(() -> RestException.restThrow("attachment not found",HttpStatus.BAD_REQUEST));
        }


        User user = User.builder()
                .firstName(registerDTO.firstName())
                .lastName(registerDTO.lastName())
                .phoneNumber(registerDTO.phoneNumber())
                .gender(Gender.valueOf(registerDTO.gender().toUpperCase()))
                .password(passwordEncoder.encode(registerDTO.password()))
                .birthDay(registerDTO.birthday())
                .attachment(attachment)
                .role(Roles.STUDENT)
                .build();
        userRepository.save(user);

        return generateTokenDTO(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

    public Optional<User> findUserById(Integer userId) {
        try {
            return userRepository.findById(Long.valueOf(userId));
        } catch (Exception e) {
           throw RestException.restThrow("user not found",HttpStatus.BAD_REQUEST);
        }
    }


    private TokenDTO generateTokenDTO(User employee) {
        String id = employee.getId().toString();
        String accessToken = jwtProvider.createAccessToken(id);
        String refreshToken = jwtProvider.createRefreshAccessToken(id);
        return TokenDTO.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public User checkCredential(String username, String password) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                username,
                password
        );
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        return (User) authentication.getPrincipal();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
