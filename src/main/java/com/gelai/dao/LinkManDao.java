package com.gelai.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gelai.bean.LinkMan;

public interface LinkManDao extends BaseDao<LinkMan>{
	
	/**
	 * 模糊查询加分页查询
	 */
	//public Integer findCount(DetachedCriteria detachedCriteria);
	
	/**
	 * 模糊查询加分页查询
	 */
	//public List<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer current,Integer pageSize);

	/**
	 * 联系人添加
	 * @param linkMan
	 */
	//public void save(LinkMan linkMan);
	
	/**
	 * 根据id查联系人
	 * @param lkm_id
	 * @return
	 */
	//public LinkMan finById(Long lkm_id);

	/**
	 * 修改联系人
	 * @param linkMan
	 */
	//public void update(LinkMan linkMan);

	/**
	 * 删除联系人
	 */
	//public void delete(LinkMan linkMan);

}
