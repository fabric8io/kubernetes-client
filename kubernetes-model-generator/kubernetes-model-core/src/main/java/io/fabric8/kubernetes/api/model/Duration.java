/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.IOException;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Duration represents a duration
 *
 * <p>
 * Duration stores a period of time as a valid {@link java.time.Duration}.
 *
 * @see <a href=
 *      "https://github.com/kubernetes/kubernetes/blob/a38096a0696514a034de7f8d0cc5a3ec5e7da8ff/vendor/github.com/go-openapi/strfmt/duration.go#L74">github.com/go-openapi/strfmt/duration.go</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize
@JsonSerialize(using = Duration.Serializer.class)
@ToString
@EqualsAndHashCode
public class Duration implements KubernetesResource {

  private static final long serialVersionUID = -2326157920610452294L;

  private static final String DURATION_REGEX = "(\\d+)\\s*([A-Za-zµ]+)";
  private static final Pattern DURATION_PATTERN = Pattern.compile(DURATION_REGEX);
  private java.time.Duration javaDuration;

  /**
   * No args constructor for use in serialization
   */
  public Duration() {
  }

  public Duration(java.time.Duration javaDuration) {
    this.javaDuration = javaDuration;
  }

  public java.time.Duration getDuration() {
    return javaDuration;
  }

  public void setDuration(java.time.Duration javaDuration) {
    this.javaDuration = javaDuration;
  }

  /**
   * Converts Duration to a primitive value ready to be written to a database.
   *
   * @return duration value in nanoseconds
   */
  public Long getValue() {
    return Optional.ofNullable(javaDuration).map(java.time.Duration::toNanos).orElse(0L);
  }

  /**
   * Tests if the provided string represents a valid Duration.
   *
   * @param durationToTest String with a possible Duration value
   * @return true if the provided String is a Duration, false otherwise
   */
  public static boolean isDuration(String durationToTest) {
    try {
      Duration.parse(durationToTest);
      return true;
    } catch (ParseException e) {
      return false;
    }
  }

  /**
   * Parses {@link String} into Duration.
   *
   * <table>
   * <caption>Valid time abbreviations</caption>
   * <thead>
   * <tr>
   * <th>Abbreviation</th>
   * <th>Time Unit</th>
   * </tr>
   * </thead>
   * <tbody>
   * <tr>
   * <td>ns, nano, nanos</td>
   * <td>Nanosecond</td>
   * </tr>
   * <tr>
   * <td>us, µs, micro, micros</td>
   * <td>Microseconds</td>
   * </tr>
   * <tr>
   * <td>ms, milli, millis</td>
   * <td>Millisecond</td>
   * </tr>
   * <tr>
   * <td>s, sec, secs</td>
   * <td>Second</td>
   * </tr>
   * <tr>
   * <td>m, min, mins</td>
   * <td>Minute</td>
   * </tr>
   * <tr>
   * <td>h, hr, hour, hours</td>
   * <td>Hour</td>
   * </tr>
   * <tr>
   * <td>d, day, days</td>
   * <td>Day</td>
   * </tr>
   * <tr>
   * <td>w, wk, week, weeks</td>
   * <td>Week</td>
   * </tr>
   * </tbody>
   * </table>
   * <br>
   * <p>
   * Example:
   *
   * <pre>{@code
   *   Duration.parse("1min1s");
   * }</pre>
   *
   * @param duration String to be parsed
   * @return the parsed Duration
   * @throws ParseException if format is not parsable
   */
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public static Duration parse(String duration) throws ParseException {
    java.time.Duration accumulator = java.time.Duration.ZERO;
    boolean found = false;
    final Matcher matcher = Optional.ofNullable(duration).map(String::trim).map(DURATION_PATTERN::matcher).orElse(null);
    while (matcher != null && matcher.find()) {
      found = true;
      final java.time.Duration durationToken = Optional.ofNullable(TimeUnits.from(matcher.group(2)))
          .map(tu -> java.time.Duration.of(Long.parseLong(matcher.group(1)), tu.timeUnit))
          .orElseThrow(() -> new ParseException(String.format("Invalid duration token (%s)", matcher.group()), 0));
      accumulator = accumulator.plus(durationToken);
    }
    if (!found) {
      throw new ParseException(String.format("Provided duration string (%s) is invalid", duration), 0);
    }
    return new Duration(accumulator);
  }

  public static class Serializer extends StdSerializer<Duration> {

    public Serializer() {
      super(Duration.class);
    }

    @Override
    public void serialize(Duration duration, JsonGenerator jgen, SerializerProvider provider) throws IOException {
      jgen.writeString(String.format("%sns", duration.getValue()));
    }

    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
      visitor.expectStringFormat(typeHint);
    }
  }

  private enum TimeUnits {

    NANOSECOND(ChronoUnit.NANOS, "ns", "nano", "nanos"),
    MICROSECOND(ChronoUnit.MICROS, "us", "µs", "micro", "micros"),
    MILLISECOND(ChronoUnit.MILLIS, "ms", "milli", "millis"),
    SECOND(ChronoUnit.SECONDS, "s", "sec", "secs"),
    MINUTE(ChronoUnit.MINUTES, "m", "min", "mins"),
    HOUR(ChronoUnit.HOURS, "h", "hr", "hour", "hours"),
    DAY(ChronoUnit.DAYS, "d", "day", "days"),
    WEEK(SevenDayWeek.INSTANCE, "w", "wk", "week", "weeks");

    private final Set<String> abbreviations;
    private final TemporalUnit timeUnit;

    TimeUnits(TemporalUnit timeUnit, String... abbreviations) {
      this.timeUnit = timeUnit;
      this.abbreviations = new HashSet<>(Arrays.asList(abbreviations));
    }

    static TimeUnits from(String abbreviation) {
      return Stream.of(values()).filter(tu -> tu.abbreviations.contains(abbreviation.toLowerCase())).findAny()
          .orElse(null);
    }
  }

  /**
   * Provides an <strong>exact</strong> {@link TemporalUnit} implementation
   * of a 7 day week.
   */
  private static class SevenDayWeek implements TemporalUnit {

    private static final SevenDayWeek INSTANCE = new SevenDayWeek();

    private static final java.time.Duration SEVEN_DAYS = java.time.Duration.ofDays(7L);

    private SevenDayWeek() {
    }

    @Override
    public java.time.Duration getDuration() {
      return SEVEN_DAYS;
    }

    @Override
    public boolean isDurationEstimated() {
      return false;
    }

    @Override
    public boolean isDateBased() {
      return true;
    }

    @Override
    public boolean isTimeBased() {
      return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <R extends Temporal> R addTo(R temporal, long amount) {
      return (R) temporal.plus(amount, this);
    }

    @Override
    public long between(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
      return temporal1Inclusive.until(temporal2Exclusive, this);
    }
  }
}
