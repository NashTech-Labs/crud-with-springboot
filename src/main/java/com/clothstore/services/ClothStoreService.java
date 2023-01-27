package com.clothstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothstore.dao.IClothSTore;
import com.clothstore.entity.Cloth;

/**
 * The type Cloth store service.
 */
@Service
public class ClothStoreService implements IClothStoreService {
	
	@Autowired
	private IClothSTore dao;

	@Override
	public List<Cloth> getCloths() {
		return dao.getCloths();
	}

	@Override
	public Cloth createCloth(Cloth cloth) {
		return dao.createCloth(cloth);
	}

	@Override
	public Cloth updateCloth(int clothId, Cloth cloth) {
		return dao.updateCloth(clothId, cloth);
	}

	@Override
	public Cloth getCloth(int clothId) {
		return dao.getCloth(clothId);
	}

	@Override
	public boolean deleteCloth(int clothId) {
		return dao.deleteCloth(clothId);
	}

}
