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
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

/**
 * Main interface for Knative Client.
 */
public interface KnativeClient extends Client {

  // Serving
  /**
   * API entrypoint for Service(serving.knative.dev/v1)
   *
   * @return MixedOperation for Service class
   */
  MixedOperation<Service, ServiceList, Resource<Service>> services();

  /**
   * API entrypoint for Route(serving.knative.dev/v1)
   *
   * @return MixedOperation for Route class
   */
  MixedOperation<Route, RouteList, Resource<Route>> routes();

  /**
   * API entrypoint for Revision(serving.knative.dev/v1)
   *
   * @return MixedOperation for Revision class
   */
  MixedOperation<Revision, RevisionList, Resource<Revision>> revisions();

  /**
   * API entrypoint for Configuration(serving.knative.dev/v1)
   *
   * @return MixedOperation for Configuration class
   */
  MixedOperation<Configuration, ConfigurationList, Resource<Configuration>> configurations();

  /**
   * API entrypoint for DomainMapping (serving.knative.dev/v1beta1)
   * 
   * @return MixedOperation for DomainMapping class
   */
  MixedOperation<DomainMapping, DomainMappingList, Resource<DomainMapping>> domainMappings();

  //Eventing
  /**
   * API entrypoint for Broker(eventing.knative.dev/v1)
   *
   * @return MixedOperation for Broker class
   */
  MixedOperation<Broker, BrokerList, Resource<Broker>> brokers();

  /**
   * API entrypoint for Trigger(eventing.knative.dev/v1)
   *
   * @return MixedOperation for Trigger class
   */
  MixedOperation<Trigger, TriggerList, Resource<Trigger>> triggers();

  /**
   * API entrypoint for EventType(eventing.knative.dev/v1)
   *
   * @return MixedOperation for EventType class
   */
  MixedOperation<EventType, EventTypeList, Resource<EventType>> eventTypes();

  //Messaging
  /**
   * API entrypoint for Channel(messaging.knative.dev/v1)
   *
   * @return MixedOperation for Channel class
   */
  MixedOperation<Channel, ChannelList, Resource<Channel>> channels();

  /**
   * API entrypoint for Subscription(messaging.knative.dev/v1)
   *
   * @return MixedOperation for Subscription class
   */
  MixedOperation<Subscription, SubscriptionList, Resource<Subscription>> subscriptions();

  /**
   * API entrypoint for Sequence(flows.knative.dev/v1)
   *
   * @return MixedOperation for Sequence class
   */
  MixedOperation<Sequence, SequenceList, Resource<Sequence>> sequences();

  /**
   * API entrypoint for Parallel(flows.knative.dev/v1)
   *
   * @return MixedOperation for Parallel class
   */
  MixedOperation<Parallel, ParallelList, Resource<Parallel>> parallels();

  /**
   * API entrypoint for InMemoryChannel(messaging.knative.dev/v1)
   *
   * @return MixedOperation for InMemoryChannel class
   */
  MixedOperation<InMemoryChannel, InMemoryChannelList, Resource<InMemoryChannel>> inMemoryChannels();

  // Eventing Sources

  /**
   * API entrypoint for PingSource(sources.knative.dev/v1beta1)
   * 
   * @return MixedOperation for PingSource class
   */
  MixedOperation<PingSource, PingSourceList, Resource<PingSource>> pingSources();

  /**
   * API entrypoint for SinkBinding(sources.knative.dev/v1beta1)
   * 
   * @return MixedOperation for SinkBinding class
   */
  MixedOperation<SinkBinding, SinkBindingList, Resource<SinkBinding>> sinkBindings();

  /**
   * API entrypoint for ContainerSource(sources.knative.dev/v1beta1)
   * 
   * @return MixedOperation for ContainerSource class
   */
  MixedOperation<ContainerSource, ContainerSourceList, Resource<ContainerSource>> containerSources();

  /**
   * API entrypoint for ApiServerSource(sources.knative.dev/v1beta1)
   * 
   * @return MixedOperation for ApiServerSource class
   */
  MixedOperation<ApiServerSource, ApiServerSourceList, Resource<ApiServerSource>> apiServerSources();

  // Eventing Contrib
  /**
   * API entrypoint for AwsSqsSource(sources.knative.dev/v1alpha1)
   * 
   * @return MixedOperation for AwsSqsSource class
   */
  MixedOperation<AwsSqsSource, AwsSqsSourceList, Resource<AwsSqsSource>> awsSqsSources();

  /**
   * API entrypoint for CouchDbSource(sources.knative.dev/v1alpha1)
   * 
   * @return MixedOperation for CouchDbSource class
   */
  MixedOperation<CouchDbSource, CouchDbSourceList, Resource<CouchDbSource>> couchDbSources();

  /**
   * API entrypoint for GitHubSource(sources.knative.dev/v1alpha1)
   * 
   * @return MixedOperation for GitHubSource class
   */
  MixedOperation<GitHubSource, GitHubSourceList, Resource<GitHubSource>> gitHubSources();

  /**
   * API entrypoint for GitHubBinding(bindings.knative.dev/v1alpha1)
   * 
   * @return MixedOperation for GitHubBinding class
   */
  MixedOperation<GitHubBinding, GitHubBindingList, Resource<GitHubBinding>> gitHubBindings();

  /**
   * API entrypoint for GitLabSource(sources.knative.dev/v1alpha1)
   * 
   * @return MixedOperation for GitLabSource class
   */
  MixedOperation<GitLabSource, GitLabSourceList, Resource<GitLabSource>> gitLabSources();

  /**
   * API entrypoint for GitLabBinding(bindings.knative.dev/v1alpha1)
   * 
   * @return MixedOperation for GitLabBinding class
   */
  MixedOperation<GitLabBinding, GitLabBindingList, Resource<GitLabBinding>> gitLabBindings();

  /**
   * API entrypoint for PrometheusSource(sources.knative.dev/v1alpha1)
   * 
   * @return MixedOperation for PrometheusSource class
   */
  MixedOperation<PrometheusSource, PrometheusSourceList, Resource<PrometheusSource>> prometheusSources();

  /**
   * API entrypoint for KafkaChannel(messaging.knative.dev/v1beta)
   * 
   * @return MixedOperation for KafkaChannel class
   */
  MixedOperation<KafkaChannel, KafkaChannelList, Resource<KafkaChannel>> kafkaChannels();

  /**
   * API entrypoint for KafkaSource(sources.knative.dev/v1beta1)
   * 
   * @return MixedOperation for KafkaSource class
   */
  MixedOperation<KafkaSource, KafkaSourceList, Resource<KafkaSource>> kafkasSources();

  /**
   * API entrypoint for KafkaBinding(bindings.knative.dev/v1beta1)
   * 
   * @return MixedOperation for KafkaBinding class
   */
  MixedOperation<KafkaBinding, KafkaBindingList, Resource<KafkaBinding>> kafkaBindings();
}
