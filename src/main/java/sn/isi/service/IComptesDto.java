package sn.isi.service;


import sn.isi.dto.ComptesDto;

import java.util.List;

public interface IComptesDto {

	public int add(ComptesDto comptesDto);
	public int delete(int id);
	public int update(ComptesDto comptesDto);
	public List<ComptesDto> list();
	public ComptesDto get(int id);
}
