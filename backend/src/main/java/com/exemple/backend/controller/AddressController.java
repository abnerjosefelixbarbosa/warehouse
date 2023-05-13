package com.exemple.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.backend.face.AddressFace;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private AddressFace addressFace;
	
	public ResponseEntity<String> create() {
		try {
			return ResponseEntity.status(200).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(null);
		}
	}
}
