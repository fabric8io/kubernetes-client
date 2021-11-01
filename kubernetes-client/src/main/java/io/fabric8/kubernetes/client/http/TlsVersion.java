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
 */
public enum TlsVersion {
  TLS_1_3,
  TLS_1_2,
  TLS_1_1,
  TLS_1_0,
  SSL_3_0;

  public static TlsVersion forJavaName(String string) {
    if (string.equals("SSLv3")) {
      return SSL_3_0;
    }
    if (string.equals("TLSv1")) {
      return TLS_1_0;
    }
    return TlsVersion.valueOf(string.replaceAll("[v.]", "_"));
  }
  
}
