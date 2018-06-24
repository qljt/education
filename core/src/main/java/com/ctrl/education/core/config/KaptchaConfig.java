package com.ctrl.education.core.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * com.ctrl.education.core.config
 *
 * @author liyang
 * @name KaptchaConfig
 * @description
 * @date 2018-06-10 下午4:42
 */
@Configuration
public class KaptchaConfig {
    @Bean(name="captchaProducer")
    public DefaultKaptcha getKaptchaBean(){
        DefaultKaptcha defaultKaptcha=new DefaultKaptcha();
        Properties properties=new Properties();
        /*properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");*/
        properties.setProperty("kaptcha.background.impl", "243,243,230");
        //字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "234,94,50");
        //宽度
        properties.setProperty("kaptcha.image.width", "80");
        //高度
        properties.setProperty("kaptcha.image.height", "40");
        //session值
        properties.setProperty("kaptcha.session.key", "code");
        //验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        //验证码字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        //文本集合，验证码值从此集合中获取
        properties.setProperty("kaptcha.textproducer.char.string", "123456789");
        //文字干扰线
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
        Config config=new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
