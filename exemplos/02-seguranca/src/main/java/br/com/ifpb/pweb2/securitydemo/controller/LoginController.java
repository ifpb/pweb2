package br.com.ifpb.pweb2.securitydemo.controller;


import br.com.ifpb.pweb2.securitydemo.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raul on 22/10/19
 */

@RestController
public class LoginController {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody Login login) {

        System.out.println(passwordEncoder.encode(login.getPassword()));

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.getLogin(), login.getPassword());

        String token = this.jwtUtil.generateToken(authenticationManager.authenticate(authenticationToken));

        return ResponseEntity.ok(new Token(token));
    }


}
