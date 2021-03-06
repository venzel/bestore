package br.com.venzel.store.modules.order.order.use_cases.show_order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.order.order.dtos.OrderDTO;
import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.order.order.exceptions.OrderNotFoundException;
import br.com.venzel.store.modules.order.order.mappers.OrderMapper;
import br.com.venzel.store.modules.order.order.repositories.OrderRepository;
import br.com.venzel.store.modules.order.order.utils.OrderMessageUtils;

@Service
public class ShowOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public OrderDTO execute(Long id) {
        
        Optional<Order> optionalEntity = orderRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new OrderNotFoundException(OrderMessageUtils.ORDER_NOT_FOUND);
        }

        return orderMapper.toDTO(optionalEntity.get());
    } 
}
