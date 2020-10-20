package com.kakuiwong.rpc;

import com.kakuiwong.api.GUserRpc;
import com.kakuiwong.model.GUser;
import com.kakuiwong.model.dto.GException;
import com.kakuiwong.model.dto.ResultDTO;
import com.kakuiwong.service.GUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: gaoyang
 * @Description:
 */
@DubboService(version = "${rpc.verson}")
public class GUserRpcImpl implements GUserRpc {

    @Autowired
    GUserService userService;

    public ResultDTO<GUser> infoById(Long id) {
        if (id == 1) {
            throw new GException("测试异常 GException");
        } else if (id == 2) {
            throw new NullPointerException("测试异常 SqlSessionException");
        } else if (id == 3) {
            throw new RuntimeException("测试异常 SqlSessionException");
        }
        return ResultDTO.success(userService.infoById(id));
    }
}
