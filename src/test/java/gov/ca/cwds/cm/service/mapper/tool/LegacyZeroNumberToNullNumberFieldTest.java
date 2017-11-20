package gov.ca.cwds.cm.service.mapper.tool;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * @author CWDS TPT-3 Team
 */
public class LegacyZeroNumberToNullNumberFieldTest {

  private final LegacyZeroNumberToNullNumberMapper testSubject  = new LegacyZeroNumberToNullNumberMapper();

  @Test
  public void zeroToNull_null_whenZeroShortInput() {
    final Short actual = testSubject.zeroToNull((short) 0);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void zeroToNull_returnsInput_whenNonZeroShortInput() {
    // given
    final Short input = 10;

    // when
    final Number actual = testSubject.zeroToNull(input);

    // then
    assertThat(actual, is(input));
  }

  @Test
  public void zeroToNull_null_whenZeroLongInput() {
    final Long actual = testSubject.zeroToNull(0L);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void zeroToNull_returnsInput_whenNonZeroLongInput() {
    // given
    final Long input = 10L;

    // when
    final Number actual = testSubject.zeroToNull(input);

    // then
    assertThat(actual, is(input));
  }

  @Test
  public void nullToZero_zero_whenZeroShortInput() {
    final Short actual = testSubject.nullToZero((Short) null);
    assertThat(actual, is(equalTo((short) 0)));
  }

  @Test
  public void nullToZero_returnsInput_whenNonZeroShortInput() {
    // given
    final Short input = 10;

    // when
    final Short actual = testSubject.nullToZero(input);

    // then
    assertThat(actual, is(input));
  }

  @Test
  public void nullToZero_zero_whenZeroLongInput() {
    final Long actual = testSubject.nullToZero((Long) null);
    assertThat(actual, is(equalTo(0L)));
  }

  @Test
  public void nullToZero_returnsInput_whenNonZeroLongInput() {
    // given
    final Long input = 10L;

    // when
    final Long actual = testSubject.nullToZero(input);

    // then
    assertThat(actual, is(input));
  }

}