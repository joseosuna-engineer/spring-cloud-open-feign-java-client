package com.prottonne.open.feign.service;

import com.prottonne.open.feign.config.ExternalServiceConfig;
import com.prottonne.open.feign.dto.Request;
import com.prottonne.open.feign.dto.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "${service.id}",
        configuration = ExternalServiceConfig.class
)
public interface ExternalService {

    @RequestMapping(
            path = "/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    Response getObject(
            @RequestBody Request request,
            @RequestHeader(value = HttpHeaders.AUTHORIZATION) String someHeader
    );

}
