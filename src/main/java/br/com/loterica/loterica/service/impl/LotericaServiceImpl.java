package br.com.loterica.loterica.service.impl;

import br.com.loterica.loterica.database.entity.Jogo;
import br.com.loterica.loterica.database.repository.JogoRepository;
import br.com.loterica.loterica.dto.JogoRequestDTO;
import br.com.loterica.loterica.dto.JogoResponseDTO;
import br.com.loterica.loterica.exception.IdNotFound;
import br.com.loterica.loterica.service.LotericaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class LotericaServiceImpl implements LotericaService {

    @Autowired
    private JogoRepository jogoRepository;

    public JogoResponseDTO gravarJogo(JogoRequestDTO request) {
        Random rand = new Random();
        int numeroSorteado = 0;

        for (int i=0; i<6; i++) {
            numeroSorteado = numeroSorteado * 10 + rand.nextInt(10);
        }

        Jogo jogoEntity = jogoRepository.save(Jogo.builder()
                .numeroSorteado(numeroSorteado)
                .local(request.getLocal())
                .dataCriacao(new Date())
                .build());

        return JogoResponseDTO.builder()
                .id(jogoEntity.getId())
                .numeroSorteado(jogoEntity.getNumeroSorteado())
                .local(jogoEntity.getLocal())
                .dataCriacao(jogoEntity.getDataCriacao())
                .build();
    }

    public List<Jogo> listarJogo() {return jogoRepository.findAll();}

    public Optional<Jogo> buscarJogoPorId(Long id) {return jogoRepository.findById(id);}

    public JogoResponseDTO updateJogo (Long id, JogoRequestDTO request) {

        Jogo jogoEntity = buscarJogoPorId(id).orElseThrow(() -> new IdNotFound(String.format("ID NAO ENCONTRADO")));

            jogoEntity.setLocal(request.getLocal());
            jogoRepository.save(jogoEntity);

            return JogoResponseDTO.builder()
                    .id(jogoEntity.getId())
                    .numeroSorteado(jogoEntity.getNumeroSorteado())
                    .local(jogoEntity.getLocal())
                    .dataCriacao(new Date())
                    .build();
    }
}
