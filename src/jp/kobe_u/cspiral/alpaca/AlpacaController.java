package jp.kobe_u.cspiral.alpaca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.kobe_u.cspiral.alpaca.model.Comment;
import jp.kobe_u.cspiral.alpaca.model.Like;
import jp.kobe_u.cspiral.alpaca.model.Presenters;
import jp.kobe_u.cspiral.alpaca.model.Report;
import jp.kobe_u.cspiral.alpaca.util.DBUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class AlpacaController {
	private final String LIKE_COLLECTION_NAME = "like";
	private final String COMMENT_COLLECTION_NAME = "comment";

	private DBCollection LIKE_COLLECTION;
	private DBCollection COMMENT_COLLECTION;
	private String presenter;

	public AlpacaController() {
		this.presenter = "c0";
		this.LIKE_COLLECTION = DBUtils.getInstance().getDb().getCollection(LIKE_COLLECTION_NAME);
		this.COMMENT_COLLECTION = DBUtils.getInstance().getDb().getCollection(COMMENT_COLLECTION_NAME);
	}


	public void like() {
		DBObject like = new BasicDBObject();
		like.put("date", new Date());
		like.put("presenter", presenter);
		LIKE_COLLECTION.save(like);
	}

	public void comment(String message) {
		DBObject comment = new BasicDBObject();
		comment.put("date", new Date());
		comment.put("presenter", presenter);
		comment.put("message", message);
		COMMENT_COLLECTION.save(comment);
	}


	public Report getReport(String presenter, int n) {
		DBObject query = new BasicDBObject();
		query.put("presenter", presenter);

		Report report = new Report(presenter);
		List<Like> likes = new ArrayList<Like>();
		List<Comment> comments = new ArrayList<Comment>();

		DBCursor cursor = LIKE_COLLECTION.find(query);
		/*
		for (DBObject like : cursor) {
			likes.add(new Like((Date)like.get("date")));
		}
		*/
		report.setTotalLike(cursor.count());
		DBObject sort = new BasicDBObject("_id", -1);
		cursor = COMMENT_COLLECTION.find(query).sort(sort).limit(n);
		for (DBObject comment : cursor) {
			comments.add(new Comment(
					(Date)comment.get("date"), (String)comment.get("message")));
		}

		report.setLikes(likes);
		report.setComments(comments);
		return report;
	}


	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public String getPresenter() {
		return presenter;
	}

	public Presenters listPresenters() {
		Presenters presenters = new Presenters();
		DBCursor cursor = LIKE_COLLECTION.find();
		for (DBObject presenter : cursor) {
			presenters.add((String)presenter.get("presenter"));
		}
		return presenters;
	}

}