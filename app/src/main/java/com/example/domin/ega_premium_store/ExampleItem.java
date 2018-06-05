package com.example.domin.ega_premium_store;

public class ExampleItem  {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;
    private String mDesc;

    public ExampleItem(String imageUrl, String creator, int likes, String desc){
        mImageUrl = imageUrl;
        mCreator = creator;
        mLikes = likes;
        mDesc = desc;

    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public String getCreator(){
        return mCreator;
    }

    public int getLikeCount(){
        return mLikes;
    }

    public String getDesc(){
        return mDesc;
    }


}
