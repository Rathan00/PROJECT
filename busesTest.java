import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class BusesDAOTest {


	BusesDAO busesDAO = new BusesDAOImplementation();
	
	@Test
	public void selectTest() {
		
		System.out.println("Test started..");
		Assertions.assertTrue(busesDAO!=null);
		System.out.println("Got the DAO : "+busesDAO);

		Buses bus = busesDAO.selectBus(102);
		
		System.out.println("Bus Obj : "+bus);

		System.out.println("Test over...");
	}
	
	@Test
	public void InsertBusTest() {
		
		Buses busObj = new Buses();
		Assertions.assertTrue(busObj!=null);
		System.out.println("bus created....");
		
		busObj.setBusId(109);
		busObj.setBusNumber("TS17C7738");
		busObj.setTravelAgency("Kudali Travels");
		busObj.setBusType("A/C Sleeper");
		busObj.setTotalSeats(40);
		busObj.setAvailableSeats(26);
		busObj.setFare(1100.0f);
		
		busesDAO.insertBus(busObj);
		
	}
