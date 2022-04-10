package grafana.service;

import java.util.List;

import grafana.entity.Ta_typ;

public interface Ta_typService {

	public List<Ta_typ> findAll();

	public Ta_typ findById(int id);

	public void save(Ta_typ ta_typ);

	public void deleteById(int id);
}
