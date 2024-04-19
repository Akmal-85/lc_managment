package com.company.lc_managment.dto;

import com.company.lc_managment.utils.AppConstants;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {
    private String accessToken;

    private String refreshToken;

    @Builder.Default
    private final String tokenType = AppConstants.BEARER_TYPE;

}
