package br.com.loterica.loterica.service;

import br.com.loterica.loterica.database.entity.Jogo;
import br.com.loterica.loterica.dto.JogoRequestDTO;
import br.com.loterica.loterica.dto.JogoResponseDTO;

import java.util.List;

public interface LotericaService {

    public JogoResponseDTO gravarJogo(JogoRequestDTO request);

    public List<Jogo> listarJogo();

    public JogoResponseDTO updateJogo(Long id, JogoRequestDTO request) throws Exception;
}
