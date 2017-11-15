package gov.ca.cwds.cm.service.mapper.tool;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.math.BigDecimal;
import org.junit.Test;

/**
 * @author CWDS TPT-3 Team
 */
public class LegacyZeroNumberToNullStringMapperTest {

  private final LegacyZeroNumberToNullStringMapper testSubject = new LegacyZeroNumberToNullStringMapper();

  @Test
  public void toBigDecimal_zero_whenNullInput() {
    final BigDecimal actual = testSubject.toBigDecimal(null);
    assertThat(actual, is(equalTo(BigDecimal.ZERO)));
  }

  @Test
  public void toBigDecimal_zero_whenEmptyInput() {
    final BigDecimal actual = testSubject.toBigDecimal("");
    assertThat(actual, is(equalTo(BigDecimal.ZERO)));
  }

  @Test
  public void toBigDecimal_success_whenValidInput() {
    final BigDecimal actual = testSubject.toBigDecimal("123");
    assertThat(actual, is(equalTo(new BigDecimal("123"))));
  }

  @Test(expected = NumberFormatException.class)
  public void toBigDecimal_exception_whenInvalidInput() {
    testSubject.toBigDecimal("notANumber");
  }

  @Test
  public void toInteger_zero_whenNullInput() {
    final Integer actual = testSubject.toInteger(null);
    assertThat(actual, is(equalTo(0)));
  }

  @Test
  public void toInteger_zero_whenEmptyInput() {
    final Integer actual = testSubject.toInteger("");
    assertThat(actual, is(equalTo(0)));
  }

  @Test
  public void toInteger_success_whenValidInput() {
    final Integer actual = testSubject.toInteger("123");
    assertThat(actual, is(equalTo(123)));
  }

  @Test(expected = NumberFormatException.class)
  public void toInteger_exception_whenInvalidInput() {
    testSubject.toInteger("notANumber");
  }

  @Test
  public void toShort_zero_whenNullInput() {
    final Short actual = testSubject.toShort(null);
    assertThat(actual, is(equalTo((short) 0)));
  }

  @Test
  public void toShort_zero_whenEmptyInput() {
    final Short actual = testSubject.toShort("");
    assertThat(actual, is(equalTo((short) 0)));
  }

  @Test
  public void toShort_success_whenValidInput() {
    final Short actual = testSubject.toShort("123");
    assertThat(actual, is(equalTo((short) 123)));
  }

  @Test(expected = NumberFormatException.class)
  public void toShort_exception_whenInvalidInput() {
    testSubject.toShort("notANumber");
  }

  @Test
  public void toStringFromDecimal_null_whenNullInput() {
    final String actual = testSubject.toStringFromDecimal(null);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toStringFromDecimal_null_whenZeroInput() {
    final String actual = testSubject.toStringFromDecimal(BigDecimal.ZERO);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toStringFromDecimal_success_whenValidInput() {
    final String actual = testSubject.toStringFromDecimal(new BigDecimal("101"));
    assertThat(actual, is(equalTo("101")));
  }

  @Test
  public void toStringFromInteger_null_whenNullInput() {
    final String actual = testSubject.toStringFromInteger(null);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toStringFromInteger_null_whenZeroInput() {
    final String actual = testSubject.toStringFromInteger(0);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toStringFromInteger_success_whenValidInput() {
    final String actual = testSubject.toStringFromInteger(101);
    assertThat(actual, is(equalTo("101")));
  }

  @Test
  public void toStringFromShort_null_whenNullInput() {
    final String actual = testSubject.toStringFromShort(null);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toStringFromShort_null_whenZeroInput() {
    final String actual = testSubject.toStringFromShort((short) 0);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toStringFromShort_success_whenValidInput() {
    final String actual = testSubject.toStringFromShort(Short.parseShort("101"));
    assertThat(actual, is(equalTo("101")));
  }

}