package com.example.zadanienrdwa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private List<ShoppingItem> shoppingItems;

    public ShoppingListAdapter(List<ShoppingItem> items) {
        this.shoppingItems = items;
    }

    //    item jak v-for we vue
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.item_checkbox);
        }
    }

//    Nowy widok pojedynczego elementu listy  <ShoppingItem v-for
    @NonNull
    @Override
    public ShoppingListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_list_item, parent, false);
        return new ViewHolder(view);
    }

    // ustawienie kazdego z parametrów pojedynczego wiersza {{item}}
    @Override
    public void onBindViewHolder(@NonNull ShoppingListAdapter.ViewHolder holder, int position) {
        ShoppingItem item = shoppingItems.get(position);
        holder.checkBox.setText(item.getName());
        holder.checkBox.setChecked(item.isChecked());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setChecked(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return shoppingItems.size();
    }
}
