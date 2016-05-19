package com.ucalendar.ucalendar.structure;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class UCalendarHolder extends RecyclerView.ViewHolder
{
    private Context context;
    private UCalendarDate date;

    public UCalendarHolder(View view)
    {
        super(view);
        setupLayout(view);
    }

    private void setupLayout(View view)
    {

    }

    public void bindUCalendarDate(UCalendarDate date, Context context)
    {
        this.context = context;
        this.date = date;
    }
}
