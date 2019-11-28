package com.example.mybatis.generator.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Article implements Serializable {
    private Integer id;

    private String title;

    private String author;

    private String fileName;

    /**
     * 状态
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "状态")
    private Short state;

    private String content;

    private static final long serialVersionUID = 1L;

    public Article(Integer id, String title, String author, String fileName, Short state) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.fileName = fileName;
        this.state = state;
    }

    public Article(Integer id, String title, String author, String fileName, Short state, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.fileName = fileName;
        this.state = state;
        this.content = content;
    }

    public Article() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", fileName=").append(fileName);
        sb.append(", state=").append(state);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}