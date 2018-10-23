package com.dsm2018.sns.Item;

public class RecyclerItem {
    private int profile_img;
    private String profile_name;
    private int posting_img;
    private int like;
    private int comment;
    private String how_many_like;
    private String posting_who;
    private String posting_contents;
    private String comment_who;
    private String comment_contents;


    public RecyclerItem (int profile_img, String profile_name, int posting_img,int like, int comment, String how_many_like, String posting_who, String posting_contents, String comment_who, String comment_contents){
        this.profile_img = profile_img;
        this.profile_name = profile_name;
        this.posting_img = posting_img;
        this.like = like;
        this.comment = comment;
        this.how_many_like = how_many_like;
        this.posting_who = posting_who;
        this.posting_contents = posting_contents;
        this.comment_who = comment_who;
        this.comment_contents = comment_contents;

    }

    public int getProfileIMG (){
        return profile_img;
    }

    public String getName(String name) {
        return profile_name;
    }

    public int getPostingIMG() {
        return posting_img;
    }

    public int getLike() { return like;}

    public int getComment() {return comment;}

    public String getHowManyLike() {
        return how_many_like;
    }

    public String getPostingWho() {
        return posting_who;
    }

    public String getPosting_contents() {
        return posting_contents;
    }

    public String getComment_who() {
        return comment_who;
    }

    public String getComment_contents() {
        return comment_contents;
    }

}