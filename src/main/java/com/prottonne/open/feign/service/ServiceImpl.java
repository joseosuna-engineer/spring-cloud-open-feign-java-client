package com.prottonne.open.feign.service;

import com.prottonne.open.feign.dto.Request;
import com.prottonne.open.feign.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExternalService externalService;

    public ServiceImpl() {
        super();
    }

    public Response getObject(Request request) {

        logger.info("calling external service {}", request);

        Response response = externalService.getObject(request, "someHeader");

        logger.info("callback external service {}", response);

        check(response);

        return response;
    }

    private void check(Response response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
