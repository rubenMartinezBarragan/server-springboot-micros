package com.ccsw.tutorialgame.game.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author ccsw
 *
 */
@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "age", nullable = false)
	private String age;

	@Column(name = "category_id", nullable = false)
	private Long idCategory;

	@Column(name = "author_id", nullable = false)
	private Long idAuthor;

	/**
	 * @return id
	 */
	public Long getId() {

		return this.id;
	}

	/**
	 * @param id new value of {@link #getId}.
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * @return title
	 */
	public String getTitle() {

		return this.title;
	}

	/**
	 * @param title new value of {@link #getTitle}.
	 */
	public void setTitle(String title) {

		this.title = title;
	}

	/**
	 * @return age
	 */
	public String getAge() {

		return this.age;
	}

	/**
	 * @param age new value of {@link #getAge}.
	 */
	public void setAge(String age) {

		this.age = age;
	}

	/**
	 * @return the idCategory
	 */
	public Long getIdCategory() {
		return idCategory;
	}

	/**
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	/**
	 * @return the idAuthor
	 */
	public Long getIdAuthor() {
		return idAuthor;
	}

	/**
	 * @param idAuthor the idAuthor to set
	 */
	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

}