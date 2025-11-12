package com.projeto.Brasileiras.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;

@Service
public class ClienteService {                                 //tem que mudar sempre
    public static final String enderecoArmazenamentoArquivo = "C:/IFerno/3º Ano/Web/Brasileiras/src/main/resources/static/img/fotos/clientes";

    public String salvarFoto(MultipartFile arquivo) throws IOException {
        if (arquivo == null || arquivo.isEmpty()) {
            throw new NullPointerException("Arquivo de imagem do cliente está vazia");
        }

        String nomeArquivo = UUID.randomUUID() + "_" + StringUtils.cleanPath(arquivo.getOriginalFilename());

        File pasta = new File(enderecoArmazenamentoArquivo);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        File destino = new File(pasta, nomeArquivo);
        Files.copy(arquivo.getInputStream(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return "/img/fotos/clientes/" + nomeArquivo;

    }
}
