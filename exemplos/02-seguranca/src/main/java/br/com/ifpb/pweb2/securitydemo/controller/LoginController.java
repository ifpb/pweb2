package br.com.ifpb.pweb2.securitydemo.controller;

import br.com.ifpb.pweb2.securitydemo.config.jwt.JwtUtil;
import br.com.ifpb.pweb2.securitydemo.controller.dto.LoginDTO;
import br.com.ifpb.pweb2.securitydemo.controller.dto.TokenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("login")
    public ResponseEntity login(LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getPassword());

        String token = this.jwtUtil.generateToken((UserDetails) authenticationManager.authenticate(authenticationToken));

        return ResponseEntity.ok(new TokenDTO(token));
    }

}
