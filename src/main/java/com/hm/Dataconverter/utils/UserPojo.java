package com.hm.Dataconverter.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private long id;
    private String password;
    private String userName;
    private String email;
}
