package me.dyatkokg.costaccountingapi.exception;

public class IncomeNotFoundException extends RuntimeException {
    public IncomeNotFoundException() {
        super("Income with this id is not found");
    }
}
