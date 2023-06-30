package com.ccsw.tutorialloan.game.model;

/**
 * @author ccsw
 *
 */
public class GameDto {

	private Long id;
	private String title;
	private String age;

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
}