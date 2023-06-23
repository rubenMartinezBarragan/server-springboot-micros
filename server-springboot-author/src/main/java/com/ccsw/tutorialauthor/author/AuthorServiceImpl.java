package com.ccsw.tutorialauthor.author;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorialauthor.author.model.Author;
import com.ccsw.tutorialauthor.author.model.AuthorDto;
import com.ccsw.tutorialauthor.author.model.AuthorSearchDto;

import jakarta.transaction.Transactional;

/**
 * @author ccsw
 *
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Author get(Long id) {
		return this.authorRepository.findById(id).orElse(null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Page<Author> findPage(AuthorSearchDto dto) {
		return this.authorRepository.findAll(dto.getPageable().getPageable());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Long id, AuthorDto data) {
		Author author;

		if (id == null) {
			author = new Author();
		} else {
			author = this.authorRepository.findById(id).orElse(null);
		}

		BeanUtils.copyProperties(data, author, "id");

		this.authorRepository.save(author);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Long id) throws Exception {
		if (this.authorRepository.findById(id).orElse(null) == null) {
			throw new Exception("Not exists");
		}

		this.authorRepository.deleteById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Author> findAll() {
		return (List<Author>) this.authorRepository.findAll();
	}

}