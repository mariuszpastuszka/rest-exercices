package pl.vavatech.restdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface VirusRestControllerInterface {
    List<Virus> getViruses();

    ResponseEntity<Virus> getVirusById(@PathVariable("id") Long myId);
}
