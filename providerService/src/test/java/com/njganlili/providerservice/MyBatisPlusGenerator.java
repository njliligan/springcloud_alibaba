package com.njganlili.providerservice;

/**
 * @author njgan
 * @description
 * @date 2022/2/27 12:33
 */

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import net.sf.jsqlparser.schema.Column;

import java.util.*;

public class MyBatisPlusGenerator {

    public static void main(String[] args) {

        Map<OutputFile,String> fileStringMap = new HashMap<>();
        fileStringMap.put(OutputFile.mapperXml,
                System.getProperty("user.dir")+"\\providerService"+"\\src\\main\\resources\\mapping");
        fileStringMap.put(OutputFile.entity,
                System.getProperty("user.dir")+"\\commonService"+"\\src\\main\\java\\com\\njganlili\\commonservice\\entity");
        fileStringMap.put(OutputFile.service,
                System.getProperty("user.dir")+"\\interfaces"+"\\src\\main\\java\\com\\njganlili\\interfaces\\provider");
        fileStringMap.put(OutputFile.serviceImpl,
                System.getProperty("user.dir")+"\\providerService"+"\\src\\main\\java\\com\\njganlili\\providerservice\\service\\impl");
        fileStringMap.put(OutputFile.controller,
                System.getProperty("user.dir")+"\\providerService"+"\\src\\main\\java\\com\\njganlili\\providerservice\\controller");
        fileStringMap.put(OutputFile.mapper,
                System.getProperty("user.dir")+"\\providerService"+"\\src\\main\\java\\com\\njganlili\\providerservice\\dao");

        System.out.println(System.getProperty("user.dir"));
        FastAutoGenerator.create(
                "jdbc:mysql://127.0.0.1:3306/miky?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false",
                        "root",
                        "root")
            // 全局配置
            .globalConfig(builder ->
                    builder.author("miky")
                            .enableSwagger()
                            .commentDate("yyyy-MM-dd")
                            .fileOverride())
            // 包配置
            .packageConfig(builder ->
                    builder.parent("com.njganlili")
                            .entity("commonservice."+"entity")
                            .service("interfaces.provider."+"service")
                            .serviceImpl("providerservice."+"service.impl")
                            .controller("providerservice."+"controller")
                            .mapper("providerservice."+"dao")
                            .xml("providerservice."+"mapper")
                            .pathInfo(fileStringMap)
            )
            // 策略配置
            .strategyConfig( builder ->
                    builder.addInclude("user")
//                            .addTablePrefix()
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper")
                            .build()
            )
            /*
                模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
               .templateEngine(new BeetlTemplateEngine())
               .templateEngine(new FreemarkerTemplateEngine())
             */
            .execute();
    }
}
