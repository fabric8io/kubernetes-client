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
package io.fabric8.mockwebserver

import io.fabric8.mockwebserver.utils.ResponseProvider
import okhttp3.*
import okhttp3.mockwebserver.RecordedRequest
import okio.ByteString
import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference

class DefaultMockServerTest extends Specification {

    DefaultMockServer server

    @Shared
    OkHttpClient client = new OkHttpClient()

    def setup() {
        server = new DefaultMockServer()
        server.start()
    }

    def cleanup() {
        server.shutdown()
    }

    def "getPort, should return a valid port"() {
        when:
        def result = server.getPort()

        then:
        assert result > 0
        assert result <= 65535
    }

    def "getHostName, should return a valid host name"() {
        when:
        def result = server.getHostName()

        then:
        assert !result.isBlank()
    }

    def "toProxy, should return Proxy with the current HostName and Port"() {
        when:
        def result = server.toProxyAddress()

        then:
        assert result.address() instanceof InetSocketAddress
        assert ((InetSocketAddress)result.address()).getPort() == server.getPort()
        assert ((InetSocketAddress)result.address()).getHostName() == server.getHostName()
    }

    def "getRequestCount, with no requests, should return 0"() {
        when:
        def result = server.getRequestCount()

        then:
        assert result == 0
    }

    def "getRequestCount, with multiple, should return valid request count"() {
        given:
        client.newCall(new Request.Builder().url(server.url("/")).get().build()).execute()
        client.newCall(new Request.Builder().url(server.url("/one")).get().build()).execute()
        client.newCall(new Request.Builder().url(server.url("/two")).get().build()).execute()

        when:
        def result = server.getRequestCount()

        then:
        assert result == 3
    }

    def "getLastRequest, with no requests, should return null"() {
        when:
        def result = server.getLastRequest()

        then:
        assert result == null
    }

    def "getLastRequest, with one request, should return the request"() {
        given:
        client.newCall(new Request.Builder().url(server.url("/")).get().build()).execute()

        when:
        def result = server.getLastRequest()

        then:
        assert result.getPath() == "/"
    }

    def "getLastRequest, with one request, can be invoked multiple times"() {
        given:
        client.newCall(new Request.Builder().url(server.url("/")).get().build()).execute()
        server.getLastRequest()

        when:
        def result = server.getLastRequest()

        then:
        assert result.getPath() == "/"
    }

    def "getLastRequest, with multiple requests, should return the latest request"() {
        given:
        client.newCall(new Request.Builder().url(server.url("/")).get().build()).execute()
        client.newCall(new Request.Builder().url(server.url("/one")).get().build()).execute()
        client.newCall(new Request.Builder().url(server.url("/two")).get().build()).execute()

        when:
        def result = server.getLastRequest()

        then:
        assert result.getPath() == "/two"
    }

    def "getLastRequest, with multiple requests, can be invoked multiple times"() {
        given:
        client.newCall(new Request.Builder().url(server.url("/")).get().build()).execute()
        client.newCall(new Request.Builder().url(server.url("/one")).get().build()).execute()
        server.getLastRequest()
        client.newCall(new Request.Builder().url(server.url("/two")).get().build()).execute()
        server.getLastRequest()

        when:
        def result = server.getLastRequest()

        then:
        assert result.getPath() == "/two"
    }

    def "takeRequest, with timeout and no requests, should return null and don't block (after timeout)"() {
        when:
        def result = server.takeRequest(1, TimeUnit.MICROSECONDS)

        then:
        assert result == null
    }

    def "when setting an expectation with once it should be met only the first time"() {
        given:
        server.expect().get().withPath("/api/v1/users").andReturn(200, "admin").once()

        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users")).get().build()
        Response response1 = client.newCall(request).execute()
        Response response2 = client.newCall(request).execute()

        then:
        assert response1.code() == 200
        assert response1.body().string() == "admin"
        assert response2.code() == 404

        cleanup:
        response1.close()
        response2.close()
    }

    def "when setting an expectation with n-th times it should be met only the for the first n-th times"() {
        given:
        server.expect().get().withPath("/api/v1/users").andReturn(200, "admin").times(3)

        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users")).get().build()
        Response response1 = client.newCall(request).execute()
        Response response2 = client.newCall(request).execute()
        Response response3 = client.newCall(request).execute()
        Response response4 = client.newCall(request).execute()

        then:
        assert response1.code() == 200
        assert response1.body().string() == "admin"
        assert response2.code() == 200
        assert response2.body().string() == "admin"
        assert response3.code() == 200
        assert response3.body().string() == "admin"
        assert response4.code() == 404

        cleanup:
        response1.close()
        response2.close()
        response3.close()
        response4.close()
    }

