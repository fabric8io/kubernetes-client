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
}
