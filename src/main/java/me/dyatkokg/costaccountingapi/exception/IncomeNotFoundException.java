package me.dyatkokg.costaccountingapi.exception;

public class IncomeNotFoundException extends RuntimeException {
    private static final String MESSAGE = "l";

    public IncomeNotFoundException() {
        super("Income with this id is not found");
    }
}
