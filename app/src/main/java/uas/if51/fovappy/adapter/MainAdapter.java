package uas.if51.fovappy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uas.if51.fovappy.R;
import uas.if51.fovappy.models.DataModel;
import uas.if51.fovappy.models.MakananModel;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.HolderData>{
    private Context ctx;
    private List<MakananModel> listMakanan;

    public MainAdapter(Context ctx, List<MakananModel> listMakanan) {
        this.ctx = ctx;
        this.listMakanan = listMakanan;
    }


    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_near, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {

        MakananModel dm = listMakanan.get(position);

        holder.tvId_makanan.setText(String.valueOf(dm.getId_makanan()));
        holder.tvNama_Makanan.setText(dm.getNama_makanan());
        holder.tvDeskripsi.setText(dm.getDeskripsi());
        holder.tvHarga.setText(dm.getHarga());
    }


    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvId_makanan, tvNama_Makanan, tvHarga, tvDeskripsi;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvDeskripsi  = itemView.findViewById(R.id.tv_desmakanan);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            tvId_makanan = itemView.findViewById(R.id.tv_idMakanan);
            tvNama_Makanan = itemView.findViewById(R.id.tv_nmmakan);
        }
    }
}
