package br.com.loterica.loterica.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JogoResponseDTO {

    private Long id;
    private Integer numeroSorteado;
    private Date dataCriacao;
    private String local;
}
