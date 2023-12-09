package com.example.nasatelegrambotspring.service;

import com.example.nasatelegrambotspring.model.NasaObject;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

public interface NasaService {
    @Async
    CompletableFuture<NasaObject> getPhoto();
}
