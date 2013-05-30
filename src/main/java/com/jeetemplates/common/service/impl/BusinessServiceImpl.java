/**
 * 
 */
package com.jeetemplates.common.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeetemplates.common.model.BusinessEntity;
import com.jeetemplates.common.persistence.BusinessDao;
import com.jeetemplates.common.service.BusinessService;

/**
 * Implementation of {@link BusinessService}
 * 
 * @author jeetemplates
 */
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public abstract class BusinessServiceImpl<BE extends BusinessEntity> implements BusinessService<BE> {

	/**
	 * Class of BusinessEntity.
	 */
	// private Class<BE> persistentClass = (Class<BE>) ((ParameterizedType)
	// getClass().getGenericSuperclass()).getActualTypeArguments()[1];

	/**
	 * Get the business dao.
	 * 
	 * @return busines dao
	 */
	protected abstract BusinessDao<BE> getDao();

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void create(BE e) {
		getDao().create(e);
	}

	@Override
	public List<BE> retrieveAll() {
		return getDao().retrieveAll();
	}

	@Override
	public BE retrieveById(Long id) {
		return getDao().retrieveById(id);
	}

}
