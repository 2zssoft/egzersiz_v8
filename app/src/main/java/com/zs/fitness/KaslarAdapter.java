package com.zs.fitness;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tchzafer on 21/03/2018.
 */

public class KaslarAdapter extends RecyclerView.Adapter<KaslarAdapter.MyViewHolder> {

    ArrayList<Kaslar> mKaslarList;
    LayoutInflater inflater;

    public KaslarAdapter(Context context, ArrayList<Kaslar> Kaslars) {
        inflater = LayoutInflater.from(context);
        this.mKaslarList = Kaslars;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.kasgrup_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Kaslar selectedKaslar = mKaslarList.get(position);
        holder.setData(selectedKaslar, position);

    }

    @Override
    public int getItemCount() {
        return mKaslarList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final Context context2 ;
        TextView KaslarName, KaslarDescription;
        ImageView KaslarImage, deleteKaslar;

        public MyViewHolder(View itemView) {

            super(itemView);
            context2 = itemView.getContext();
            KaslarName = (TextView) itemView.findViewById(R.id.productName);
            KaslarDescription = (TextView) itemView.findViewById(R.id.productDescription);
            KaslarImage = (ImageView) itemView.findViewById(R.id.productImage);
            deleteKaslar = (ImageView) itemView.findViewById(R.id.deleteproduct);
            deleteKaslar.setOnClickListener(this);
            KaslarName.setOnClickListener(this);
            KaslarImage.setOnClickListener(this);

        }

        public void setData(Kaslar selectedKaslar, int position) {

           // this.KaslarName.setText(selectedKaslar.getKaslarName());
            this.KaslarName.setText(selectedKaslar.getKaslarAdi());
            this.KaslarDescription.setText(selectedKaslar.getKaslarDescription());
            this.KaslarImage.setImageResource(selectedKaslar.getImageID());


        }



        @Override
        public void onClick(View v) {
String kas=this.KaslarName.getText().toString();
switch (kas)
{
    case "Omuz":kas="Shoulders";break;
    case "Arka kol":kas="Triceps";break;
    case "Karın":kas="Abdominals";break;
    case "Sırt":kas="Back";break;
    case "Ön kol":kas="Biceps";break;
    case "Kanat":kas="Lats";break;
    case "Arka bacak":kas="Hamstrings";break;
    case "Kalfler":kas="Calves";break;
    case "Ön Bacak":kas="Quads";break;
    case "Göğüs":kas="Chest";break;
    case "Kalça":kas="Glutes";break;
    case "Traps":kas="Traps";break;

}
            String ana_kas="%";
if(kas.equals("Hepsi")||kas.equals("All"))
{
    ana_kas="%";
}
else
{
    ana_kas=ana_kas+kas+"%";
}




         /*   if (Locale.getDefault().getLanguage().toString().equals("tr") == true) {
                ana_kas = "%Karın %";
            } else {
                ana_kas = "%Abs%";

            }*/
            final Intent intent;
            final Bundle bundle = new Bundle();
                intent =  new Intent(context2, Liste.class);
            String ekipman = "%";
            String ekler = "";
            String keyw = "";
            bundle.putString("keyword", keyw);
            bundle.putString("ana_kas", ana_kas);
            bundle.putString("ekipman", ekipman);
            bundle.putString("ekler", ekler);

            // bundle.putString("ana_kas", ana_kas);
            intent.putExtras(bundle);



            context2.startActivity(intent);

        }


    }
}