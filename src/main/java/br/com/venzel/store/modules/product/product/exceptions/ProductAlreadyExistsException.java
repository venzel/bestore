package br.com.venzel.store.modules.product.product.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class ProductAlreadyExistsException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
