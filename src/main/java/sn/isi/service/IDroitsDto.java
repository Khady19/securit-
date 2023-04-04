package sn.isi.service;



import java.util.List;

import sn.isi.dto.DroitsDto;

public interface IDroitsDto {

	public int add(DroitsDto roleDto);
	public int delete(int id);
	public int update(DroitsDto roleDto);
	public List<DroitsDto> list();
	public DroitsDto get(int id);
}
