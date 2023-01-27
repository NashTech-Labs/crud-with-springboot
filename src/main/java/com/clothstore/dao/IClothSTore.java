package com.clothstore.dao;

import java.util.List;

import com.clothstore.entity.Cloth;

/**
 * The interface Cloth s tore.
 */
public interface IClothSTore {

	/**
	 * Gets cloths.
	 *
	 * @return the cloths
	 */
	List<Cloth> getCloths();

	/**
	 * Gets cloth.
	 *
	 * @param clothId the cloth id
	 * @return the cloth
	 */
	Cloth getCloth(int clothId);

	/**
	 * Create cloth cloth.
	 *
	 * @param cloth the cloth
	 * @return the cloth
	 */
	Cloth createCloth(Cloth cloth);

	/**
	 * Create c loth cloth.
	 *
	 * @param cloth the cloth
	 * @return the cloth
	 */
	Cloth createCLoth(Cloth cloth);

	/**
	 * Update cloth cloth.
	 *
	 * @param clothId the cloth id
	 * @param cloth   the cloth
	 * @return the cloth
	 */
	Cloth updateCloth(int clothId, Cloth cloth);

	/**
	 * Deletec c loth boolean.
	 *
	 * @param clothId the cloth id
	 * @return the boolean
	 */
	boolean deletecCLoth(int clothId);

	/**
	 * Delete cloth boolean.
	 *
	 * @param clothId the cloth id
	 * @return the boolean
	 */
	boolean deleteCloth(int clothId);
}
