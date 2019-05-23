package com.assegd.erorr;

import java.util.Set;

public class BookUnsupportedFieldPatchException extends RuntimeException {

    public BookUnsupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}
