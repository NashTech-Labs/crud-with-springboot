package com.clothstore.services;

import java.util.List;

import com.clothstore.entity.Cloth;

/**
 * The interface Cloth store service.
 */
public interface IClothStoreService {

	/**
	 * Gets cloths.
	 *
	 * @return the cloths
	 */
	List<Cloth> getCloths();

	/**
	 * Create cloth cloth.
	 *
	 * @param cloth the cloth
	 * @return the cloth
	 */
	Cloth createCloth(Cloth cloth);

	/**
	 * Update cloth cloth.
	 *
	 * @param clothId the cloth id
	 * @param cloth   the cloth
	 * @return the cloth
	 */
	Cloth updateCloth(int clothId, Cloth cloth);

	/**
	 * Gets cloth.
	 *
	 * @param clothId the cloth id
	 * @return the cloth
	 */
	Cloth getCloth(int clothId);

	/**
	 * Delete cloth boolean.
	 *
	 * @param clothId the cloth id
	 * @return the boolean
	 */
	boolean deleteCloth(int clothId);

}
