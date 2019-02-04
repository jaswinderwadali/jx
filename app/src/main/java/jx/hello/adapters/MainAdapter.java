package jx.hello.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import jx.hello.BR;
import jx.hello.R;
import jx.hello.viewmodel.MainViewModel;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainViewModel mainViewModel;

    public MainAdapter(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, viewGroup, false);
        return new CardViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CardViewHolder genericViewHolder = (CardViewHolder) viewHolder;
        genericViewHolder.bind(mainViewModel, i);

    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.card_item;
    }


    @Override
    public int getItemCount() {
        return mainViewModel.getDummyData().size();
    }


    static class CardViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;

        CardViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        void bind(MainViewModel mainViewModel, int position) {
            binding.setVariable(BR.viewModel, mainViewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }
    }
}
