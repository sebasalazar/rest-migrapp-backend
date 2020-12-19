package cl.sebastian.proyecto.rest.filter;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleCORSFilter implements Filter {

    private static final Locale CL = new Locale("es", "CL");
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleCORSFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.debug("Iniciando filtro");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String origin = StringUtils.trimToEmpty(request.getHeader("origin"));
        if (StringUtils.isBlank(origin)) {
            LOGGER.debug("=== Origen desconocido, se setea '*' ===");
            origin = "*";
        }

        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Origin", origin);
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, X-API-APP, X-API-KEY");

        // Just ACCEPT and REPLY OK if OPTIONS
        final String requestMethod = StringUtils.upperCase(StringUtils.trimToEmpty(request.getMethod()));
        if (StringUtils.equals("OPTIONS", requestMethod)) {
            response.setLocale(CL);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        LOGGER.debug("Cerrando el filtro");
    }

}
