package me.dyatkokg.costaccountingapi.config;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static Object getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
