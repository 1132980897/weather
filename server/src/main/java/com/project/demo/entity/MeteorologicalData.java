package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 气象数据：(MeteorologicalData)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MeteorologicalData")
public class MeteorologicalData implements Serializable {

    // MeteorologicalData编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meteorological_data_id")
    private Integer meteorological_data_id;

    // 呼和浩特
    @Basic
    private String hohhot;
    // 年
    @Basic
    private String year;
    // 月
    @Basic
    private String month;
    // 日
    @Basic
    private String day;
    // 降水量
    @Basic
    private String precipitation;
    // 极大风速
    @Basic
    private String extreme_wind_speed;
    // 极大风速的风向
    @Basic
    private String a_direction_of_extreme_wind_speed;
    // 平均气压
    @Basic
    private String average_air_pressure;
    // 平均风速
    @Basic
    private String average_wind_speed;
    // 平均气温
    @Basic
    private String average_temperature;
    // 平均水气压
    @Basic
    private String average_water_pressure;
    // 平均相对湿度
    @Basic
    private String average_relative_humidity;
    // 日照时数
    @Basic
    private String sunlight_hours;
    // 最低气压
    @Basic
    private String minimum_air_pressure;
    // 最低气温
    @Basic
    private String minimum_temperature;
    // 最高气压
    @Basic
    private String maximum_air_pressure;
    // 最高气温
    @Basic
    private String maximum_temperature;
    // 最大风速
    @Basic
    private String maximum_wind_speed;
    // 最大风速的风向
    @Basic
    private String wind_direction_of_maximum_wind_speed;
    // 最小相对湿度
    @Basic
    private String minimum_relative_humidity;

    // 点击数
    @Basic
    private Integer hits;













    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
