package me.dyatkokg.costaccountingapi.exception;

public class ExpenseNotFoundException extends ElementNotFoundException {
    private static final String MESSAGE = "Expense with this id is not found";

    public ExpenseNotFoundException() {
        super(MESSAGE);
    }
}
