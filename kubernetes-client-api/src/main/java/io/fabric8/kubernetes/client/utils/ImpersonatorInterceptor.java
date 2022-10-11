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
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.http.BasicBuilder;
import io.fabric8.kubernetes.client.http.HttpHeaders;
import io.fabric8.kubernetes.client.http.Interceptor;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;

public class ImpersonatorInterceptor implements Interceptor {

  public static final String NAME = "IMPERSONATOR";

  private final Config config;

  public ImpersonatorInterceptor(Config config) {
    this.config = config;
  }

  @Override
  public Interceptor withConfig(Config config) {
    return new ImpersonatorInterceptor(config);
  }

  @Override
  public void before(BasicBuilder builder, HttpHeaders headers) {
    RequestConfig requestConfig = config.getRequestConfig();
    if (isNotNullOrEmpty(requestConfig.getImpersonateUsername())) {

      builder.header("Impersonate-User", requestConfig.getImpersonateUsername());

      String[] impersonateGroups = requestConfig.getImpersonateGroups();
      if (isNotNullOrEmpty(impersonateGroups)) {
        for (String group : impersonateGroups) {
          builder.header("Impersonate-Group", group);
        }
      }

      Map<String, List<String>> impersonateExtras = requestConfig.getImpersonateExtras();
      if (isNotNullOrEmpty(impersonateExtras)) {
        Collection<?> keys = impersonateExtras.keySet();
        for (Object key : keys) {
          List<String> values = impersonateExtras.get(key);
          if (values != null) {
            for (String value : values) {
              builder.header("Impersonate-Extra-" + key, value);
            }
          }
        }
      }
    }
  }
}
