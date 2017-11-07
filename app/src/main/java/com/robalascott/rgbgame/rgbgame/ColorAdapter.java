package com.robalascott.rgbgame.rgbgame;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by robscott on 2017-10-22.
 */

class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.MyViewHolder>{
    private List<ColorObject> colorList;
    private Context con;
    private ItemClickListener listner;
    public interface ItemClickListener{
         void onItemClick(View v, int pos, String style);
    }
    public void setOnClick(ItemClickListener listner){
        this.listner = listner;
    }

    public ColorAdapter(List<ColorObject> dropListArray, Context context) {
            this.colorList = dropListArray;
            this.con = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ColorObject colorObject = colorList.get(position);
        holder.idView.setBackgroundColor(colorObject.getRGB());
        Log.d("adapter",Integer.toString(colorObject.getBlue()));
        holder.idView.setText(Integer.toString(colorObject.getBlue()));
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView idView;
        public MyViewHolder(View v){
            super(v);
            idView = itemView.findViewById(R.id.idTextView);

            v.setOnClickListener (new View.OnClickListener (){
                @Override
                public void onClick(View v) {
                    if(listner!=null){
                        int position = getAdapterPosition ();
                        if(position!= RecyclerView.NO_POSITION){
                            listner.onItemClick (v,position,"asd");
                        }
                    }
                }

            });

        }
    }
}
