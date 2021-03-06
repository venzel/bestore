package br.com.venzel.store.modules.profile.address.exceptions;

import br.com.venzel.store.shared.exceptions.problems.EntityAlreadyExistsException;

public class AddressInUseException extends EntityAlreadyExistsException {

    private static final long serialVersionUID = 1L;

    public AddressInUseException(String message) {
        super(message);
    }
}
