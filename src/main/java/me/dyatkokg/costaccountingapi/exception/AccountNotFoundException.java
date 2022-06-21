package me.dyatkokg.costaccountingapi.exception;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(){
        super("Account with this id is not found");
    }
}
