package cts.rabobank.glassdoorscheduler.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BOOKING_INFO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Room roomInfo;

	@Column(name = "BOOKING_START_DATE", nullable = false)
	private LocalDate bookingStartDate;

	@Column(name = "BOOKING_STARTTIME", nullable = false)
	private LocalTime bookingStartTime;

	@Column(name = "BOOKING_ENDTIME", nullable = false)
	private LocalTime bookingEndTime;

	@CreationTimestamp
	@Column(name = "CREATEDON", nullable = false)
	private Timestamp createdOn;

	@ManyToOne(cascade = CascadeType.ALL)
	private UserInfo userInfo;
	
	//@Column(name = "PURPOSE", nullable = false)
	//private String purpose;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private MeetingType meetingType;
}
