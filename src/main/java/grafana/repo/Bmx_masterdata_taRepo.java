package grafana.repo;



import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grafana.entity.Bmx_masterdata_ta;
import grafana.entity.Ta_typ;
@Repository
public interface Bmx_masterdata_taRepo extends JpaRepository<Bmx_masterdata_ta, String> {
	Page<Bmx_masterdata_ta> findAll(Pageable pageable);
	//Page<Bmx_masterdata_ta> findByTa(int ta, Pageable pageable);
	Page<Bmx_masterdata_ta> findByTatyp(Ta_typ tatyp,Pageable pageable);
	Page<Bmx_masterdata_ta> findByTatypEqualsAndTaGreaterThanEqualAndTaLessThanEqual(Ta_typ tatyp,int ta_from,int ta_until,Pageable pageable);
	Page<Bmx_masterdata_ta> findByTatypEqualsAndTaGreaterThanEqual(Ta_typ tatyp,int ta_from,Pageable pageable);
	Page<Bmx_masterdata_ta> findByTatypEqualsAndTaLessThanEqual(Ta_typ tatyp,int ta_until,Pageable pageable);
	Page<Bmx_masterdata_ta> findByTa(int ta,Pageable pageable);
	Page<Bmx_masterdata_ta> findByTatypAndTa(Ta_typ ta_typ,int ta,Pageable pageable);
	
	
	Page<Bmx_masterdata_ta> findByTatypIn(List<Ta_typ> ta_typs,Pageable pageable);
	Page<Bmx_masterdata_ta> findByTatypInAndTaGreaterThanEqualAndTaLessThanEqual(List<Ta_typ> ta_typs,int ta_from,int ta_until,Pageable pageable);
	Page<Bmx_masterdata_ta> findByTatypInAndTaGreaterThanEqual(List<Ta_typ> ta_typs,int ta_from,Pageable pageable);
	Page<Bmx_masterdata_ta> findByTatypInAndTaLessThanEqual(List<Ta_typ> ta_typs,int ta_until,Pageable pageable);
	Page<Bmx_masterdata_ta> findByTatypInAndTaIn(List<Ta_typ>ta_typs,List<Integer> tas,Pageable pageable);
	
	
	Page<Bmx_masterdata_ta> findByType0In(List<String>type0s,Pageable pageable);
	Page<Bmx_masterdata_ta> findByType0InAndType1InAndName1Equals(List<String>type0s,List<String>type1s,String name1,Pageable pageable);


	Page<Bmx_masterdata_ta> findByType0AndType1AndName1AndLevel(String type_0,String type_1,String name_1,int level,Pageable pageable);
	Page<Bmx_masterdata_ta> findByType0AndType1AndName1AndType2AndName2AndLevel(String type_0,String type_1,String name_1,String type_2,String name_2,int level,Pageable pageable);
	Page<Bmx_masterdata_ta> findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndLevel(String type_0,String type_1,String name_1,String type_2,String name_2,String type_3,String name_3,int level,Pageable pageable);
	Page<Bmx_masterdata_ta> findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndLevel(String type_0,String type_1,String name_1,String type_2,String name_2,String type_3,String name_3,String type_4,String name_4,int level,Pageable pageable);
	Page<Bmx_masterdata_ta> findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndLevel(String type_0,String type_1,String name_1,String type_2,String name_2,String type_3,String name_3,String type_4,String name_4,String type_5,String name_5,int level,Pageable pageable);

	Page<Bmx_masterdata_ta> findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndType6AndName6AndLevel(String type_0,String type_1,String name_1,String type_2,String name_2,String type_3,String name_3,String type_4,String name_4,String type_5,String name_5,String type_6,String name_6,int level,Pageable pageable);
	Page<Bmx_masterdata_ta> findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndType6AndName6AndType7AndName7AndLevel(String type_0,String type_1,String name_1,String type_2,String name_2,String type_3,String name_3,String type_4,String name_4,String type_5,String name_5,String type_6,String name_6,String type_7,String name_7,int level,Pageable pageable);
	Page<Bmx_masterdata_ta> findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndType6AndName6AndType7AndName7AndType8AndName8AndLevel(String type_0,String type_1,String name_1,String type_2,String name_2,String type_3,String name_3,String type_4,String name_4,String type_5,String name_5,String type_6,String name_6,String type_7,String name_7,String type_8,String name_8,int level,Pageable pageable);

	Page<Bmx_masterdata_ta> findByLevel(int level,Pageable pageable);



}
