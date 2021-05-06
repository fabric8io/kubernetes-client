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
package io.fabric8.openshift.client.dsl.internal.build;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import io.fabric8.openshift.client.dsl.internal.build.BuildConfigOperationsImpl;
import okhttp3.OkHttpClient;
import okio.BufferedSink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ArchiveFileInputStreamRequestBodyTest {
  @Mock
  OkHttpClient okHttpClient;

  @Mock
  OpenShiftConfig config;

  @Mock
  BufferedSink bufferedSink;

  @BeforeEach
  public void setUp() {
    this.okHttpClient = Mockito.mock(OkHttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    this.config = new OpenShiftConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    this.bufferedSink = Mockito.mock(BufferedSink.class, Mockito.RETURNS_DEEP_STUBS);
  }

  @Test
  void testWriteToThrowsExceptionShouldAddEvents() throws IOException {
    // Given
    File tempFile = File.createTempFile("test-", ".war");
    String eventMessage = "FailedScheduling demo-1-7zkjd.1619493da51f6b6f some error";
    BuildConfigOperationsImpl.ArchiveFileInputStreamRequestBody body = new BuildConfigOperationsImpl.ArchiveFileInputStreamRequestBody(okHttpClient, config, new FileInputStream(tempFile), 50L, "test-bc", "ns1");
    body = spy(body);
    doThrow(IOException.class).when(body).writeToSink(any());
    doReturn(eventMessage).when(body).getRecentEvents();
    doCallRealMethod().when(body).writeTo(any());

    // When
    BuildConfigOperationsImpl.ArchiveFileInputStreamRequestBody finalBody = body;
    KubernetesClientException exception = assertThrows(KubernetesClientException.class,
      () -> finalBody.writeTo(bufferedSink));

    // Then
    assertTrue(exception.getMessage().contains(eventMessage));
  }

  @Test
  void testWriteToShouldCompleteSuccessfully() throws IOException {
    // Given
    BuildConfigOperationsImpl.ArchiveFileInputStreamRequestBody body = mock(BuildConfigOperationsImpl.ArchiveFileInputStreamRequestBody.class, Mockito.RETURNS_DEEP_STUBS);
    doNothing().when(body).writeToSink(any());

    // When
    body.writeTo(bufferedSink);

    // Then
    verify(body, times(0)).getRecentEvents();
  }
}
