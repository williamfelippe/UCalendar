package com.ucalendar.ucalendar.structure;

public class UCalendarDate
{
    private int date;
    private boolean marker;
    private int color;

    public UCalendarDate(int date)
    {
        setDate(date);
    }

    public UCalendarDate(int date, boolean marker)
    {
        setDate(date);
        setMarker(marker);
        setColor(color);
    }

    public UCalendarDate(int date, boolean marker, int color)
    {
        setDate(date);
        setMarker(marker);
        setColor(color);
    }

    public int getDate()
    {
        return date;
    }

    public void setDate(int date)
    {
        this.date = date;
    }

    public boolean hasMarker()
    {
        return marker;
    }

    public void setMarker(boolean marker)
    {
        this.marker = marker;
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }
}