package ua.com.magazine_store.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import ua.com.magazine_store.dao.BucketDao;
import ua.com.magazine_store.dao.impl.BucketDaoImpl;
import ua.com.magazine_store.domain.Bucket;
import ua.com.magazine_store.service.BucketService;

public class BucketServiceImpl implements BucketService {

	private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
	private static BucketService bucketServiceImpl;

	private BucketDao bucketDao;

	private BucketServiceImpl() {
		this.bucketDao = new BucketDaoImpl();
	}

	public static BucketService getBucketService() {
		if (bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}
		return bucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket t) {
		return bucketDao.create(t);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket t) {
		return bucketDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

}
