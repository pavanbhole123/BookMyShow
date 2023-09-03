package com.BookMyShow.Service;

import com.BookMyShow.Models.*;
import com.BookMyShow.Repository.Exception.UserEmailNotFoundException;
import com.BookMyShow.Repository.ShowRepository;
import com.BookMyShow.Repository.ShowSeatRepository;
import com.BookMyShow.Repository.TicketRepository;
import com.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Override
    public Ticket TicketBooking(Long useId, Long showId, List<Long> showSeatId) {
        return null;
    }

    @Override
    public Ticket CancelTicket(Long ticketId) {
        Optional<Ticket>ticketOptional=ticketRepository.findById(ticketId);
        if(ticketOptional.isEmpty()){
            throw new UserEmailNotFoundException("Given Ticket Id is not exist");
        }
        Ticket ticket = ticketOptional.get();
        ticket.setBookingStatus(BookingStatus.CANCELLED);
        for (ShowSeat showSeat:ticket.getShowSeat()){
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(showSeat);
        }
        return  ticketRepository.save(ticket);
    }

    @Override
    public Ticket TransferTicket(Long fromUserId, Long ToUserId, Long TicketId) {
        Optional<Ticket>ticketOptional=ticketRepository.findById(TicketId);
        if(ticketOptional.isEmpty()){
            throw new UserEmailNotFoundException("Ticket with given id not found");
        }
        Optional<User>fromUserOptional=userRepository.findById(fromUserId);
        Optional<User>toUserOptional=userRepository.findById(ToUserId);
        if(fromUserOptional.isEmpty() || toUserOptional.isEmpty()){
            throw new UserEmailNotFoundException("Users with given id not found");
        }
        Ticket ticket = ticketOptional.get();
        User fromUser = fromUserOptional.get();

        List<Ticket>bookedTicket = fromUser.getTickets();
        bookedTicket.remove(ticket);
       // fromUser.setTickets(bookedTicket);
        userRepository.save(fromUser);
        User toUser = toUserOptional.get();
        bookedTicket = toUser.getTickets();
        bookedTicket.add(ticket);
        //toUser.setTickets(bookedTicket);
        toUser = userRepository.save(toUser);
        ticket.setUser(toUser);
        return ticketRepository.save(ticket);
    }
}
