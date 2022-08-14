package edu.mriabov.restproject.proxy;


import edu.mriabov.restproject.config.ProjectConfiguration;
import edu.mriabov.restproject.model.Contact;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "contact",url = "http://localhost:8080/api/contact",
        configuration = ProjectConfiguration.class)
public interface ContactProxy {

    @GetMapping(value = "/getMessagesByStatus")
    @Headers(value = "Content-Type:application/json")
    List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status);
}
