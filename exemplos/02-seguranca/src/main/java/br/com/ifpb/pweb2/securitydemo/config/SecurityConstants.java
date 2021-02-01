package br.com.ifpb.pweb2.securitydemo.config;

public class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/api/authenticate";

    // Signing key for HS512 algorithm
    // Use http://www.allkeysgenerator.com/ para gerar uma chave
    public static final String JWT_SECRET = "E07451F5-583D-4B1A-8AF1-A3AF70AABD43";

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";

    private SecurityConstants() {}
}
