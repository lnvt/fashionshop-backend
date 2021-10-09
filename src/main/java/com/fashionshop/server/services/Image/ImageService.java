package com.fashionshop.server.services.Image;

import com.fashionshop.server.models.ImageModel;
import com.fashionshop.server.repositories.IImageRepository;
import com.fashionshop.server.services.Interface.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService implements IImageService {

    @Autowired
    private IImageRepository imageRepository;

    @Override
    public Iterable<ImageModel> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<ImageModel> findById(long id) {
        return imageRepository.findById(id);
    }

    @Override
    public ImageModel save(ImageModel imageModel) {
        return imageRepository.save(imageModel);
    }

    @Override
    public void remove(Long id) {
        imageRepository.deleteById(id);
    }
}
