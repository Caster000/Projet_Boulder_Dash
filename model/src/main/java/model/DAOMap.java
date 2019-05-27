package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import entity.EntityFactory;
//import entity.IEntity;
import entity.Map;


public class DAOMap {
	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	/** The connection. */
	//private final Connection connection;

	/**
	 * Instantiates a new DAO entity.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMap(/*final Connection connection*/)  {
		//this.connection = connection;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	public boolean create(final Map entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	public boolean delete(final Map entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	public boolean update(final Map entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	public Map find(final int id) {
		Map map = new Map();

	/////   access base de donnee   /////
			String urlString = "jdbc:mysql://localhost/jpublankproject?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String loginString = "root";
			String passwdString = "";
			Connection cnConnection = null;
			Statement stStatement = null;
			ResultSet resultSet = null;

			String sqlRequestString = "SELECT * FROM map WHERE `ID` = " + id;//"{call helloworldById(?)}";
			/////////////////////////////////////
			

			try {
				// 1): Chargement du driver // sur la vm ?
				//Class.forName(connectorString);//plus necessaire apparament (d'apres le message d'erreur)
				// 2): Connexion
				cnConnection = DriverManager.getConnection(urlString, loginString, passwdString);
				// 3): creation du statement (jsp ce que c'est)
				stStatement = cnConnection.createStatement();
				// 4): execute requete
				resultSet = stStatement.executeQuery(sqlRequestString);
				// 5):
			if (resultSet.first()) {
				int width = resultSet.getInt("width");
				int height = resultSet.getInt("height");
				map = new Map(width,height);
			
				String TEMP_road_FromSQL = resultSet.getString("mapChar");
                TEMP_road_FromSQL = TEMP_road_FromSQL.replaceAll("\r\n", "");

                System.out.println(TEMP_road_FromSQL);

                for(int y=0; y < height; y++)
                {
                    for(int x=0; x < width; x++)
                    {
                        map.setOnTheMapXY(EntityFactory.getFromFileSymbol(TEMP_road_FromSQL.charAt(y*width + x)), x, y);
                        System.out.println(y*width + x);
                    }
                }
            }
            else {
                System.out.println("<ERREUR, la route na pas ete trouvee>");
            }
			
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 6): on vide la mémoire
				cnConnection.close();
				stStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//			System.out.println(map.getOnTheMapXY(0, 0).toString());
//	        System.out.println(map.getOnTheMapXY(1, 1).toString());
//	        System.out.println(map.getOnTheMapXY(3, 2).toString());
		return map;
	}
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
//	protected Connection getConnection() {
//		return this.connection;
//	}
	
	
}
