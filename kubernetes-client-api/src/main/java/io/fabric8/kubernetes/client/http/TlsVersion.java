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

package io.fabric8.kubernetes.client.http;

/**
 * TODO: determine if java names should be used here as well or instead
 *
 * Replacement for okhttp3.TlsVersion
 */
public enum TlsVersion {

  // these need to be kept in preference order
  TLS_1_3("TLSv1.3"),
  TLS_1_2("TLSv1.2"),
  @Deprecated
  TLS_1_1("TLSv1.1"),
  @Deprecated
  TLS_1_0("TLSv1"),
  @Deprecated
  SSL_3_0("SSLv3"),
  ;

  final String javaName;

  TlsVersion(String javaName) {
    this.javaName = javaName;
  }

  public static TlsVersion forJavaName(String string) {
    if (string.equals("SSLv3")) {
      return SSL_3_0;
    }
    if (string.equals("TLSv1")) {
      return TLS_1_0;
    }
    return TlsVersion.valueOf(string.replaceAll("[v.]", "_"));
  }

  public String javaName() {
    return javaName;
  }

}
