package grafana.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grafana.entity.Ta_typ;
import grafana.repo.Ta_TypRepo;

@Service
public class Ta_typServiceImpl implements Ta_typService {

	@Autowired
	private Ta_TypRepo ta_typDAO;

	@Override
	@Transactional
	public List<Ta_typ> findAll() {

		return ta_typDAO.findAll();
	}

	

	@Override
	public void save(Ta_typ ta_typ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}



	@Override
	public Ta_typ findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
