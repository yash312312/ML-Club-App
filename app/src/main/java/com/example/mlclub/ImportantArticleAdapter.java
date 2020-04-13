package com.example.mlclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImportantArticleAdapter extends RecyclerView.Adapter<ImportantArticleAdapter.ViewHolder>{
    private static final String TAG="ImportantArticleAdapter";
    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mLinks = new ArrayList<>();
    private Context mContext;

    public ImportantArticleAdapter(ArrayList<String> mTitle, ArrayList<String> mLinks, Context mContext) {
        this.mTitle = mTitle;
        this.mLinks = mLinks;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.links_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.link.setText(mLinks.get(position));
        holder.title.setText(mTitle.get(position));
        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mTitle.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView link,title;
        LinearLayout parent_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            link=itemView.findViewById(R.id.link);
            title=itemView.findViewById(R.id.title);
            parent_layout=itemView.findViewById(R.id.parent);
        }
    }
}
