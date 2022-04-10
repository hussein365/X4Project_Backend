package grafana.restcontroller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import grafana.entity.Bmx_masterdata_ta;
import grafana.entity.Ta_typ;
import grafana.entity.Ta_typandTa;
import grafana.entity.Type0Type1;
import grafana.repo.Bmx_masterdata_taRepo;
import grafana.repo.Bmx_masterdata_taRepo2;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Bmx_masterdata_taRestController {

	@Autowired
	private Bmx_masterdata_taRepo bmx_masterdata_taRepo;

	@Autowired
	private Bmx_masterdata_taRepo2 bmx_masterdata_taRepo2;

	@GetMapping("/bmx_masterdata_ta")
	public List<Bmx_masterdata_ta> findAll() {
		return bmx_masterdata_taRepo.findAll();
	}

	@GetMapping("/Tree TA_TYP TA2")
	public List<Bmx_masterdata_ta> filterwithta_typundta2(@RequestParam("ta_typ") String ta_typ,
			@RequestParam("ta_from") String ta_from, @RequestParam("ta_until") String ta_until) {
		return bmx_masterdata_taRepo2.filterbyTa_typundta2(ta_typ, ta_from, ta_until);
	}

	@GetMapping("/Tree TA_TYP TA")
	public List<Bmx_masterdata_ta> filterwithta_typundta(@RequestParam("ta_typ") String ta_typ,
			@RequestParam("ta") String ta) {
		return bmx_masterdata_taRepo2.filterbyTa_typundta(ta_typ, ta);
	}

	@GetMapping("/Tree TA")
	public List<Bmx_masterdata_ta> filterwithta(@RequestParam("ta") int ta) {
		List<Bmx_masterdata_ta> result = new ArrayList<Bmx_masterdata_ta>();
		for (Bmx_masterdata_ta data : bmx_masterdata_taRepo.findAll()) {
			if (data.getTa() == ta) {
				result.add(data);
			}
		}
		return result;
	}

	@GetMapping("/bmx_masterdata_ta/{oid}")
	public Bmx_masterdata_ta findById(@PathVariable String oid) {
		if (bmx_masterdata_taRepo.existsById(oid)) {
			return bmx_masterdata_taRepo.findById(oid).get();
		} else {
			return null;
		}

	}

	@DeleteMapping("/bmx_masterdata_ta/{oid}")
	public String deleteById(@PathVariable String oid) {

		if (bmx_masterdata_taRepo.existsById(oid)) {
			bmx_masterdata_taRepo.deleteById(oid);
			return "Bmx_masterdata_ta with oid= " + oid + " succeffuly deleted";
		} else {
			return "Bmx_masterdata_ta with oid= " + oid + " not found";
		}
	}

	@PostMapping("/bmx_masterdata_ta")
	public Bmx_masterdata_ta addBmx_master_ta(@RequestBody Bmx_masterdata_ta bmx_masterdata_ta) {
		return bmx_masterdata_taRepo.save(bmx_masterdata_ta);

	}

	@GetMapping("/page_bmx_masterdata_ta")
	public Page<Bmx_masterdata_ta> findAll(Pageable pageable) {
		return bmx_masterdata_taRepo.findAll(pageable);
	}

	@GetMapping("/page_bmx_masterdata_tabyta/{ta}")
	public Page<Bmx_masterdata_ta> findByTa(@PathVariable int ta, Pageable pageable) {

		return bmx_masterdata_taRepo.findByTa(ta, pageable);
	}

	@PostMapping("/page_bmx_masterdata_tabyta_typ")
	public Page<Bmx_masterdata_ta> findByTaTyp(@RequestBody Ta_typ ta_typ, Pageable pageable) {

		return bmx_masterdata_taRepo.findByTatyp(ta_typ, pageable);
	}

	@PostMapping("/page_bmx_masterdata_tabyta_typs")
	public Page<Bmx_masterdata_ta> findByTaTyps(@RequestBody Ta_typ[] ta_typs, Pageable pageable) {

		List<Bmx_masterdata_ta> result = new ArrayList<Bmx_masterdata_ta>();
		for (Ta_typ ta_typ : ta_typs) {
			int totalPages = bmx_masterdata_taRepo.findByTatyp(ta_typ, pageable).getTotalPages();
			int pageSize = bmx_masterdata_taRepo.findByTatyp(ta_typ, pageable).getSize();
			long totalElements = bmx_masterdata_taRepo.findByTatyp(ta_typ, pageable).getTotalElements();
			System.out.println(totalPages);
			System.out.println(pageSize);
			int pages = (int) (totalElements / 1000) + 1;
			System.out.println(pages);
			for (int i = 0; i < pages; i++) {

				List<Bmx_masterdata_ta> list = bmx_masterdata_taRepo.findByTatyp(ta_typ, PageRequest.of(i, 1000))
						.getContent();
				for (Bmx_masterdata_ta data : list) {
					result.add(data);
				}
			}
		}
		return new PageImpl<Bmx_masterdata_ta>(result, pageable, result.size());
	}

	@PostMapping("/page_bmx_masterdata_tabyta_typandta")
	public Page<Bmx_masterdata_ta> findByTaTypandTa(@RequestBody Ta_typ ta_typ,
			@RequestParam(required = false, name = "ta_from") String ta_from,
			@RequestParam(required = false, name = "ta_until") String ta_until, Pageable pageable) {
		if (ta_until == null && ta_from == null) {
			return bmx_masterdata_taRepo.findByTatyp(ta_typ, pageable);
		}
		if (ta_until == null) {
			return bmx_masterdata_taRepo.findByTatypEqualsAndTaGreaterThanEqual(ta_typ, Integer.parseInt(ta_from),
					pageable);
		}
		if (ta_from == null) {
			return bmx_masterdata_taRepo.findByTatypEqualsAndTaLessThanEqual(ta_typ, Integer.parseInt(ta_until),
					pageable);
		}

		return bmx_masterdata_taRepo.findByTatypEqualsAndTaGreaterThanEqualAndTaLessThanEqual(ta_typ,
				Integer.parseInt(ta_from), Integer.parseInt(ta_until), pageable);

	}

	@PostMapping("/page_bmx_masterdata_tabyta_typsandta")
	public Page<Bmx_masterdata_ta> findByTaTypsAndTa(@RequestBody Ta_typ[] ta_typs,
			@RequestParam(required = false, name = "ta_from") String ta_from,
			@RequestParam(required = false, name = "ta_until") String ta_until,
			@RequestParam(required = false, name = "PageSize") int PageSize,
			@RequestParam(required = false, name = "PageNo") int page_number) {

		Pageable pageable = PageRequest.of(page_number, PageSize);
		List<Bmx_masterdata_ta> result = new ArrayList<Bmx_masterdata_ta>();
		if (ta_until == null && ta_from == null) {
			System.out.println("ta_from is null and ta_until is null");
			for (Ta_typ ta_typ : ta_typs) {

				int totalPages = bmx_masterdata_taRepo.findByTatyp(ta_typ, pageable).getTotalPages();
				int pageSize = bmx_masterdata_taRepo.findByTatyp(ta_typ, pageable).getSize();
				long totalElements = bmx_masterdata_taRepo.findByTatyp(ta_typ, pageable).getTotalElements();
				System.out.println(totalPages);
				System.out.println(pageSize);
				int pages = (int) (totalElements / 1000) + 1;
				System.out.println(pages);
				for (int i = 0; i < pages; i++) {

					List<Bmx_masterdata_ta> list = bmx_masterdata_taRepo.findByTatyp(ta_typ, PageRequest.of(i, 1000))
							.getContent();
					for (Bmx_masterdata_ta data : list) {
						result.add(data);
					}
				}
			}
		}

		if (ta_until == null && ta_from != null) {
			System.err.println("ta_until is null");
			for (Ta_typ ta_typ : ta_typs) {

				int totalPages = bmx_masterdata_taRepo
						.findByTatypEqualsAndTaGreaterThanEqual(ta_typ, Integer.parseInt(ta_from), pageable)
						.getTotalPages();
				int pageSize = bmx_masterdata_taRepo
						.findByTatypEqualsAndTaGreaterThanEqual(ta_typ, Integer.parseInt(ta_from), pageable).getSize();
				long totalElements = bmx_masterdata_taRepo
						.findByTatypEqualsAndTaGreaterThanEqual(ta_typ, Integer.parseInt(ta_from), pageable)
						.getTotalElements();
				System.out.println(totalPages);
				System.out.println(pageSize);
				int pages = (int) (totalElements / 1000) + 1;
				System.out.println(pages);
				for (int i = 0; i < pages; i++) {

					List<Bmx_masterdata_ta> list = bmx_masterdata_taRepo.findByTatypEqualsAndTaGreaterThanEqual(ta_typ,
							Integer.parseInt(ta_from), PageRequest.of(i, 1000)).getContent();
					for (Bmx_masterdata_ta data : list) {
						result.add(data);
					}
				}
			}
		}
		if (ta_from == null && ta_until != null) {

			System.out.println("ta_from is null");
			for (Ta_typ ta_typ : ta_typs) {

				int totalPages = bmx_masterdata_taRepo
						.findByTatypEqualsAndTaLessThanEqual(ta_typ, Integer.parseInt(ta_until), pageable)
						.getTotalPages();
				int pageSize = bmx_masterdata_taRepo
						.findByTatypEqualsAndTaLessThanEqual(ta_typ, Integer.parseInt(ta_until), pageable).getSize();
				long totalElements = bmx_masterdata_taRepo
						.findByTatypEqualsAndTaLessThanEqual(ta_typ, Integer.parseInt(ta_until), pageable)
						.getTotalElements();
				System.out.println(totalPages);
				System.out.println(pageSize);
				int pages = (int) (totalElements / 1000) + 1;
				System.out.println(pages);
				for (int i = 0; i < pages; i++) {

					List<Bmx_masterdata_ta> list = bmx_masterdata_taRepo.findByTatypEqualsAndTaLessThanEqual(ta_typ,
							Integer.parseInt(ta_until), PageRequest.of(i, 1000)).getContent();
					for (Bmx_masterdata_ta data : list) {
						result.add(data);
					}
				}
			}
		}
		if (ta_from != null && ta_until != null) {
			System.out.println("ta_from and ta_until are not null");
			for (Ta_typ ta_typ : ta_typs) {

				int totalPages = bmx_masterdata_taRepo.findByTatypEqualsAndTaGreaterThanEqualAndTaLessThanEqual(ta_typ,
						Integer.parseInt(ta_from), Integer.parseInt(ta_until), pageable).getTotalPages();
				int pageSize = bmx_masterdata_taRepo.findByTatypEqualsAndTaGreaterThanEqualAndTaLessThanEqual(ta_typ,
						Integer.parseInt(ta_from), Integer.parseInt(ta_until), pageable).getSize();
				long totalElements = bmx_masterdata_taRepo.findByTatypEqualsAndTaGreaterThanEqualAndTaLessThanEqual(
						ta_typ, Integer.parseInt(ta_from), Integer.parseInt(ta_until), pageable).getTotalElements();
				System.out.println(totalPages);
				System.out.println(pageSize);
				int pages = (int) (totalElements / 1000) + 1;
				System.out.println(pages);
				for (int i = 0; i < pages; i++) {

					List<Bmx_masterdata_ta> list = bmx_masterdata_taRepo
							.findByTatypEqualsAndTaGreaterThanEqualAndTaLessThanEqual(ta_typ, Integer.parseInt(ta_from),
									Integer.parseInt(ta_until), PageRequest.of(i, 1000))
							.getContent();
					for (Bmx_masterdata_ta data : list) {
						result.add(data);
					}
				}
			}
		}

		return new PageImpl<Bmx_masterdata_ta>(result, pageable, result.size());
	}

	@PostMapping("/page_bmx_masterdata_tabyta_typsandtas")
	public Page<Bmx_masterdata_ta> findByTaTypsAndTas(@RequestBody Ta_typandTa ta_typandta, Pageable pageable) {

		List<Bmx_masterdata_ta> result = new ArrayList<Bmx_masterdata_ta>();
		for (Ta_typ ta_typ : ta_typandta.getTa_typs()) {
			for (int ta : ta_typandta.getTas()) {
				int totalPages = bmx_masterdata_taRepo.findByTatypAndTa(ta_typ, ta, pageable).getTotalPages();
				int pageSize = bmx_masterdata_taRepo.findByTatypAndTa(ta_typ, ta, pageable).getSize();
				long totalElements = bmx_masterdata_taRepo.findByTatypAndTa(ta_typ, ta, pageable).getTotalElements();
				System.out.println(totalPages);
				System.out.println(pageSize);
				int pages = (int) (totalElements / 1000) + 1;
				System.out.println(pages);
				for (int i = 0; i < pages; i++) {

					List<Bmx_masterdata_ta> list = bmx_masterdata_taRepo
							.findByTatypAndTa(ta_typ, ta, PageRequest.of(i, 1000)).getContent();
					for (Bmx_masterdata_ta data : list) {
						result.add(data);
					}
				}
			}
		}
		return new PageImpl<Bmx_masterdata_ta>(result, pageable, result.size());

	}

	@PostMapping("/page_bmx_masterdata_tabyta_typs2")
	public Page<Bmx_masterdata_ta> findByTaTyps2(@RequestBody Ta_typ[] ta_typs, Pageable pageable) {

		return bmx_masterdata_taRepo.findByTatypIn(Arrays.asList(ta_typs), pageable);
	}

	@PostMapping("/page_bmx_masterdata_tabyta_typsandta2")
	public Page<Bmx_masterdata_ta> findByTaTypsAndTa2(@RequestBody Ta_typ[] ta_typs,
			@RequestParam(required = false, name = "ta_from") String ta_from,
			@RequestParam(required = false, name = "ta_until") String ta_until, Pageable pageable) {

		if (ta_until == null && ta_from == null) {
			System.out.println("ta_from is null and ta_until is null");
			return bmx_masterdata_taRepo.findByTatypIn(Arrays.asList(ta_typs), pageable);
		}

		if (ta_until == null && ta_from != null) {
			System.out.println("ta_until is null");
			return bmx_masterdata_taRepo.findByTatypInAndTaGreaterThanEqual(Arrays.asList(ta_typs),
					Integer.parseInt(ta_from), pageable);
		}
		if (ta_from == null && ta_until != null) {

			System.out.println("ta_from is null");
			return bmx_masterdata_taRepo.findByTatypInAndTaLessThanEqual(Arrays.asList(ta_typs),
					Integer.parseInt(ta_until), pageable);

		}
		if (ta_from != null && ta_until != null) {
			System.out.println("ta_from and ta_until are not null");
			return bmx_masterdata_taRepo.findByTatypInAndTaGreaterThanEqualAndTaLessThanEqual(Arrays.asList(ta_typs),
					Integer.parseInt(ta_from), Integer.parseInt(ta_until), pageable);
		}
		return null;

	}

	@PostMapping("/page_bmx_masterdata_tabyta_typsandtas2")
	public Page<Bmx_masterdata_ta> findByTaTypsAndTas2(@RequestBody Ta_typandTa ta_typandta, Pageable pageable) {

		return bmx_masterdata_taRepo.findByTatypInAndTaIn(Arrays.asList(ta_typandta.getTa_typs()),
				Arrays.asList(ta_typandta.getTas()), pageable);

	}

	@PostMapping("/page_bmx_masterdata_taby_type_0")
	public Page<Bmx_masterdata_ta> findByType_0(@RequestBody String[] type_0s, Pageable pageable) {

		return bmx_masterdata_taRepo.findByType0In(Arrays.asList(type_0s), pageable);
	}

	@PostMapping("/page_bmx_masterdata_ta_level_1`")
	public Page<Bmx_masterdata_ta> findByType_0(@RequestBody Type0Type1 type_0type_1,
			@RequestParam(required = false, name = "name1") String name1, Pageable pageable) {

		return bmx_masterdata_taRepo.findByType0InAndType1InAndName1Equals(Arrays.asList(type_0type_1.getType0s()),
				Arrays.asList(type_0type_1.getType1s()), name1, pageable);
	}

	@GetMapping("/page_bmx_masterdata_ta_level_11") 
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Level1(@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1, Pageable pageable) {

	return bmx_masterdata_taRepo.findByType0AndType1AndName1AndLevel(type_0, type_1, name_1, 1, pageable);
	}
	@GetMapping("/page_bmx_masterdata_ta_level_2") 
	public Page<Bmx_masterdata_ta> findByType0Type1Name1(@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1, Pageable pageable) {
		return bmx_masterdata_taRepo.findByType0AndType1AndName1AndLevel(type_0, type_1, name_1, 2, pageable);
	}
	@GetMapping("/page_bmx_masterdata_ta_level_22") 
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Level2(@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,Pageable pageable) {
		return bmx_masterdata_taRepo.findByType0AndType1AndName1AndType2AndName2AndLevel(type_0, type_1, name_1,type_2,name_2, 2, pageable);
	}

	@GetMapping("/page_bmx_masterdata_ta_level_3")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2, Pageable pageable) {
		return bmx_masterdata_taRepo.findByType0AndType1AndName1AndType2AndName2AndLevel(type_0, type_1, name_1, type_2,
				name_2, 3, pageable);
	}
	
	@GetMapping("/page_bmx_masterdata_ta_level_33")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Level3(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3, Pageable pageable) {
		return bmx_masterdata_taRepo.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndLevel(type_0, type_1,
				name_1, type_2, name_2, type_3, name_3, 3, pageable);
	}

	@GetMapping("/page_bmx_masterdata_ta_level_4")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3, Pageable pageable) {
		return bmx_masterdata_taRepo.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndLevel(type_0, type_1,
				name_1, type_2, name_2, type_3, name_3, 4, pageable);
	}
	@GetMapping("/page_bmx_masterdata_ta_level_44")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Type4Name4Level4(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3,
			@RequestParam(required = false, name = "type_4") String type_4,
			@RequestParam(required = false, name = "name_4") String name_4, Pageable pageable) {
		return bmx_masterdata_taRepo
				.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndLevel(type_0, type_1,
						name_1, type_2, name_2, type_3, name_3, type_4, name_4, 4, pageable);
	}

	@GetMapping("/page_bmx_masterdata_ta_level_5")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Type4Name4(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3,
			@RequestParam(required = false, name = "type_4") String type_4,
			@RequestParam(required = false, name = "name_4") String name_4, Pageable pageable) {
		return bmx_masterdata_taRepo
				.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndLevel(type_0, type_1,
						name_1, type_2, name_2, type_3, name_3, type_4, name_4, 5, pageable);
	}
	
	@GetMapping("/page_bmx_masterdata_ta_level_55")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Type4Name4Type5Name5Level5(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3,
			@RequestParam(required = false, name = "type_4") String type_4,
			@RequestParam(required = false, name = "name_4") String name_4,
			@RequestParam(required = false, name = "type_5") String type_5,
			@RequestParam(required = false, name = "name_5") String name_5, Pageable pageable) {

		return bmx_masterdata_taRepo
				.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndLevel(
						type_0, type_1, name_1, type_2, name_2, type_3, name_3, type_4, name_4, type_5, name_5, 5,
						pageable);

	}

	@GetMapping("/page_bmx_masterdata_ta_level_6")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Type4Name4Type5Name5(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3,
			@RequestParam(required = false, name = "type_4") String type_4,
			@RequestParam(required = false, name = "name_4") String name_4,
			@RequestParam(required = false, name = "type_5") String type_5,
			@RequestParam(required = false, name = "name_5") String name_5, Pageable pageable) {

		return bmx_masterdata_taRepo
				.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndLevel(
						type_0, type_1, name_1, type_2, name_2, type_3, name_3, type_4, name_4, type_5, name_5, 6,
						pageable);

	}
	@GetMapping("/page_bmx_masterdata_ta_level_66")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Type4Name4Type5Name5Type6Name6Level6(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3,
			@RequestParam(required = false, name = "type_4") String type_4,
			@RequestParam(required = false, name = "name_4") String name_4,
			@RequestParam(required = false, name = "type_5") String type_5,
			@RequestParam(required = false, name = "name_5") String name_5,
			@RequestParam(required = false, name = "type_6") String type_6,
			@RequestParam(required = false, name = "name_6") String name_6, Pageable pageable) {
		return bmx_masterdata_taRepo
				.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndType6AndName6AndLevel(
						type_0, type_1, name_1, type_2, name_2, type_3, name_3, type_4, name_4, type_5, name_5, type_6,
						name_6, 6, pageable);
	}

	@GetMapping("/page_bmx_masterdata_ta_level_7")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Type4Name4Type5Name5Type6Name6(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3,
			@RequestParam(required = false, name = "type_4") String type_4,
			@RequestParam(required = false, name = "name_4") String name_4,
			@RequestParam(required = false, name = "type_5") String type_5,
			@RequestParam(required = false, name = "name_5") String name_5,
			@RequestParam(required = false, name = "type_6") String type_6,
			@RequestParam(required = false, name = "name_6") String name_6, Pageable pageable) {
		return bmx_masterdata_taRepo
				.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndType6AndName6AndLevel(
						type_0, type_1, name_1, type_2, name_2, type_3, name_3, type_4, name_4, type_5, name_5, type_6,
						name_6, 7, pageable);
	}
	@GetMapping("/page_bmx_masterdata_ta_level_77")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Type4Name4Type5Name5Type6Name6Type7Name7Level7(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3,
			@RequestParam(required = false, name = "type_4") String type_4,
			@RequestParam(required = false, name = "name_4") String name_4,
			@RequestParam(required = false, name = "type_5") String type_5,
			@RequestParam(required = false, name = "name_5") String name_5,
			@RequestParam(required = false, name = "type_6") String type_6,
			@RequestParam(required = false, name = "name_6") String name_6,
			@RequestParam(required = false, name = "type_7") String type_7,
			@RequestParam(required = false, name = "name_7") String name_7, Pageable pageable) {
		return bmx_masterdata_taRepo
				.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndType6AndName6AndType7AndName7AndLevel(
						type_0, type_1, name_1, type_2, name_2, type_3, name_3, type_4, name_4, type_5, name_5, type_6,
						name_6, type_7, name_7, 7, pageable);
	}


	@GetMapping("/page_bmx_masterdata_ta_level_8")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Type4Name4Type5Name5Type6Name6Type7Name7(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3,
			@RequestParam(required = false, name = "type_4") String type_4,
			@RequestParam(required = false, name = "name_4") String name_4,
			@RequestParam(required = false, name = "type_5") String type_5,
			@RequestParam(required = false, name = "name_5") String name_5,
			@RequestParam(required = false, name = "type_6") String type_6,
			@RequestParam(required = false, name = "name_6") String name_6,
			@RequestParam(required = false, name = "type_7") String type_7,
			@RequestParam(required = false, name = "name_7") String name_7, Pageable pageable) {
		return bmx_masterdata_taRepo
				.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndType6AndName6AndType7AndName7AndLevel(
						type_0, type_1, name_1, type_2, name_2, type_3, name_3, type_4, name_4, type_5, name_5, type_6,
						name_6, type_7, name_7, 8, pageable);
	}
	@GetMapping("/page_bmx_masterdata_ta_level_88")
	public Page<Bmx_masterdata_ta> findByType0Type1Name1Type2Name2Type3Name3Type4Name4Type5Name5Type6Name6Type7Name7Type8Name8Level8(
			@RequestParam(required = false, name = "type_0") String type_0,
			@RequestParam(required = false, name = "type_1") String type_1,
			@RequestParam(required = false, name = "name_1") String name_1,
			@RequestParam(required = false, name = "type_2") String type_2,
			@RequestParam(required = false, name = "name_2") String name_2,
			@RequestParam(required = false, name = "type_3") String type_3,
			@RequestParam(required = false, name = "name_3") String name_3,
			@RequestParam(required = false, name = "type_4") String type_4,
			@RequestParam(required = false, name = "name_4") String name_4,
			@RequestParam(required = false, name = "type_5") String type_5,
			@RequestParam(required = false, name = "name_5") String name_5,
			@RequestParam(required = false, name = "type_6") String type_6,
			@RequestParam(required = false, name = "name_6") String name_6,
			@RequestParam(required = false, name = "type_7") String type_7,
			@RequestParam(required = false, name = "name_7") String name_7,
			@RequestParam(required = false, name = "type_8") String type_8,
			@RequestParam(required = false, name = "name_8") String name_8, Pageable pageable) {
		return bmx_masterdata_taRepo
				.findByType0AndType1AndName1AndType2AndName2AndType3AndName3AndType4AndName4AndType5AndName5AndType6AndName6AndType7AndName7AndType8AndName8AndLevel(
						type_0, type_1, name_1, type_2, name_2, type_3, name_3, type_4, name_4, type_5, name_5, type_6,
						name_6, type_7, name_7,type_8,name_8, 8, pageable);
	}

	@GetMapping("/page_bmx_masterdata_ta_findByLevel")
	public Page<Bmx_masterdata_ta> findByLevel(@RequestParam(required = false, name = "level") int level,
			Pageable pageable) {
		return bmx_masterdata_taRepo.findByLevel(level, pageable);
	}

	@GetMapping("/bmx_masterdata_ta_oid")
	public Bmx_masterdata_ta findById2(@RequestParam(name = "oid") String oid) {
		if (bmx_masterdata_taRepo.existsById(oid)) {
			return bmx_masterdata_taRepo.findById(oid).get();
		} else {
			return null;
		}

	}

}
