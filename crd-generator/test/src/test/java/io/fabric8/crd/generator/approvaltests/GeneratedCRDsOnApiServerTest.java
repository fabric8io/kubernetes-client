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
package io.fabric8.crd.generator.approvaltests;

import io.fabric8.crd.generator.approvaltests.jdktypes.JdkTypes;
import io.fabric8.crd.generator.approvaltests.jdktypes.JdkTypesSpec;
import io.fabric8.crd.generator.approvaltests.shapes.Shapes;
import io.fabric8.crd.generator.approvaltests.shapes.ShapesSpec;
import io.fabric8.crdv2.generator.CRDGenerator;
import io.fabric8.crdv2.generator.v1.JsonSchema;
import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsBuilder;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.namespace.QName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.awaitility.Awaitility.await;

/**
 * Specs and approval files only pin what the generator emits. These tests check what matters to users against a
 * real API server: the CRDs are accepted, and the content the client writes is neither rejected nor pruned.
 */
// Pinned: an unversioned server reuses the newest cached binary, which may predate selectableFields (1.32+)
@EnableKubeAPIServer(kubeAPIVersion = "1.37.*")
class GeneratedCRDsOnApiServerTest {

  private static final String NAMESPACE = "default";

  static KubernetesClient client;

  @TempDir
  static File crdDir;

  @ParameterizedTest(name = "{1}")
  @MethodSource("io.fabric8.crd.generator.approvaltests.CRDGeneratorApprovalTest#crdApprovalTests")
  @DisplayName("Every approved CRD is a valid CRD the API server establishes")
  void approvedCrdIsEstablished(Class<? extends CustomResource<?, ?>>[] crClasses, String crdName) {
    assertThat(establish(generate(crdName, crClasses)).getMetadata().getName()).isEqualTo(crdName);
  }

  @Test
  @DisplayName("A populated Shapes resource round-trips through the API server without being rejected or pruned")
  void shapesRoundTrip() {
    establish(generate("shapes.samples.fabric8.io", Shapes.class));
    final Shapes shapes = new Shapes();
    shapes.setMetadata(new ObjectMetaBuilder().withName("all-shapes").withNamespace(NAMESPACE).build());
    shapes.setSpec(populatedShapes());
    // compared as written, reading it back into Shapes would depend on how Jackson deserializes the spec
    final GenericKubernetesResource written = client.getKubernetesSerialization()
        .convertValue(shapes, GenericKubernetesResource.class);

    createOnceServed(written);

    final GenericKubernetesResource stored = client.genericKubernetesResources("samples.fabric8.io/v1", "Shapes")
        .inNamespace(NAMESPACE).withName("all-shapes").get();
    assertThat(stored.getAdditionalProperties().get("spec"))
        .isEqualTo(written.getAdditionalProperties().get("spec"));
  }

  @Test
  @DisplayName("A populated JdkTypes resource round-trips through the API server without being rejected or pruned")
  void jdkTypesRoundTrip() {
    establish(generate("jdktypes.samples.fabric8.io", JdkTypes.class));
    final JdkTypes jdkTypes = new JdkTypes();
    jdkTypes.setMetadata(new ObjectMetaBuilder().withName("all-jdk-types").withNamespace(NAMESPACE).build());
    jdkTypes.setSpec(populatedJdkTypes());
    // through JSON, a conversion would keep the binary values as byte[] instead of their base64 string
    final GenericKubernetesResource written = client.getKubernetesSerialization()
        .unmarshal(client.getKubernetesSerialization().asJson(jdkTypes), GenericKubernetesResource.class);

    createOnceServed(written);

    final GenericKubernetesResource stored = client.genericKubernetesResources("samples.fabric8.io/v1", "JdkTypes")
        .inNamespace(NAMESPACE).withName("all-jdk-types").get();
    assertThat(stored.getAdditionalProperties().get("spec"))
        .isEqualTo(written.getAdditionalProperties().get("spec"));
  }

  /**
   * Pins the reason the migration guide recommends leaving empty binary values null or omitting them.
   */
  @Test
  @DisplayName("An empty byte[] is rejected, the client writes it as an empty string and format: byte doesn't accept it")
  void emptyByteArrayIsRejected() {
    establish(generate("jdktypes.samples.fabric8.io", JdkTypes.class));
    final JdkTypes jdkTypes = new JdkTypes();
    jdkTypes.setMetadata(new ObjectMetaBuilder().withName("empty-bytes").withNamespace(NAMESPACE).build());
    jdkTypes.setSpec(new JdkTypesSpec());
    jdkTypes.getSpec().setBytes(new byte[0]);

    assertThatThrownBy(() -> createOnceServed(jdkTypes))
        .isInstanceOf(KubernetesClientException.class)
        .extracting(e -> ((KubernetesClientException) e).getCode())
        .isEqualTo(422);
  }

