package com.techeazy.lmds.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parcel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "parcel tracking id cannot be left empty")
	private String trackingId;

	@NotNull(message = "parcel status is needed to be added")
	private String status;
	private String description;
	private double weight;

	@NotNull(message = "Destination address of a parcel is required")
	private String destinationAddress;

	@ManyToOne
	@JoinColumn(name = "order_detail_id")
	private OrderDetail orderDetail;

}
