@Override
	public List<AvailableBuses> showAvailableBuses(String src, String dest, Date date) {
		// TODO Auto-generated method stub
		
		List<AvailableBuses> avlBusesList = new ArrayList();
		
		
		 RouteDAO routeDAO = new RouteDAOImplementation();
		
		 int rid = routeDAO.selectRouteId(src, dest);
		 
		 System.out.println("SRC = "+src);
		 System.out.println("DEST = "+dest);
		 
		 TravelTimeDAO travelDAO = new TravelTimeDAOImplementation();
		 System.out.println("ROUTE ID = "+rid);
		 
		 Route route = routeDAO.selectRoute(rid);
		 
		 List<TravelTime> listTT = travelDAO.selectTravels(rid);
		 
		TicketDAO ticketDAO = new TicketDAOImplementation();
		
				
		 
		 for (TravelTime tobj : listTT) {
			    
			 	AvailableBuses avlbus = new AvailableBuses();
			 	
			 	BusesDAO busDAO = new BusesDAOImplementation();
			 	Buses bus = busDAO.selectBus(tobj.getBusId());
			 	Time tm = tobj.getTime();
			 	
			 	int availableSeats = ticketDAO.availableSeats(tm, date, bus.getBusId());
			 	
			 	if(availableSeats >= 0) {

			 		avlbus.setBusId(bus.getBusId());
				 	avlbus.setBusNumber(bus.getBusNumber());
				 	avlbus.setTravelAgency(bus.getTravelAgency());
				 	avlbus.setBusType(bus.getBusType());
				 	avlbus.setAvailableSeats(availableSeats);
				 	avlbus.setTotalSeats(bus.getTotalSeats());
				 	avlbus.setFare(bus.getFare());
				 	avlbus.setSrc(route.getSrc());
				 	avlbus.setDest(route.getDest());
				 	avlbus.setJourneyTime(route.getJourneyTime());
				 	avlbus.setDistance(route.getDistance());
				 	avlbus.setTime(tobj.getTime());
				 	avlbus.setJourneyDate(date);
				 	
				 	avlBusesList.add(avlbus);
			 	}
			 	
			}
		
		 
		 return avlBusesList;

	}
