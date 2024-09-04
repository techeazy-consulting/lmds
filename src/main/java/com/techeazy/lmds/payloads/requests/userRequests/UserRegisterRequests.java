package com.techeazy.lmds.payloads.requests.userRequests;

import com.techeazy.lmds.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

    private String name;
    private String email;
    private String password;
    private String contact;
    private AccountType accountType;
}
