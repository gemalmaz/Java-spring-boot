package com.gm.book.business.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBookResponse {
	
	private int id;
	
	private String name;

}
