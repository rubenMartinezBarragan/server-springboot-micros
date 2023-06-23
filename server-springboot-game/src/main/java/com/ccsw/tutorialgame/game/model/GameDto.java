package com.ccsw.tutorialgame.game.model;

import com.ccsw.tutorialgame.author.model.AuthorDto;
import com.ccsw.tutorialgame.category.model.CategoryDto;

/**
 * @author ccsw
 *
 */
public class GameDto {

	private Long id;
	private String title;
	private String age;
	private CategoryDto category;
	private AuthorDto author;

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
	 * @return the category
	 */
	public CategoryDto getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	/**
	 * @return the author
	 */
	public AuthorDto getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(AuthorDto author) {
		this.author = author;
	}

}