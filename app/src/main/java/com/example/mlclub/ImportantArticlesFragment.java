package com.example.mlclub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImportantArticlesFragment extends Fragment {
    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mLinks = new ArrayList<>();
    View view;
    private LinearLayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view=inflater.inflate(R.layout.important_articles,container,false);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        initList();
        return view;
    }
    public void createImpArtRecyclerView(){
        RecyclerView recyclerView=view.findViewById(R.id.imp_art_recycler_view);
        ImportantArticleAdapter adapter=new ImportantArticleAdapter(mTitle,mLinks,getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

    }
    public void initList(){
        mLinks.add("www.google.com");
        mLinks.add("www.Youtube.com");
        mTitle.add("Google");
        mTitle.add("YouTube");
        createImpArtRecyclerView();

    }
}
