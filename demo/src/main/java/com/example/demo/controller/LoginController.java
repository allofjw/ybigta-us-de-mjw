package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String index(){
        return "index2";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }
    private static final String authorizationRequestBaseUri="oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls=new HashMap<>(); //일단 구글은 안쓸것같지만, 애플은 쓸수도 있으니..
    private final ClientRegistrationRepository clientRegistrationRepository;

    @GetMapping("/login")
    public String getLoginPage(Model model)throws Exception {
        logger.info("in getLoginPage");
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type =ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);

        if (type!=ResolvableType.NONE &&
        ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])){
            clientRegistrations=(Iterable<ClientRegistration>) clientRegistrationRepository;
        }
        assert clientRegistrations != null;
        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientSecret(),
                        authorizationRequestBaseUri+"/"+registration.getRegistrationId()));
        model.addAttribute("urls",oauth2AuthenticationUrls);

        return "login";
    }

    @GetMapping("/home")
    public String home() {

        return "home";
    }


    @RequestMapping("/accessDenied")
    public String accessDenied(){return "accessDenied";}
}
