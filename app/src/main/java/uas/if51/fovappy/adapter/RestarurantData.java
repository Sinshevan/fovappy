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

public class RestarurantData extends RecyclerView.Adapter<RestarurantData.HolderData>{
    private Context ctx;
    private List<DataModel> listRestaurant;

    public RestarurantData(Context ctx, List<DataModel> listRestaurant) {
        this.ctx = ctx;
        this.listRestaurant = listRestaurant;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurantnear, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listRestaurant.get(position);

        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNama.setText(dm.getNama_restaurant());
        holder.tvRating.setText(dm.getRating());
        holder.tvWaktu.setText(dm.getWaktu());
        holder.tvAlamat.setText(dm.getAlamat());
        holder.tvAsal.setText(dm.getAsal());
    }

    @Override
    public int getItemCount() {
        return listRestaurant.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvId, tvNama, tvRating, tvWaktu, tvAlamat, tvAsal;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_namaresto);
            tvRating = itemView.findViewById(R.id.tv_rating);
            tvWaktu = itemView.findViewById(R.id.tv_waktu);
            tvAlamat = itemView.findViewById(R.id.tv_jalan);
            tvAsal = itemView.findViewById(R.id.tv_tempat);
        }
    }
}
