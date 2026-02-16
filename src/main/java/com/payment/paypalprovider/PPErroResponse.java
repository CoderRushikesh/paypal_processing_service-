package com.payment.paypalprovider;

import lombok.Data;

@Data
public class PPErroResponse {
    private String errorCode;
    private String errorMessage;
}