    def "when setting an expectation with always it should be met only always"() {
        given:
        server.expect().get().withPath("/api/v1/users").andReturn(200, "admin").always()

        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users")).get().build()
        Response response1 = client.newCall(request).execute()
        Response response2 = client.newCall(request).execute()
        Response response3 = client.newCall(request).execute()
        Response response4 = client.newCall(request).execute()

        then:
        assert response1.code() == 200
        assert response1.body().string() == "admin"
        assert response2.code() == 200
        assert response2.body().string() == "admin"
        assert response3.code() == 200
        assert response3.body().string() == "admin"
        assert response4.code() == 200
        assert response4.body().string() == "admin"

        cleanup:
        response1.close()
        response2.close()
        response3.close()
        response4.close()
    }

    def "when setting an expectation as an object it should be serialized to json"() {
        given:
        User root = new User(0, "root", true)

        server.expect().get().withPath("/api/v1/users").andReturn(200, root).always()

        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users")).get().build()
        Response response1 = client.newCall(request).execute()

        then:
        assert response1.code() == 200
        assert response1.body().string() == "{\"id\":0,\"username\":\"root\",\"enabled\":true}"

        cleanup:
        response1.close()
    }

    def "when setting a timed websocket message it should be fire at the specified time"() {
        given:
        CountDownLatch closed = new CountDownLatch(1)
        Queue<String> messages = new ArrayBlockingQueue<String>(1)
        AtomicReference<WebSocket> webSocketRef = new AtomicReference<>()
        WebSocketListener listener = new WebSocketListener() {
            @Override
            void onMessage(WebSocket webSocket, String text) {
                messages.add(text)
            }

            @Override
            void onMessage(WebSocket webSocket, ByteString bytes) {
                onMessage(webSocket, bytes.utf8())
            }

            @Override
            void onClosing(WebSocket webSocket, int code, String reason) {
                webSocket.close(code, reason)
            }

            @Override
            void onClosed(WebSocket webSocket, int code, String reason) {
                closed.countDown()
            }
        }

        server.expect().get().withPath("/api/v1/users/watch")
            .andUpgradeToWebSocket()
                .open()
                .waitFor(1000).andEmit("DELETED")
                .done()
            .once()

        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users/watch")).get().build()
        webSocketRef.set(client.newWebSocket(request, listener))

        then:
        messages.poll(10, TimeUnit.SECONDS) == "DELETED"

        when:
        webSocketRef.get().close(1000, "just close")

        then:
        closed.await(10, TimeUnit.SECONDS)
    }

    def "when setting a request/response websocket message it should be fired when the event is triggered"() {
        given:
        CountDownLatch opened = new CountDownLatch(1)
        CountDownLatch closed = new CountDownLatch(1)
        CountDownLatch queued = new CountDownLatch(2)
        Queue<String> messages = new ArrayBlockingQueue<String>(2)
        AtomicReference<WebSocket> webSocketRef = new AtomicReference<>()

        WebSocketListener listener = new WebSocketListener() {
            @Override
            void onOpen(WebSocket webSocket, Response response) {
                webSocketRef.set(webSocket)
                opened.countDown()
            }

            @Override
            void onMessage(WebSocket webSocket, String text) {
                messages.add(text)
                queued.countDown()
            }

            @Override
            void onMessage(WebSocket webSocket, ByteString bytes) {
                onMessage(webSocket, bytes.utf8())
            }

            @Override
            void onClosing(WebSocket webSocket, int code, String reason) {
                webSocket.close(code, reason)
            }

            @Override
            void onClosed(WebSocket webSocket, int code, String reason) {
                closed.countDown()
            }
        }

        server.expect().get().withPath("/api/v1/users/watch")
                .andUpgradeToWebSocket()
                .open()
                    .expect("create root").andEmit("CREATED").once()
                    .expect("delete root").andEmit("DELETED").once()
                .done()
                .once()


        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users/watch")).get().build()
        webSocketRef.set(client.newWebSocket(request, listener))

        then:
        opened.await(10, TimeUnit.SECONDS)
        WebSocket ws = webSocketRef.get()
        ws.send("create root")
        ws.send("delete root")
        queued.await(10, TimeUnit.SECONDS)
        messages.poll(10, TimeUnit.SECONDS) == "CREATED"
        messages.poll(10, TimeUnit.SECONDS) == "DELETED"

        when:
        ws.close(1000, "just close")

        then:
        closed.await(10, TimeUnit.SECONDS)
    }

