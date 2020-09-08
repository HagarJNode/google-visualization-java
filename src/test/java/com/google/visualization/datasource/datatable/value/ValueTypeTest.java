// Copyright 2009 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.visualization.datasource.datatable.value;

import com.google.visualization.datasource.base.TypeMismatchException;

import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * A unit test for ValueType.
 *
 * @author Yaniv S.
 */
public class ValueTypeTest extends TestCase {

  /**
   * Tests ValueType.createValue();
   */
  public void testCreateValue() {
    // Test creating a TextValue.
    try {
      Value v = ValueType.TEXT.createValue("Text value");
      assertTrue(v.getType() == ValueType.TEXT);
      TextValue tv = (TextValue) v;
      assertEquals(tv.getValue(), "Text value");
    } catch (TypeMismatchException e) {
      fail();
    }

    // Verify that an exception is thrown on type mismatch for TextValue.
    try {
      Value v = ValueType.TEXT.createValue(5);
      fail();
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a null TextValue.
    try {
      Value v = ValueType.TEXT.createValue(null);
      assertTrue(v.getType() == ValueType.TEXT);
      TextValue tv = (TextValue) v;
      assertEquals(tv.getValue(), "");
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a NumberValue.
    try {
      Value v = ValueType.NUMBER.createValue(5.3);
      assertTrue(v.getType() == ValueType.NUMBER);
      NumberValue nv = (NumberValue) v;
      assertEquals(nv.getValue(), 5.3);
    } catch (TypeMismatchException e) {
      fail();
    }

    // Verify that an exception is thrown on type mismatch for NumberValue.
    try {
      Value v = ValueType.NUMBER.createValue("abc");
      fail();
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a null NumberValue.
    try {
      Value v = ValueType.NUMBER.createValue(null);
      assertTrue(v.getType() == ValueType.NUMBER);
      NumberValue nv = (NumberValue) v;
      assertEquals(nv, NumberValue.getNullValue());
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a BooleanValue.
    try {
      Value v = ValueType.BOOLEAN.createValue(true);
      assertTrue(v.getType() == ValueType.BOOLEAN);
      BooleanValue bv = (BooleanValue) v;
      assertEquals(bv.getValue(), true);
    } catch (TypeMismatchException e) {
      fail();
    }

    // Verify that an exception is thrown on type mismatch for BooleanValue.
    try {
      Value v = ValueType.BOOLEAN.createValue("abc");
      fail();
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a null BooleanValue.
    try {
      Value v = ValueType.BOOLEAN.createValue(null);
      assertTrue(v.getType() == ValueType.BOOLEAN);
      BooleanValue bv = (BooleanValue) v;
      assertEquals(bv, BooleanValue.getNullValue());
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a DateValue.
    try {
      Value v = ValueType.DATE.createValue(LocalDate.of(2009, 2, 15));
      assertTrue(v.getType() == ValueType.DATE);
      DateValue dv = (DateValue) v;
      assertEquals(dv.compareTo(new DateValue(LocalDate.of(2009, 2, 15))), 0);
    } catch (TypeMismatchException e) {
      fail();
    }

    // Verify that an exception is thrown on type mismatch for DateValue.
    try {
      Value v = ValueType.DATE.createValue("abc");
      fail();
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a null DateValue.
    try {
      Value v = ValueType.DATE.createValue(null);
      assertTrue(v.getType() == ValueType.DATE);
      DateValue dv = (DateValue) v;
      assertEquals(dv, DateValue.getNullValue());
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a DateTimeValue.
    try {
      Value v = ValueType.DATETIME.createValue(LocalDateTime.of(2009, 2, 15, 12, 30, 14));
      assertTrue(v.getType() == ValueType.DATETIME);
      DateTimeValue dtv = (DateTimeValue) v;
      assertEquals(dtv.compareTo(new DateTimeValue(LocalDateTime.of(2009, 2, 15, 12, 30, 14))), 0);
    } catch (TypeMismatchException e) {
      fail();
    }

    // Verify that an exception is thrown on type mismatch for DateTimeValue.
    try {
      Value v = ValueType.DATETIME.createValue("abc");
      fail();
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a null DateTimeValue.
    try {
      Value v = ValueType.DATETIME.createValue(null);
      assertTrue(v.getType() == ValueType.DATETIME);
      DateTimeValue dtv = (DateTimeValue) v;
      assertEquals(dtv, DateTimeValue.getNullValue());
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a TimeOfDayValue.
    try {
      Value v = ValueType.TIMEOFDAY.createValue(LocalTime.of(12, 30, 14));
      assertTrue(v.getType() == ValueType.TIMEOFDAY);
      TimeOfDayValue todv = (TimeOfDayValue) v;
      assertEquals(todv.compareTo(new TimeOfDayValue(LocalTime.of(12, 30, 14))), 0);
    } catch (TypeMismatchException e) {
      fail();
    }

    // Verify that an exception is thrown on type mismatch for TimeOfDayValue.
    try {
      Value v = ValueType.DATETIME.createValue("abc");
      fail();
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }

    // Test creating a null DateTimeValue.
    try {
      Value v = ValueType.TIMEOFDAY.createValue(null);
      assertTrue(v.getType() == ValueType.TIMEOFDAY);
      TimeOfDayValue todv = (TimeOfDayValue) v;
      assertEquals(todv, TimeOfDayValue.getNullValue());
    } catch (TypeMismatchException e) {
      // Do nothing, this is the expected behavior.
    }
  }
}
