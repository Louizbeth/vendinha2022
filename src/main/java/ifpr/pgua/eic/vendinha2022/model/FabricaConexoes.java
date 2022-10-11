package ifpr.pgua.eic.vendinha2022.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {

    private static int MAX_CONEXOES = 5;

    private static FabricaConexoes instance;
    
    private Connection[] conexoes;
    
    private FabricaConexoes(){
        conexoes = new Connection[MAX_CONEXOES];
    }

    public static FabricaConexoes getInstance(){
        if(instance == null){
            instance = new FabricaConexoes();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{
        for(int i = 0; i < conexoes.length; i++){
            conexoes[i] = DriverManager.getConnection("jdbc:mysql://jdbc:mysql://wagnerweinert.com.br:3306/app", "root", "");
            return conexoes[i];
        }

        throw new SQLException("Não há conexões disponíveis! Esqueceu de fechar?");
    }
}
