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

import io.fabric8.knative.client.eventing.v1alpha1.internal.BrokerOperationsImpl;
import io.fabric8.knative.client.eventing.v1alpha1.internal.EventTypeOperationsImpl;
import io.fabric8.knative.client.eventing.v1alpha1.internal.TriggerOperationsImpl;
import io.fabric8.knative.client.flows.v1alpha1.internal.SequenceOperationsImpl;
import io.fabric8.knative.client.messaging.v1alpha1.internal.ChannelOperationsImpl;
import io.fabric8.knative.client.messaging.v1alpha1.internal.InMemoryChannelOperationsImpl;
import io.fabric8.knative.client.messaging.v1alpha1.internal.SubscriptionOperationsImpl;
import io.fabric8.knative.client.serving.v1.internal.ConfigurationOperationsImpl;
import io.fabric8.knative.client.serving.v1.internal.RevisionOperationsImpl;
import io.fabric8.knative.client.serving.v1.internal.RouteOperationsImpl;
import io.fabric8.knative.client.serving.v1.internal.ServiceOperationsImpl;
import io.fabric8.knative.eventing.v1alpha1.Broker;
import io.fabric8.knative.eventing.v1alpha1.BrokerList;
import io.fabric8.knative.eventing.v1alpha1.DoneableBroker;
import io.fabric8.knative.eventing.v1alpha1.DoneableEventType;
import io.fabric8.knative.eventing.v1alpha1.DoneableTrigger;
import io.fabric8.knative.eventing.v1alpha1.EventType;
import io.fabric8.knative.eventing.v1alpha1.EventTypeList;
import io.fabric8.knative.eventing.v1alpha1.Trigger;
import io.fabric8.knative.eventing.v1alpha1.TriggerList;
import io.fabric8.knative.flows.v1alpha1.DoneableSequence;
import io.fabric8.knative.flows.v1alpha1.Sequence;
import io.fabric8.knative.flows.v1alpha1.SequenceList;
import io.fabric8.knative.messaging.v1alpha1.Channel;
import io.fabric8.knative.messaging.v1alpha1.ChannelList;
import io.fabric8.knative.messaging.v1alpha1.DoneableChannel;
import io.fabric8.knative.messaging.v1alpha1.DoneableInMemoryChannel;
import io.fabric8.knative.messaging.v1alpha1.DoneableSubscription;
import io.fabric8.knative.messaging.v1alpha1.InMemoryChannel;
import io.fabric8.knative.messaging.v1alpha1.InMemoryChannelList;
import io.fabric8.knative.messaging.v1alpha1.Subscription;
import io.fabric8.knative.messaging.v1alpha1.SubscriptionList;
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
}
