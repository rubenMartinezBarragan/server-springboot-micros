package com.ccsw.tutorialloan.loan;

import java.sql.Date;

import org.springframework.data.domain.Page;

import com.ccsw.tutorialloan.loan.model.Loan;
import com.ccsw.tutorialloan.loan.model.LoanDto;
import com.ccsw.tutorialloan.loan.model.LoanSearchDto;

/**
 * @author ruben martinez barragan
 *
 */
public interface LoanService {

	/**
	 * Método para recuperar un listado paginado y filtrando opcionalmente por
	 * título del juego y/o cliente y/o fecha de {@link Loan}
	 *
	 * @param dto        dto de búsqueda
	 * @param idGame     PK del título del juego
	 * @param idCliente  PK del cliente
	 * @param dateSearch fecha
	 * @return {@link Page} de {@link Loan}
	 */
	Page<Loan> findPage(LoanSearchDto dto, Long idGame, Long idClient, Date dateSearch);

	/**
	 * Método para eliminar un {@link Loan}
	 *
	 * @param id PK de la entidad
	 */
	void delete(Long id) throws Exception;

	/**
	 * Guarda un prestamo
	 *
	 * @param dto datos de la entidad
	 */
	void save(LoanDto dto) throws Exception;

}