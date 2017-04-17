package appsind.atom.com.br.appandroidsind.model;

import java.util.Date;

/**
 * Created by vinicius.oliveira on 17/04/2017.
 */

public class Partner {

    private Integer id;
    private String name;
    private Integer cpf;
    private String celular;
    private String empresa;
    private String dt_nascimento;
    private String password;

    public Partner(String name, Integer cpf, String celular, String empresa, String dt_nascimento, String password){
        this.name = name;
        this.cpf = cpf;
        this.celular = celular;
        this.empresa = empresa;
        this.dt_nascimento = dt_nascimento;
        this.password = password;
    }
}