    def "when receiving an unexpected websocket message it should close the connection with status code 1002"() {
        given:
        CountDownLatch opened = new CountDownLatch(1)
        CountDownLatch closed = new CountDownLatch(1)
        int closeCode = -1
        String closeReason = null
        AtomicReference<WebSocket> webSocketRef = new AtomicReference<>()

        WebSocketListener listener = new WebSocketListener() {
            @Override
            void onOpen(WebSocket webSocket, Response response) {
                webSocketRef.set(webSocket)
                opened.countDown()
            }

            @Override
            void onMessage(WebSocket webSocket, String text) {
                System.out.println(text)
            }

            @Override
            void onMessage(WebSocket webSocket, ByteString bytes) {
                onMessage(webSocket, bytes.utf8())
            }

            @Override
            void onClosing(WebSocket webSocket, int code, String reason) {
                System.out.println("Closing: " + code + " : " + reason)
                webSocket.close(code, reason)
            }

            @Override
            void onClosed(WebSocket webSocket, int code, String reason) {
                closeCode = code
                closeReason = reason
                closed.countDown()
            }
        }

        server.expect().get().withPath("/api/v1/users/watch")
                .andUpgradeToWebSocket()
                .open()
                    .expect("expected message").andEmit("MESSAGE OK").once()
                .done()
                .once()

        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users/watch")).get().build()
        webSocketRef.set(client.newWebSocket(request, listener))

        then:
        opened.await(10, TimeUnit.SECONDS)
        WebSocket ws = webSocketRef.get()
        ws.send("unexpected message")
        closed.await(10, TimeUnit.SECONDS)
        assert closeCode == 1002
        assert closeReason == "Unexpected message:unexpected message"

    }

    def "when setting a delayed response it should be delayed for the specified duration"() {
        given:
        server.expect().get().withPath("/api/v1/users").delay(100, TimeUnit.MILLISECONDS).andReturn(200, "admin").once()

        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users")).get().build()
        long startTime = System.currentTimeMillis()
        Response response1 = client.newCall(request).execute()

        then:
        assert response1.code() == 200
        assert response1.body().string() == "admin"
        assert System.currentTimeMillis() - startTime >= 100

        cleanup:
        response1.close()
    }

    def "when using a body provider it should work as for static responses"() {
        given:
        int[] counter = [0]
        server.expect().get().withPath("/api/v1/users").andReply(200, {req -> "admin" + (counter[0]++)}).always()

        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users")).get().build()
        Response response1 = client.newCall(request).execute()
        Response response2 = client.newCall(request).execute()

        then:
        assert response1.code() == 200
        assert response1.body().string() == "admin0"
        assert response2.code() == 200
        assert response2.body().string() == "admin1"

        cleanup:
        response1.close()
        response2.close()
    }

    def "when using a response provider it should work as for static responses"() {
        given:
        int[] counter = [0, 0]
        server.expect().get().withPath("/api/v1/users").andReply(new ResponseProvider<Object>() {
            private Headers headers = new Headers.Builder().build()

            int getStatusCode(RecordedRequest request) {
                return 200 + (counter[0]++)
            }

            Object getBody(RecordedRequest request) {
                return "admin" + (counter[1]++)
            }

            @Override
            Headers getHeaders() {
                return headers
            }

            @Override
            void setHeaders(Headers headers) {
                this.headers = headers
            }
        }).always()

        when:
        Request req = new Request.Builder().url(server.url("/api/v1/users")).get().build()
        Response response1 = client.newCall(req).execute()
        Response response2 = client.newCall(req).execute()

        then:
        assert response1.code() == 200
        assert response1.body().string() == "admin0"
        assert response2.code() == 201
        assert response2.body().string() == "admin1"

        cleanup:
        response1.close()
        response2.close()
    }

    def "should be able to set headers on responses"() {
        given:
        server.expect().get().withPath("/api/v1/users").andReturn(200, "admin").withHeader("test: header").withHeader("test2", "header2").once()

        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users")).get().build()
        Response response = client.newCall(request).execute()

        then:
        assert response.code() == 200
        assert response.body().string() == "admin"
        assert response.header("test") == "header"
        assert response.header("test2") == "header2"

        cleanup:
        response.close()
    }

