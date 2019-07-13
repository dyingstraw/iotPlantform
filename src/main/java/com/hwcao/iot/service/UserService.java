package com.hwcao.iot.service;

import com.hwcao.iot.dto.User.UserReqDTO;
import com.hwcao.iot.dto.User.UserRespDTO;
import com.hwcao.iot.dto.UserDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.user.User;

import javax.servlet.http.HttpSession;

/**
 * @author guyaren
 */
public interface UserService {
    /**
     * @param userReqDTO
     * @return
     */
    Result<UserRespDTO> login(UserReqDTO userReqDTO, HttpSession httpSession);

    Result register(UserReqDTO userReqDTO);
}
