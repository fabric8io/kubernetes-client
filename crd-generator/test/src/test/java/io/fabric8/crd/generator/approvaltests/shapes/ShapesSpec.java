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
package io.fabric8.crd.generator.approvaltests.shapes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.fabric8.kubernetes.api.model.Duration;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * The Java shapes whose schema does not follow from the field type alone: types with their own
 * serializer, enums that rename their values, properties that only exist as a getter, generic, optional
 * and polymorphic types, and content that cannot be described at all.
 * GeneratedCRDsOnApiServerTest round-trips a populated instance through a real API server.
 */
@Getter
@Setter
public class ShapesSpec {

  /** Serializes through its own serializer as a Go duration ("5400000000000ns"). */
  private Duration k8sDuration;
  /** Jackson reports date-time, but the value is an ISO-8601 duration ("PT1H30M"). */
  private java.time.Duration isoDuration;
  private Period isoPeriod;
  private Instant instant;
  private LocalDate localDate;
  /** Jackson reports date-time, but the value has no offset ("2026-01-01T10:15:30"). */
  private LocalDateTime localDateTime;
  private UUID uuid;
  private Protocol protocol;
  private Holder holder;
  private Shape shape;
  /** Inherits @JsonTypeInfo from an interface, so the client also writes a type id. */
  private Square square;
  /** On a property, @JsonTypeInfo applies to the elements. */
  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "dimensions")
  @JsonSubTypes({
      @JsonSubTypes.Type(value = Point.class, name = "2d"),
      @JsonSubTypes.Type(value = Point3d.class, name = "3d")
  })
  private List<Point> points;
  private Object any;
  private Map<String, Object> anyMap;
  private List<Object> anyList;
  private Optional<Object> optionalAny;
  private Optional<Map<String, String>> optionalLabels;

  /** Serialized through {@link JsonValue}, so the enum values are the lower-case ones. */
  public enum Protocol {
    TCP("tcp"),
    UDP("udp");

    private final String value;

    Protocol(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }
  }

  public static class Holder extends GenericHolder<Inner> {
  }

  @Getter
  @Setter
  public static class GenericHolder<T> {
    private T value;
  }

  @Getter
  @Setter
  public static class Inner {
    private String name;

    /** Only exists as a getter, but Jackson still writes it. */
    public String getComputed() {
      return name == null ? null : name.toUpperCase();
    }
  }

  @Getter
  @Setter
  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "kind")
  @JsonSubTypes({ @JsonSubTypes.Type(value = Circle.class, name = "circle") })
  public abstract static class Shape {
    private String name;
  }

  @Getter
  @Setter
  public static class Circle extends Shape {
    private double radius;
  }

  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "kind")
  @JsonSubTypes({ @JsonSubTypes.Type(value = Square.class, name = "square") })
  public interface Polygon {
  }

  @Getter
  @Setter
  public static class Square implements Polygon {
    private double side;
  }

  @Getter
  @Setter
  public static class Point {
    private int x;
    private int y;
  }

  @Getter
  @Setter
  public static class Point3d extends Point {
    private int z;
  }
}
