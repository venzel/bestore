package br.com.venzel.store.modules.user.address.user_cases.create_address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.user.address.dtos.AddressDTO;
import br.com.venzel.store.modules.user.address.dtos.CreateAddressDTO;

@RestController
@RequestMapping("/users/adresses")
public class CreateAddressController {

    @Autowired
    private CreateAddressService createAddressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO handle(@RequestBody CreateAddressDTO dto) {
        
        return createAddressService.execute(dto);
    }
}
