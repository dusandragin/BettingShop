package bettingshop.data;

/*
 * Input data bean for new comments
 * 
*/
public class CommentData {
	private Integer idTheme;
	private Integer idUser;
	private String commentContent;

	public CommentData() {
	}

	public Integer getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(Integer idTheme) {
		this.idTheme = idTheme;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
}
