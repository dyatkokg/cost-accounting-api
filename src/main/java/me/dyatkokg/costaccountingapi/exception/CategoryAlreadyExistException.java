package me.dyatkokg.costaccountingapi.exception;

public class CategoryAlreadyExistException extends RuntimeException {

    public CategoryAlreadyExistException() {
        super("Category with this name already exist");
    }
}
