package io.saikiran.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.saikiran.api.entity.Article;
import io.saikiran.api.repository.ArticleDAO;
import io.saikiran.api.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {

	
	private ArticleDAO articleDAO;

	public ArticleServiceImpl(ArticleDAO repository) {
		this.articleDAO = repository;
	}

	
	@Override
	public Article getArticleById(int articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		return obj;
	}

	@Override
	public List<Article> getAllArticles() {
		return articleDAO.getAllArticles();
	}

	@Override
	public synchronized boolean addArticle(Article article) {
		if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
			return false;
		} else {
			articleDAO.addArticle(article);
			return true;
		}
	}

	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
}
