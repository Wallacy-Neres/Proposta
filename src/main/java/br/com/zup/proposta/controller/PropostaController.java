package br.com.zup.proposta.controller;

import br.com.zup.proposta.dto.PropostaDTO;
import br.com.zup.proposta.usecase.interfaces.PropostaUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaUC useCase;

    @PostMapping("/criar")
    public ResponseEntity<?> criarProposta(@RequestBody @Valid PropostaDTO propostaDTO, UriComponentsBuilder builder){

        return useCase.excute(propostaDTO, builder);
    }


}
