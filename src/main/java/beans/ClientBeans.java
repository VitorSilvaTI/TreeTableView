package beans;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

/* É necessario que a classe com os atributos do banco seja extendida pelo RecursiveTreeObject
 * para na utilização TreeTableView reconheça os seus valores; */

public class ClientBeans extends RecursiveTreeObject<ClientBeans> {

    private int id;
    private String name;
    private String cpf;
    private String number;
    private String profession;
    private String ide;


    public ClientBeans(String name, String cpf, String number, String profession, String ide) {
        this.name = name;
        this.cpf = cpf;
        this.number = number;
        this.profession = profession;
        this.ide = ide;
    }

    public ClientBeans(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }
}
