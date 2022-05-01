package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.Receipt;
import com.example.springcourses.services.ReceiptService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@JpaImplementation
public class ReceiptJpaService extends AbstractJpaService<Receipt, UUID> implements ReceiptService {

    @Override
    public JpaRepository<Receipt, UUID> getRepository() {
        throw new UnsupportedOperationException();
    }
}
