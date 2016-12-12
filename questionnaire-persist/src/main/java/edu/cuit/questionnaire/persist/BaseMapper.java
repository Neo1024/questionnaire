package edu.cuit.questionnaire.persist;

/**
 * 
 * @author lixin
 * @date Apr 13, 2016
 *
 */
public interface BaseMapper<T> {

	public void save(T t);

	public T findById(Long id);

	public void update(T t);

}
