package br.com.meli.as_perolas_api.controller;

import br.com.meli.as_perolas_api.model.Jewel;
import br.com.meli.as_perolas_api.service.JewelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class JewelController {

    private JewelService jewelService;

    public JewelController(JewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping("/joia")
    public ResponseEntity<Jewel> createNewJewel(@RequestBody Jewel jewel) {
        Jewel createdJewel = this.jewelService.create(jewel);
        URI uri = URI.create("/joia");
        return ResponseEntity.created(uri).body(createdJewel);
    }

    @GetMapping("/joias")
    public ResponseEntity<List<Jewel>> getJewels() {
        List<Jewel> jewels = this.jewelService.listAll();
        return ResponseEntity.ok(jewels);
    }

    @DeleteMapping("/joia/{id}")
    public ResponseEntity deleteJewel(@PathVariable Long id) {
        this.jewelService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/joia")
    public ResponseEntity<Jewel> updateJewel(@RequestBody Jewel jewel) {
        Jewel updatedJewel = this.jewelService.update(jewel);
        return ResponseEntity.ok(updatedJewel);
    }
}
