package fr.eni.ecole.dal;

import java.util.List;

public interface CRUD<T> 
{
	void insert(T item);
	List<T> selectAll();
	T selectById(int id);
	void update(T item);
	void delete(T item);
}
