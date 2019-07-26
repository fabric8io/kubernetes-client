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


import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.knative.serving.v1beta1.*;
import io.fabric8.knative.eventing.v1alpha1.*;
import io.fabric8.knative.messaging.v1alpha1.*;

public interface KnativeClient extends Client {

    // Serving
  MixedOperation<Service, ServiceList, DoneableService, Resource<Service, DoneableService>> services();
  MixedOperation<Route, RouteList, DoneableRoute, Resource<Route, DoneableRoute>> routes();
  MixedOperation<Revision, RevisionList, DoneableRevision, Resource<Revision, DoneableRevision>> revisions();
  MixedOperation<Configuration, ConfigurationList, DoneableConfiguration, Resource<Configuration, DoneableConfiguration>> configurations();


    //Eventing
  MixedOperation<Broker, BrokerList, DoneableBroker, Resource<Broker, DoneableBroker>> brokers();
  MixedOperation<Trigger, TriggerList, DoneableTrigger, Resource<Trigger, DoneableTrigger>> triggers();
  MixedOperation<Channel, ChannelList, DoneableChannel, Resource<Channel, DoneableChannel>> channels();
  MixedOperation<Subscription, SubscriptionList, DoneableSubscription, Resource<Subscription, DoneableSubscription>> subscriptions();
  MixedOperation<EventType, EventTypeList, DoneableEventType, Resource<EventType, DoneableEventType>> eventTypes();

    //Messaging
  MixedOperation<Sequence, SequenceList, DoneableSequence, Resource<Sequence, DoneableSequence>> sequences();
  MixedOperation<InMemoryChannel, InMemoryChannelList, DoneableInMemoryChannel, Resource<InMemoryChannel, DoneableInMemoryChannel>> inMemoryChannels();
}
