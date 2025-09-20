package com.projeto.Brasileiras.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data; 
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "funcionarios")
@DiscriminatorValue("FUNCIONARIO")
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")   
public class Funcionario extends Pessoa{

    @Column(name = "salario", nullable = false)
    private double salario;

    @Column(name = "cargo", nullable = false)
    private String cargo;
    
    @Column(name = "departamento", nullable = false)
    private String departamento;
    
    @Column(name = "matricula", nullable = false)
    private String matricula;

    public Funcionario(Long id, String nome, String telefone, String email, String senha, String cpf,
            LocalDate dtNascimento, Endereco endereco, double salario, String cargo, String departamento,
            String matricula) {
        super(id, nome, telefone, email, senha, cpf, dtNascimento, endereco);
        this.salario = salario;
        this.cargo = cargo;
        this.departamento = departamento;
        this.matricula = matricula;
    }

    public Funcionario(double salario, String cargo, String departamento, String matricula) {
        this.salario = salario;
        this.cargo = cargo;
        this.departamento = departamento;
        this.matricula = matricula;
    }

    public Funcionario() {}

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    

}
