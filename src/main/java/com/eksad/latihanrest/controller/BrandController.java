package com.eksad.latihanrest.controller;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.latihanrest.dao.BrandDao;
import com.eksad.latihanrest.model.Brand;

@RestController
@RequestMapping("brand")
public class BrandController {
	@Autowired
	BrandDao brandDao;
	
	@RequestMapping("getAll")
	public List<Brand> getAll(){
		List<Brand> result = new ArrayList<>();
		
		brandDao.findAll().forEach(result::add);
		
		return result;	
	}
	@RequestMapping("getOne/{id}")
	public Brand getOne(@PathVariable Long id) {
		return brandDao.findById(id).orElse(null);
	}
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestBody Brand brand) {
		try {
			brandDao.save(brand);
			return "Berhasil Tersimpan";
		} catch (Exception e) {
			e.printStackTrace();
			return "Gagal Tersimpan";
		}
	
	}
}
