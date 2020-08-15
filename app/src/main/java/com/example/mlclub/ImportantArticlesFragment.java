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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ImportantArticlesFragment extends Fragment {
    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mLinks = new ArrayList<>();
    private View view;
    List<DocumentSnapshot> list;
    FirebaseFirestore firebaseFirestore;
    private LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.important_articles, container, false);
        firebaseFirestore = FirebaseFirestore.getInstance();
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        initList();
        return view;
    }

    private void createImpArtRecyclerView() {
        RecyclerView recyclerView = view.findViewById(R.id.imp_art_recycler_view);
        ImportantArticleAdapter adapter = new ImportantArticleAdapter(mTitle, mLinks, getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initList() {


       /* mLinks.add("www.google.com");
        mLinks.add("www.Youtube.com");
        mTitle.add("Google");
        mTitle.add("YouTube");*/
        createImpArtRecyclerView();

    }
}
