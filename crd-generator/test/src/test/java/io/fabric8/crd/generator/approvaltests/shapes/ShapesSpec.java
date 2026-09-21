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

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * The Java shapes whose schema does not follow from the field type alone: types with their own
 * serializer, enums that rename their values, properties that only exist as a getter, generic and
 * polymorphic types, and content that cannot be described at all.
 */
public class ShapesSpec {

  /** Serializes as a Kubernetes duration string ("1h30m") through its own serializer. */
  private Duration k8sDuration;
  /** Serializes as an ISO-8601 duration ("PT1H30M"), which no Kubernetes string format accepts. */
  private java.time.Duration isoDuration;
  private Period isoPeriod;
  private Instant instant;
  private LocalDate localDate;
  private UUID uuid;
  private Protocol protocol;
  private Holder holder;
  private Shape shape;
  private Object any;
  private Map<String, Object> anyMap;
  private List<Object> anyList;

  public Duration getK8sDuration() {
    return k8sDuration;
  }

  public void setK8sDuration(Duration k8sDuration) {
    this.k8sDuration = k8sDuration;
  }

  public java.time.Duration getIsoDuration() {
    return isoDuration;
  }

  public void setIsoDuration(java.time.Duration isoDuration) {
    this.isoDuration = isoDuration;
  }

  public Period getIsoPeriod() {
    return isoPeriod;
  }

  public void setIsoPeriod(Period isoPeriod) {
    this.isoPeriod = isoPeriod;
  }

  public Instant getInstant() {
    return instant;
  }

  public void setInstant(Instant instant) {
    this.instant = instant;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public Protocol getProtocol() {
    return protocol;
  }

  public void setProtocol(Protocol protocol) {
    this.protocol = protocol;
  }

  public Holder getHolder() {
    return holder;
  }

  public void setHolder(Holder holder) {
    this.holder = holder;
  }

  public Shape getShape() {
    return shape;
  }

  public void setShape(Shape shape) {
    this.shape = shape;
  }

  public Object getAny() {
    return any;
  }

  public void setAny(Object any) {
    this.any = any;
  }

  public Map<String, Object> getAnyMap() {
    return anyMap;
  }

  public void setAnyMap(Map<String, Object> anyMap) {
    this.anyMap = anyMap;
  }

  public List<Object> getAnyList() {
    return anyList;
  }

  public void setAnyList(List<Object> anyList) {
    this.anyList = anyList;
  }

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

  public static class GenericHolder<T> {
    private T value;

    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }
  }

  public static class Inner {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    /** Only exists as a getter, but Jackson still writes it. */
    public String getComputed() {
      return name == null ? null : name.toUpperCase();
    }
  }

  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "kind")
  @JsonSubTypes({ @JsonSubTypes.Type(value = Circle.class, name = "circle") })
  public abstract static class Shape {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  public static class Circle extends Shape {
    private double radius;

    public double getRadius() {
      return radius;
    }

    public void setRadius(double radius) {
      this.radius = radius;
    }
  }
}
