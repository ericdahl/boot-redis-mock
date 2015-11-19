package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppDAO {

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public AppDAO(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void put(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }
}
