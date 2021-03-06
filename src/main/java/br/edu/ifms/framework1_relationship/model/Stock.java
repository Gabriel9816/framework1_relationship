package br.edu.ifms.framework1_relationship.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // cria todos os get e set
@AllArgsConstructor // cria os construtores
@NoArgsConstructor // cria os construtores
@Entity // cria a tabela no banco de dados
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    private String name;
    private String localization;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Stock_and_Stores", 
            joinColumns = { @JoinColumn(name = "Stock_ID") }, 
            inverseJoinColumns = { @JoinColumn(name = "Store_ID") })
            

    private List<Stock> stocks;

}
