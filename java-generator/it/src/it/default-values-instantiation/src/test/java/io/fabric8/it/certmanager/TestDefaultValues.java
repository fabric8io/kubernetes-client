/**
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
package io.fabric8.it.certmanager;

import com.fasterxml.jackson.databind.JsonNode;
import io.cert_manager.v1.CertificateRequest;
import io.cert_manager.v1.certificaterequestspec.Ten;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.util.List;

import static io.cert_manager.v1.CertificateRequestSpec.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDefaultValues {

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");

  @Test
  void testDefaultValues() throws Exception {
    // Arrange
    CertificateRequest cr =
      Serialization.unmarshal(getClass().getResourceAsStream("/empty.yaml"), CertificateRequest.class);

    // Act
    String one = cr.getSpec().getOne();
    Boolean two = cr.getSpec().getTwo();
    Integer three = cr.getSpec().getThree();
    Long four = cr.getSpec().getFour();
    Long five = cr.getSpec().getFive();
    Float six = cr.getSpec().getSix();
    Double seven = cr.getSpec().getSeven();
    Double eight = cr.getSpec().getEight();
    List<String> nine = cr.getSpec().getNine();
    Ten ten = cr.getSpec().getTen();
    Eleven eleven = cr.getSpec().getEleven();
    ZonedDateTime twelve = cr.getSpec().getTwelve();

    // Assert
    assertEquals("one", one);
    assertEquals(true, two);
    assertEquals(3, three);
    assertEquals(4L, four);
    assertEquals(5L, five);
    assertEquals(6,1f, six);
    assertEquals(7.2d, seven);
    assertEquals(8.2d, eight);
    assertEquals(2, nine.size());
    assertEquals("nine1", nine.get(0));
    assertEquals("nine2", nine.get(1));
    assertEquals("tenone", ten.getTenOne());
    assertEquals("tentwo", ten.getTenTwo());
    assertEquals(Eleven.BAZ, eleven);
    assertEquals(ZonedDateTime.parse("2017-07-21T17:32:28Z", formatter), twelve);
  }
}
