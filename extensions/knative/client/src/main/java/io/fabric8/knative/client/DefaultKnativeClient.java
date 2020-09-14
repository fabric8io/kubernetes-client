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

import io.fabric8.knative.client.eventing.v1.internal.BrokerOperationsImpl;
import io.fabric8.knative.client.eventing.v1.internal.TriggerOperationsImpl;
import io.fabric8.knative.client.eventing.v1alpha1.internal.AwsSqsSourceOperationsImpl;
import io.fabric8.knative.client.eventing.v1alpha1.internal.CouchDbSourceOperationsImpl;
import io.fabric8.knative.client.eventing.v1alpha1.internal.GitHubBindingOperationsImpl;
import io.fabric8.knative.client.eventing.v1alpha1.internal.GitHubSourceOperationsImpl;
import io.fabric8.knative.client.eventing.v1alpha1.internal.GitLabBindingOperationsImpl;
import io.fabric8.knative.client.eventing.v1alpha1.internal.GitLabSourceOperationsImpl;
import io.fabric8.knative.client.eventing.v1alpha1.internal.PrometheusSourceOperationsImpl;
import io.fabric8.knative.client.eventing.v1beta1.internal.EventTypeOperationsImpl;
import io.fabric8.knative.client.eventing.v1beta1.internal.KafkaBindingOperationsImpl;
import io.fabric8.knative.client.eventing.v1beta1.internal.KafkaChannelOperationsImpl;
import io.fabric8.knative.client.eventing.v1beta1.internal.KafkaSourceOperationsImpl;
import io.fabric8.knative.client.flows.v1.internal.SequenceOperationsImpl;
import io.fabric8.knative.client.messaging.v1.internal.ChannelOperationsImpl;
import io.fabric8.knative.client.messaging.v1.internal.InMemoryChannelOperationsImpl;
import io.fabric8.knative.client.messaging.v1.internal.SubscriptionOperationsImpl;
import io.fabric8.knative.client.serving.v1.internal.ConfigurationOperationsImpl;
import io.fabric8.knative.client.serving.v1.internal.RevisionOperationsImpl;
import io.fabric8.knative.client.serving.v1.internal.RouteOperationsImpl;
import io.fabric8.knative.client.serving.v1.internal.ServiceOperationsImpl;
import io.fabric8.knative.client.sources.v1beta1.internal.ApiServerSourceOperationsImpl;
import io.fabric8.knative.client.sources.v1beta1.internal.ContainerSourceOperationsImpl;
import io.fabric8.knative.client.sources.v1beta1.internal.PingSourceOperationsImpl;
import io.fabric8.knative.client.sources.v1beta1.internal.SinkBindingOperationsImpl;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSource;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSourceList;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.DoneableAwsSqsSource;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSource;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSourceList;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.DoneableCouchDbSource;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.DoneableGitHubBinding;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.DoneableGitHubSource;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubBinding;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubBindingList;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSource;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSourceList;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.DoneableGitLabBinding;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.DoneableGitLabSource;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBinding;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBindingList;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSource;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSourceList;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.DoneableKafkaBinding;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.DoneableKafkaChannel;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.DoneableKafkaSource;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaBinding;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaBindingList;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannel;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannelList;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSource;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSourceList;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.DoneablePrometheusSource;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSource;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSourceList;
import io.fabric8.knative.eventing.v1.Broker;
import io.fabric8.knative.eventing.v1.BrokerList;
import io.fabric8.knative.eventing.v1.DoneableBroker;
import io.fabric8.knative.eventing.v1.DoneableTrigger;
import io.fabric8.knative.eventing.v1.Trigger;
import io.fabric8.knative.eventing.v1.TriggerList;
import io.fabric8.knative.eventing.v1beta1.DoneableEventType;
import io.fabric8.knative.eventing.v1beta1.EventType;
import io.fabric8.knative.eventing.v1beta1.EventTypeList;
import io.fabric8.knative.flows.v1.DoneableSequence;
import io.fabric8.knative.flows.v1.Sequence;
import io.fabric8.knative.flows.v1.SequenceList;
import io.fabric8.knative.messaging.v1.Channel;
import io.fabric8.knative.messaging.v1.ChannelList;
import io.fabric8.knative.messaging.v1.DoneableChannel;
import io.fabric8.knative.messaging.v1.DoneableInMemoryChannel;
import io.fabric8.knative.messaging.v1.DoneableSubscription;
import io.fabric8.knative.messaging.v1.InMemoryChannel;
import io.fabric8.knative.messaging.v1.InMemoryChannelList;
import io.fabric8.knative.messaging.v1.Subscription;
import io.fabric8.knative.messaging.v1.SubscriptionList;
import io.fabric8.knative.serving.v1.Configuration;
import io.fabric8.knative.serving.v1.ConfigurationList;
import io.fabric8.knative.serving.v1.DoneableConfiguration;
import io.fabric8.knative.serving.v1.DoneableRevision;
import io.fabric8.knative.serving.v1.DoneableRoute;
import io.fabric8.knative.serving.v1.DoneableService;
import io.fabric8.knative.serving.v1.Revision;
import io.fabric8.knative.serving.v1.RevisionList;
import io.fabric8.knative.serving.v1.Route;
import io.fabric8.knative.serving.v1.RouteList;
import io.fabric8.knative.serving.v1.Service;
import io.fabric8.knative.serving.v1.ServiceList;
import io.fabric8.knative.sources.v1beta1.ApiServerSource;
import io.fabric8.knative.sources.v1beta1.ApiServerSourceList;
import io.fabric8.knative.sources.v1beta1.ContainerSource;
import io.fabric8.knative.sources.v1beta1.ContainerSourceList;
import io.fabric8.knative.sources.v1beta1.DoneableApiServerSource;
import io.fabric8.knative.sources.v1beta1.DoneableContainerSource;
import io.fabric8.knative.sources.v1beta1.DoneablePingSource;
import io.fabric8.knative.sources.v1beta1.DoneableSinkBinding;
import io.fabric8.knative.sources.v1beta1.PingSource;
import io.fabric8.knative.sources.v1beta1.PingSourceList;
import io.fabric8.knative.sources.v1beta1.SinkBinding;
import io.fabric8.knative.sources.v1beta1.SinkBindingList;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import okhttp3.OkHttpClient;

