package pl.vavatech.restdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VirusRestController implements VirusRestControllerInterface {

    private final VirusService virusService;

    public VirusRestController(final VirusService virusService) {
        this.virusService = virusService;
    }

    @Override
    @GetMapping("/viruses")
    public List<Virus> getViruses() {
        return List.of();
    }
;
    @Override
    @GetMapping("/viruses/{id}")
    // 200 - ok
    // 404 - not found
    public ResponseEntity<Virus> getVirusById(@PathVariable("id") Long idik) {
        var virus = virusService.findById(idik);

        return virus.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/viruses")
    public ResponseEntity<Virus> createVirus(@RequestBody Virus virus) {
        // save virus
        return ResponseEntity.created(null).build();
    }
}
