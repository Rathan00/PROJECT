
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BusesDAOImplementation implements BusesDAO {

	Connection conn ; //GLOBAL 
	
	public BusesDAOImplementation() {
		try {
			//1. Load the Driver
			System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded....");
			
			//2. Acquire the connection
			System.out.println("Trying to connect....");
			conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected : "+ conn);
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insertBus(Buses bus) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("INSERT INTO DEPT10 VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pst.setInt(1, bus.getBusId());
			pst.setString(2, bus.getNumber());
			pst.setString(3,bus.getDeparture());
			pst.setString(4,bus.getDestination());
			pst.setString(5,bus.getBusType());
			pst.setInt(6,bus.getRootId());
			pst.setInt(7,bus.getJourneyTime());
			pst.setLong(8,bus.getAvailableDate());
			pst.setLong(9,bus.getReachingDate());
			pst.setInt(10,bus.getAvailableSeats());
			pst.setInt(11,bus.getStartTime());
			pst.setInt(12,bus.getEndTime());

			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Rows created : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public Buses selectBus(int busId) {
		
		Buses busObj =null;
		try {
			
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM DEPT10 WHERE DEPTNO="+busId);
			
			//5. process teh result if any
			if(result.next()) {
				busObj = new Buses(); //blank object
				
				busObj.setBusId(result.getInt(1));
				busObj.setNumber(result.getString(2));
				busObj.setDeparture(result.getString(3));
				busObj.setDestination(result.getString(4));
				busObj.setBusType(result.getString(5));
				busObj.setRootId(result.getInt(6));
				busObj.setJourneyTime(result.getInt(7));
				busObj.setAvailableDate(result.getLong(8));
				busObj.setReachingDate(result.getLong(9));
				busObj.setAvailableSeats(result.getInt(10));
				busObj.setStartTime(result.getInt(11));
				busObj.setEndTime(result.getInt(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return busObj;
	}

	@Override
	public List<Buses> selectBuses() {
		
		List<Buses> busList = new ArrayList<Buses>();
		try {
			
			 
			Statement statement = conn.createStatement();
			System.out.println("Statement is created : "+ statement);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			ResultSet result = statement.executeQuery("SELECT * FROM DEPT10");
			
			//5. process teh result if any
			while(result.next()) {
				Buses busObj = new Buses(); //blank object
				
				busObj.setBusId(result.getInt(1));
				busObj.setNumber(result.getString(2));
				busObj.setDeparture(result.getString(3));
				busObj.setDestination(result.getString(4));
				busObj.setBusType(result.getString(5));
				busObj.setRootId(result.getInt(6));
				busObj.setJourneyTime(result.getInt(7));
				busObj.setAvailableDate(result.getLong(8));
				busObj.setReachingDate(result.getLong(9));
				busObj.setAvailableSeats(result.getInt(10));
				busObj.setStartTime(result.getInt(11));
				busObj.setEndTime(result.getInt(12));
				busList.add(busObj); // add this object to the LIST 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return busList;
	}

	@Override
	public void updateBus(Buses bus) {
		//3. make a desired statement (insert/update/delete/select)
		
				try {
					PreparedStatement pst = 
							conn.prepareStatement("UPDATE DEPT10 set dname=?, loc=? where deptno=?");
					
					
					pst.setInt(1, bus.getBusId());
					pst.setString(2, bus.getNumber());
					pst.setString(3,bus.getDeparture());
					pst.setString(4,bus.getDestination());
					pst.setString(5,bus.getBusType());
					pst.setInt(6,bus.getRootId());
					pst.setInt(7,bus.getJourneyTime());
					pst.setLong(8,bus.getAvailableDate());
					pst.setLong(9,bus.getReachingDate());
					pst.setInt(10,bus.getAvailableSeats());
					pst.setInt(11,bus.getStartTime());
					pst.setInt(12,bus.getEndTime());

					
					System.out.println("PreparedStatement is created : "+ pst);
					
					//4. execute that statement //  UR TABLENAME IS MYDEPT120
					int rows = pst.executeUpdate();
					
					System.out.println("Row MODIFIED : "+rows);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void deleteBus(int busId) {
		//3. make a desired statement (insert/update/delete/select)
		
		try {
			PreparedStatement pst = 
					conn.prepareStatement("DELETE FROM DEPT10 where deptno=?");
			
			pst.setInt(1, busId); //WHERE deptno=?

			
			System.out.println("PreparedStatement is created : "+ pst);
			
			//4. execute that statement //  UR TABLENAME IS MYDEPT120
			int rows = pst.executeUpdate();
			
			System.out.println("Row DELETED : "+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
