package br.com.loterica.loterica.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name="TB_JOGO")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="numero_sorteado")
    private Integer numeroSorteado;

    @Column(name="data_criacao")
    private Date dataCriacao;

    @Column(name="local")
    private String local;


}
