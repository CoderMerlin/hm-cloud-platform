package com.hm.cloud.auth.props;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 作者 owen
 * @version 创建时间：2017年11月12日 上午22:57:51
 * url白名单处理 application.yml中配置需要放权的url白名单
 * blog: https://blog.51cto.com/13005375
 * code: https://gitee.com/owenwangwen/open-capacity-platform
 */
@ConfigurationProperties(prefix = "security.oauth2")
public class PermitUrlProperties {

    /**
     * 监控中心和swagger需要访问的url
     */
    private static final String[] ENDPOINTS = {
            //端点监控
            "/**/actuator/**", "/**/actuator/**/**",
            "/**/doc.html", "/doc.html",
            "/v2/api-docs/**", "/swagger-ui.html", "/swagger-resources/**", "/webjars/**",
            // api-gateway webflux swagger
            //业务中心swagger
            "/**/v2/api-docs/**", "/**/swagger-ui.html", "/**/swagger-resources/**", "/**/webjars/**",
            //熔断监控
            "/**/turbine.stream", "/**/turbine.stream**/**", "/**/hystrix", "/**/hystrix.stream", "/**/hystrix/**", "/**/hystrix/**/**", "/**/proxy.stream/**",
            "/**/druid/**", "/**/favicon.ico", "/**/prometheus"
    };

    private String[] ignored;

    /**
     * 需要放开权限的url
     *
     * @return 自定义的url和监控中心需要访问的url集合
     */
    public String[] getIgnored() {
        if (ignored == null || ignored.length == 0) {
            return ENDPOINTS;
        }

        List<String> list = new ArrayList<>();
        for (String url : ENDPOINTS) {
            list.add(url);
        }
        for (String url : ignored) {
            list.add(url);
        }

        return list.toArray(new String[list.size()]);
    }

    public void setIgnored(String[] ignored) {
        this.ignored = ignored;
    }

}
