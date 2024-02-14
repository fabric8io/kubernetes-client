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
package io.fabric8.kubeapitest.binary;

public class OSInfo {
  private final String os;
  private final String arch;

  public OSInfo() {
    final var osArch = System.getProperty("os.arch").toLowerCase();
    switch (osArch) {
      case "ppc64":
        arch = "ppc64le";
        break;
      case "aarch64":
        arch = "arm64";
        break;
      default:
        arch = "amd64";
    }

    final var os = System.getProperty("os.name").toLowerCase();
    if (os.contains("win")) {
      this.os = "windows";
    } else if (os.contains("mac")) {
      this.os = "darwin";
    } else {
      this.os = os;
    }
  }

  public String getOSName() {
    return os;
  }

  public String getOSArch() {
    return arch;
  }
}
