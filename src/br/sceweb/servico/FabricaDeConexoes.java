package br.sceweb.servico;

import java.sql.DriverManager;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

/**
 * Fabrica para gerar as conex�es com o Banco de Dados MySQL
 * @author Caue Polimanti
 * @version 1.0
 *
 */
public class FabricaDeConexoes {
	/**
	 * Objeto de log
	 */
	Logger logger = Logger.getLogger(FabricaDeConexoes.class);
	public Connection getConnection(){
		String url = "jdbc:mysql://localhost/sceweb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return (Connection) DriverManager.getConnection(url,"root","");
			}
		catch (CommunicationsException e){
			logger.info("Exce��o de comunicacao com o DB causa: " + e.getMessage());
			
			throw new RuntimeException(e); 
		}
		catch (Exception e){
			logger.info("Exce��o geral causa: " + e.getMessage());
			
			throw new RuntimeException(e); 
		}
	}
}
