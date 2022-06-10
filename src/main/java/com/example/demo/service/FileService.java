package com.example.demo.service;

import com.example.demo.process.FileProcess;
import org.springframework.stereotype.Service;

@Service
public interface FileService {

    public boolean insertNewFile (Object objectFile);
}
