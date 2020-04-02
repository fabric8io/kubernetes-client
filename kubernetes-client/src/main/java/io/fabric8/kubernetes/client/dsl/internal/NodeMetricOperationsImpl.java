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
package io.fabric8.kubernetes.client.dsl.internal;

import java.util.Map;

import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.URLUtils;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class NodeMetricOperationsImpl extends OperationSupport {
	private static String METRIC_ENDPOINT_URL = "apis/metrics.k8s.io/v1beta1/nodes";

	public NodeMetricOperationsImpl(OkHttpClient client, Config config) {
		super(new OperationContext().withOkhttpClient(client).withConfig(config));
	}

	public NodeMetricsList metrics() {
		try {
			String resourceUrl = URLUtils.join(config.getMasterUrl(), METRIC_ENDPOINT_URL);
			return handleMetric(resourceUrl, NodeMetricsList.class);
		} catch(Exception e) {
			throw KubernetesClientException.launderThrowable(e);
		}
	}

	public NodeMetrics metrics(String nodeName) {
		try {
			String resourceUrl = URLUtils.join(config.getMasterUrl(), METRIC_ENDPOINT_URL, nodeName);
			return handleMetric(resourceUrl, NodeMetrics.class);
		} catch(Exception e) {
			throw KubernetesClientException.launderThrowable(e);
		}
	}

	public NodeMetricsList metrics(Map<String, Object> labelsMap) {
		try {
      HttpUrl.Builder httpUrlBuilder = HttpUrl.get(URLUtils.join(config.getMasterUrl(), METRIC_ENDPOINT_URL)).newBuilder();

      StringBuilder sb = new StringBuilder();
			for(Map.Entry<String, Object> entry : labelsMap.entrySet()) {
				sb.append(entry.getKey()).append("=").append(entry.getValue().toString()).append(",");
			}
      httpUrlBuilder.addQueryParameter("labelSelector", sb.toString().substring(0, sb.toString().length() - 1));
			return handleMetric(httpUrlBuilder.build().toString(), NodeMetricsList.class);
		} catch(Exception e) {
			throw KubernetesClientException.launderThrowable(e);
		}
	}

}
