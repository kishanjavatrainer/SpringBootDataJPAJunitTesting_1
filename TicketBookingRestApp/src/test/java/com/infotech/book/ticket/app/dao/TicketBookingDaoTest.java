package com.infotech.book.ticket.app.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.infotech.book.ticket.app.entities.Ticket;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketBookingDaoTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	@Test
	public void testSaveTicket(){
		Ticket ticket = getTicket();
		Ticket savedInDb = entityManager.persist(ticket);
		Ticket getFromDb = ticketBookingDao.findOne(savedInDb.getTicketId());
		
		assertThat(getFromDb).isEqualTo(savedInDb);
	}
	
	private Ticket getTicket() {
		Ticket ticket = new Ticket();
		ticket.setPassengerName("Sean Murphy");
		ticket.setSourceStation("Delhi");
		ticket.setDestStation("Mumbai");
		ticket.setBookingDate(new Date());
		ticket.setEmail("sean.s2006@gmail.com");
		return ticket;
	}
}
