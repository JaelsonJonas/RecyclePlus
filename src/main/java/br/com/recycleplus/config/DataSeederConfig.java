package br.com.recycleplus.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.recycleplus.models.Endereco;
import br.com.recycleplus.models.Genero;
import br.com.recycleplus.models.Material;
import br.com.recycleplus.models.Sigla;
import br.com.recycleplus.models.Status;
import br.com.recycleplus.models.StatusTransacao;
import br.com.recycleplus.models.Tipo;
import br.com.recycleplus.models.Transacao;
import br.com.recycleplus.models.Usuario;
import br.com.recycleplus.repository.EnderecoRepository;
import br.com.recycleplus.repository.MaterialRepository;
import br.com.recycleplus.repository.TransacaoRepository;
import br.com.recycleplus.repository.UsuarioRepository;

@Configuration
public class DataSeederConfig implements CommandLineRunner {

        @Autowired
        UsuarioRepository repository;

        @Autowired
        TransacaoRepository tRepository;

        @Autowired
        MaterialRepository mRepository;

        @Autowired
        EnderecoRepository eRepository;

        @Override
        public void run(String... args) throws Exception {

                repository.saveAll(List.of(
                                Usuario
                                .builder()
                                .login("joao.silva")
                                .email("joao.silva@email.com.br")
                                .senha("Senha123")
                                .nomeCompleto("João da Silva")
                                .documento("12345678900")
                                .telefone("11954323230")
                                .dataNasc(LocalDate.of(1990, 01, 01))
                                .genero(Genero.MASCULINO)
                                .status(Status.ATIVO)
                                .build()

                ));

                tRepository.saveAll(List.of(
                                Transacao.builder()
                                                .data(LocalDate.now())
                                                .valor(new BigDecimal(5000))
                                                .tipo(StatusTransacao.ENVIADO)
                                                .horario(LocalTime.now())
                                                .idUsuario(1l)
                                                .build(),
                                Transacao.builder()
                                                .data(LocalDate.now())
                                                .valor(new BigDecimal(1000))
                                                .tipo(StatusTransacao.ENVIADO)
                                                .horario(LocalTime.now())
                                                .idUsuario(1l)
                                                .build(),
                                Transacao.builder()
                                                .data(LocalDate.now())
                                                .valor(new BigDecimal(1235))
                                                .tipo(StatusTransacao.RECEBIDO)
                                                .horario(LocalTime.now())
                                                .idUsuario(1l)
                                                .build(),
                                Transacao.builder()
                                                .data(LocalDate.now())
                                                .valor(new BigDecimal(40))
                                                .tipo(StatusTransacao.RECEBIDO)
                                                .horario(LocalTime.now())
                                                .idUsuario(1l)
                                                .build(),
                                Transacao.builder()
                                                .data(LocalDate.now())
                                                .valor(new BigDecimal(345))
                                                .tipo(StatusTransacao.ENVIADO)
                                                .horario(LocalTime.now())
                                                .idUsuario(1l)
                                                .build(),
                                Transacao.builder()
                                                .data(LocalDate.now())
                                                .valor(new BigDecimal(5000))
                                                .tipo(StatusTransacao.ENVIADO)
                                                .horario(LocalTime.now())
                                                .idUsuario(1l)
                                                .build()

                ));

                mRepository.saveAll(List.of(

                                Material
                                                .builder()
                                                .nome("Papelão")
                                                .valor(new BigDecimal(0.12))
                                                .tipo(Tipo.PAPEL)
                                                .build(),
                                Material
                                                .builder()
                                                .nome("Garrafa Pet")
                                                .valor(new BigDecimal(1.40))
                                                .tipo(Tipo.PLASTICO)
                                                .build(),
                                Material
                                                .builder()
                                                .nome("Latinha de Refrigerante")
                                                .valor(new BigDecimal(5.35))
                                                .tipo(Tipo.ALUMINIO)
                                                .build(),
                                Material
                                                .builder()
                                                .nome("Garrafa de vidro")
                                                .valor(new BigDecimal(3.79))
                                                .tipo(Tipo.VIDRO)
                                                .build()

                ));

                eRepository.saveAll(List.of(
                                Endereco
                                                .builder().logradouro("Rua dos loucos")
                                                .numero(0)
                                                .cep("1234567")
                                                .bairro("Vila Mariana")
                                                .estado("São Paulo")
                                                .cidade("São paulo")
                                                .sigla(Sigla.SP)
                                                .status(Status.ATIVO)
                                                .idUsuario(1l)
                                                .build()));
        }

}
