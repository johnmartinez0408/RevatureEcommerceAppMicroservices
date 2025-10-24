package com.example.order_service.external.decoder;

import com.example.order_service.exception.OrderServiceException;
import com.example.order_service.model.ErrorDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.web.ErrorResponse;

import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ErrorDetail errorDetail = objectMapper
                    .readValue(response.body().asInputStream(), ErrorDetail.class);
            return new OrderServiceException(
                    errorDetail.getErrorMessage(),
                    errorDetail.getErrorCode(),
                    errorDetail.getStatusCode());
        } catch (IOException e) {
            throw new OrderServiceException("Internal server error", "INTERNAL_SERVER_ERROR", 500);
        }
    }
}
