package me.dyatkokg.costaccountingapi.exception;

public class WasteNotFoundException extends RuntimeException {
    public WasteNotFoundException() {
        super("Waste with this id is not found");
    }
}
