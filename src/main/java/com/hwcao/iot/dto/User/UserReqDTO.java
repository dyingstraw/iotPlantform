package com.hwcao.iot.dto.User;

import lombok.Data;

/**
 * @author guyaren
 */
@Data
public class UserReqDTO {
    private String userName;
    private String password;
    private String userDesc;
}
