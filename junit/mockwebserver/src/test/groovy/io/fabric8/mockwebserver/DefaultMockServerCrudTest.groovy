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

import com.fasterxml.jackson.databind.ObjectMapper
import io.fabric8.mockwebserver.crud.CrudDispatcher
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.mockwebserver.MockWebServer
import spock.lang.Shared
import spock.lang.Specification

class DefaultMockServerCrudTest extends Specification {

  DefaultMockServer server

  @Shared
  def client = new OkHttpClient()

  @Shared
  def mapper = new ObjectMapper()

  def setup() {
    server = new DefaultMockServer(new Context(), new MockWebServer(), new HashMap<>(),
        new CrudDispatcher(new Context(), new UserAttributeExtractor(), new JsonResponseComposer()), false)
    server.start()
  }

  def cleanup() {
    server.shutdown()
  }

  def "get /, with empty store, should return 404"() {
    when:
    def result = client.newCall(new Request.Builder().url(server.url("/")).build()).execute()

    then:
    assert result.code() == 404
    assert result.body().string() == ""
  }

  def "get /, with one item, should return item"() {
    given:
    client.newCall(new Request.Builder().url(server.url("/")).post(
        RequestBody.create(MediaType.parse("application/json"),
            mapper.writeValueAsString(new User(1L, "user", true)))).build()).
        execute()

    when:
    def result = client.newCall(new Request.Builder().url(server.url("/")).build()).execute()

    then:
    assert result.code() == 200
    assert result.body().string() == "{\"id\":1,\"username\":\"user\",\"enabled\":true}"
  }

  def "get /, with multiple items, should return array"() {
    given:
    client.newCall(new Request.Builder().url(server.url("/")).post(
        RequestBody.create(MediaType.parse("application/json"),
            mapper.writeValueAsString(new User(1L, "user", true)))).build()).
        execute()
    client.newCall(new Request.Builder().url(server.url("/")).post(
        RequestBody.create(MediaType.parse("application/json"),
            mapper.writeValueAsString(new User(2L, "user-2", true)))).build()).
        execute()

    when:
    def result = client.newCall(new Request.Builder().url(server.url("/")).build()).execute()

    then:
    assert result.code() == 200
    assert result.body().string() ==
        "[{\"id\":1,\"username\":\"user\",\"enabled\":true},{\"id\":2,\"username\":\"user-2\",\"enabled\":true}]"
  }

  def "get /1, with existent item, should return item"() {
    given:
    client.newCall(new Request.Builder().url(server.url("/")).post(
        RequestBody.create(MediaType.parse("application/json"),
            mapper.writeValueAsString(new User(1L, "user", true)))).build()).
        execute()
    client.newCall(new Request.Builder().url(server.url("/")).post(
        RequestBody.create(MediaType.parse("application/json"),
            mapper.writeValueAsString(new User(2L, "user-2", true)))).build()).
        execute()

    when:
    def result = client.newCall(new Request.Builder().url(server.url("/1")).build()).execute()

    then:
    assert result.code() == 200
    assert result.body().string() == "{\"id\":1,\"username\":\"user\",\"enabled\":true}"
  }

  def "put /1, with missing item, should create item"() {
    when:
    def result = client.newCall(new Request.Builder().url(server.url("/1")).put(
        RequestBody.create(MediaType.parse("application/json"),
            mapper.writeValueAsString(new User(1L, "user-replaced", true)))).build()).
        execute()

    then:
    assert result.code() == 201
    assert result.body().string() == "{\"id\":1,\"username\":\"user-replaced\",\"enabled\":true}"
  }

  def "put /1, with existent item, should replace item"() {
    given:
    client.newCall(new Request.Builder().url(server.url("/")).post(
        RequestBody.create(MediaType.parse("application/json"),
            mapper.writeValueAsString(new User(1L, "user", true)))).build()).
        execute()

    when:
    def result = client.newCall(new Request.Builder().url(server.url("/1")).put(
        RequestBody.create(MediaType.parse("application/json"),
            mapper.writeValueAsString(new User(1L, "user-replaced", true)))).build()).
        execute()

    then:
    assert result.code() == 202
    assert result.body().string() == "{\"id\":1,\"username\":\"user-replaced\",\"enabled\":true}"
    def item = client.newCall(new Request.Builder().url(server.url("/1")).build()).execute()
    assert item.body().string() == "{\"id\":1,\"username\":\"user-replaced\",\"enabled\":true}"
  }
}
