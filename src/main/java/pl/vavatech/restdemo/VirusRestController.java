package pl.vavatech.restdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/viruses/{id}")
    public ResponseEntity<Void> deleteVirus(@PathVariable("id") Long idik) {
        boolean deleted = virusService.deleteVirusById(idik);
//        if (deleted) {
//            return ResponseEntity
//                    .noContent()
//                    .build();
//        } else {
//            return ResponseEntity
//                    .notFound()
//                    .build();
//        }

        return Optional.of(deleted)
                .filter(aBoolean -> aBoolean)
                .map(aBoolean -> ResponseEntity.noContent().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/viruses")
    public ResponseEntity<Virus> mutateVirus(Virus mutated) {
        // tricky implementation when property is null...
        if (mutated.name() != null) {
            // set name
        }
        // what if we want set name to null???
        return Optional.ofNullable(mutated)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/viruses/{id}")
    public ResponseEntity<Void> replaceWithMoreDangerous(@PathVariable("id") Long id, @RequestBody Virus delta) {
        return ResponseEntity.noContent().build();
    }
}
