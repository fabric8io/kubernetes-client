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
package io.fabric8.kubernetes.client.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IpAddressMatcherTest {

  @DisplayName("matches returns true for matching IPs and IP/Netmask subnets")
  @ParameterizedTest(name = "{index}: IP ''{1}'' matches ''{0}'' IP/Netmask")
  @MethodSource("matchesTrueInput")
  void matchesTrue(String ipOrSubnet, String ip) {
    assertThat(new IpAddressMatcher(ipOrSubnet).matches(ip)).isTrue();
  }

  static Stream<Arguments> matchesTrueInput() {
    return Stream.of(
        arguments("192.168.1.0/24", "192.168.1.104"),
        arguments("192.168.10.110", "192.168.10.110"),
        arguments("192.168.1.0/8", "192.168.10.110"),
        arguments("192.168.1.0/24", "192.168.1.100"),
        arguments("0.0.0.0/0", "123.4.5.6"),
        arguments("0.0.0.0/0", "192.168.0.159"),
        arguments("192.168.0.159/0", "123.4.5.6"),
        arguments("192.168.0.159/0", "192.168.0.159"));
  }

  @DisplayName("matches returns false for non-matching IPs and IP/Netmask subnets")
  @ParameterizedTest(name = "{index}: IP ''{1}'' does not match ''{0}'' IP/Netmask")
  @MethodSource("matchesFalseInput")
  void matchesFalse(String ipOrSubnet, String ip) {
    assertThat(new IpAddressMatcher(ipOrSubnet).matches(ip)).isFalse();
  }

  static Stream<Arguments> matchesFalseInput() {
    return Stream.of(
        arguments("192.168.10.110", "192.168.1.0/8"),
        arguments("192.168.1.0/24", "193.168.1.10"),
        arguments("192.168.1.0/24", "192.168.2.10"),
        arguments("192.168.1.0/8", "193.168.1.10"),
        arguments("192.168.1.128/25", "192.168.1.104"),
        arguments("kubernetes.default.svc", "kubernetes.default.svc"));
  }
}
