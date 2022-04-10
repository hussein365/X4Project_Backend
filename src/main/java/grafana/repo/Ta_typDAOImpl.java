package grafana.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grafana.entity.Ta_typ;

@Repository
public class Ta_typDAOImpl implements Ta_typDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Ta_typ> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Ta_typ> theQuery = currentSession.createQuery("from Ta_typ", Ta_typ.class);

		return theQuery.getResultList();
	}

	@Override
	public Ta_typ findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Ta_typ theTa_typ = currentSession.get(Ta_typ.class, id);

		return theTa_typ;
	}

	@Override
	public void save(Ta_typ ta_typ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

}
