package cn.weather.springcloud.weather.service.impl;

import cn.weather.springcloud.weather.model.City;
import cn.weather.springcloud.weather.model.CityList;
import cn.weather.springcloud.weather.service.CityDataService;
import cn.weather.springcloud.weather.utils.XmlBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author wangyu
 * @Date 2019/10/12 14:21
 * @Version 1.0
 */
@Service
public class CityDataServiceImpl implements CityDataService {

  private Logger LOG = LoggerFactory.getLogger(CityDataServiceImpl.class);

  @Override
  public List<City> listCity() {
    CityList cityList = null;
    try {
      // 读取XML文件
      Resource resource = new ClassPathResource("citylist.xml");
      BufferedReader br = new BufferedReader(
          new InputStreamReader(resource.getInputStream(), "utf-8"));
      StringBuffer buffer = new StringBuffer();
      String line = "";

      while ((line = br.readLine()) != null) {
        buffer.append(line);
      }

      br.close();

      // XML转为Java对象
      cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, buffer.toString());
    } catch (Exception e) {
      LOG.error("Error：", e);
    }
    return cityList.getCityList();
  }
}
