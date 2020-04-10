package com.example.photoshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private List<Uploads> uploadsList;

    public ImageAdapter(Context context, List<Uploads> uploads) {
        this.context = context;
        this.uploadsList = uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return  new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Uploads current = uploadsList.get(position);
        holder.caption.setText(current.getName());
        Picasso.get().load(current.getImageUrl()).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return uploadsList.size();
    }

    public class ImageViewHolder extends  RecyclerView.ViewHolder {

        public TextView caption;
        public ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            caption = itemView.findViewById(R.id.tv_caption);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
