package com.BookMyShow.Service;


import com.BookMyShow.Models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket TicketBooking(Long useId, Long showId, List<Long>showSeatId);
    Ticket CancelTicket(Long ticketId);
    Ticket TransferTicket(Long fromUserId, Long ToUserId,Long TicketId);
}