  /**
   * Jackson reports date-time for every JDK date and time type, and the generator only keeps it for some.
   * Each value the client writes is sent to a CRD that declares date-time for every property: the API server
   * must accept exactly the ones the generator kept the format for.
   */
  @ParameterizedTest(name = "{0} keeps date-time: {1}")
  @MethodSource("temporalProperties")
  @DisplayName("The generator keeps date-time exactly where the API server accepts the value the client writes")
  void dateTimeFormatMatchesApiServerValidation(String property, boolean generatorKeepsDateTime) {
    establish(dateTimeEverywhereCrd());
    final GenericKubernetesResource resource = new GenericKubernetesResourceBuilder()
        .withApiVersion("samples.fabric8.io/v1").withKind("Temporals")
        .withNewMetadata().withName(property.toLowerCase()).withNamespace(NAMESPACE).endMetadata()
        .addToAdditionalProperties("spec", Map.of(property, TEMPORAL_VALUES.get(property)))
        .build();

    if (generatorKeepsDateTime) {
      createOnceServed(resource);
    } else {
      assertThatThrownBy(() -> createOnceServed(resource))
          .isInstanceOf(KubernetesClientException.class)
          .extracting(e -> ((KubernetesClientException) e).getCode())
          .isEqualTo(422);
    }
  }

  static Stream<Arguments> temporalProperties() {
    final Map<String, JSONSchemaProps> generated = JsonSchema.from(TemporalsSpec.class).getProperties();
    return TEMPORAL_VALUES.keySet().stream().sorted()
        .map(p -> Arguments.of(p, "date-time".equals(generated.get(p).getFormat())));
  }

  @SuppressWarnings("unchecked")
  private static final Map<String, Object> TEMPORAL_VALUES = new KubernetesSerialization()
      .convertValue(TemporalsSpec.sample(), Map.class);

  public static class TemporalsSpec {
    public Instant instant;
    public OffsetDateTime offsetDateTime;
    public ZonedDateTime zonedDateTime;
    public Date date;
    public java.sql.Timestamp timestamp;
    public java.sql.Date sqlDate;
    public Calendar calendar;
    public LocalDateTime localDateTime;
    public java.sql.Time sqlTime;
    public java.time.Duration duration;
    public OffsetTime offsetTime;
    public YearMonth yearMonth;
    public MonthDay monthDay;

