package com.example.photoService.repository;

import com.example.photoService.dao.PhotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoDetailsRepository extends CrudRepository<PhotoEntity, Long> {
}
