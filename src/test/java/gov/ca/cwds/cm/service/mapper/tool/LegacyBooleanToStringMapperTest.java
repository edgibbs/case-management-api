package gov.ca.cwds.cm.service.mapper.tool;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;

/**
 * @author CWDS TPT-3 Team
 */
public class LegacyBooleanToStringMapperTest {

  private final LegacyBooleanToStringMapper testSubject = new LegacyBooleanToStringMapper();

  @Test
  public void toBooleanValue_returnsNull_whenUnknownValueInput() {
    final Boolean actual = testSubject.toBooleanValue("random_string");
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toBooleanValue_returnsNull_whenEmptyInput() {
    final Boolean actual = testSubject.toBooleanValue("");
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toBooleanValue_returnsNull_whenNullValueInput() {
    final Boolean actual = testSubject.toBooleanValue(null);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toBooleanValue_returnsTrue_whenYInput() {
    final Boolean actual = testSubject.toBooleanValue("Y");
    assertThat(actual, is(equalTo(Boolean.TRUE)));
  }

  @Test
  public void toBooleanValue_returnsFalse_whenNInput() {
    final Boolean actual = testSubject.toBooleanValue("N");
    assertThat(actual, is(equalTo(Boolean.FALSE)));
  }

  @Test
  public void toStringValue_returnsNull_whenNullInput() {
    final String actual = testSubject.toStringValue(null);
    assertThat(actual, is(nullValue()));
  }

  @Test
  public void toStringValue_returnsY_whenTrueInput() {
    final String actual = testSubject.toStringValue(true);
    assertThat(actual, is(equalTo("Y")));
  }

  @Test
  public void toStringValue_returnsN_whenFalseInput() {
    final String actual = testSubject.toStringValue(false);
    assertThat(actual, is(equalTo("N")));
  }

}