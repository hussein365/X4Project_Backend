package grafana.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import grafana.entity.Bmx_masterdata_ta;

public interface Bmx_masterdata_taRepo2 {
	public List<Bmx_masterdata_ta> filterbyTa_typundta(String ta_typ, String ta);
	
	public List<Bmx_masterdata_ta>filterByTa(String ta);
	
	public List<Bmx_masterdata_ta> filterbyTa_typundta2(String ta_typ, String ta_from,String ta_until);
	public Page<Bmx_masterdata_ta> filterbyTa_typ(int[]ta_typs,Pageable pageable);

	
}
