package com.gestion.gestion.Service;

import com.gestion.gestion.model.BaseDeConnaissance;
import com.gestion.gestion.Repository.BaseDeConnaissanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseDeConnaissanceService {

    @Autowired
    private BaseDeConnaissanceRepository baseDeConnaissanceRepository;

    public List<BaseDeConnaissance> getAllBaseDeConnaissances() {
        return baseDeConnaissanceRepository.findAll();
    }

    public Optional<BaseDeConnaissance> getBaseDeConnaissanceById(Long id) {
        return baseDeConnaissanceRepository.findById(id);
    }

    public BaseDeConnaissance createBaseDeConnaissance(BaseDeConnaissance baseDeConnaissance) {
        return baseDeConnaissanceRepository.save(baseDeConnaissance);
    }

    public BaseDeConnaissance updateBaseDeConnaissance(Long id, BaseDeConnaissance baseDeConnaissanceDetails) {
        Optional<BaseDeConnaissance> optionalBaseDeConnaissance = baseDeConnaissanceRepository.findById(id);

        if (optionalBaseDeConnaissance.isPresent()) {
            BaseDeConnaissance existingBaseDeConnaissance = optionalBaseDeConnaissance.get();
            existingBaseDeConnaissance.setQuestion(baseDeConnaissanceDetails.getQuestion());
            existingBaseDeConnaissance.setReponse(baseDeConnaissanceDetails.getReponse());
            existingBaseDeConnaissance.setImageURL(baseDeConnaissanceDetails.getImageURL());
            existingBaseDeConnaissance.setDocumentURL(baseDeConnaissanceDetails.getDocumentURL());
            existingBaseDeConnaissance.setLienURL(baseDeConnaissanceDetails.getLienURL());
            return baseDeConnaissanceRepository.save(existingBaseDeConnaissance);
        } else {
            throw new RuntimeException("BaseDeConnaissance not found with id: " + id);
        }
    }

    public void deleteBaseDeConnaissance(Long id) {
        baseDeConnaissanceRepository.deleteById(id);
    }
}

