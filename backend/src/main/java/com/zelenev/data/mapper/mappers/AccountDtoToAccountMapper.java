package com.zelenev.data.mapper.mappers;

import com.zelenev.data.dto.AccountDto;
import com.zelenev.data.entities.Account;
import com.zelenev.data.mapper.BaseObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoToAccountMapper extends BaseObjectMapper<AccountDto, Account> {

    @Override
    public Account convert(AccountDto object) {
        Account account = new Account();

        account.setLogin(object.getLogin());
        account.setPassword(object.getPassword());
        return account;
    }

    @Override
    public Class<AccountDto> getInClass() {
        return AccountDto.class;
    }

    @Override
    public Class<Account> getOutClass() {
        return Account.class;
    }
}
