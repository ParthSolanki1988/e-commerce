package com.simform.ecommerceapi.dto;

import com.simform.ecommerceapi.entity.Orders;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String name;
    private int age;
    private MembershipDto membership;
    private List<OrdersDto> orderList;
}
