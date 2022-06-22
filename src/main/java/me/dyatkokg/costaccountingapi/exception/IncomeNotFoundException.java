package me.dyatkokg.costaccountingapi.exception;

public class IncomeNotFoundException extends ElementNotFoundException {
    private static final String MESSAGE = "Income with this id is not found";

    public IncomeNotFoundException() {
        super(MESSAGE);
    }
}
