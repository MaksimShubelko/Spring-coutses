package com.example.springcourses.services.jpa;

import com.example.springcourses.acpect.ActivityLog;
import com.example.springcourses.acpect.TimeToExecutingLog;
import com.example.springcourses.dto.ReceiptDto;
import com.example.springcourses.entity.Receipt;
import com.example.springcourses.entity.ReceiptStatus;
import com.example.springcourses.mapper.ReceiptMapper;
import com.example.springcourses.repository.ReceiptRepository;
import com.example.springcourses.repository.UserRepository;
import com.example.springcourses.services.ReceiptService;
import com.example.springcourses.services.config.JpaImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@JpaImplementation
public class ReceiptJpaService extends AbstractJpaService<ReceiptDto, Receipt, Long> implements ReceiptService {

    private final ReceiptRepository repository;
    private final ReceiptMapper mapper;


    @TimeToExecutingLog
    @ActivityLog(activity = "receipt_cancel", value = "Receipt cancelled {id}")
    @Override
    public void cancelReceipt(Long id) {
        Optional<Receipt> receiptOptional = repository.findById(id);
        if (receiptOptional.isPresent()) {
            Receipt receipt = receiptOptional.get();
            if (receipt.getReceiptStatus() == ReceiptStatus.PENDING) {
                receipt.setReceiptStatus(ReceiptStatus.CANCELLED);
                repository.save(receipt);
            }
        }
    }

    @TimeToExecutingLog
    @ActivityLog(activity = "receipt_payed", value = "Receipt payed {id}")
    @Override
    public void markReceiptAsPayed(Long id) {
        Optional<Receipt> receiptOptional = repository.findById(id);
        if (receiptOptional.isPresent()) {
            Receipt receipt = receiptOptional.get();
            if (receipt.getReceiptStatus() == ReceiptStatus.PENDING) {
                receipt.setReceiptStatus(ReceiptStatus.PAYED);
                repository.save(receipt);
            }
        }
    }

    @Override
    public ReceiptDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(ReceiptDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<ReceiptDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ReceiptDto mapToDto(Receipt entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Receipt mapToEntity(ReceiptDto dto) {
        return mapper.map(dto);
    }

    @Override
    public JpaRepository<Receipt, Long> getRepository() {
        return repository;
    }
}
