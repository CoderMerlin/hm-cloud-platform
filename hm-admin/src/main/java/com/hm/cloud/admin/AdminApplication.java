package com.hm.cloud.admin;

import com.hm.cloud.admin.util.VerifyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Coder编程
 * @Title: AdminApplication
 * @ProjectName hm-cloud-platform
 * @Description: TODO
 * @date 2020/11/1718:17
 */
@EnableRedisHttpSession
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(AdminApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }
}
