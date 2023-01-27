package com.clothstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clothstore.entity.Cloth;

/**
 * The type Cloth store.
 */
@Transactional
@Repository
public abstract class ClothStore implements IClothSTore {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all books available in database and return it as List<Book>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cloth> getCloths() {
		
		String hql = "FROM cloth as english ORDER BY english.id";
		return (List<Cloth>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Book detail by given book id 
	 */
	@Override
	public Cloth getCloth(int clothId) {
		
		return entityManager.find(Cloth.class, clothId);
	}

	/**
	 * This method is responsible to create new book in database
	 */
	@Override
	public Cloth createCLoth(Cloth cloth) {
		entityManager.persist(cloth);
		Cloth b = getLastInsertedCloth();
		return b;
	}

	/**
	 * This method is responsible to update book detail in database
	 */
	@Override
	public Cloth updateCloth(int clothId, Cloth cloth) {
		
		//First We are taking Book detail from database by given book id and 
		// then updating detail with provided book object
		Cloth clothFromDB = getCloth(clothId);
		clothFromDB.setName(cloth.getName());
		clothFromDB.setPrice(cloth.getPrice());
		clothFromDB.setCategory(cloth.getCategory());
		
		entityManager.flush();
		
		//again i am taking updated result of clothes and returning the cloth object
		Cloth updatedCloth = getCloth(clothId);
		
		return updatedCloth;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteCloth(int clothId) {
		Cloth cloth = getCloth(clothId);
		entityManager.remove(cloth);

		boolean status = entityManager.contains(cloth);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Book class
	 * @return book
	 */
	private Cloth getLastInsertedCloth(){
		String hql = "from cloth order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Cloth cloth = (Cloth)query.getSingleResult();
		return cloth;
	}

}
