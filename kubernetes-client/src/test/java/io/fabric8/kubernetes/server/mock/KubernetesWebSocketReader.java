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

package io.fabric8.kubernetes.server.mock;

import okhttp3.ResponseBody;
import io.fabric8.mockwebserver.WebSocketReader;
import io.fabric8.mockwebserver.utils.Closeables;
import okio.ByteString;

import java.io.IOException;

public class KubernetesWebSocketReader implements WebSocketReader {
    @Override
    public byte[] read(ResponseBody message) {
        try {
            byte streamID = message.source().readByte();
            ByteString byteString = message.source().readByteString();
            if (byteString.size() > 0) {
                switch (streamID) {
                    case 1:
                    case 2:
                    case 3:
                        return byteString.toByteArray();
                    default:
                        throw new IOException("Unknown stream ID " + streamID);
                }
            }
        } catch (IOException e) {

        } finally {
            Closeables.closeQuietly(message);
        }
        throw new IllegalStateException("Failed to read websocket response body.");
    }
}
