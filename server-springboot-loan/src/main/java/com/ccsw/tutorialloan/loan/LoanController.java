package com.ccsw.tutorialloan.loan;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorialloan.client.ClientClient;
import com.ccsw.tutorialloan.client.model.ClientDto;
import com.ccsw.tutorialloan.game.GameClient;
import com.ccsw.tutorialloan.game.model.GameDto;
import com.ccsw.tutorialloan.loan.model.Loan;
import com.ccsw.tutorialloan.loan.model.LoanDto;
import com.ccsw.tutorialloan.loan.model.LoanSearchDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author ruben martinez barragan
 *
 */
@Tag(name = "Loan", description = "API of Loan")
@RequestMapping(value = "/loan")
@RestController
@CrossOrigin(origins = "*")
public class LoanController {

	@Autowired
	LoanService loanService;

	@Autowired
	ClientClient clientClient;

	@Autowired
	GameClient gameClient;

	@Autowired
	DozerBeanMapper mapper;

	/**
	 * Método para recuperar un listado paginado de {@link Loan}
	 *
	 * @param dto dto de búsqueda
	 * @return {@link Page} de {@link LoanDto}
	 */
	@Operation(summary = "Find Page", description = "Method that return a page of Loans")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public Page<LoanDto> findPage(@RequestBody LoanSearchDto dto) {
		List<ClientDto> clients = clientClient.findAll();
		List<GameDto> games = gameClient.find();

		Page<Loan> page = this.loanService.findPage(dto);

		return new PageImpl<>(page.getContent().stream().map(loan -> {
			LoanDto loanDto = new LoanDto();

			loanDto.setId(loan.getId());
			loanDto.setGame(
					games.stream().filter(game -> game.getId().equals(loan.getIdGame())).findFirst().orElse(null));
			loanDto.setClient(clients.stream().filter(client -> client.getId().equals(loan.getIdClient())).findFirst()
					.orElse(null));
			loanDto.setDateLoan(loan.getDateLoan());
			loanDto.setDateReturn(loan.getDateReturn());

			return loanDto;
		}).collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
	}

	/**
	 * Método para recuperar una lista de {@link Loan}
	 *
	 * @param idGame     PK título del juego
	 * @param idClient   PK del cliente
	 * @param dateSearch fecha
	 * @return {@link List} de {@link LoanDto}
	 */
	@Operation(summary = "Find", description = "Method that return a filtered list of Loan")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<LoanDto> find(@RequestParam(value = "idGame", required = false) Long idGame,
			@RequestParam(value = "idClient", required = false) Long idClient,
			@RequestParam(value = "dateSearch", required = false) Date dateSearch) {
		List<ClientDto> clients = clientClient.findAll();
		List<GameDto> games = gameClient.find();

		return loanService.find(idGame, idClient, dateSearch).stream().map(loan -> {
			LoanDto loanDto = new LoanDto();

			loanDto.setId(loan.getId());
			loanDto.setGame(
					games.stream().filter(game -> game.getId().equals(loan.getIdGame())).findFirst().orElse(null));
			loanDto.setClient(clients.stream().filter(client -> client.getId().equals(loan.getIdClient())).findFirst()
					.orElse(null));
			loanDto.setDateLoan(loan.getDateLoan());
			loanDto.setDateReturn(loan.getDateReturn());

			return loanDto;
		}).collect(Collectors.toList());
	}

	/**
	 * Método para eliminar un {@link Loan}
	 *
	 * @param id PK de la entidad
	 */
	@Operation(summary = "Delete", description = "Method that deletes a Loan")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) throws Exception {
		this.loanService.delete(id);
	}

	/**
	 * Método para crear un {@link Loan}
	 *
	 * @param dto datos de la entidad
	 */
	@Operation(summary = "Save", description = "Method that saves a Loan")
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public void save(@RequestBody LoanDto dto) throws Exception {
		loanService.save(dto);
	}
}