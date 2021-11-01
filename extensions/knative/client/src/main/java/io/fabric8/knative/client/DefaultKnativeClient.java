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
package io.fabric8.knative.client;

import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSource;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSourceList;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSource;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSourceList;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubBinding;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubBindingList;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSource;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSourceList;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBinding;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBindingList;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSource;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSourceList;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaBinding;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaBindingList;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannel;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannelList;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSource;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSourceList;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSource;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSourceList;
import io.fabric8.knative.eventing.v1.Broker;
import io.fabric8.knative.eventing.v1.BrokerList;
import io.fabric8.knative.eventing.v1.Trigger;
import io.fabric8.knative.eventing.v1.TriggerList;
import io.fabric8.knative.eventing.v1beta1.EventType;
import io.fabric8.knative.eventing.v1beta1.EventTypeList;
import io.fabric8.knative.flows.v1.Parallel;
import io.fabric8.knative.flows.v1.ParallelList;
import io.fabric8.knative.flows.v1.Sequence;
import io.fabric8.knative.flows.v1.SequenceList;
import io.fabric8.knative.messaging.v1.Channel;
import io.fabric8.knative.messaging.v1.ChannelList;
import io.fabric8.knative.messaging.v1.InMemoryChannel;
import io.fabric8.knative.messaging.v1.InMemoryChannelList;
import io.fabric8.knative.messaging.v1.Subscription;
import io.fabric8.knative.messaging.v1.SubscriptionList;
import io.fabric8.knative.serving.v1.Configuration;
import io.fabric8.knative.serving.v1.ConfigurationList;
import io.fabric8.knative.serving.v1.Revision;
import io.fabric8.knative.serving.v1.RevisionList;
import io.fabric8.knative.serving.v1.Route;
import io.fabric8.knative.serving.v1.RouteList;
import io.fabric8.knative.serving.v1.Service;
import io.fabric8.knative.serving.v1.ServiceList;
import io.fabric8.knative.sources.v1.ApiServerSource;
import io.fabric8.knative.sources.v1.ApiServerSourceList;
import io.fabric8.knative.sources.v1.ContainerSource;
import io.fabric8.knative.sources.v1.ContainerSourceList;
import io.fabric8.knative.sources.v1.PingSource;
import io.fabric8.knative.sources.v1.PingSourceList;
import io.fabric8.knative.sources.v1.SinkBinding;
import io.fabric8.knative.sources.v1.SinkBindingList;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.http.HttpClient;

public class DefaultKnativeClient extends BaseClient implements NamespacedKnativeClient {

    public DefaultKnativeClient() {
        super();
    }

    public DefaultKnativeClient(Config configuration) {
        super(configuration);
    }

    public DefaultKnativeClient(HttpClient httpClient, Config configuration) {
        super(httpClient, configuration);
    }

    @Override
    public NamespacedKnativeClient inAnyNamespace() {
        return inNamespace(null);
    }

    @Override
    public NamespacedKnativeClient inNamespace(String namespace) {
        Config updated = new ConfigBuilder(getConfiguration()).withNamespace(namespace).build();

        return new DefaultKnativeClient(getHttpClient(), updated);
    }

    @Override
    public FunctionCallable<NamespacedKnativeClient> withRequestConfig(RequestConfig requestConfig) {
        return new WithRequestCallable<>(this, requestConfig);
    }

