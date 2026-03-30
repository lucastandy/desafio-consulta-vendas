package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	
	public Page<SaleReportDTO> searchSales(String minDateStr, String maxDateStr, String name, Pageable pageable) {

	    LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

	    LocalDate maxDate = (maxDateStr == null || maxDateStr.isEmpty())
	        ? today
	        : LocalDate.parse(maxDateStr);

	    LocalDate minDate = (minDateStr == null || minDateStr.isEmpty())
	        ? maxDate.minusYears(1)
	        : LocalDate.parse(minDateStr);

	    name = (name == null) ? "" : name;

	    return repository.searchSales(minDate, maxDate, name, pageable);
	}
	
	public List<SaleSummaryDTO> summarySales(String minDateStr, String maxDateStr) {

	    LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

	    LocalDate maxDate = (maxDateStr == null || maxDateStr.isEmpty())
	        ? today
	        : LocalDate.parse(maxDateStr);

	    LocalDate minDate = (minDateStr == null || minDateStr.isEmpty())
	        ? maxDate.minusYears(1)
	        : LocalDate.parse(minDateStr);

	    return repository.summarySales(minDate, maxDate);
	}
	
	
	
	
}
