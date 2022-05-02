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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.operator.v1.DNSRecord;
import io.fabric8.openshift.api.model.operator.v1.DNSRecordBuilder;
import io.fabric8.openshift.api.model.operator.v1.DNSRecordList;
import io.fabric8.openshift.api.model.operator.v1.DNSRecordListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class DNSRecordTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    DNSRecord dnsrecord = getDNSRecord();
    server.expect().post()
        .withPath("/apis/ingress.operator.openshift.io/v1/namespaces/ns1/dnsrecords")
        .andReturn(HttpURLConnection.HTTP_OK, dnsrecord)
        .once();

    // When
    dnsrecord = client.operator().dnsRecords().inNamespace("ns1").create(dnsrecord);

    // Then
    assertNotNull(dnsrecord);
    assertEquals("foo", dnsrecord.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/ingress.operator.openshift.io/v1/namespaces/ns1/dnsrecords/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getDNSRecord())
        .once();

    // When
    DNSRecord f = client.operator().dnsRecords().inNamespace("ns1").withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/ingress.operator.openshift.io/v1/namespaces/ns1/dnsrecords")
        .andReturn(HttpURLConnection.HTTP_OK, new DNSRecordListBuilder().withItems(getDNSRecord()).build())
        .once();

    // When
    DNSRecordList fgList = client.operator().dnsRecords().inNamespace("ns1").list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/ingress.operator.openshift.io/v1/namespaces/ns1/dnsrecords/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getDNSRecord())
        .once();

    // When
    boolean deleted = client.operator().dnsRecords().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private DNSRecord getDNSRecord() {
    return new DNSRecordBuilder()
        .withNewMetadata()
        .withName("foo")
        .withNamespace("ns1")
        .endMetadata()
        .withNewSpec()
        .withDnsName("foo.dns")
        .withRecordType("CNAME")
        .withTargets("1.2.4.3")
        .endSpec()
        .build();
  }
}
