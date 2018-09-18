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

import io.fabric8.kubernetes.client.Config;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressMatcherTest {

  @Test
  public void testIpRangeMatcher() {
    Assert.assertTrue(new IpAddressMatcher("192.168.10.110").matches("192.168.10.110"));
    Assert.assertTrue(new IpAddressMatcher("192.168.1.0/8").matches("192.168.10.110"));
    Assert.assertTrue(new IpAddressMatcher("192.168.1.0/24").matches("192.168.1.100"));
    Assert.assertFalse(new IpAddressMatcher("192.168.1.0/24").matches("193.168.1.10"));
    Assert.assertFalse(new IpAddressMatcher("192.168.1.0/24").matches("192.168.2.10"));
    Assert.assertFalse(new IpAddressMatcher("192.168.1.0/24").matches("192.168.2.10"));
    Assert.assertFalse(new IpAddressMatcher("192.168.1.0/8").matches("193.168.1.10"));
    Assert.assertFalse(new IpAddressMatcher(Config.KUBERNETES_NO_PROXY).matches("kubernetes.default.svc"));
  }

  @Test
  public void testIpAddressRegexp() {
    try {
      Pattern pattern = Pattern.compile(HttpClientUtils.ipv4Pattern, Pattern.CASE_INSENSITIVE);
      Matcher matcherPlain = pattern.matcher("192.168.0.1");
      Assert.assertTrue(matcherPlain.matches());

      Matcher matcherPlainProtocol = pattern.matcher("http://192.168.0.1");
      Assert.assertTrue(matcherPlainProtocol.matches());

      Matcher matcherPlainProtocol2 = pattern.matcher("https://192.168.0.1");
      Assert.assertTrue(matcherPlainProtocol2.matches());

      Matcher matcherRange = pattern.matcher("192.168.0.1/24");
      Assert.assertTrue(matcherRange.matches());

      Matcher matcherRangeProtocol = pattern.matcher("http://192.168.0.1/24");
      Assert.assertTrue(matcherRangeProtocol.matches());

      Matcher matcherRangeProtocol2 = pattern.matcher("https://192.168.0.1/24");
      Assert.assertTrue(matcherRangeProtocol2.matches());
    } catch (Exception e) {
      throw new IllegalStateException("Failed to compile pattern.");
    }
  }
}
