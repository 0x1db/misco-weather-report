package cn.weather.springcloud.weather.utils;

import java.io.Reader;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * @Author wangyu
 * @Date 2019/10/12 14:22
 * @Version 1.0
 */
public class XmlBuilder {

  /**
   * 将XML转为指定的POJO
   */
  public static Object xmlStrToOject(Class<?> clazz, String xmlStr) throws Exception {
    Object xmlObject = null;
    Reader reader = null;
    JAXBContext context = JAXBContext.newInstance(clazz);

    // XML 转为对象的接口
    Unmarshaller unmarshaller = context.createUnmarshaller();

    reader = new StringReader(xmlStr);
    xmlObject = unmarshaller.unmarshal(reader);

    if (null != reader) {
      reader.close();
    }

    return xmlObject;
  }
}
