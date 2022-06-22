package me.dyatkokg.costaccountingapi.exception;

public class CategoryAlreadyExistException extends RuntimeException {

    public CategoryAlreadyExistException() {
        super("ExpenseCategory with this name already exist");
    }
}
