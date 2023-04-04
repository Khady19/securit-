package sn.isi.service;

import java.util.ArrayList;
import java.util.List;

import sn.isi.dao.DroitsImpl;
import sn.isi.dto.DroitsDto;
import sn.isi.entities.Droits;

public class DroitsDtoImpl implements IDroitsDto {

	private DroitsImpl ddao = new DroitsImpl();
	@Override
	public int add(DroitsDto droitsDto) {
		
		return ddao.add(ddao.DroitsDtoToDroitsEntity(droitsDto));
	}

	@Override
	public int delete(int id) {
		
		return ddao.delete(id, new Droits());
	}
	


	@Override
	public int update(DroitsDto droitsDto) {
		
		return ddao.update(ddao. DroitsDtoToDroitsEntity(droitsDto));
	}

	@Override
	public List<DroitsDto> list() {
		List<DroitsDto>droitsDtos = new ArrayList<DroitsDto>();
		List<Droits> droits = ddao.list(new Droits());
		for (Droits d: droits) {
			if (droitsDtos.isEmpty()){
				droitsDtos.add(ddao.DroitsEntityToDroitsDto(d));
			}else{
				boolean trouve = false;
				for (DroitsDto rdto: droitsDtos) {
					System.out.println(d.getName()+"/"+rdto.getName());
					if (d.getName().equals(rdto.getName())){
						trouve = true;
						break;
					} 
				}
				if (!trouve)
					droitsDtos.add(ddao.DroitsEntityToDroitsDto(d));
			}
		}
		
		return droitsDtos;
	}

	@Override
	public DroitsDto get(int id) {
		
		return ddao.DroitsEntityToDroitsDto(ddao.get(id, new Droits()));
	}

}
