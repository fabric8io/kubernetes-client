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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.client.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
* Excerpt of code by @author Luke Taylor from
* https://github.com/spring-projects/spring-security/blob/master/web/src/main/java/org/springframework/security/web/util/matcher/IpAddressMatcher.java
*
*
* Matches a request based on IP Address or subnet mask matching against the remote
* address.
* <p>
* Both IPv6 and IPv4 addresses are supported, but a matcher which is configured with an
* IPv4 address will never match a request which returns an IPv6 address, and vice-versa.
*
* */
public final class IpAddressMatcher {

  private static final Logger logger = LoggerFactory.getLogger(IpAddressMatcher.class);

  private final int nMaskBits;

  private final InetAddress requiredAddress;

  /**
   * Takes a specific IP address or a range specified using the IP/Netmask (e.g.
   * 192.168.1.0/24 or 202.24.0.0/14).
   *
   * @param ipAddress the address or range of addresses from which the request must
   *        come.
   */
  public IpAddressMatcher(String ipAddress) {
    if (ipAddress.indexOf('/') > 0) {
      String[] addressWithMask = ipAddress.split("\\/");
      ipAddress = addressWithMask[0];
      this.nMaskBits = Integer.parseInt(addressWithMask[1]);
    } else {
      this.nMaskBits = -1;
    }
    this.requiredAddress = parseAddress(ipAddress);
  }

  public boolean matches(String address) {
    InetAddress remoteAddress = parseAddress(address);
    if (remoteAddress == null || requiredAddress == null) {
      return false;
    }
    if (!this.requiredAddress.getClass().equals(remoteAddress.getClass())) {
      return false;
    }
    if (this.nMaskBits < 0) {
      return remoteAddress.equals(this.requiredAddress);
    }
    byte[] remAddr = remoteAddress.getAddress();
    byte[] reqAddr = this.requiredAddress.getAddress();
    int nMaskFullBytes = this.nMaskBits / 8;
    byte finalByte = (byte) (0xFF00 >> (this.nMaskBits & 0x07));
    for (int i = 0; i < nMaskFullBytes; i++) {
      if (remAddr[i] != reqAddr[i]) {
        return false;
      }
    }
    if (finalByte != 0) {
      return (remAddr[nMaskFullBytes] & finalByte) == (reqAddr[nMaskFullBytes] & finalByte);
    }
    return true;
  }

  private InetAddress parseAddress(String address) {
    try {
      return InetAddress.getByName(address);
    } catch (UnknownHostException e) {
      // Log error only when address is not generated by client as default parameters
      if (!Config.DEFAULT_MASTER_URL.contains(address)) {
        logger.error("Failed to resolve hostname: {}", address);
      }
      return null;
    }
  }
}
