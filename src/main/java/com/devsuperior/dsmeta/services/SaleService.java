package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.projections.SaleReportProjection;
import com.devsuperior.dsmeta.projections.SaleSummaryProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Transactional(readOnly = true)
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<SaleReportDTO> getReport(String minDate, String maxDate, String name) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate overAYear = today.minusYears(1L);

		LocalDate min = "".equals(minDate) ? overAYear : LocalDate.parse(minDate);
		LocalDate max = "".equals(maxDate) ? today : LocalDate.parse(maxDate);

		List<SaleReportProjection> result = repository.searchReport(min, max, name);
		return result.stream().map(x -> new SaleReportDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<SaleSummaryDTO> getSummary(String minDate, String maxDate) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate overAYear = today.minusYears(1L);

		LocalDate min = "".equals(minDate) ? overAYear : LocalDate.parse(minDate);
		LocalDate max = "".equals(maxDate) ? today : LocalDate.parse(maxDate);

		List<SaleSummaryProjection> result = repository.searchSummary(min, max);
		return result.stream().map(x -> new SaleSummaryDTO(x)).collect(Collectors.toList());
	}
}
