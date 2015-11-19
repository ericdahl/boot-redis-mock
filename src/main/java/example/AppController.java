package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    private final AppDAO dao;

    @Autowired
    public AppController(AppDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/db/{key}", method = RequestMethod.GET)
    public String get(@PathVariable String key) {
        LOGGER.info("get: [{}]", key);

        final String value = dao.get(key);
        return value == null ? "(null)" : value;
    }

    @RequestMapping(value = "/db/{key}", method = RequestMethod.PUT)
    public void put(@PathVariable String key, @RequestBody String value) {
        LOGGER.info("put: [{}] <- [{}]", key, value);
        dao.put(key, value);
    }
}
