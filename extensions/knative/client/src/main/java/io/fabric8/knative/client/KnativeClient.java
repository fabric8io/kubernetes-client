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
  MixedOperation<Service, ServiceList, DoneableService, Resource<Service, DoneableService>> services();

  /**
   * API entrypoint for Route(serving.knative.dev/v1)
   *
   * @return MixedOperation for Route class
   */
  MixedOperation<Route, RouteList, DoneableRoute, Resource<Route, DoneableRoute>> routes();

  /**
   * API entrypoint for Revision(serving.knative.dev/v1)
   *
   * @return MixedOperation for Revision class
   */
  MixedOperation<Revision, RevisionList, DoneableRevision, Resource<Revision, DoneableRevision>> revisions();

  /**
   * API entrypoint for Configuration(serving.knative.dev/v1)
   *
   * @return MixedOperation for Configuration class
   */
  MixedOperation<Configuration, ConfigurationList, DoneableConfiguration, Resource<Configuration, DoneableConfiguration>> configurations();


  //Eventing
  /**
   * API entrypoint for Broker(eventing.knative.dev/v1)
   *
   * @return MixedOperation for Broker class
   */
  MixedOperation<Broker, BrokerList, DoneableBroker, Resource<Broker, DoneableBroker>> brokers();
  /**
   * API entrypoint for Trigger(eventing.knative.dev/v1)
   *
   * @return MixedOperation for Trigger class
   */
  MixedOperation<Trigger, TriggerList, DoneableTrigger, Resource<Trigger, DoneableTrigger>> triggers();
  /**
   * API entrypoint for EventType(eventing.knative.dev/v1)
   *
   * @return MixedOperation for EventType class
   */
  MixedOperation<EventType, EventTypeList, DoneableEventType, Resource<EventType, DoneableEventType>> eventTypes();

  //Messaging
  /**
   * API entrypoint for Channel(messaging.knative.dev/v1)
   *
   * @return MixedOperation for Channel class
   */
  MixedOperation<Channel, ChannelList, DoneableChannel, Resource<Channel, DoneableChannel>> channels();
  /**
   * API entrypoint for Subscription(messaging.knative.dev/v1)
   *
   * @return MixedOperation for Subscription class
   */
  MixedOperation<Subscription, SubscriptionList, DoneableSubscription, Resource<Subscription, DoneableSubscription>> subscriptions();
  /**
   * API entrypoint for Sequence(messaging.knative.dev/v1)
   *
   * @return MixedOperation for Sequence class
   */
  MixedOperation<Sequence, SequenceList, DoneableSequence, Resource<Sequence, DoneableSequence>> sequences();
  /**
   * API entrypoint for InMemoryChannel(messaging.knative.dev/v1)
   *
   * @return MixedOperation for InMemoryChannel class
   */
  MixedOperation<InMemoryChannel, InMemoryChannelList, DoneableInMemoryChannel, Resource<InMemoryChannel, DoneableInMemoryChannel>> inMemoryChannels();

  // Eventing Sources

  /**
   * API entrypoint for PingSource(sources.knative.dev/v1beta1)
   * @return MixedOperation for PingSource class
   */
  MixedOperation<PingSource, PingSourceList, DoneablePingSource, Resource<PingSource, DoneablePingSource>> pingSources();

  /**
   * API entrypoint for SinkBinding(sources.knative.dev/v1beta1)
   * @return MixedOperation for SinkBinding class
   */
  MixedOperation<SinkBinding, SinkBindingList, DoneableSinkBinding, Resource<SinkBinding, DoneableSinkBinding>> sinkBindings();

  /**
   * API entrypoint for ContainerSource(sources.knative.dev/v1beta1)
   * @return MixedOperation for ContainerSource class
   */
  MixedOperation<ContainerSource, ContainerSourceList, DoneableContainerSource, Resource<ContainerSource, DoneableContainerSource>> containerSources();
  /**
   * API entrypoint for ApiServerSource(sources.knative.dev/v1beta1)
   * @return MixedOperation for ApiServerSource class
   */
  MixedOperation<ApiServerSource, ApiServerSourceList, DoneableApiServerSource, Resource<ApiServerSource, DoneableApiServerSource>> apiServerSources();


  // Eventing Contrib
  /**
   * API entrypoint for AwsSqsSource(sources.knative.dev/v1alpha1)
   * @return MixedOperation for AwsSqsSource class
   */
  MixedOperation<AwsSqsSource, AwsSqsSourceList, DoneableAwsSqsSource, Resource<AwsSqsSource, DoneableAwsSqsSource>> awsSqsSources();
  /**
   * API entrypoint for CouchDbSource(sources.knative.dev/v1alpha1)
   * @return MixedOperation for CouchDbSource class
   */
  MixedOperation<CouchDbSource, CouchDbSourceList, DoneableCouchDbSource, Resource<CouchDbSource, DoneableCouchDbSource>> couchDbSources();
  /**
   * API entrypoint for GitHubSource(sources.knative.dev/v1alpha1)
   * @return MixedOperation for GitHubSource class
   */
  MixedOperation<GitHubSource, GitHubSourceList, DoneableGitHubSource, Resource<GitHubSource, DoneableGitHubSource>> gitHubSources();
  /**
   * API entrypoint for GitHubBinding(bindings.knative.dev/v1alpha1)
   * @return MixedOperation for GitHubBinding class
   */
  MixedOperation<GitHubBinding, GitHubBindingList, DoneableGitHubBinding, Resource<GitHubBinding, DoneableGitHubBinding>> gitHubBindings();
  /**
   * API entrypoint for GitLabSource(sources.knative.dev/v1alpha1)
   * @return MixedOperation for GitLabSource class
   */
  MixedOperation<GitLabSource, GitLabSourceList, DoneableGitLabSource, Resource<GitLabSource, DoneableGitLabSource>> gitLabSources();
  /**
   * API entrypoint for GitLabBinding(bindings.knative.dev/v1alpha1)
   * @return MixedOperation for GitLabBinding class
   */
  MixedOperation<GitLabBinding, GitLabBindingList, DoneableGitLabBinding, Resource<GitLabBinding, DoneableGitLabBinding>> gitLabBindings();
  /**
   * API entrypoint for PrometheusSource(sources.knative.dev/v1alpha1)
   * @return MixedOperation for PrometheusSource class
   */
  MixedOperation<PrometheusSource, PrometheusSourceList, DoneablePrometheusSource, Resource<PrometheusSource, DoneablePrometheusSource>> prometheusSources();
  /**
   * API entrypoint for KafkaChannel(messaging.knative.dev/v1beta)
   * @return MixedOperation for KafkaChannel class
   */
  MixedOperation<KafkaChannel, KafkaChannelList, DoneableKafkaChannel, Resource<KafkaChannel, DoneableKafkaChannel>> kafkaChannels();
  /**
   * API entrypoint for KafkaSource(sources.knative.dev/v1beta1)
   * @return MixedOperation for KafkaSource class
   */
  MixedOperation<KafkaSource, KafkaSourceList, DoneableKafkaSource, Resource<KafkaSource, DoneableKafkaSource>> kafkasSources();
  /**
   * API entrypoint for KafkaBinding(bindings.knative.dev/v1beta1)
   * @return MixedOperation for KafkaBinding class
   */
  MixedOperation<KafkaBinding, KafkaBindingList, DoneableKafkaBinding, Resource<KafkaBinding, DoneableKafkaBinding>> kafkaBindings();
}
