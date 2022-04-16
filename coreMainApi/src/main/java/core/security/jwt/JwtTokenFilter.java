package core.security.jwt;

import core.commons.AppLogMessagess;
import core.exception.CustomException;
import core.util.LogAuditFactory;
import core.util.TimeMeasurer;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;

    static final Logger log = Logger.getLogger(JwtTokenFilter.class.getName());

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws CustomException {

        final String uuid = LogAuditFactory.getKey().concat(" ");
        final String token = jwtTokenProvider.resolveToken(httpServletRequest);
        final String fingerprintdevice = jwtTokenProvider.resolveFingerprint(httpServletRequest);
        TimeMeasurer timer = new TimeMeasurer();
        
        log.info(fingerprintdevice.concat("|"+uuid.concat(AppLogMessagess.REQUEST_IN)));
        log.info(fingerprintdevice.concat("|"+uuid.concat(AppLogMessagess.URL.concat(httpServletRequest.getMethod()+" >> "+ httpServletRequest.getRequestURL()))));
        log.info(fingerprintdevice.concat("|"+uuid.concat(String.valueOf(AppLogMessagess.TOKEN+token))));
        
        if(token==null)
            log.info(fingerprintdevice.concat("|"+uuid.concat(String.valueOf(AppLogMessagess.FINGERPRINTDEVICE+fingerprintdevice)))); 
       
        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication auth = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

            httpServletResponse.setHeader( "uuid", uuid);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            throw new CustomException("Invalid token supplied", HttpStatus.UNAUTHORIZED);
        } finally {           
            log.info(fingerprintdevice.concat("|"+uuid.concat(AppLogMessagess.RESPONSE_CODE.concat(String.valueOf(httpServletResponse.getStatus())))));
            log.info(fingerprintdevice.concat("|"+uuid.concat(AppLogMessagess.DISPATCHTIME.concat(String.valueOf(timer.measure())))));
            log.info(fingerprintdevice.concat("|"+uuid.concat(AppLogMessagess.DISPATCHTIME.concat(String.valueOf(timer.measure())))));
            log.info(fingerprintdevice.concat("|"+uuid.concat(AppLogMessagess.RESPONSE_OUT)));
        }

    }

}
