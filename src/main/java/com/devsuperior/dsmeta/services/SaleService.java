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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<SaleReportDTO> getReportPage(String minDate, String maxDate, String name, Pageable pageable) {
		LocalDate min = convertMinDate(minDate);
		LocalDate max = convertMaxDate(maxDate);
		Page<SaleReportProjection> result = repository.searchReportPage(min, max, name, pageable);
		return result.map(x -> new SaleReportDTO(x));
	}

	@Transactional(readOnly = true)
	public List<SaleSummaryDTO> searchSummaryList(String minDate, String maxDate) {
		LocalDate min = convertMinDate(minDate);
		LocalDate max = convertMaxDate(maxDate);
		List<SaleSummaryProjection> result = repository.searchSummaryList(min, max);
		return result.stream().map(x -> new SaleSummaryDTO(x)).collect(Collectors.toList());
	}

	private LocalDate convertMinDate(String minDate) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate overYear = today.minusYears(1L);
		LocalDate min = "".equals(minDate) ? overYear : LocalDate.parse(minDate);
		return min;
	}

	private LocalDate convertMaxDate(String maxDate) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate max = "".equals(maxDate) ? today : LocalDate.parse(maxDate);
		return max;
	}
}
