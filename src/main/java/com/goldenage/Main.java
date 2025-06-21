package com.goldenage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws JAXBException, JsonProcessingException {
        String xmlString =           "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ns2:observations xmlns=\"http://xml.vaisala.com/schema/internal/jx/common/v3\" xmlns:ns2=\"http://xml.vaisala.com/schema/internal/jx/observation/v3\">\n" +
                "    <ns2:observation>\n" +
                "        <ns2:source sourceType=\"FIXED_WEATHER_STATION\">\n" +
                "            <idType>SOURCE_FULL_NAME</idType>\n" +
                "            <id>GA-ROAD-METEO-STATION</id>\n" +
                "            <geoPositionPoint x=\"24.8757\" y=\"60.2815\" z=\"27.0\" srs=\"EPSG:4326\" horizontalDop=\"1.0\" fixQuality=\"7\"/>\n" +
                "        </ns2:source>\n" +
                "        <ns2:observation>\n" +
                "            <ns2:source sourceType=\"FIXED_WEATHER_STATION\">\n" +
                "                <idType>SOURCE_FULL_NAME</idType>\n" +
                "                <id>WXT536_1</id>\n" +
                "            </ns2:source>\n" +
                "            <ns2:dataValues codeSpace=\"VAISALA_SURFACE_OBS\" timestamp=\"2025-06-10T07:53:11.998Z\" reason=\"SCHEDULED\">\n" +
                "                <ns2:dataValue parameterName=\"SENSOR_STATUS\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"ST\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WIND_DIRECTION\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"DEGREES\" code=\"WD\" qualityValue=\"-8997\" qualityLevel=\"0\">223</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WIND_SPEED\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"METRES_PER_SECOND\" code=\"WS\" qualityValue=\"-8997\" qualityLevel=\"0\">0.90</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_TEMPERATURE\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"DEGREES_CELSIUS\" code=\"TA\" qualityValue=\"8500\" qualityLevel=\"0\">18.94</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RELATIVE_HUMIDITY\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"PERCENT\" code=\"RH\" qualityValue=\"8500\" qualityLevel=\"0\">51.25</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE\" statisticName=\"MEAN\" statisticPeriod=\"PT1M\" unitName=\"HECTO_PASCALS\" code=\"PA\" qualityValue=\"10\" qualityLevel=\"0\">994.81</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"PRECIPITATION_INTENSITY\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"MILLIMETRES_PER_HOUR\" code=\"PRF\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"SUM\" statisticPeriod=\"PT24H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"10\" qualityLevel=\"0\">33.80</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WIND_SPEED\" statisticName=\"MAXIMUM\" statisticPeriod=\"PT10M\" unitName=\"METRES_PER_SECOND\" code=\"WS\" qualityValue=\"10\" qualityLevel=\"0\">3.84</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WIND_SPEED\" statisticName=\"MINIMUM\" statisticPeriod=\"PT10M\" unitName=\"METRES_PER_SECOND\" code=\"WS\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WIND_GUST_DIRECTION\" statisticName=\"VALUE\" statisticPeriod=\"PT10M\" unitName=\"DEGREES\" code=\"WGD\" qualityValue=\"10\" qualityLevel=\"0\">57</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WIND_DIRECTION\" statisticName=\"MINIMUM\" statisticPeriod=\"PT10M\" unitName=\"DEGREES\" code=\"WD\" qualityValue=\"10\" qualityLevel=\"0\">265</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WIND_SPEED\" statisticName=\"VALUE\" statisticPeriod=\"PT2M\" unitName=\"METRES_PER_SECOND\" code=\"WS\" qualityValue=\"10\" qualityLevel=\"0\">1.15</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WIND_DIRECTION\" statisticName=\"MEAN\" statisticPeriod=\"PT2M\" unitName=\"DEGREES\" code=\"WD\" qualityValue=\"10\" qualityLevel=\"0\">150</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WET_BULB_TEMPERATURE\" statisticName=\"MEAN\" statisticPeriod=\"PT1M\" unitName=\"DEGREES_CELSIUS\" code=\"TAB\" qualityValue=\"10\" qualityLevel=\"0\">14.20</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"DEW_POINT_TEMPERATURE\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"DEGREES_CELSIUS\" code=\"TD\" qualityValue=\"10\" qualityLevel=\"0\">8.65</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_STATE\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"RS\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ON\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"RAINON\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_TEMPERATURE\" statisticName=\"MINIMUM\" statisticPeriod=\"PT24H\" unitName=\"DEGREES_CELSIUS\" code=\"TA\" qualityValue=\"-8500\" qualityLevel=\"0\">14.19</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_TEMPERATURE\" statisticName=\"MAXIMUM\" statisticPeriod=\"PT24H\" unitName=\"DEGREES_CELSIUS\" code=\"TA\" qualityValue=\"-8500\" qualityLevel=\"0\">29.12</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_DURATION\" statisticName=\"SUM\" statisticPeriod=\"PT24H\" unitName=\"MINUTES\" code=\"RD\" qualityValue=\"-8500\" qualityLevel=\"0\">19</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE_QFE\" statisticName=\"MEAN\" statisticPeriod=\"PT1M\" unitName=\"HECTO_PASCALS\" code=\"QFE\" qualityValue=\"8500\" qualityLevel=\"0\">983.24</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE_QFE\" statisticName=\"MINIMUM\" statisticPeriod=\"PT1H\" unitName=\"HECTO_PASCALS\" code=\"QFE\" qualityValue=\"-8500\" qualityLevel=\"0\">983.20</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE_QFE\" statisticName=\"MAXIMUM\" statisticPeriod=\"PT1H\" unitName=\"HECTO_PASCALS\" code=\"QFE\" qualityValue=\"-8500\" qualityLevel=\"0\">983.43</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE_QFF\" statisticName=\"MEAN\" statisticPeriod=\"PT1M\" unitName=\"HECTO_PASCALS\" code=\"QFF\" qualityValue=\"8500\" qualityLevel=\"0\">962.08</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE_QFF\" statisticName=\"MINIMUM\" statisticPeriod=\"PT1H\" unitName=\"HECTO_PASCALS\" code=\"QFF\" qualityValue=\"-8500\" qualityLevel=\"0\">961.98</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE_QFF\" statisticName=\"MAXIMUM\" statisticPeriod=\"PT1H\" unitName=\"HECTO_PASCALS\" code=\"QFF\" qualityValue=\"-8500\" qualityLevel=\"0\">962.19</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE_QNH\" statisticName=\"MEAN\" statisticPeriod=\"PT1M\" unitName=\"HECTO_PASCALS\" code=\"QNH\" qualityValue=\"8500\" qualityLevel=\"0\">935.50</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE_QNH\" statisticName=\"MINIMUM\" statisticPeriod=\"PT1H\" unitName=\"HECTO_PASCALS\" code=\"QNH\" qualityValue=\"-8500\" qualityLevel=\"0\">935.29</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_PRESSURE_QNH\" statisticName=\"MAXIMUM\" statisticPeriod=\"PT1H\" unitName=\"HECTO_PASCALS\" code=\"QNH\" qualityValue=\"-8500\" qualityLevel=\"0\">935.55</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"AIR_TEMPERATURE_TREND\" statisticName=\"VALUE\" statisticPeriod=\"PT3H\" unitName=\"DEGREES_CELSIUS\" code=\"TATR\" qualityValue=\"-8500\" qualityLevel=\"0\">3.38</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"PRESSURE_TREND\" statisticName=\"VALUE\" statisticPeriod=\"PT3H\" unitName=\"HECTO_PASCALS\" code=\"PATR\" qualityValue=\"-8500\" qualityLevel=\"0\">0.34</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"SUM\" statisticPeriod=\"PT1H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"-8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"SUM\" statisticPeriod=\"PT3H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"-8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"SUM\" statisticPeriod=\"PT6H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"-8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"SUM\" statisticPeriod=\"PT12H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"-8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
//                "                <ns2:dataValue parameterName=\"PRESENT_WEATHER\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"PWNWS\" heightMetres=\"0.0\" qualityValue=\"10\" qualityLevel=\"0\">C</ns2:dataValue>\n" +
                "            </ns2:dataValues>\n" +
                "        </ns2:observation>\n" +
                "    </ns2:observation>\n" +
                "    <ns2:observation>\n" +
                "        <ns2:source sourceType=\"FIXED_WEATHER_STATION\">\n" +
                "            <idType>SOURCE_FULL_NAME</idType>\n" +
                "            <id>GA-ROAD-METEO-STATION</id>\n" +
                "            <geoPositionPoint x=\"24.8757\" y=\"60.2815\" z=\"27.0\" srs=\"EPSG:4326\" horizontalDop=\"1.0\" fixQuality=\"7\"/>\n" +
                "        </ns2:source>\n" +
                "        <ns2:observation>\n" +
                "            <ns2:source sourceType=\"FIXED_WEATHER_STATION\">\n" +
                "                <idType>SOURCE_FULL_NAME</idType>\n" +
                "                <id>PWD12_1</id>\n" +
                "            </ns2:source>\n" +
                "            <ns2:dataValues codeSpace=\"VAISALA_SURFACE_OBS\" timestamp=\"2025-06-10T07:53:11.998Z\" reason=\"SCHEDULED\">\n" +
                "                <ns2:dataValue parameterName=\"SENSOR_STATUS\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"ST\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"PRECIPITATION_INTENSITY\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"MILLIMETRES_PER_HOUR\" code=\"PRF\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"VALUE\" statisticPeriod=\"PT1H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"HARDWARE_STATUS\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"HCS\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_STATE\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"RS\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ON\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"RAINON\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"VALUE\" statisticPeriod=\"PT24H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"-8500\" qualityLevel=\"0\">1.19</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"VALUE\" statisticPeriod=\"PT12H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"-8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"VALUE\" statisticPeriod=\"PT6H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"-8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"RAIN_ACCUMULATION\" statisticName=\"VALUE\" statisticPeriod=\"PT3H\" unitName=\"MILLIMETRES\" code=\"PR\" qualityValue=\"-8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"PRESENT_WEATHER\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"PWNWS\" heightMetres=\"0.0\" qualityValue=\"10\" qualityLevel=\"0\">C</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"PRESENT_WEATHER\" statisticName=\"VALUE\" statisticPeriod=\"PT15M\" unitName=\"PRESENT_WEATHER_WMO\" code=\"PW\" heightMetres=\"0.0\" qualityValue=\"-8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"PRESENT_WEATHER\" statisticName=\"VALUE\" statisticPeriod=\"PT1H\" unitName=\"PRESENT_WEATHER_WMO\" code=\"PW\" heightMetres=\"0.0\" qualityValue=\"-8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "            </ns2:dataValues>\n" +
                "        </ns2:observation>\n" +
                "    </ns2:observation>\n" +
                "    <ns2:observation>\n" +
                "        <ns2:source sourceType=\"FIXED_WEATHER_STATION\">\n" +
                "            <idType>SOURCE_FULL_NAME</idType>\n" +
                "            <id>GA-ROAD-METEO-STATION</id>\n" +
                "            <geoPositionPoint x=\"24.8757\" y=\"60.2815\" z=\"27.0\" srs=\"EPSG:4326\" horizontalDop=\"1.0\" fixQuality=\"7\"/>\n" +
                "        </ns2:source>\n" +
                "        <ns2:observation>\n" +
                "            <ns2:source sourceType=\"FIXED_WEATHER_STATION\">\n" +
                "                <idType>SOURCE_FULL_NAME</idType>\n" +
                "                <id>DSC211_1</id>\n" +
                "            </ns2:source>\n" +
                "            <ns2:dataValues codeSpace=\"VAISALA_SURFACE_OBS\" timestamp=\"2025-06-10T07:53:11.998Z\" reason=\"SCHEDULED\">\n" +
                "                <ns2:dataValue parameterName=\"SENSOR_STATUS\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"ST\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"SURFACE_GRIP\" statisticName=\"VALUE\" statisticPeriod=\"PT5M\" unitName=\"NO_UNIT\" code=\"GR\" qualityValue=\"8500\" qualityLevel=\"0\">0.82</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"HARDWARE_STATUS\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"HCS\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"WATER_LAYER_THICKNESS\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"MILLIMETRES\" code=\"WLT\" qualityValue=\"8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"SNOW_LAYER_THICKNESS\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"MILLIMETRES\" code=\"SLT\" qualityValue=\"8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"ICE_LAYER_THICKNESS\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"MILLIMETRES\" code=\"ILT\" qualityValue=\"8500\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"SURFACE_STATE\" statisticName=\"VALUE\" statisticPeriod=\"PT5M\" unitName=\"NO_UNIT\" code=\"ENSST\" heightMetres=\"0.0\" qualityValue=\"8500\" qualityLevel=\"0\">1</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"VAISALA_SURFACE_STATE\" statisticName=\"VALUE\" statisticPeriod=\"PT5M\" unitName=\"NO_UNIT\" code=\"SST\" heightMetres=\"0.0\" qualityValue=\"8500\" qualityLevel=\"0\">1</ns2:dataValue>\n" +
                "            </ns2:dataValues>\n" +
                "        </ns2:observation>\n" +
                "    </ns2:observation>\n" +
                "    <ns2:observation>\n" +
                "        <ns2:source sourceType=\"FIXED_WEATHER_STATION\">\n" +
                "            <idType>SOURCE_FULL_NAME</idType>\n" +
                "            <id>GA-ROAD-METEO-STATION</id>\n" +
                "            <geoPositionPoint x=\"24.8757\" y=\"60.2815\" z=\"27.0\" srs=\"EPSG:4326\" horizontalDop=\"1.0\" fixQuality=\"7\"/>\n" +
                "        </ns2:source>\n" +
                "        <ns2:observation>\n" +
                "            <ns2:source sourceType=\"FIXED_WEATHER_STATION\">\n" +
                "                <idType>SOURCE_FULL_NAME</idType>\n" +
                "                <id>DTS12G_1</id>\n" +
                "            </ns2:source>\n" +
                "            <ns2:dataValues codeSpace=\"VAISALA_SURFACE_OBS\" timestamp=\"2025-06-10T07:53:11.998Z\" reason=\"SCHEDULED\">\n" +
                "                <ns2:dataValue parameterName=\"SENSOR_STATUS\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"NO_UNIT\" code=\"ST\" qualityValue=\"10\" qualityLevel=\"0\">0</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"SUB_SURFACE_TEMPERATURE\" statisticName=\"VALUE\" statisticPeriod=\"PT1M\" unitName=\"DEGREES_CELSIUS\" code=\"TSUBSURF\" qualityValue=\"8500\" qualityLevel=\"0\">17.70</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"SUB_SURFACE_TEMPERATURE\" statisticName=\"MINIMUM\" statisticPeriod=\"PT24H\" unitName=\"DEGREES_CELSIUS\" code=\"TSUBSURF\" qualityValue=\"-8500\" qualityLevel=\"0\">12.20</ns2:dataValue>\n" +
                "                <ns2:dataValue parameterName=\"SUB_SURFACE_TEMPERATURE\" statisticName=\"MAXIMUM\" statisticPeriod=\"PT24H\" unitName=\"DEGREES_CELSIUS\" code=\"TSUBSURF\" qualityValue=\"-8500\" qualityLevel=\"0\">29.80</ns2:dataValue>\n" +
                "            </ns2:dataValues>\n" +
                "        </ns2:observation>\n" +
                "    </ns2:observation>\n" +
                "</ns2:observations>\n";
        XmlMapper xmlMapper = new XmlMapper();

        Observations obs = xmlMapper.readValue(xmlString, Observations.class);
        System.out.println(obs.getObservations().size());
        //===================================================================================================
        WeatherData weatherData=new WeatherData();
//        return WeatherData.builder()
//                .dateTime(timestamp)
//                .temperature_C(AIR_TEMPERATURE)
//                .humidity_pcnt(humidity.get())
//                .dewPoint_C(dewPoint.get())
//                .pressure_kPa(pressure.get())
//                .windSpeedAvg_mps(WIND_SPEED)
//                .windSpeedGusts_mps(WIND_GUST_DIRECTION)
//                .windDirectionAvg_grd(WIND_DIRECTION)
//                .surfaceState(SNOW_LAYER_THICKNESS)
//                .temperatureRoad_C(SUB_SURFACE_TEMPERATURE)
//                .visibility_m(visibility.get())
//                .precipitationQuantity_mm(precipitationQuantity_mm.get())
//                .precipitationIntensity_mmh(precipitationIntensity_mmh.get())
//                .rainSnowState(rainSnowState)
//                .soilTemperatureDepth(soilTemperatureDepth.get())
//                .chemicalConcentration(chemicalConcentration.get())
//                .sediment_mm(sediment_mm)
//                .chemicalCount(eco.get())
//                .build();

        List<DataValue> dataValues = new ArrayList<>();
        List<DataValue> dataValuesAir= obs.getObservations().get(0).getObservations().get(0).getDataValues().getDataValueList();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            weatherData.setWeatherDate(formatter.parse(obs.getObservations().get(0).getObservations().get(0).getDataValues().getTimestamp()));
        } catch (ParseException e) {
            weatherData.setWeatherDate(Date.from(Instant.now()));
        }
        for (DataValue data : dataValuesAir) {
            if (Objects.equals(data.getParameterName(), "AIR_TEMPERATURE") && Objects.equals(data.getStatisticName(), "VALUE")) {
                weatherData.setTemperature(data.getValue());
            }
            if (Objects.equals(data.getParameterName(), "WIND_SPEED") ) {
                weatherData.setWind_speed(data.getValue());
            }
            if (Objects.equals(data.getParameterName(), "WIND_DIRECTION") ) {
                weatherData.setWind_direction(data.getValue());
            }
            if (Objects.equals(data.getParameterName(), "RELATIVE_HUMIDITY") ) {
                weatherData.setHumidity(data.getValue());
            }
            if (Objects.equals(data.getParameterName(), "AIR_PRESSURE") ) {
                weatherData.setPressure(data.getValue());
            }
        }
        System.out.println(weatherData);
  //      System.out.println(dataValuesAir.toString());
        List<DataValue> dataValuesRoad= obs.getObservations().get(1).getObservations().get(0).getDataValues().getDataValueList();
      //  System.out.println(dataValuesRoad.toString());
        // рабочий код
//        XmlMapper xmlMapper = new XmlMapper();
//
//        Observations obs = xmlMapper.readValue(xmlString, Observations.class);
//        System.out.println(obs.getObservations().toString());
    }

}