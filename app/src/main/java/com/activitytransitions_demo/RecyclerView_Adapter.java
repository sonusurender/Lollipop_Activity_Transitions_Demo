package com.activitytransitions_demo;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sonu on 06/08/16.
 */

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.RecyclerViewHolder> {

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView mName, mPhone;
        View mCircle;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.user_name);
            mPhone = (TextView) itemView.findViewById(R.id.user_phone);
            mCircle = itemView.findViewById(R.id.user_circle);
        }
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_user_row_layout, viewGroup, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {

        // get the single element from the main array
        final User user = User.USER[i];

        // Set the values
        viewHolder.mName.setText(user.get(User.Field.NAME));
        viewHolder.mPhone.setText(user.get(User.Field.PHONE));

        // Set the color of the shape
        GradientDrawable bgShape = (GradientDrawable) viewHolder.mCircle.getBackground();
        bgShape.setColor(Color.parseColor(user.get(User.Field.COLOR)));
    }

    @Override
    public int getItemCount() {
        return User.USER.length;
    }
}
