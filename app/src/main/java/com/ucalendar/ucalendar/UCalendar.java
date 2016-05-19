package com.ucalendar.ucalendar;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ucalendar.R;
import com.ucalendar.ucalendar.structure.UCalendarAdapter;
import com.ucalendar.ucalendar.structure.UCalendarDate;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class UCalendar extends LinearLayout implements View.OnClickListener
{
    private Context context;

    private OnSelectDateListener listener;

    private ImageView previousButton;
    private ImageView nextButton;
    private LinearLayout daysOfWeekLayout;
    private RecyclerView calendar;

    private List<UCalendarDate> items;
    private UCalendarAdapter adapter;

    private int currentYear;
    private int currentMonth;

    public UCalendar(Context context)
    {
        super(context);
        this.context = context;

        initializeComponents();
        initializeCalendar();
        fillCalendar(new DateTime());
    }

    private void initializeComponents()
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.calendar_component, this);

        previousButton = (ImageView) findViewById(R.id.previous_month_button);
        nextButton = (ImageView) findViewById(R.id.next_month_button);

        daysOfWeekLayout = (LinearLayout) findViewById(R.id.days_of_week);

        calendar = (RecyclerView) findViewById(R.id.calendar);

        previousButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    private void initializeCalendar()
    {
        items = new ArrayList<>();

        adapter = new UCalendarAdapter(context, items);

        calendar.setItemAnimator(new DefaultItemAnimator());
        calendar.setLayoutManager(new LinearLayoutManager(context));
        //calendar.addItemDecoration(new SpacesItemDecoration(16));
        calendar.setAdapter(adapter);
    }

    private void fillCalendar(DateTime dateTime)
    {

    }

    private void changeMonth(Flag flag)
    {
        //Do something
        DateTime dateTime = new DateTime();
        fillCalendar(dateTime);
    }

    public void setButtonsResources(int previousButtonResourceId, int nextButtonResourceId)
    {
        previousButton.setImageResource(previousButtonResourceId);
        nextButton.setImageResource(nextButtonResourceId);
    }

    public void setDaysOfWeekNames(String[] daysOfWeekNames)
    {
        if (daysOfWeekNames.length != 7) throw new ExceptionInInitializerError();
        else
        {
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            for (String dayOfWeek : daysOfWeekNames)
            {
                TextView dayOfWeekTextView = new TextView(context);
                dayOfWeekTextView.setText(dayOfWeek);
                dayOfWeekTextView.setLayoutParams(layoutParams);
                daysOfWeekLayout.addView(dayOfWeekTextView);
            }
        }

    }

    public void addEvent(int day, int month, int year)
    {

    }

    public void addEvent(DateTime dateTime)
    {

    }

    public void addEvent(int day, int month, int year, int markerColor)
    {

    }

    public void addEvent(DateTime dateTime, int markerColor)
    {

    }

    public void removeEvent(int day, int month, int year)
    {

    }

    public void removeEvent(DateTime dateTime)
    {

    }

    protected void setOnSelectDateListener(OnSelectDateListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.previous_month_button:
                changeMonth(Flag.PREVIOUS);
                break;

            case R.id.next_month_button:
                changeMonth(Flag.NEXT);
                break;

            default:
                break;
        }
    }
}