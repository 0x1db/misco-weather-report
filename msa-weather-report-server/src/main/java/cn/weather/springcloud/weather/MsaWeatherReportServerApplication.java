package cn.weather.springcloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsaWeatherReportServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsaWeatherReportServerApplication.class, args);
  }

}
