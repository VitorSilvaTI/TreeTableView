package dao;

import beans.ClientBeans;
import connection.DataBaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    /* Metodo para salvar os dados no banco; */

    public void saveInformation(ClientBeans clientBeans){
        DataBaseConnection connectionClient = new DataBaseConnection();
        connectionClient.connect();
        try {
            PreparedStatement pst = connectionClient.connection.prepareStatement("insert into cliente(nome, cpf, numero, profissao, ide) values(?,?,?,?,?)");
            pst.setString(1, clientBeans.getName());
            pst.setString(2, clientBeans.getCpf());
            pst.setString(3, clientBeans.getNumber());
            pst.setString(4, clientBeans.getProfession());
            pst.setString(5, clientBeans.getIde());
            pst.execute();
        }catch (SQLException e){
            System.out.println("Erro ao salvar o cliente");
            e.printStackTrace();
        }
        connectionClient.disconnect();
    }

    /* Metodo para puxar as informações do banco; */

    public List<ClientBeans> selectInformation(){
        DataBaseConnection connectionClient =  new DataBaseConnection();
        List<ClientBeans> listClients =  new ArrayList<>();
        connectionClient.connect();
        try {
            PreparedStatement pst = connectionClient.connection.prepareStatement("select * from cliente");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ClientBeans clientBeans =  new ClientBeans();
                clientBeans.setId(rs.getInt("id"));
                clientBeans.setName(rs.getString("nome"));
                clientBeans.setCpf(rs.getString("cpf"));
                clientBeans.setNumber(rs.getString("numero"));
                clientBeans.setProfession(rs.getString("profissao"));
                clientBeans.setIde(rs.getString("ide"));
                listClients.add(clientBeans);
            }
        }catch (SQLException e ){
            System.out.println("erro ao listar os clientes");
            e.printStackTrace();
        }
        return listClients;
    }
}
