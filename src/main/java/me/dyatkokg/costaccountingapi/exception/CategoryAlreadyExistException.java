package me.dyatkokg.costaccountingapi.exception;

public class CategoryAlreadyExistException extends RuntimeException {
    private static final String MESSAGE = "ExpenseCategory with this name already exist";

    public CategoryAlreadyExistException() {
        super(MESSAGE);
    }
}
