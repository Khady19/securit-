package sn.isi.service;



import sn.isi.dao.ComptesImpl;
import sn.isi.dto.ComptesDto;
import sn.isi.entities.Comptes;

import java.util.ArrayList;
import java.util.List;

public class ComptesDtoImpl implements IComptesDto {

	private ComptesImpl cdao = new ComptesImpl();
	@Override
	public int add(ComptesDto comptesDto) {

		return cdao.add(cdao.ComptesDtoToComptesEntity(comptesDto));
	}

	@Override
	public int delete(int id) {

		return cdao.delete(id, new Comptes());
	}

	@Override
	public int update(ComptesDto comptesDto) {
		

		return cdao.update(cdao.ComptesDtoToComptesEntity(comptesDto));
	}

	@Override
	public List<ComptesDto> list() {
		List<ComptesDto> comptesDto = new ArrayList<ComptesDto>();
		cdao.list(new Comptes()).forEach(droits -> {
			
			comptesDto.add(cdao.ComptesEntityToComptesDto(droits));
		});
		return comptesDto; 
	}
	 

	@Override
	public ComptesDto get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

