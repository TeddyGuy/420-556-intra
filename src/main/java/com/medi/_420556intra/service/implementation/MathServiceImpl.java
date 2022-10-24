package com.medi._420556intra.service.implementation;

import com.medi._420556intra.service.MathService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MathServiceImpl implements MathService {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a-b;
    }
}