    static TemporalsSpec sample() {
      final LocalDateTime localDateTime = LocalDateTime.of(2026, 1, 2, 10, 15, 30);
      final Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
      final GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
      calendar.setTimeInMillis(instant.toEpochMilli());
      final TemporalsSpec sample = new TemporalsSpec();
      sample.instant = instant;
      sample.offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(1));
      sample.zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Madrid"));
      sample.date = Date.from(instant);
      sample.timestamp = java.sql.Timestamp.from(instant);
      sample.sqlDate = new java.sql.Date(instant.toEpochMilli());
      sample.calendar = calendar;
      sample.localDateTime = localDateTime;
      sample.sqlTime = new java.sql.Time(instant.toEpochMilli());
      sample.duration = java.time.Duration.ofMinutes(90);
      sample.offsetTime = OffsetTime.of(localDateTime.toLocalTime(), ZoneOffset.ofHours(1));
      sample.yearMonth = YearMonth.from(localDateTime);
      sample.monthDay = MonthDay.from(localDateTime);
      return sample;
    }
  }

  private static CustomResourceDefinition dateTimeEverywhereCrd() {
    final JSONSchemaProps dateTime = new JSONSchemaPropsBuilder().withType("string").withFormat("date-time").build();
    return new CustomResourceDefinitionBuilder()
        .withNewMetadata().withName("temporals.samples.fabric8.io").endMetadata()
        .withNewSpec()
        .withGroup("samples.fabric8.io").withScope("Namespaced")
        .withNewNames().withKind("Temporals").withPlural("temporals").withSingular("temporals").endNames()
        .addNewVersion().withName("v1").withServed(true).withStorage(true)
        .withNewSchema().withNewOpenAPIV3Schema().withType("object")
        .addToProperties("spec", new JSONSchemaPropsBuilder().withType("object")
            .withProperties(TEMPORAL_VALUES.keySet().stream().collect(Collectors.toMap(p -> p, p -> dateTime)))
            .build())
        .endOpenAPIV3Schema().endSchema()
        .endVersion()
        .endSpec()
        .build();
  }

  private static ShapesSpec populatedShapes() {
    final ShapesSpec.Inner inner = new ShapesSpec.Inner();
    inner.setName("inner");
    final ShapesSpec.Holder holder = new ShapesSpec.Holder();
    holder.setValue(inner);
    final ShapesSpec.Circle circle = new ShapesSpec.Circle();
    circle.setName("circle");
    circle.setRadius(2.5);
    final ShapesSpec.Square square = new ShapesSpec.Square();
    square.setSide(1.5);
    final ShapesSpec.Point point = new ShapesSpec.Point();
    point.setX(1);
    point.setY(2);
    final ShapesSpec.Point3d point3d = new ShapesSpec.Point3d();
    point3d.setX(1);
    point3d.setY(2);
    point3d.setZ(3);
    final ShapesSpec spec = new ShapesSpec();
    spec.setK8sDuration(new Duration(java.time.Duration.ofMinutes(90)));
    spec.setIsoDuration(java.time.Duration.ofMinutes(90));
    spec.setIsoPeriod(Period.ofDays(3));
    spec.setInstant(Instant.parse("2026-01-02T10:15:30Z"));
    spec.setLocalDate(LocalDate.of(2026, 1, 2));
    spec.setLocalDateTime(LocalDateTime.of(2026, 1, 2, 10, 15, 30));
    spec.setUuid(UUID.fromString("9f1c7a5e-3b2d-4c1e-8f6a-0d9e8b7c6a5f"));
    spec.setProtocol(ShapesSpec.Protocol.UDP);
    spec.setHolder(holder);
    spec.setShape(circle);
    spec.setSquare(square);
    spec.setPoints(List.of(point, point3d));
    spec.setSerializedAsInner(inner);
    spec.setAny("a scalar, which type: object would reject");
    spec.setAnyMap(Map.of("number", 1, "nested", Map.of("list", List.of("a", "b"))));
    spec.setAnyList(List.of("text", 2, Map.of("key", "value")));
    spec.setOptionalAny(Optional.of(List.of(1, 2)));
    spec.setOptionalLabels(Optional.of(Map.of("app", "shapes")));
    return spec;
  }

  private static JdkTypesSpec populatedJdkTypes() {
    // 100 bytes are 136 base64 characters, more than the 76 per line a MIME encoder writes
    final byte[] bytes = new byte[100];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) (i * 7);
    }
    final JdkTypesSpec spec = new JdkTypesSpec();
    spec.setBytes(bytes);
    spec.setByteBuffer(ByteBuffer.wrap(bytes));
    spec.setOptionalBytes(Optional.of(bytes));
    spec.setByteArrays(List.of(bytes, new byte[] { 1 }));
    spec.setByteArrayMap(Map.of("key", bytes));
    spec.setMaxSizedBytes(bytes);
    spec.setMinSizedBytes(new byte[] { 1, 2 });
    spec.setEmptyBytes(new byte[0]);
    spec.setBoxedBytes(new Byte[] { 1, -1 });
    spec.setByteList(List.of((byte) 1, (byte) -1));
    spec.setChars("chars".toCharArray());
    spec.setQname(new QName("urn:example", "local", "ex"));
    spec.setQnames(List.of(new QName("local"), new QName("urn:example", "other")));
    spec.setYear(Year.of(2024));
    spec.setYears(List.of(Year.of(2024), Year.of(2025)));
    spec.setMonth(Month.JANUARY);
    spec.setMonths(Map.of("first", Month.JANUARY, "last", Month.DECEMBER));
    spec.setSqlDate(java.sql.Date.valueOf("2024-01-15"));
    spec.setSqlDates(List.of(java.sql.Date.valueOf("2024-01-15"), java.sql.Date.valueOf("2024-12-31")));
    spec.setLocale(Locale.forLanguageTag("zh-Hant-TW"));
    spec.setLocales(Map.of("es", Locale.forLanguageTag("es-ES"), "th", Locale.forLanguageTag("th-TH-u-nu-thai")));
    spec.setLocaleKeys(Map.of(Locale.forLanguageTag("zh-Hant-TW"), "zh"));
    spec.setMaxInt(Integer.MAX_VALUE);
    spec.setMaxLong(Long.MAX_VALUE);
    spec.setInts(List.of(Integer.MIN_VALUE, Integer.MAX_VALUE));
    spec.setLongs(Map.of("min", Long.MIN_VALUE, "max", Long.MAX_VALUE));
    return spec;
  }

  @SafeVarargs
  private static CustomResourceDefinition generate(String crdName, Class<? extends CustomResource<?, ?>>... crClasses) {
    final String file = new CRDGenerator()
        .inOutputDir(crdDir)
        .customResourceClasses(crClasses)
        .forCRDVersions("v1")
        .detailedGenerate()
        .getCRDDetailsPerNameAndVersion().get(crdName).get("v1").getFilePath();
    try (InputStream is = Files.newInputStream(Path.of(file))) {
      return client.getKubernetesSerialization().unmarshal(is, CustomResourceDefinition.class);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private static CustomResourceDefinition establish(CustomResourceDefinition crd) {
    client.resource(crd).forceConflicts().serverSideApply();
    return client.apiextensions().v1().customResourceDefinitions().withName(crd.getMetadata().getName())
        .waitUntilCondition(c -> c != null && c.getStatus() != null && c.getStatus().getConditions() != null
            && c.getStatus().getConditions().stream()
                .anyMatch(condition -> "Established".equals(condition.getType()) && "True".equals(condition.getStatus())),
            30, TimeUnit.SECONDS);
  }

  /**
   * The resource endpoint of a just established CRD can still answer 404 for a moment; any other error is final.
   */
  private static void createOnceServed(HasMetadata resource) {
    await().atMost(30, TimeUnit.SECONDS).until(() -> {
      try {
        client.resource(resource).create();
        return true;
      } catch (KubernetesClientException e) {
        if (e.getCode() == 404) {
          return false;
        }
        throw e;
      }
    });
  }
}
