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
package io.fabric8.kubernetes.client.internal;

import java.io.*;
import java.math.BigInteger;
import java.security.spec.RSAPrivateCrtKeySpec;

/**
 * This code is inspired and taken over from net.auth.core:oauth
 * (albeit in a highly stripped variation):
 * <p/>
 * Source is from http://oauth.googlecode.com/svn/code/java/ which is licensed
 * under the APL (http://oauth.googlecode.com/svn/code/java/LICENSE.txt)
 * <p/>
 * All credits go to the original author (zhang)
 *
 * @author roland
 * @since 30/09/15
 */
class PKCS1Util {

  private PKCS1Util() {
  }

  public static RSAPrivateCrtKeySpec decodePKCS1(byte[] keyBytes) throws IOException {
    DerParser parser = new DerParser(keyBytes);
    Asn1Object sequence = parser.read();
    sequence.validateSequence();
    parser = new DerParser(sequence.getValue());
    parser.read();

    return new RSAPrivateCrtKeySpec(next(parser), next(parser),
      next(parser), next(parser),
      next(parser), next(parser),
      next(parser), next(parser));
  }

  // ==========================================================================================

  private static BigInteger next(DerParser parser) throws IOException {
    return parser.read().getInteger();
  }

  static class DerParser {

    private InputStream in;

    DerParser(byte[] bytes) throws IOException {
      this.in = new ByteArrayInputStream(bytes);
    }

    Asn1Object read() throws IOException {
      int tag = in.read();

      if (tag == -1) {
        throw new IOException("Invalid DER: stream too short, missing tag");
      }

      int length = getLength();
      byte[] value = new byte[length];
      if (in.read(value) < length) {
        throw new IOException("Invalid DER: stream too short, missing value");
      }

      return new Asn1Object(tag, value);
    }

    private int getLength() throws IOException {
      int i = in.read();
      if (i == -1) {
        throw new IOException("Invalid DER: length missing");
      }

      if ((i & ~0x7F) == 0) {
        return i;
      }

      int num = i & 0x7F;
      if (i >= 0xFF || num > 4) {
        throw new IOException("Invalid DER: length field too big ("
          + i + ")");
      }

      byte[] bytes = new byte[num];
      if (in.read(bytes) < num) {
        throw new IOException("Invalid DER: length too short");
      }

      return new BigInteger(1, bytes).intValue();
    }
  }

  static class Asn1Object {

    private final int type;
    private final byte[] value;
    private final int tag;

    public Asn1Object(int tag, byte[] value) {
      this.tag = tag;
      this.type = tag & 0x1F;
      this.value = value;
    }

    public byte[] getValue() {
      return value;
    }

    BigInteger getInteger() throws IOException {
      if (type != 0x02) {
        throw new IOException("Invalid DER: object is not integer"); //$NON-NLS-1$
      }
      return new BigInteger(value);
    }

    void validateSequence() throws IOException {
      if (type != 0x10) {
        throw new IOException("Invalid DER: not a sequence");
      }
      if ((tag & 0x20) != 0x20) {
        throw new IOException("Invalid DER: can't parse primitive entity");
      }
    }
  }
}
