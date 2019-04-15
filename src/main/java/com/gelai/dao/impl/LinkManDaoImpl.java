package com.gelai.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.gelai.bean.LinkMan;
import com.gelai.dao.LinkManDao;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

//	public LinkManDaoImpl() {
//		super(LinkMan.class);
//	}

	/**
	 * 模糊查询加查询总记录数
	 */
//	@Override
//	public Integer findCount(DetachedCriteria detachedCriteria) {
//		detachedCriteria.setProjection(Projections.rowCount());
//		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
//		Integer count = 0;
//		if (list.size()>0) {
//			count = list.get(0).intValue();
//		}
//		return count;
//	}
	
	/**
	 * 模糊查询加分页查询
	 */
//	@Override
//	public List<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer begin,Integer pageSize) {
//		detachedCriteria.setProjection(null);
//		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
//		return list;
//	}

	/**
	 * 联系人添加
	 * @param linkMan
	 */
//	@Override
//	public void save(LinkMan linkMan) {
//		this.getHibernateTemplate().save(linkMan);
//	}

	/**
	 * 根据id查联系人
	 * @param lkm_id
	 * @return
	 */
//	@Override
//	public LinkMan finById(Long lkm_id) {
//		return this.getHibernateTemplate().get(LinkMan.class, lkm_id);
//	}

	/**
	 * 修改联系人
	 * @param linkMan
	 */
//	@Override
//	public void update(LinkMan linkMan) {
//		this.getHibernateTemplate().update(linkMan);
//	}

	/**
	 * 删除联系人
	 */
//	@Override
//	public void delete(LinkMan linkMan) {
//		this.getHibernateTemplate().delete(linkMan);
//	}

	
}
