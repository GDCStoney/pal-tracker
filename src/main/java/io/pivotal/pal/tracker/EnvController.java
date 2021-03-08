package io.pivotal.pal.tracker;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private final String port;
    private final String memoryLimit;
    private final String cfInstanceIndex;
    private final String cfInstanceAddr;

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env= new HashMap<>();

        env.put("PORT" ,port);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddr);

        return env;
    }

    public EnvController(
        @Value("${port:NOT_SET}") String port,
        @Value("${memory.limit:NOT_SET}") String memoryLimit,
        @Value("${cf.instance.index:NOT_SET}") String cfInstanceIndex,
        @Value("${cf.instance.addr:NOT_SET}") String cfInstanceAddr
    ) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddr = cfInstanceAddr;
    }
}
