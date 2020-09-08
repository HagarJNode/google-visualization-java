package com.google.visualization.datasource.base;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeFormat extends Format
{
  private final DateTimeFormatter dateTimeFormatter;
  private final int patternLength;

  public LocalDateTimeFormat(final String _pattern, final Locale _locale)
  {
    dateTimeFormatter = DateTimeFormatter.ofPattern(_pattern, _locale);
    patternLength = _pattern.length();
  }

  @Override
  public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos)
  {
    if (obj != null && toAppendTo != null)
    {
      if (obj instanceof LocalDateTime)
      {
        toAppendTo.append(dateTimeFormatter.format((LocalDateTime)obj));
      }
    }

    return toAppendTo;
  }

  @Override
  public Object parseObject(final String source, final ParsePosition pos)
  {
    pos.setIndex(patternLength);
    return LocalDateTime.parse(source, dateTimeFormatter);
  }
}

