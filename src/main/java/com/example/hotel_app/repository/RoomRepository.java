package com.example.hotel_app.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.hotel_app.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	
	public List<Room> priceLessThan(BigDecimal price);
	
	@Query(value="select r from Room r left join fetch r.bookings ")
	public   List<Room> getAllRoomsWithBookings();

	
	// Custom JPQL query to fetch all rooms with their bookings
	@Query("SELECT DISTINCT r FROM Room r JOIN FETCH r.bookings b WHERE b.id IS NOT NULL")
	List<Room> findAllRoomsWithBookings();
	
	
	@Query("SELECT r FROM Room r " +
		       "WHERE r.id NOT IN (" +
		       "   SELECT b.room.id FROM Booking b " +
		       "   WHERE :givenDate BETWEEN b.checkIn AND b.checkOut" +
		       ")")
		List<Room> findAvailableRooms(@Param("givenDate") LocalDate givenDate);
	
	
	@Query(value="SELECT *  FROM room r	WHERE r.id NOT IN "
			+ "	(SELECT b.room_id  FROM booking  b  WHERE :givenDate BETWEEN b.check_in AND b.check_out)	", nativeQuery = true)
	List<Room> findAvailableRoomsUsingQuery(@Param("givenDate") LocalDate givenDate);
	
	/* */

}
