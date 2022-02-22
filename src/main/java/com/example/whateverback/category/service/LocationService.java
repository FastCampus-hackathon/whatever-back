package com.example.whateverback.category.service;

import com.example.whateverback.category.model.entity.Location;
import com.example.whateverback.category.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<String> getLocation() {
        return locationRepository.findFirstLocation();
    }

    public List<String> getLocationByName(String name) {
        Long loc_mcd = locationRepository.findByName(name).getLocMcd();
        return locationRepository.findByLocMcd(loc_mcd).stream()
                .map(Location::getName)
                .collect(Collectors.toList());
    }

    public String getLocationBcdByName(String name) {
        if (name == null) return "";
        Location location = locationRepository.findByName(name);
        Long num = location.getLocBcd();
        String text = num.toString();
        return text;
    }

    public String getLocationMcdByName(String name) {
        if (name == null) return "";
        return locationRepository.findByName(name).getLocMcd().toString();
    }
}
