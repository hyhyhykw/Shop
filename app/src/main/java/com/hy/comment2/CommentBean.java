package com.hy.comment2;

/**
 * Created by Amour on 2017/5/5.
 */

public class CommentBean {
    private int type;//类型,0为评论，1为回复
    private String nickname;
    private String time;
    private String content;

    private String replyNmae;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReplyNmae() {
        return replyNmae;
    }

    public void setReplyNmae(String replyNmae) {
        this.replyNmae = replyNmae;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
