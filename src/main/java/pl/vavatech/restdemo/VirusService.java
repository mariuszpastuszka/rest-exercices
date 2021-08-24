package pl.vavatech.restdemo;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VirusService {

    Optional<Virus> findById(Long id) {
        return Optional.empty();
    }

    boolean deleteVirusById(Long id) {
        return true;
    }
}
