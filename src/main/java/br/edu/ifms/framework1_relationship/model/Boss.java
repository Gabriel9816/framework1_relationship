package br.edu.ifms.framework1_relationship.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //cria todos os get e set
@AllArgsConstructor //cria os construtores
@NoArgsConstructor //cria os construtores
@Entity //cria a tabela no banco de dados
public class Boss {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    private String name;
    private double salary;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "HumanResources_ID")
    private HumanResources humanResources;
}
