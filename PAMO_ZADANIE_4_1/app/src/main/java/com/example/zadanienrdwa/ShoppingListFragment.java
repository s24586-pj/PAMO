package com.example.zadanienrdwa;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class ShoppingListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ShoppingListAdapter adapter;
    private List<ShoppingItem> shoppingItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        Ładowanie xml->znajdowanie elementu po id->ustawianie danych pionowo-> tworzenie listy->uzycie recyclerView z adapterem
        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        shoppingItems = Arrays.asList(
                new ShoppingItem("Tuńczyk w puszce"),
                new ShoppingItem("Sałata"),
                new ShoppingItem("Kukurydza"),
                new ShoppingItem("Czerwona fasola"),
                new ShoppingItem("Cebula"),
                new ShoppingItem("Oliwa z oliwek"),
                new ShoppingItem("Sól"),
                new ShoppingItem("Pieprz")
        );

        adapter = new ShoppingListAdapter(shoppingItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
