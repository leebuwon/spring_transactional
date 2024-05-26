package com.tx.springtransactional.domain.service;

import com.tx.springtransactional.domain.dto.CreateProductDto;
import com.tx.springtransactional.domain.entity.Product;
import com.tx.springtransactional.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void createProduct(CreateProductDto dto) {
        Product product = Product.builder()
                .productName(dto.getProductName())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();

        create(product);
    }

    // 사실 가장 쉬운 방법은 트랜잭션 전파 수준을 default 상태인 required로 설정하면 부모 수준에서만 transactional을 설정해도 문제가 되지 않는다.
    // 학습 용으로 내부 트랜잭션을 어떻게 관리하는지 알고 싶었다.
    @Transactional(propagation = Propagation.REQUIRES_NEW) // 부모 트랜잭션과 다른 새로운 트랜잭션 생성 (rollback 각각)
    public void create(Product product) {
        productRepository.save(product);
        throw new RuntimeException();
    }
}
