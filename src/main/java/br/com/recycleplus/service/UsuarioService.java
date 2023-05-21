package br.com.recycleplus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.recycleplus.DTO.Adress;
import br.com.recycleplus.DTO.TransactionData;
import br.com.recycleplus.DTO.UsuarioDTO;
import br.com.recycleplus.exceptions.RestNotFoundException;
import br.com.recycleplus.models.Usuario;
import br.com.recycleplus.repository.EnderecoRepository;
import br.com.recycleplus.repository.TransacaoRepository;
import br.com.recycleplus.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    public UsuarioDTO getWithEndereco(Long idUsuario, Pageable pageable) {

        Usuario get = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RestNotFoundException("Usuario não encontrado"));

        List<TransactionData> lista = transacaoRepository.findByIdUsuario(idUsuario, pageable).stream()
                .map(TransactionData::new).toList();

        Adress endereco = enderecoRepository.findByIdUsuario(idUsuario).map(Adress::new).get();

        return new UsuarioDTO(get, lista, endereco);

    }

}
