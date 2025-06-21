package com.goldenage;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * Информация с метеостанции
 * <p>
 * Created by dma on 06.11.2015.
 */
@Getter
@Setter
//SuperBuilder
public class WeatherData {



 //   @Column(name = "p_id", columnDefinition = "NUMERIC")
    private Long id;

   // @Column(name = "p_owner_id", columnDefinition = "NUMERIC")
    private Integer ownerId;


    private Date weatherDate;


    private Double temperature;

//
//    @Column(name = "p_weather_type")
//    private Integer weatherType;
//
//
//    @Column(name = "p_weather_road_condition_type")
//    private Integer roadConditionType;
//
//
//    @Column(name = "p_road_condition")
//    private Double roadCondition;
//
//    @Column(name = "p_ksc")
//    private Double ksc;
//
//
//    @Column(name = "p_time_forecast")
//    @Temporal(TemporalType.TIME)
//    private Date timeForecast;
//
    private Double humidity;
//
//
//    @Column(name = "p_dew_point")
//    private Double dew_point;
//
//
//    @Column(name = "p_precipitation")
//    private Integer precipitation;



    private Double wind_speed;


    private Double wind_direction;


//    @Column(name = "p_sum_of_precipitation")
//    private Double sum_of_precipitation;
//
//
//    @Column(name = "p_rain_intensity")
//    private Double rain_intensity;
//
//
//    /**
//     * Видимость
//     */
//    @Column(name = "p_visibility")
//    private Integer visibility;
//
//
    private Double pressure;
//
//    @Column(name = "p_class_of_precipitation")
//    private Integer class_of_precipitation;
//
//
//    @Column(name = "p_max_wind_speed")
//    private Double max_wind_speed;
//
//
//    @Column(name = "t_temperature_surface")
//    private Double t_temperature_surface;


//    @Column(name = "p_conductivity")
//    private Double conductivity;


//    @Column(name = "p_signal_surface")
//    private Double signal_surface;
//
//
//    @Column(name = "p_frequency_of_black_ice")
//    private Double frequency_of_black_ice;
//
//
//    @Column(name = "p_state_surface")
//    private Double state_surface;
//
//
//    @Column(name = "p_soil_temperature_depth")
//    private Double soil_temperature_depth;
//
//    @Column(name = "p_chemical_concentration")
//    private Double chemical_concentration;
//
//
//    @Column(name = "p_chemical_count")
//    private Double chemical_count;
//
//    @Column(name = "p_is_forecast")
//    private Boolean forecast;
//
//    /**
//     * Состояние осадков
//     * (enum)
//     */
//    @Column(name = "p_precipitation_state")
//    private PrecipitationStateEType precipitationState;
//
//
//    @Column(name = "p_wmo_synop_text")
//    //@Transient
//    private String wmoSynopText;
//    //@Transient
//    @Column(name = "p_nws_present_weather_text")
//    private String nwsPresentWeatherText;
//
//    /**
//     * Состояние осадков
//     * (текст)
//     */
//    @Column(name = "p_precipitation_state_text")
//    private String precipitationStateText;
//
//    /**
//     * Состояние поверхности
//     * (enum)
//     */
//    @Column(name = "p_surface_state")
//    private SurfaceStateEType surfaceState;

    /**
     * Состояние поверхности
     * (текст)
     */
//    @Column(name = "p_surface_state_text")
//    private String surfaceStateText;
//
//    /**
//     * Предупреждение скользкости поверхности
//     * (enum)
//     */
//    @Column(name = "p_surface_warning")
//    private SurfaceWarningEType surfaceWarning;
//
//    /**
//     * Предупреждение скользкости поверхности
//     * (текст)
//     */
//    @Column(name = "p_surface_warning_text")
//    private String surfaceWarningText;
//
//    /**
//     * Толщина отложений
//     */
//    @Column(name = "p_sediment")
//    private Double sediment;
//
//
//    @Column(name = "p_ksc_new")
//    private Double kscNew;

    //@Transient
//    @Column(name = "p_ksc_flag")
//    private Boolean kscFlag;
//
//
//    @Column(name = "p_last_update_time")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastUpdateTime;

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", weatherDate=" + weatherDate +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", wind_speed=" + wind_speed +
                ", wind_direction=" + wind_direction +
                ", pressure=" + pressure +
                '}';
    }
}
