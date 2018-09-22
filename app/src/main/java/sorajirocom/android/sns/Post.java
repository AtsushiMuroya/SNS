package sorajirocom.android.sns;

public class Post {
    String content;
    String title;
    int likeCount;
    String key;

    public Post(){

    }
    public Post(String key,String title, String content, int likeCount){
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
        this.key = key;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public int getLikeCount(){
        return likeCount;
    }
    public void setLikeCount(int likeCount){
        this.likeCount = likeCount;
    }
    public String getKey(){
        return key;
    }
    public void setKey(String key){
        this.key = key;
    }
}
