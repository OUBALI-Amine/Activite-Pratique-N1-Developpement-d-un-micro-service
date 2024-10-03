package org.enset.bankaccountservice.mappers;

import org.enset.bankaccountservice.dto.BankAccountRequestDTO;
import org.enset.bankaccountservice.dto.BankAccountResponseDTO;
import org.enset.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO requestDTO){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BeanUtils.copyProperties(requestDTO,bankAccount);
        return bankAccount;
    }
}