    @Override
    public MixedOperation<Service, ServiceList, Resource<Service>> services() {
        return Handlers.getOperation(Service.class, ServiceList.class, this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Route, RouteList, Resource<Route>> routes() {
        return Handlers.getOperation(Route.class, RouteList.class, this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Revision, RevisionList, Resource<Revision>> revisions() {
        return Handlers.getOperation(Revision.class, RevisionList.class, this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Configuration, ConfigurationList, Resource<Configuration>> configurations() {
        return Handlers.getOperation(Configuration.class, ConfigurationList.class, this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Broker, BrokerList, Resource<Broker>> brokers() {
        return Handlers.getOperation(Broker.class, BrokerList.class, this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Trigger, TriggerList, Resource<Trigger>> triggers() {
        return Handlers.getOperation(Trigger.class, TriggerList.class, this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Channel, ChannelList, Resource<Channel>> channels() {
        return Handlers.getOperation(Channel.class, ChannelList.class, this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Subscription, SubscriptionList, Resource<Subscription>> subscriptions() {
        return Handlers.getOperation(Subscription.class, SubscriptionList.class, this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<EventType, EventTypeList, Resource<EventType>> eventTypes() {
        return Handlers.getOperation(EventType.class, EventTypeList.class, this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Sequence, SequenceList, Resource<Sequence>> sequences() {
        return Handlers.getOperation(Sequence.class, SequenceList.class, this.getHttpClient(), this.getConfiguration());
    }

  @Override
  public MixedOperation<Parallel, ParallelList, Resource<Parallel>> parallels() {
    return Handlers.getOperation(Parallel.class, ParallelList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
    public MixedOperation<InMemoryChannel, InMemoryChannelList, Resource<InMemoryChannel>> inMemoryChannels() {
        return Handlers.getOperation(InMemoryChannel.class, InMemoryChannelList.class, this.getHttpClient(), this.getConfiguration());
    }

  @Override
  public MixedOperation<PingSource, PingSourceList, Resource<PingSource>> pingSources() {
    return Handlers.getOperation(PingSource.class, PingSourceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<SinkBinding, SinkBindingList, Resource<SinkBinding>> sinkBindings() {
    return Handlers.getOperation(SinkBinding.class, SinkBindingList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<ContainerSource, ContainerSourceList, Resource<ContainerSource>> containerSources() {
    return Handlers.getOperation(ContainerSource.class, ContainerSourceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<ApiServerSource, ApiServerSourceList, Resource<ApiServerSource>> apiServerSources() {
    return Handlers.getOperation(ApiServerSource.class, ApiServerSourceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<AwsSqsSource, AwsSqsSourceList, Resource<AwsSqsSource>> awsSqsSources() {
    return Handlers.getOperation(AwsSqsSource.class, AwsSqsSourceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<CouchDbSource, CouchDbSourceList, Resource<CouchDbSource>> couchDbSources() {
    return Handlers.getOperation(CouchDbSource.class, CouchDbSourceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<GitHubSource, GitHubSourceList, Resource<GitHubSource>> gitHubSources() {
    return Handlers.getOperation(GitHubSource.class, GitHubSourceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<GitHubBinding, GitHubBindingList, Resource<GitHubBinding>> gitHubBindings() {
    return Handlers.getOperation(GitHubBinding.class, GitHubBindingList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<GitLabSource, GitLabSourceList, Resource<GitLabSource>> gitLabSources() {
    return Handlers.getOperation(GitLabSource.class, GitLabSourceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<GitLabBinding, GitLabBindingList, Resource<GitLabBinding>> gitLabBindings() {
    return Handlers.getOperation(GitLabBinding.class, GitLabBindingList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<PrometheusSource, PrometheusSourceList, Resource<PrometheusSource>> prometheusSources() {
    return Handlers.getOperation(PrometheusSource.class, PrometheusSourceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<KafkaChannel, KafkaChannelList, Resource<KafkaChannel>> kafkaChannels() {
    return Handlers.getOperation(KafkaChannel.class, KafkaChannelList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<KafkaSource, KafkaSourceList, Resource<KafkaSource>> kafkasSources() {
    return Handlers.getOperation(KafkaSource.class, KafkaSourceList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<KafkaBinding, KafkaBindingList, Resource<KafkaBinding>> kafkaBindings() {
    return Handlers.getOperation(KafkaBinding.class, KafkaBindingList.class, this.getHttpClient(), this.getConfiguration());
  }
}
