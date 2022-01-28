package Model;

public class BoardDTO {
private int num;
private String title;
private String writer;
private String filename;
private String content;
private String b_date;

public BoardDTO(int num, String title, String writer, String filename, String content, String b_date) {
	this.num = num;
	this.title = title;
	this.writer = writer;
	this.filename = filename;
	this.content = content;
	this.b_date = b_date;
}


public BoardDTO(String title, String writer, String filename, String content) {
	this.title = title;
	this.writer = writer;
	this.filename = filename;
	this.content = content;
}


public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getWriter() {
	return writer;
}

public void setWriter(String writer) {
	this.writer = writer;
}

public String getFilename() {
	return filename;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getB_date() {
	return b_date;
}

public void setB_date(String b_date) {
	this.b_date = b_date;
}


}
