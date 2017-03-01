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

import okhttp3.Response;

import java.io.IOException;

public interface ExecListener {

    /**
     * Called when the request has successfully been upgraded to a web socket.
     */
    void onOpen( Response response);

    /**
     * Called when the transport or protocol layer of this web socket errors during communication.
     *
     * @param response Present when the failure is a direct result of the response (e.g., failed
     * upgrade, non-101 response code, etc.). {@code null} otherwise.
     */
    void onFailure(Throwable t, Response response);


    /**
     * Called when the server sends a close message. This may have been initiated
     * from a call to {@link okhttp3.WebSocket#close(int, String) close()} or as an unprompted
     * message from the server.
     *
     * @param code The <a href="http://tools.ietf.org/html/rfc6455#section-7.4.1">RFC-compliant</a>
     * status code.
     * @param reason Reason for close or an empty string.
     */
    void onClose(int code, String reason);
}
