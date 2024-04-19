package com.company.lc_managment.utils;

import com.company.lc_managment.entity.User;
import com.company.lc_managment.exception.RestException;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@UtilityClass
public class CommonUtils {

    public static User getCurrentUserFromContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal().equals("anonymousUser"))
            throw RestException.restThrow("it is close way", HttpStatus.UNAUTHORIZED);

        return (User) authentication.getPrincipal();
    }

    public static String makeFileUrl(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/attachment/")
                .path(id.toString()).toUriString();
    }
}
