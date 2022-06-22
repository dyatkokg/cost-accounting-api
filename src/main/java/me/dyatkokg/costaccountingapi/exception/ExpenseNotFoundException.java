package me.dyatkokg.costaccountingapi.exception;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException() {
        super("Expense with this id is not found");
    }
}
