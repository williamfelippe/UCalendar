package com.ucalendar.ucalendar.structure;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ucalendar.R;

import java.util.List;

public class UCalendarAdapter extends RecyclerView.Adapter<UCalendarHolder>
{
    private Context context;
    private final List<UCalendarDate> items;


    public UCalendarAdapter(Context context, List<UCalendarDate> items)
    {
        this.context = context;
        this.items = items;
    }

    @Override
    public UCalendarHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar, parent, false);
        return new UCalendarHolder(view);
    }

    @Override
    public void onBindViewHolder(UCalendarHolder holder, int position)
    {
        UCalendarDate date = items.get(position);
        holder.bindUCalendarDate(date, context);
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }
}