    def "when setting an httprequest/response websocket message it should be fired when the event is triggered"() {
        given:
        CountDownLatch opened = new CountDownLatch(1)
        CountDownLatch closed = new CountDownLatch(1)
        CountDownLatch queued = new CountDownLatch(2)
        Queue<String> messages = new ArrayBlockingQueue<String>(2)
        AtomicReference<WebSocket> webSocketRef = new AtomicReference<>()

        WebSocketListener listener = new WebSocketListener() {
            @Override
            void onOpen(WebSocket webSocket, Response response) {
                webSocketRef.set(webSocket)
                opened.countDown()
            }

            @Override
            void onMessage(WebSocket webSocket, String text) {
                messages.add(text)
                queued.countDown()
            }

            @Override
            void onMessage(WebSocket webSocket, ByteString bytes) {
                onMessage(webSocket, bytes.utf8())
            }

            @Override
            void onClosing(WebSocket webSocket, int code, String reason) {
                webSocket.close(code, reason)
            }

            @Override
            void onClosed(WebSocket webSocket, int code, String reason) {
                closed.countDown()
            }
        }

        server.expect().get().withPath("/api/v1/users/watch")
                .andUpgradeToWebSocket()
                .open()
                .expectHttpRequest("/api/v1/create").andEmit("CREATED").once()
                .expectHttpRequest("/api/v1/delete").andEmit("DELETED").once()
                .done()
                .once()


        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users/watch")).get().build()
        webSocketRef.set(client.newWebSocket(request, listener))

        then:
        opened.await(10, TimeUnit.SECONDS)
        WebSocket ws = webSocketRef.get()

        when:
        request = new Request.Builder().url(server.url("/api/v1/create")).get().build()
        client.newCall(request).execute()

        then:
        messages.poll(10, TimeUnit.SECONDS) == "CREATED"

        when:
        request = new Request.Builder().url(server.url("/api/v1/delete")).get().build()
        client.newCall(request).execute()

        then:
        messages.poll(10, TimeUnit.SECONDS) == "DELETED"

        when:
        ws.close(1000, "just close")

        then:
        closed.await(10, TimeUnit.SECONDS)
    }

    def "when setting an sentWebSocketMessage/response websocket message it should be fired when the event is triggered"() {
        given:
        CountDownLatch opened = new CountDownLatch(1)
        CountDownLatch closed = new CountDownLatch(1)
        CountDownLatch queued = new CountDownLatch(2)
        Queue<String> messages = new ArrayBlockingQueue<String>(2)
        AtomicReference<WebSocket> webSocketRef = new AtomicReference<>()

        WebSocketListener listener = new WebSocketListener() {
            @Override
            void onOpen(WebSocket webSocket, Response response) {
                webSocketRef.set(webSocket)
                opened.countDown()
            }

            @Override
            void onMessage(WebSocket webSocket, String text) {
                messages.add(text)
                queued.countDown()
            }

            @Override
            void onMessage(WebSocket webSocket, ByteString bytes) {
                onMessage(webSocket, bytes.utf8())
            }

            @Override
            void onClosing(WebSocket webSocket, int code, String reason) {
                webSocket.close(code, reason)
            }

            @Override
            void onClosed(WebSocket webSocket, int code, String reason) {
                closed.countDown()
            }
        }

        server.expect().get().withPath("/api/v1/users/watch")
                .andUpgradeToWebSocket()
                .open()
                .expectHttpRequest("/api/v1/create").andEmit("CREATED").once()
                .expectSentWebSocketMessage("CREATED").andEmit("DELETED").once()
                .done()
                .once()


        when:
        Request request = new Request.Builder().url(server.url("/api/v1/users/watch")).get().build()
        webSocketRef.set(client.newWebSocket(request, listener))

        then:
        opened.await(10, TimeUnit.SECONDS)
        WebSocket ws = webSocketRef.get()

        when:
        request = new Request.Builder().url(server.url("/api/v1/create")).get().build()
        client.newCall(request).execute()

        then:
        messages.poll(10, TimeUnit.SECONDS) == "CREATED"
        messages.poll(10, TimeUnit.SECONDS) == "DELETED"

        when:
        ws.close(1000, "just close")

        then:
        closed.await(10, TimeUnit.SECONDS)
    }
}
