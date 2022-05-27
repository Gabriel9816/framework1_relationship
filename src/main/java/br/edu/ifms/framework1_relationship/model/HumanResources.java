package br.edu.ifms.framework1_relationship.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //cria todos os get e set
@AllArgsConstructor //cria os construtores
@NoArgsConstructor //cria os construtores
@Entity //cria a tabela no banco de dados
public class HumanResources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    private String nome;
    private double cost;

    
    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "Boss_ID")
    private Boss boss;

   
    @OneToMany(mappedBy = "humanResourcess")
    List<Employee> employees = new ArrayList<Employee>();
}
