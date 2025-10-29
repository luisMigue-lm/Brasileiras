package com.projeto.Brasileiras.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FuncionarioService {
    public static final String enderecoArmazenamentoArquivo = "C:/IFerno/3º Ano/Web/3º Bimestre/Brasileiras/src/main/resources/static/img/fotos/clientes";

    public String salvarFoto(MultipartFile arquivo) throws IOException {
        if (arquivo == null || arquivo.isEmpty()) {
            throw new NullPointerException("Arquivo de imagem do funcionário está vazia");
        }

        String nomeArquivo = UUID.randomUUID() + "_" + StringUtils.cleanPath(arquivo.getOriginalFilename());

        File pasta = new File(enderecoArmazenamentoArquivo);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        File destino = new File(pasta, nomeArquivo);
        Files.copy(arquivo.getInputStream(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return "/img/fotos/funcionários/" + nomeArquivo;

    }
}
