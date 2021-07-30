package br.com.venzel.store.modules.order.use_cases.create_order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.order.dtos.OrderDTO;
import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.order.exceptions.OrderAlreadyExistsException;
import br.com.venzel.store.modules.order.mapper.OrderMapper;
import br.com.venzel.store.modules.order.repositories.OrderRepository;
import br.com.venzel.store.modules.order.utils.OrderMessageUtils;

@Service
public class CreateOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public OrderDTO execute(OrderDTO dto) {
        
        Optional<Order> optionalEntity = orderRepository.findById(dto.getId());

        if (optionalEntity.isPresent()) {
            throw new OrderAlreadyExistsException(OrderMessageUtils.ORDER_ALREADY_EXISTS);
        }

        Order order = orderMapper.toEntity(dto);

        orderRepository.save(order);

        return orderMapper.toDTO(order);
    }
}
