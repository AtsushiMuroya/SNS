package sorajirocom.android.sns;

public class Post {
    String content;
    String title;
    int likeCount;

    public Post(){

    }
    public Post(String title, String content, int likeCount){
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String message){
        this.title = title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String userName){
        this.content = content;
    }
    public int getLikeCount(){
        return likeCount;
    }
    public void setLikeCount(int likeCount){
        this.likeCount = likeCount;
    }
}
