package com.kakuiwong.api;

import com.kakuiwong.model.GUser;
import com.kakuiwong.model.dto.ResultDTO;

/**
 * @author: gaoyang
 * @Description:
 */
public interface GUserRpc {

    ResultDTO<GUser> infoById(Long id);
}
