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
import io.fabric8.knative.serving.v1beta1.DomainMapping;
import io.fabric8.knative.serving.v1beta1.DomainMappingList;
import io.fabric8.knative.sources.v1.ApiServerSource;
import io.fabric8.knative.sources.v1.ApiServerSourceList;
import io.fabric8.knative.sources.v1.ContainerSource;
import io.fabric8.knative.sources.v1.ContainerSourceList;
import io.fabric8.knative.sources.v1.PingSource;
import io.fabric8.knative.sources.v1.PingSourceList;
import io.fabric8.knative.sources.v1.SinkBinding;
import io.fabric8.knative.sources.v1.SinkBindingList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ExtensionRootClientAdapter;
import io.fabric8.kubernetes.client.extension.SupportTestingClient;

public class DefaultKnativeClient extends ExtensionRootClientAdapter<DefaultKnativeClient>
    implements NamespacedKnativeClient, SupportTestingClient {

  public DefaultKnativeClient() {
    super();
  }

  public DefaultKnativeClient(Config config) {
    super(config);
  }

  public DefaultKnativeClient(Client client) {
    super(client);
  }

  @Override
  protected DefaultKnativeClient newInstance(Client client) {
    return new DefaultKnativeClient(client);
  }

  @Override
  public FunctionCallable<NamespacedKnativeClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public MixedOperation<Service, ServiceList, Resource<Service>> services() {
    return resources(Service.class, ServiceList.class);
  }

  @Override
  public MixedOperation<Route, RouteList, Resource<Route>> routes() {
    return resources(Route.class, RouteList.class);
  }

  @Override
  public MixedOperation<Revision, RevisionList, Resource<Revision>> revisions() {
    return resources(Revision.class, RevisionList.class);
  }

  @Override
  public MixedOperation<Configuration, ConfigurationList, Resource<Configuration>> configurations() {
    return resources(Configuration.class, ConfigurationList.class);
  }

  @Override
  public MixedOperation<DomainMapping, DomainMappingList, Resource<DomainMapping>> domainMappings() {
    return resources(DomainMapping.class, DomainMappingList.class);
  }

  @Override
  public MixedOperation<Broker, BrokerList, Resource<Broker>> brokers() {
    return resources(Broker.class, BrokerList.class);
  }

  @Override
  public MixedOperation<Trigger, TriggerList, Resource<Trigger>> triggers() {
    return resources(Trigger.class, TriggerList.class);
  }

  @Override
  public MixedOperation<Channel, ChannelList, Resource<Channel>> channels() {
    return resources(Channel.class, ChannelList.class);
  }

  @Override
  public MixedOperation<Subscription, SubscriptionList, Resource<Subscription>> subscriptions() {
    return resources(Subscription.class, SubscriptionList.class);
  }

  @Override
  public MixedOperation<EventType, EventTypeList, Resource<EventType>> eventTypes() {
    return resources(EventType.class, EventTypeList.class);
  }

  @Override
  public MixedOperation<Sequence, SequenceList, Resource<Sequence>> sequences() {
    return resources(Sequence.class, SequenceList.class);
  }

  @Override
  public MixedOperation<Parallel, ParallelList, Resource<Parallel>> parallels() {
    return resources(Parallel.class, ParallelList.class);
  }

  @Override
  public MixedOperation<InMemoryChannel, InMemoryChannelList, Resource<InMemoryChannel>> inMemoryChannels() {
    return resources(InMemoryChannel.class, InMemoryChannelList.class);
  }

  @Override
  public MixedOperation<PingSource, PingSourceList, Resource<PingSource>> pingSources() {
    return resources(PingSource.class, PingSourceList.class);
  }

  @Override
  public MixedOperation<SinkBinding, SinkBindingList, Resource<SinkBinding>> sinkBindings() {
    return resources(SinkBinding.class, SinkBindingList.class);
  }

  @Override
  public MixedOperation<ContainerSource, ContainerSourceList, Resource<ContainerSource>> containerSources() {
    return resources(ContainerSource.class, ContainerSourceList.class);
  }

  @Override
  public MixedOperation<ApiServerSource, ApiServerSourceList, Resource<ApiServerSource>> apiServerSources() {
    return resources(ApiServerSource.class, ApiServerSourceList.class);
  }

  @Override
  public MixedOperation<AwsSqsSource, AwsSqsSourceList, Resource<AwsSqsSource>> awsSqsSources() {
    return resources(AwsSqsSource.class, AwsSqsSourceList.class);
  }

  @Override
  public MixedOperation<CouchDbSource, CouchDbSourceList, Resource<CouchDbSource>> couchDbSources() {
    return resources(CouchDbSource.class, CouchDbSourceList.class);
  }

  @Override
  public MixedOperation<GitHubSource, GitHubSourceList, Resource<GitHubSource>> gitHubSources() {
    return resources(GitHubSource.class, GitHubSourceList.class);
  }

  @Override
  public MixedOperation<GitHubBinding, GitHubBindingList, Resource<GitHubBinding>> gitHubBindings() {
    return resources(GitHubBinding.class, GitHubBindingList.class);
  }

  @Override
  public MixedOperation<GitLabSource, GitLabSourceList, Resource<GitLabSource>> gitLabSources() {
    return resources(GitLabSource.class, GitLabSourceList.class);
  }

  @Override
  public MixedOperation<GitLabBinding, GitLabBindingList, Resource<GitLabBinding>> gitLabBindings() {
    return resources(GitLabBinding.class, GitLabBindingList.class);
  }

  @Override
  public MixedOperation<PrometheusSource, PrometheusSourceList, Resource<PrometheusSource>> prometheusSources() {
    return resources(PrometheusSource.class, PrometheusSourceList.class);
  }

  @Override
  public MixedOperation<KafkaChannel, KafkaChannelList, Resource<KafkaChannel>> kafkaChannels() {
    return resources(KafkaChannel.class, KafkaChannelList.class);
  }

  @Override
  public MixedOperation<KafkaSource, KafkaSourceList, Resource<KafkaSource>> kafkasSources() {
    return resources(KafkaSource.class, KafkaSourceList.class);
  }

  @Override
  public MixedOperation<KafkaBinding, KafkaBindingList, Resource<KafkaBinding>> kafkaBindings() {
    return resources(KafkaBinding.class, KafkaBindingList.class);
  }

  @Override
  public boolean isSupported() {
    return hasApiGroup("knative.dev", false);
  }
}
