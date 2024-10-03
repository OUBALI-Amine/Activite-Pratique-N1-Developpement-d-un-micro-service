package org.enset.bankaccountservice.web;

import org.enset.bankaccountservice.dto.BankAccountRequestDTO;
import org.enset.bankaccountservice.dto.BankAccountResponseDTO;
import org.enset.bankaccountservice.entities.BankAccount;
import org.enset.bankaccountservice.entities.Customer;
import org.enset.bankaccountservice.repositories.BankAccountRepository;
import org.enset.bankaccountservice.repositories.CustomerRepository;
import org.enset.bankaccountservice.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return bankAccountService.addAccount(bankAccount);
    }

    @MutationMapping()
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return bankAccountService.updateAccount(id,bankAccount);
    }

    @MutationMapping()
    public Boolean deleteAccount(@Argument String id){
        bankAccountService.deleteAccount(id);
        return true;
    }

    @QueryMapping()
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
}
record BankAccountDTO(Double balance, String type, String currency){}