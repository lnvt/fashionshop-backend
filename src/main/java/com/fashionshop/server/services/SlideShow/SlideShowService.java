package com.fashionshop.server.services.SlideShow;

import com.fashionshop.server.models.SlideShowModel;
import com.fashionshop.server.repositories.ISlideShowRepository;
import com.fashionshop.server.services.Interface.ISlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SlideShowService implements ISlideShowService {

    @Autowired
    private ISlideShowRepository slideShowRepository;

    @Override
    public Iterable<SlideShowModel> findAll() {
        return slideShowRepository.findAll();
    }

    @Override
    public Optional<SlideShowModel> findById(long id) {
        return slideShowRepository.findById(id);
    }

    @Override
    public SlideShowModel save(SlideShowModel slideShowModel) {
        return slideShowRepository.save(slideShowModel);
    }

    @Override
    public void remove(Long id) {
        slideShowRepository.deleteById(id);
    }
}
