package br.com.loterica.loterica.controller;

import br.com.loterica.loterica.database.entity.Jogo;
import br.com.loterica.loterica.dto.JogoRequestDTO;
import br.com.loterica.loterica.dto.JogoResponseDTO;
import br.com.loterica.loterica.service.LotericaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/loterica")
public class LotericaController {

    @Autowired
    private LotericaService lotericaService;

    @PostMapping("/salvar-jogo")
    public ResponseEntity<JogoResponseDTO> postSalvarJogo (@RequestBody JogoRequestDTO request) {

        JogoResponseDTO response = lotericaService.gravarJogo(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/listar-jogo")
    public List<Jogo> getListarJogo() {
        return lotericaService.listarJogo();
    }

    @PutMapping("/{id}/atualizar-jogo")
    public ResponseEntity<JogoResponseDTO> putAtualizarJogo (

            @PathVariable Long id,
            @RequestBody JogoRequestDTO request) throws Exception {

        JogoResponseDTO responseUpdate = lotericaService.updateJogo(id, request);
        return ResponseEntity.ok(responseUpdate);
    }

}
