package ma.houmam.customerservice.web;

import ma.houmam.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigTestController {
    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/globalConfig")

      public GlobalConfig globalConfig(){

          return globalConfig;
    }

}
