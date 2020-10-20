package com.kakuiwong.web;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.kakuiwong.api.GUserRpc;
import com.kakuiwong.model.GUser;
import com.kakuiwong.model.dto.ResultDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: gaoyang
 * @Description:
 */
@RestController
public class UserController {

    @DubboReference(version = "${rpc.user.version}", retries = 0)
    private GUserRpc userRpc;

    @NacosValue(value = "${gaoyang}",autoRefreshed = true)
    private Integer age;

    @GetMapping("/info/{id}")
    public GUser info(@PathVariable Long id) {
        ResultDTO<GUser> dto = userRpc.infoById(id);
        return dto.getResult();
    }

    @GetMapping("/config")
    public Object config() {
        return "高杨的年龄是: " + age;
    }
}
