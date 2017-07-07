package io.saikiran.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.saikiran.api.entity.Article;

@Transactional
@Repository
public class ArticleDaoImpl implements ArticleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Article getArticleById(int articleId) {
		return entityManager.find(Article.class, articleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addArticle(Article article) {
		entityManager.merge(article);
	}

	@Override
	public void updateArticle(Article article) {
		Article artcl = getArticleById(article.getArticleId());
		artcl.setTitle(article.getTitle());
		artcl.setCategory(article.getCategory());
		entityManager.flush();
	}

	@Override
	public void deleteArticle(int articleId) {
		entityManager.remove(getArticleById(articleId));
	}

	@Override
	public boolean articleExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category).getResultList()
				.size();
		System.out.println("entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category)  "+(entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category)).toString());
		return count > 0 ? true : false;
	}
}
