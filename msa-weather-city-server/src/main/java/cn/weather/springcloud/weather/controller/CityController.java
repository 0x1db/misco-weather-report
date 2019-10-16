package cn.weather.springcloud.weather.controller;

import cn.weather.springcloud.weather.model.City;
import cn.weather.springcloud.weather.service.CityDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangyu
 * @Date 2019/10/12 14:25
 * @Version 1.0
 */
@RestController
@RequestMapping("/cities")
public class CityController {

  @Autowired
  private CityDataService cityDataService;

  @GetMapping
  public List<City> listCity() {
    return cityDataService.listCity();
  }
}
