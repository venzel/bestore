package br.com.venzel.store.modules.order.order.dtos;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.venzel.store.modules.order.order_item.dtos.OrderItemDTO;
import br.com.venzel.store.modules.payment.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.user.user.dtos.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    /* Attributes */

    private Long id;

    private Boolean activated;
  
    /* Timestamps */
    
    private OffsetDateTime createdAt;
    
    private OffsetDateTime updatedAt;

    /* Cardinalities */

    private Set<OrderItemDTO> itens = new HashSet<>();

    @JsonManagedReference
    private PaymentDTO payment;

    @JsonManagedReference
    private UserDTO user;
}
