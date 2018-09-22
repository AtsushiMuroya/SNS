package sorajirocom.android.sns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {

    List<Post> items;
    OnLikeClickListener likeClickListener = null;

    public PostAdapter(Context context, int resource, List<Post> objects){
        super(context,resource,objects);
        this.items = objects;
    }
    @Override
    public int getCount(){
        return items.size();
    }
    @Override
    public Post getItem(int position){
        return items.get(position);
    }
    @Override
    public  View getView(final int position, View convertView, ViewGroup parent){

        final ViewHolder viewHolder;

//        class ViewHolder{
//            TextView userNameText;
//            TextView messageText;
//        }


        //final ViewHolder viewHolder;

        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else{
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_post,parent,false);

            viewHolder = new ViewHolder();

            viewHolder.titleText = (TextView) convertView.findViewById(R.id.title);
            viewHolder.contentText = (TextView) convertView.findViewById(R.id.content);
            viewHolder.likeImage = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.likeCountText = (TextView) convertView.findViewById(R.id.likecount);


            convertView.setTag(viewHolder);
        }
        Post item = getItem(position);

        viewHolder.titleText.setText(item.getTitle());
        viewHolder.contentText.setText(item.getContent());
        viewHolder.likeCountText.setText(String.valueOf(item.getLikeCount()));
        viewHolder.likeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeClickListener != null){
                    likeClickListener.onLikeClick(position);
                }
            }
        });

        return convertView;
    }
    static class ViewHolder {
        TextView titleText;
        TextView contentText;
        ImageView likeImage;
        TextView likeCountText;
    }
    interface OnLikeClickListener {
        void onLikeClick(int position);
    }
}
