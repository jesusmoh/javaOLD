package core.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import core.service.GeoPayEchoService;

/**
 *
 * @author JOrtiz
 */
@Component
@Scope(SCOPE_SINGLETON)
public class GeoPayEchoTimer {

	static Logger log = Logger.getLogger(GeoPayEchoTimer.class.getName());

	@Autowired
	GeoPayEchoService geoPayEchoService;

	@Scheduled(fixedRateString = "${servicegeo.echotimer}", initialDelay = 1000)
	@Async
	public void geoPayEchoRestPing() {
		geoPayEchoService.executeGeoPayEchoTask();
	}

}
