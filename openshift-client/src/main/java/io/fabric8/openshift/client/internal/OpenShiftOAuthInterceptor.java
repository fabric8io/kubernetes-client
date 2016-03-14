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

package io.fabric8.openshift.client.internal;

import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.client.OpenShiftConfig;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public class OpenShiftOAuthInterceptor implements Interceptor {

    private static final String AUTHORIZATION = "Authorization";
    private static final String LOCATION = "Location";
    private static final String AUTHORIZE_PATH = "oauth/authorize?response_type=token&client_id=openshift-challenging-client";

    private static final String BEFORE_TOKEN = "access_token=";
    private static final String AFTER_TOKEN = "&expires";

    private final OkHttpClient client;
    private final OpenShiftConfig config;
    private final AtomicReference<String> oauthToken = new AtomicReference<>();

    public OpenShiftOAuthInterceptor(OkHttpClient client, OpenShiftConfig config) {
        this.client = client;
        this.config = config;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        //Build new request
        Request.Builder builder = request.newBuilder();
        builder.header("Accept", "application/json");

        String token = oauthToken.get();
        if (Utils.isNotNullOrEmpty(token)) {
            setAuthHeader(builder, token);
        }

        request = builder.build();
        Response response = chain.proceed(request);

        if ((response.code() == 401 || response.code() == 403)
                && Utils.isNotNullOrEmpty(config.getUsername())
                && Utils.isNotNullOrEmpty(config.getPassword())) {
            // Close the previous response to prevent leaked connections.
            response.body().close();

            synchronized (client) {
                token = authorize();
                if(token != null) {
                    oauthToken.set(token);
                    setAuthHeader(builder, token);
                    request = builder.build();
                    return chain.proceed(request); //repeat request with new token
                }
            }
        }
        return response;
    }

    private void setAuthHeader(Request.Builder builder, String token) {
        if (token != null) {
            builder.header(AUTHORIZATION, String.format("Bearer %s", token));
        }
    }

    private  String authorize() {
        try {
            OkHttpClient clone = client.clone();
            clone.interceptors().remove(this);

            String credential = Credentials.basic(config.getUsername(), new String(config.getPassword()));
            URL url = new URL(URLUtils.join(config.getMasterUrl(), AUTHORIZE_PATH));
            Response response = clone.newCall(new Request.Builder().get().url(url).header(AUTHORIZATION, credential).build()).execute();
            response.body().close();
            String token = response.priorResponse().networkResponse().header(LOCATION);
            token = token.substring(token.indexOf(BEFORE_TOKEN) + BEFORE_TOKEN.length());
            token = token.substring(0, token.indexOf(AFTER_TOKEN));
            return token;
        } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(e);
        }
    }
}

