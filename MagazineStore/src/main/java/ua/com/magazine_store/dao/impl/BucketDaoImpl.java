package ua.com.magazine_store.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ua.com.magazine_store.dao.BucketDao;
import ua.com.magazine_store.domain.Bucket;
import ua.com.magazine_store.shared.FactoryManager;
import ua.com.magazine_store.utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDao {
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Bucket create(Bucket bucket) {
		try {
			em.getTransaction().begin();
			em.persist(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try {
			bucket = em.find(Bucket.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public Bucket update(Bucket t) {
		throw new IllegalStateException("there is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		try {
			Bucket bucket = read(id);
			em.getTransaction().begin();
			em.remove(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bucket> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Bucket e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
