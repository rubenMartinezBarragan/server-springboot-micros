package com.ccsw.tutorialloan.loan.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author ruben martinez barragan
 *
 */
@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "game_id", nullable = false)
	private Long idGame;

	@Column(name = "client_id", nullable = false)
	private Long idClient;

	@Column(name = "date_loan", nullable = false)
	private Date dateLoan;

	@Column(name = "date_return", nullable = false)
	private Date dateReturn;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the idGame
	 */
	public Long getIdGame() {
		return idGame;
	}

	/**
	 * @param idGame the idGame to set
	 */
	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	/**
	 * @return the idClient
	 */
	public Long getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the dateLoan
	 */
	public Date getDateLoan() {
		return dateLoan;
	}

	/**
	 * @param dateLoan the dateLoan to set
	 */
	public void setDateLoan(Date dateLoan) {
		this.dateLoan = dateLoan;
	}

	/**
	 * @return the dateReturn
	 */
	public Date getDateReturn() {
		return dateReturn;
	}

	/**
	 * @param dateReturn the dateReturn to set
	 */
	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

}