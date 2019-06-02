package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

import entity.EntityFactory;
import entity.Map;
/**
 * 
 * @author Chevallier Baptiste
 *
 */
public class DAOMap {
	/**
	 * Instantiates a new DAO entity.
	 *
	 */
	public DAOMap()  {

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

	/**
	 * Take the map in the database and transform it in entity
	 *
	 *@param id
	 */
	public Map find(final int id) {
		Map map = new Map();		//create a Map

	/////   Database access   /////
			String urlString = "jdbc:mysql://localhost/jpublankproject?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";		//all constant to database access
			String loginString = "root";
			String passwdString = "";
			Connection cnConnection = null;
			CallableStatement stStatement = null;
			ResultSet resultSet = null;

			String sqlRequestString = "{call mapById(?)}";//"SELECT * FROM map WHERE `ID` = " + id;
			/////////////////////////////////////
			
			try {
				// 1): Loading driver 
				// 2): Connection
				cnConnection = DriverManager.getConnection(urlString, loginString, passwdString);
				// 3): creation statement 
				stStatement = (CallableStatement) cnConnection.prepareCall(sqlRequestString);
				stStatement.setInt(1,id);
				stStatement.execute();
				// 4): request
				resultSet = stStatement.getResultSet();
				// 5): Result
			if (resultSet.first()) {
				int width = resultSet.getInt("width");		//get width
				int height = resultSet.getInt("height");	//get height
				map = new Map(width,height);				//instantiate map with parameters
			
				String TEMP_road_FromSQL = resultSet.getString("mapChar");		//take the map in character
                TEMP_road_FromSQL = TEMP_road_FromSQL.replaceAll("\r\n", "");	//make it in 1 line

                //System.out.println(TEMP_road_FromSQL); 	debug

                for(int y=0; y < height; y++)
                {
                    for(int x=0; x < width; x++)
                    {
                        map.setOnTheMapXY(EntityFactory.getFromFileSymbol(TEMP_road_FromSQL.charAt(y*width + x)), x, y);	//translation to entity
                       // System.out.println(y*width + x); debug
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
				// 6): we empty the memory
				cnConnection.close();
				stStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//			System.out.println(map.getOnTheMapXY(0, 0).toString());		debug
//	        System.out.println(map.getOnTheMapXY(1, 1).toString());
//	        System.out.println(map.getOnTheMapXY(3, 2).toString());
		return map;
	}
	
	
}
