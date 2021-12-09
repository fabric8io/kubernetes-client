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
package io.fabric8.kubernetes.client.dsl;

import java.io.IOException;

public interface ExecListener {
  
  public interface Response {
    
    int code();
    
    /**
     * May be null if not provided by the underlying implementation.
     * @return the body as a String
     * @throws IOException
     */
    String body() throws IOException;
    
  }

  /**
   * Called when the request has successfully been upgraded to a web socket.
   */
  default void onOpen() {}

  /**
   * Called when the transport or protocol layer of this web socket errors during communication.
   *
   * @param t Throwable
   * @param failureResponse non-null if the failure is caused by the handshake
   */
  default void onFailure(Throwable t, Response failureResponse) {}

    /**
     * Called when the server sends a close message.
     *
     * @param code The <a href="http://tools.ietf.org/html/rfc6455#section-7.4.1">RFC-compliant</a>
     * status code.
     * @param reason Reason for close or an empty string.
     */
    void onClose(int code, String reason);
}
