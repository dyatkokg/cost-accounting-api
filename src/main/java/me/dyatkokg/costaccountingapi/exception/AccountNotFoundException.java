package me.dyatkokg.costaccountingapi.exception;

public class AccountNotFoundException extends ElementNotFoundException {
    private static final String MESSAGE = "Account with this id is not found";

    public AccountNotFoundException() {
        super(MESSAGE);
    }
}
