package br.com.ifpe.ipark.dto;

public record EnderecoDTO ( String rua,
                            String numero,
                            String cep,
                            String cidade,
                            String bairro,
                            String estado
                            ){
}
