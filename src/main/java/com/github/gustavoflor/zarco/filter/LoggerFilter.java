package com.github.gustavoflor.zarco.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

import static java.lang.System.getenv;
import static java.util.Optional.ofNullable;

@Slf4j
@Component
@Order(1)
public class LoggerFilter implements Filter {
    private static final String HOSTNAME = ofNullable(getenv("HOSTNAME")).orElse("localhost");

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        log.info("Filtering request on {}", HOSTNAME);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
