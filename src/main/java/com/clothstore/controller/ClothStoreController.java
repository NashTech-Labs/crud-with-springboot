package com.clothstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clothstore.entity.Cloth;
import com.clothstore.services.IClothStoreService;

/**
 * The type Cloth store controller.
 */
@Controller
@RequestMapping("clothservice")
public class ClothStoreController {
	
	@Autowired
	private IClothStoreService service;

	/**
	 * Get cloths response entity.
	 *
	 * @return the response entity
	 */
	@GetMapping("cloths")
	public ResponseEntity<List<Cloth>> getCloths(){
		
		List<Cloth> cloths = service.getCloths();
		return new ResponseEntity<List<Cloth>>(cloths, HttpStatus.OK);
		
	}

	/**
	 * Gets cloth.
	 *
	 * @param id the id
	 * @return the cloth
	 */
	@GetMapping("cloths/{id}")
	public ResponseEntity<Cloth> getCloth(@PathVariable("id") Integer id){
		Cloth cloth = service.getCloth(id);
		return new ResponseEntity<Cloth>(cloth, HttpStatus.OK);
	}

	/**
	 * Create cloth response entity.
	 *
	 * @param cloth the cloth
	 * @return the response entity
	 */
	@PostMapping("cloths")
	public ResponseEntity<Cloth> createCloth(@RequestBody Cloth cloth){
		Cloth b = service.createCloth(cloth);
		return new ResponseEntity<Cloth>(b, HttpStatus.OK);
		
	}

	/**
	 * Update cloth response entity.
	 *
	 * @param id    the id
	 * @param cloth the cloth
	 * @return the response entity
	 */
	@PutMapping("cloths/{id}")
	public ResponseEntity<Cloth> updateCloth(@PathVariable("id") int id, @RequestBody Cloth cloth){
		
		Cloth b = service.updateCloth(id, cloth);
		return new ResponseEntity<Cloth>(b, HttpStatus.OK);
	}

	/**
	 * Delete cloth response entity.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("cloths/{id}")
	public ResponseEntity<String> deleteCloth(@PathVariable("id") int id){
		boolean isDeleted = service.deleteCloth(id);
		if(isDeleted){
			String responseContent = "Cloth list has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleted list of clothes from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