public class DefaultKnativeClient extends BaseClient implements NamespacedKnativeClient {

    public DefaultKnativeClient() {
        super();
    }

    public DefaultKnativeClient(Config configuration) {
        super(configuration);
    }

    public DefaultKnativeClient(OkHttpClient httpClient, Config configuration) {
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
        return new WithRequestCallable<NamespacedKnativeClient>(this, requestConfig);
    }

    @Override
    public MixedOperation<Service, ServiceList, DoneableService, Resource<Service, DoneableService>> services() {
        return new ServiceOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Route, RouteList, DoneableRoute, Resource<Route, DoneableRoute>> routes() {
        return new RouteOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Revision, RevisionList, DoneableRevision, Resource<Revision, DoneableRevision>> revisions() {
        return new RevisionOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Configuration, ConfigurationList, DoneableConfiguration, Resource<Configuration, DoneableConfiguration>> configurations() {
        return new ConfigurationOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Broker, BrokerList, DoneableBroker, Resource<Broker, DoneableBroker>> brokers() {
        return new BrokerOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Trigger, TriggerList, DoneableTrigger, Resource<Trigger, DoneableTrigger>> triggers() {
        return new TriggerOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Channel, ChannelList, DoneableChannel, Resource<Channel, DoneableChannel>> channels() {
        return new ChannelOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Subscription, SubscriptionList, DoneableSubscription, Resource<Subscription, DoneableSubscription>> subscriptions() {
        return new SubscriptionOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<EventType, EventTypeList, DoneableEventType, Resource<EventType, DoneableEventType>> eventTypes() {
        return new EventTypeOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<Sequence, SequenceList, DoneableSequence, Resource<Sequence, DoneableSequence>> sequences() {
        return new SequenceOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

    @Override
    public MixedOperation<InMemoryChannel, InMemoryChannelList, DoneableInMemoryChannel, Resource<InMemoryChannel, DoneableInMemoryChannel>> inMemoryChannels() {
        return new InMemoryChannelOperationsImpl(this.getHttpClient(), this.getConfiguration());
    }

  @Override
  public MixedOperation<PingSource, PingSourceList, DoneablePingSource, Resource<PingSource, DoneablePingSource>> pingSources() {
    return new PingSourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<SinkBinding, SinkBindingList, DoneableSinkBinding, Resource<SinkBinding, DoneableSinkBinding>> sinkBindings() {
    return new SinkBindingOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<ContainerSource, ContainerSourceList, DoneableContainerSource, Resource<ContainerSource, DoneableContainerSource>> containerSources() {
    return new ContainerSourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<ApiServerSource, ApiServerSourceList, DoneableApiServerSource, Resource<ApiServerSource, DoneableApiServerSource>> apiServerSources() {
    return new ApiServerSourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<AwsSqsSource, AwsSqsSourceList, DoneableAwsSqsSource, Resource<AwsSqsSource, DoneableAwsSqsSource>> awsSqsSources() {
    return new AwsSqsSourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<CouchDbSource, CouchDbSourceList, DoneableCouchDbSource, Resource<CouchDbSource, DoneableCouchDbSource>> couchDbSources() {
    return new CouchDbSourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<GitHubSource, GitHubSourceList, DoneableGitHubSource, Resource<GitHubSource, DoneableGitHubSource>> gitHubSources() {
    return new GitHubSourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<GitHubBinding, GitHubBindingList, DoneableGitHubBinding, Resource<GitHubBinding, DoneableGitHubBinding>> gitHubBindings() {
    return new GitHubBindingOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<GitLabSource, GitLabSourceList, DoneableGitLabSource, Resource<GitLabSource, DoneableGitLabSource>> gitLabSources() {
    return new GitLabSourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<GitLabBinding, GitLabBindingList, DoneableGitLabBinding, Resource<GitLabBinding, DoneableGitLabBinding>> gitLabBindings() {
    return new GitLabBindingOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<PrometheusSource, PrometheusSourceList, DoneablePrometheusSource, Resource<PrometheusSource, DoneablePrometheusSource>> prometheusSources() {
    return new PrometheusSourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<KafkaChannel, KafkaChannelList, DoneableKafkaChannel, Resource<KafkaChannel, DoneableKafkaChannel>> kafkaChannels() {
    return new KafkaChannelOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<KafkaSource, KafkaSourceList, DoneableKafkaSource, Resource<KafkaSource, DoneableKafkaSource>> kafkasSources() {
    return new KafkaSourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<KafkaBinding, KafkaBindingList, DoneableKafkaBinding, Resource<KafkaBinding, DoneableKafkaBinding>> kafkaBindings() {
    return new KafkaBindingOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }
}
