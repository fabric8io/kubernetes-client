
package io.fabric8.knative.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSource;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSourceList;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSourceSpec;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSourceStatus;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSource;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSourceList;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSourceSpec;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSourceStatus;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubBinding;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubBindingList;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubBindingSpec;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubBindingStatus;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSource;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSourceList;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSourceSpec;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSourceStatus;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBinding;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBindingList;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBindingSpec;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBindingStatus;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSource;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSourceList;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSourceSpec;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSourceStatus;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaBinding;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaBindingList;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaBindingSpec;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaBindingStatus;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannel;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannelList;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannelSpec;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannelStatus;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaNetSpec;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSASLSpec;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSource;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSourceList;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSourceSpec;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaSourceStatus;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaTLSSpec;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSource;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSourceList;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSourceSpec;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSourceStatus;
import io.fabric8.knative.eventing.v1.Broker;
import io.fabric8.knative.eventing.v1.BrokerList;
import io.fabric8.knative.eventing.v1.BrokerSpec;
import io.fabric8.knative.eventing.v1.BrokerStatus;
import io.fabric8.knative.eventing.v1.Trigger;
import io.fabric8.knative.eventing.v1.TriggerFilter;
import io.fabric8.knative.eventing.v1.TriggerList;
import io.fabric8.knative.eventing.v1.TriggerSpec;
import io.fabric8.knative.eventing.v1.TriggerStatus;
import io.fabric8.knative.eventing.v1beta1.EventType;
import io.fabric8.knative.eventing.v1beta1.EventTypeList;
import io.fabric8.knative.eventing.v1beta1.EventTypeSpec;
import io.fabric8.knative.eventing.v1beta1.EventTypeStatus;
import io.fabric8.knative.flows.v1.Parallel;
import io.fabric8.knative.flows.v1.ParallelBranch;
import io.fabric8.knative.flows.v1.ParallelBranchStatus;
import io.fabric8.knative.flows.v1.ParallelChannelStatus;
import io.fabric8.knative.flows.v1.ParallelList;
import io.fabric8.knative.flows.v1.ParallelSpec;
import io.fabric8.knative.flows.v1.ParallelStatus;
import io.fabric8.knative.flows.v1.ParallelSubscriptionStatus;
import io.fabric8.knative.flows.v1.Sequence;
import io.fabric8.knative.flows.v1.SequenceChannelStatus;
import io.fabric8.knative.flows.v1.SequenceList;
import io.fabric8.knative.flows.v1.SequenceSpec;
import io.fabric8.knative.flows.v1.SequenceStatus;
import io.fabric8.knative.flows.v1.SequenceStep;
import io.fabric8.knative.flows.v1.SequenceSubscriptionStatus;
import io.fabric8.knative.internal.eventing.pkg.apis.duck.v1.DeliverySpec;
import io.fabric8.knative.internal.eventing.pkg.apis.duck.v1.SubscriberSpec;
import io.fabric8.knative.internal.eventing.pkg.apis.duck.v1.SubscriberStatus;
import io.fabric8.knative.internal.pkg.apis.Condition;
import io.fabric8.knative.internal.pkg.apis.duck.v1.Addressable;
import io.fabric8.knative.internal.pkg.apis.duck.v1.CloudEventAttributes;
import io.fabric8.knative.internal.pkg.apis.duck.v1.CloudEventOverrides;
import io.fabric8.knative.internal.pkg.apis.duck.v1.Destination;
import io.fabric8.knative.internal.pkg.apis.duck.v1.KReference;
import io.fabric8.knative.internal.pkg.tracker.Reference;
import io.fabric8.knative.messaging.v1.Channel;
import io.fabric8.knative.messaging.v1.ChannelList;
import io.fabric8.knative.messaging.v1.ChannelSpec;
import io.fabric8.knative.messaging.v1.ChannelStatus;
import io.fabric8.knative.messaging.v1.ChannelTemplateSpec;
import io.fabric8.knative.messaging.v1.InMemoryChannel;
import io.fabric8.knative.messaging.v1.InMemoryChannelList;
import io.fabric8.knative.messaging.v1.InMemoryChannelSpec;
import io.fabric8.knative.messaging.v1.InMemoryChannelStatus;
import io.fabric8.knative.messaging.v1.Subscription;
import io.fabric8.knative.messaging.v1.SubscriptionList;
import io.fabric8.knative.messaging.v1.SubscriptionSpec;
import io.fabric8.knative.messaging.v1.SubscriptionStatus;
import io.fabric8.knative.messaging.v1.SubscriptionStatusPhysicalSubscription;
import io.fabric8.knative.serving.v1.Configuration;
import io.fabric8.knative.serving.v1.ConfigurationList;
import io.fabric8.knative.serving.v1.ConfigurationSpec;
import io.fabric8.knative.serving.v1.ConfigurationStatus;
import io.fabric8.knative.serving.v1.ContainerStatus;
import io.fabric8.knative.serving.v1.Revision;
import io.fabric8.knative.serving.v1.RevisionList;
import io.fabric8.knative.serving.v1.RevisionSpec;
import io.fabric8.knative.serving.v1.RevisionStatus;
import io.fabric8.knative.serving.v1.RevisionTemplateSpec;
import io.fabric8.knative.serving.v1.Route;
import io.fabric8.knative.serving.v1.RouteList;
import io.fabric8.knative.serving.v1.RouteSpec;
import io.fabric8.knative.serving.v1.RouteStatus;
import io.fabric8.knative.serving.v1.Service;
import io.fabric8.knative.serving.v1.ServiceList;
import io.fabric8.knative.serving.v1.ServiceSpec;
import io.fabric8.knative.serving.v1.ServiceStatus;
import io.fabric8.knative.serving.v1.TrafficTarget;
import io.fabric8.knative.sources.v1.APIVersionKind;
import io.fabric8.knative.sources.v1.APIVersionKindSelector;
import io.fabric8.knative.sources.v1.ApiServerSource;
import io.fabric8.knative.sources.v1.ApiServerSourceList;
import io.fabric8.knative.sources.v1.ApiServerSourceSpec;
import io.fabric8.knative.sources.v1.ApiServerSourceStatus;
import io.fabric8.knative.sources.v1.ContainerSource;
import io.fabric8.knative.sources.v1.ContainerSourceList;
import io.fabric8.knative.sources.v1.ContainerSourceSpec;
import io.fabric8.knative.sources.v1.ContainerSourceStatus;
import io.fabric8.knative.sources.v1.PingSource;
import io.fabric8.knative.sources.v1.PingSourceList;
import io.fabric8.knative.sources.v1.PingSourceSpec;
import io.fabric8.knative.sources.v1.PingSourceStatus;
import io.fabric8.knative.sources.v1.SinkBinding;
import io.fabric8.knative.sources.v1.SinkBindingList;
import io.fabric8.knative.sources.v1.SinkBindingSpec;
import io.fabric8.knative.sources.v1.SinkBindingStatus;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSource",
    "knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceList",
    "knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceSpec",
    "knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceStatus",
    "knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSource",
    "knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceList",
    "knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceSpec",
    "knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceStatus",
    "knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBinding",
    "knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingList",
    "knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingSpec",
    "knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingStatus",
    "knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_SecretValueFromSource",
    "knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSource",
    "knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceList",
    "knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceSpec",
    "knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceStatus",
    "knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_SecretValueFromSource",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBinding",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingList",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingSpec",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingStatus",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_SecretValueFromSource",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSource",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceList",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceSpec",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceStatus",
    "knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_SecretValueFromSource",
    "knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannel",
    "knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelList",
    "knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelSpec",
    "knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelStatus",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBinding",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingList",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingSpec",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingStatus",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaNetSpec",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaSASLSpec",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaTLSSpec",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_SecretValueFromSource",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSource",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceList",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceSpec",
    "knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceStatus",
    "knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSource",
    "knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceList",
    "knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceSpec",
    "knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceStatus",
    "knative_dev_eventing_pkg_apis_duck_v1_DeliverySpec",
    "knative_dev_eventing_pkg_apis_duck_v1_SubscriberSpec",
    "knative_dev_eventing_pkg_apis_duck_v1_SubscriberStatus",
    "knative_dev_eventing_pkg_apis_eventing_v1_Broker",
    "knative_dev_eventing_pkg_apis_eventing_v1_BrokerList",
    "knative_dev_eventing_pkg_apis_eventing_v1_BrokerSpec",
    "knative_dev_eventing_pkg_apis_eventing_v1_BrokerStatus",
    "knative_dev_eventing_pkg_apis_eventing_v1_Trigger",
    "knative_dev_eventing_pkg_apis_eventing_v1_TriggerFilter",
    "knative_dev_eventing_pkg_apis_eventing_v1_TriggerList",
    "knative_dev_eventing_pkg_apis_eventing_v1_TriggerSpec",
    "knative_dev_eventing_pkg_apis_eventing_v1_TriggerStatus",
    "knative_dev_eventing_pkg_apis_eventing_v1beta1_EventType",
    "knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeList",
    "knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeSpec",
    "knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeStatus",
    "knative_dev_eventing_pkg_apis_flows_v1_Parallel",
    "knative_dev_eventing_pkg_apis_flows_v1_ParallelBranch",
    "knative_dev_eventing_pkg_apis_flows_v1_ParallelBranchStatus",
    "knative_dev_eventing_pkg_apis_flows_v1_ParallelChannelStatus",
    "knative_dev_eventing_pkg_apis_flows_v1_ParallelList",
    "knative_dev_eventing_pkg_apis_flows_v1_ParallelSpec",
    "knative_dev_eventing_pkg_apis_flows_v1_ParallelStatus",
    "knative_dev_eventing_pkg_apis_flows_v1_ParallelSubscriptionStatus",
    "knative_dev_eventing_pkg_apis_flows_v1_Sequence",
    "knative_dev_eventing_pkg_apis_flows_v1_SequenceChannelStatus",
    "knative_dev_eventing_pkg_apis_flows_v1_SequenceList",
    "knative_dev_eventing_pkg_apis_flows_v1_SequenceSpec",
    "knative_dev_eventing_pkg_apis_flows_v1_SequenceStatus",
    "knative_dev_eventing_pkg_apis_flows_v1_SequenceStep",
    "knative_dev_eventing_pkg_apis_flows_v1_SequenceSubscriptionStatus",
    "knative_dev_eventing_pkg_apis_messaging_v1_Channel",
    "knative_dev_eventing_pkg_apis_messaging_v1_ChannelList",
    "knative_dev_eventing_pkg_apis_messaging_v1_ChannelSpec",
    "knative_dev_eventing_pkg_apis_messaging_v1_ChannelStatus",
    "knative_dev_eventing_pkg_apis_messaging_v1_ChannelTemplateSpec",
    "knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannel",
    "knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelList",
    "knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelSpec",
    "knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelStatus",
    "knative_dev_eventing_pkg_apis_messaging_v1_Subscription",
    "knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionList",
    "knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionSpec",
    "knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionStatus",
    "knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionStatusPhysicalSubscription",
    "knative_dev_eventing_pkg_apis_sources_v1_APIVersionKind",
    "knative_dev_eventing_pkg_apis_sources_v1_APIVersionKindSelector",
    "knative_dev_eventing_pkg_apis_sources_v1_ApiServerSource",
    "knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceList",
    "knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceSpec",
    "knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceStatus",
    "knative_dev_eventing_pkg_apis_sources_v1_ContainerSource",
    "knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceList",
    "knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceSpec",
    "knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceStatus",
    "knative_dev_eventing_pkg_apis_sources_v1_PingSource",
    "knative_dev_eventing_pkg_apis_sources_v1_PingSourceList",
    "knative_dev_eventing_pkg_apis_sources_v1_PingSourceSpec",
    "knative_dev_eventing_pkg_apis_sources_v1_PingSourceStatus",
    "knative_dev_eventing_pkg_apis_sources_v1_SinkBinding",
    "knative_dev_eventing_pkg_apis_sources_v1_SinkBindingList",
    "knative_dev_eventing_pkg_apis_sources_v1_SinkBindingSpec",
    "knative_dev_eventing_pkg_apis_sources_v1_SinkBindingStatus",
    "knative_dev_pkg_apis_Condition",
    "knative_dev_pkg_apis_duck_v1_Addressable",
    "knative_dev_pkg_apis_duck_v1_CloudEventAttributes",
    "knative_dev_pkg_apis_duck_v1_CloudEventOverrides",
    "knative_dev_pkg_apis_duck_v1_Destination",
    "knative_dev_pkg_apis_duck_v1_KReference",
    "knative_dev_pkg_tracker_Reference",
    "knative_dev_serving_pkg_apis_serving_v1_Configuration",
    "knative_dev_serving_pkg_apis_serving_v1_ConfigurationList",
    "knative_dev_serving_pkg_apis_serving_v1_ConfigurationSpec",
    "knative_dev_serving_pkg_apis_serving_v1_ConfigurationStatus",
    "knative_dev_serving_pkg_apis_serving_v1_ContainerStatus",
    "knative_dev_serving_pkg_apis_serving_v1_Revision",
    "knative_dev_serving_pkg_apis_serving_v1_RevisionList",
    "knative_dev_serving_pkg_apis_serving_v1_RevisionSpec",
    "knative_dev_serving_pkg_apis_serving_v1_RevisionStatus",
    "knative_dev_serving_pkg_apis_serving_v1_RevisionTemplateSpec",
    "knative_dev_serving_pkg_apis_serving_v1_Route",
    "knative_dev_serving_pkg_apis_serving_v1_RouteList",
    "knative_dev_serving_pkg_apis_serving_v1_RouteSpec",
    "knative_dev_serving_pkg_apis_serving_v1_RouteStatus",
    "knative_dev_serving_pkg_apis_serving_v1_Service",
    "knative_dev_serving_pkg_apis_serving_v1_ServiceList",
    "knative_dev_serving_pkg_apis_serving_v1_ServiceSpec",
    "knative_dev_serving_pkg_apis_serving_v1_ServiceStatus",
    "knative_dev_serving_pkg_apis_serving_v1_TrafficTarget"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class KnativeSchema {

    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSource")
    private AwsSqsSource knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource;
    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceList")
    private AwsSqsSourceList knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList;
    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceSpec")
    private AwsSqsSourceSpec knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec;
    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceStatus")
    private AwsSqsSourceStatus knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus;
    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSource")
    private CouchDbSource knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource;
    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceList")
    private CouchDbSourceList knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList;
    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceSpec")
    private CouchDbSourceSpec knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec;
    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceStatus")
    private CouchDbSourceStatus knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBinding")
    private GitHubBinding knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingList")
    private GitHubBindingList knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingSpec")
    private GitHubBindingSpec knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingStatus")
    private GitHubBindingStatus knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_SecretValueFromSource")
    private io.fabric8.knative.eventing.contrib.github.v1alpha1.SecretValueFromSource knativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSource")
    private GitHubSource knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceList")
    private GitHubSourceList knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceSpec")
    private GitHubSourceSpec knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceStatus")
    private GitHubSourceStatus knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus;
    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_SecretValueFromSource")
    private io.fabric8.knative.eventing.contrib.github.v1alpha1.SecretValueFromSource knativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBinding")
    private GitLabBinding knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingList")
    private GitLabBindingList knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingSpec")
    private GitLabBindingSpec knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingStatus")
    private GitLabBindingStatus knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_SecretValueFromSource")
    private io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.SecretValueFromSource knativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSource")
    private GitLabSource knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceList")
    private GitLabSourceList knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceSpec")
    private GitLabSourceSpec knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceStatus")
    private GitLabSourceStatus knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus;
    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_SecretValueFromSource")
    private io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.SecretValueFromSource knativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource;
    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannel")
    private KafkaChannel knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel;
    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelList")
    private KafkaChannelList knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList;
    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelSpec")
    private KafkaChannelSpec knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec;
    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelStatus")
    private KafkaChannelStatus knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBinding")
    private KafkaBinding knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingList")
    private KafkaBindingList knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingSpec")
    private KafkaBindingSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingStatus")
    private KafkaBindingStatus knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaNetSpec")
    private KafkaNetSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaSASLSpec")
    private KafkaSASLSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaTLSSpec")
    private KafkaTLSSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_SecretValueFromSource")
    private io.fabric8.knative.eventing.contrib.kafka.v1beta1.SecretValueFromSource knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSource")
    private KafkaSource knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceList")
    private KafkaSourceList knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceSpec")
    private KafkaSourceSpec knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec;
    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceStatus")
    private KafkaSourceStatus knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus;
    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSource")
    private PrometheusSource knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource;
    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceList")
    private PrometheusSourceList knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList;
    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceSpec")
    private PrometheusSourceSpec knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec;
    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceStatus")
    private PrometheusSourceStatus knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_duck_v1_DeliverySpec")
    private DeliverySpec knativeDevEventingPkgApisDuckV1DeliverySpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_duck_v1_SubscriberSpec")
    private SubscriberSpec knativeDevEventingPkgApisDuckV1SubscriberSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_duck_v1_SubscriberStatus")
    private SubscriberStatus knativeDevEventingPkgApisDuckV1SubscriberStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_Broker")
    private Broker knativeDevEventingPkgApisEventingV1Broker;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_BrokerList")
    private BrokerList knativeDevEventingPkgApisEventingV1BrokerList;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_BrokerSpec")
    private BrokerSpec knativeDevEventingPkgApisEventingV1BrokerSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_BrokerStatus")
    private BrokerStatus knativeDevEventingPkgApisEventingV1BrokerStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_Trigger")
    private Trigger knativeDevEventingPkgApisEventingV1Trigger;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerFilter")
    private TriggerFilter knativeDevEventingPkgApisEventingV1TriggerFilter;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerList")
    private TriggerList knativeDevEventingPkgApisEventingV1TriggerList;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerSpec")
    private TriggerSpec knativeDevEventingPkgApisEventingV1TriggerSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerStatus")
    private TriggerStatus knativeDevEventingPkgApisEventingV1TriggerStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventType")
    private EventType knativeDevEventingPkgApisEventingV1beta1EventType;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeList")
    private EventTypeList knativeDevEventingPkgApisEventingV1beta1EventTypeList;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeSpec")
    private EventTypeSpec knativeDevEventingPkgApisEventingV1beta1EventTypeSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeStatus")
    private EventTypeStatus knativeDevEventingPkgApisEventingV1beta1EventTypeStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_Parallel")
    private Parallel knativeDevEventingPkgApisFlowsV1Parallel;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelBranch")
    private ParallelBranch knativeDevEventingPkgApisFlowsV1ParallelBranch;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelBranchStatus")
    private ParallelBranchStatus knativeDevEventingPkgApisFlowsV1ParallelBranchStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelChannelStatus")
    private ParallelChannelStatus knativeDevEventingPkgApisFlowsV1ParallelChannelStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelList")
    private ParallelList knativeDevEventingPkgApisFlowsV1ParallelList;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelSpec")
    private ParallelSpec knativeDevEventingPkgApisFlowsV1ParallelSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelStatus")
    private ParallelStatus knativeDevEventingPkgApisFlowsV1ParallelStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelSubscriptionStatus")
    private ParallelSubscriptionStatus knativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_Sequence")
    private Sequence knativeDevEventingPkgApisFlowsV1Sequence;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceChannelStatus")
    private SequenceChannelStatus knativeDevEventingPkgApisFlowsV1SequenceChannelStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceList")
    private SequenceList knativeDevEventingPkgApisFlowsV1SequenceList;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceSpec")
    private SequenceSpec knativeDevEventingPkgApisFlowsV1SequenceSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceStatus")
    private SequenceStatus knativeDevEventingPkgApisFlowsV1SequenceStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceStep")
    private SequenceStep knativeDevEventingPkgApisFlowsV1SequenceStep;
    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceSubscriptionStatus")
    private SequenceSubscriptionStatus knativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_Channel")
    private Channel knativeDevEventingPkgApisMessagingV1Channel;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelList")
    private ChannelList knativeDevEventingPkgApisMessagingV1ChannelList;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelSpec")
    private ChannelSpec knativeDevEventingPkgApisMessagingV1ChannelSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelStatus")
    private ChannelStatus knativeDevEventingPkgApisMessagingV1ChannelStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelTemplateSpec")
    private ChannelTemplateSpec knativeDevEventingPkgApisMessagingV1ChannelTemplateSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannel")
    private InMemoryChannel knativeDevEventingPkgApisMessagingV1InMemoryChannel;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelList")
    private InMemoryChannelList knativeDevEventingPkgApisMessagingV1InMemoryChannelList;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelSpec")
    private InMemoryChannelSpec knativeDevEventingPkgApisMessagingV1InMemoryChannelSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelStatus")
    private InMemoryChannelStatus knativeDevEventingPkgApisMessagingV1InMemoryChannelStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_Subscription")
    private Subscription knativeDevEventingPkgApisMessagingV1Subscription;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionList")
    private SubscriptionList knativeDevEventingPkgApisMessagingV1SubscriptionList;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionSpec")
    private SubscriptionSpec knativeDevEventingPkgApisMessagingV1SubscriptionSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionStatus")
    private SubscriptionStatus knativeDevEventingPkgApisMessagingV1SubscriptionStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionStatusPhysicalSubscription")
    private SubscriptionStatusPhysicalSubscription knativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_APIVersionKind")
    private APIVersionKind knativeDevEventingPkgApisSourcesV1APIVersionKind;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_APIVersionKindSelector")
    private APIVersionKindSelector knativeDevEventingPkgApisSourcesV1APIVersionKindSelector;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSource")
    private ApiServerSource knativeDevEventingPkgApisSourcesV1ApiServerSource;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceList")
    private ApiServerSourceList knativeDevEventingPkgApisSourcesV1ApiServerSourceList;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceSpec")
    private ApiServerSourceSpec knativeDevEventingPkgApisSourcesV1ApiServerSourceSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceStatus")
    private ApiServerSourceStatus knativeDevEventingPkgApisSourcesV1ApiServerSourceStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSource")
    private ContainerSource knativeDevEventingPkgApisSourcesV1ContainerSource;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceList")
    private ContainerSourceList knativeDevEventingPkgApisSourcesV1ContainerSourceList;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceSpec")
    private ContainerSourceSpec knativeDevEventingPkgApisSourcesV1ContainerSourceSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceStatus")
    private ContainerSourceStatus knativeDevEventingPkgApisSourcesV1ContainerSourceStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSource")
    private PingSource knativeDevEventingPkgApisSourcesV1PingSource;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSourceList")
    private PingSourceList knativeDevEventingPkgApisSourcesV1PingSourceList;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSourceSpec")
    private PingSourceSpec knativeDevEventingPkgApisSourcesV1PingSourceSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSourceStatus")
    private PingSourceStatus knativeDevEventingPkgApisSourcesV1PingSourceStatus;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBinding")
    private SinkBinding knativeDevEventingPkgApisSourcesV1SinkBinding;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBindingList")
    private SinkBindingList knativeDevEventingPkgApisSourcesV1SinkBindingList;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBindingSpec")
    private SinkBindingSpec knativeDevEventingPkgApisSourcesV1SinkBindingSpec;
    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBindingStatus")
    private SinkBindingStatus knativeDevEventingPkgApisSourcesV1SinkBindingStatus;
    @JsonProperty("knative_dev_pkg_apis_Condition")
    private Condition knativeDevPkgApisCondition;
    @JsonProperty("knative_dev_pkg_apis_duck_v1_Addressable")
    private Addressable knativeDevPkgApisDuckV1Addressable;
    @JsonProperty("knative_dev_pkg_apis_duck_v1_CloudEventAttributes")
    private CloudEventAttributes knativeDevPkgApisDuckV1CloudEventAttributes;
    @JsonProperty("knative_dev_pkg_apis_duck_v1_CloudEventOverrides")
    private CloudEventOverrides knativeDevPkgApisDuckV1CloudEventOverrides;
    @JsonProperty("knative_dev_pkg_apis_duck_v1_Destination")
    private Destination knativeDevPkgApisDuckV1Destination;
    @JsonProperty("knative_dev_pkg_apis_duck_v1_KReference")
    private KReference knativeDevPkgApisDuckV1KReference;
    @JsonProperty("knative_dev_pkg_tracker_Reference")
    private Reference knativeDevPkgTrackerReference;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Configuration")
    private Configuration knativeDevServingPkgApisServingV1Configuration;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ConfigurationList")
    private ConfigurationList knativeDevServingPkgApisServingV1ConfigurationList;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ConfigurationSpec")
    private ConfigurationSpec knativeDevServingPkgApisServingV1ConfigurationSpec;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ConfigurationStatus")
    private ConfigurationStatus knativeDevServingPkgApisServingV1ConfigurationStatus;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ContainerStatus")
    private ContainerStatus knativeDevServingPkgApisServingV1ContainerStatus;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Revision")
    private Revision knativeDevServingPkgApisServingV1Revision;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionList")
    private RevisionList knativeDevServingPkgApisServingV1RevisionList;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionSpec")
    private RevisionSpec knativeDevServingPkgApisServingV1RevisionSpec;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionStatus")
    private RevisionStatus knativeDevServingPkgApisServingV1RevisionStatus;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionTemplateSpec")
    private RevisionTemplateSpec knativeDevServingPkgApisServingV1RevisionTemplateSpec;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Route")
    private Route knativeDevServingPkgApisServingV1Route;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RouteList")
    private RouteList knativeDevServingPkgApisServingV1RouteList;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RouteSpec")
    private RouteSpec knativeDevServingPkgApisServingV1RouteSpec;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RouteStatus")
    private RouteStatus knativeDevServingPkgApisServingV1RouteStatus;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Service")
    private Service knativeDevServingPkgApisServingV1Service;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ServiceList")
    private ServiceList knativeDevServingPkgApisServingV1ServiceList;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ServiceSpec")
    private ServiceSpec knativeDevServingPkgApisServingV1ServiceSpec;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ServiceStatus")
    private ServiceStatus knativeDevServingPkgApisServingV1ServiceStatus;
    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_TrafficTarget")
    private TrafficTarget knativeDevServingPkgApisServingV1TrafficTarget;

    /**
     * No args constructor for use in serialization
     * 
     */
    public KnativeSchema() {
    }

    /**
     * 
     * @param knativeDevPkgApisDuckV1Addressable
     * @param knativeDevEventingPkgApisEventingV1TriggerStatus
     * @param knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec
     * @param knativeDevServingPkgApisServingV1ServiceList
     * @param knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec
     * @param knativeDevEventingPkgApisEventingV1BrokerSpec
     * @param knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList
     * @param knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus
     * @param knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec
     * @param knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource
     * @param knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus
     * @param knativeDevEventingPkgApisFlowsV1ParallelChannelStatus
     * @param knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec
     * @param knativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus
     * @param knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus
     * @param knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec
     * @param knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec
     * @param knativeDevEventingPkgApisEventingV1Trigger
     * @param knativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource
     * @param knativeDevServingPkgApisServingV1RevisionList
     * @param knativeDevEventingPkgApisEventingV1Broker
     * @param knativeDevEventingPkgApisSourcesV1ApiServerSourceStatus
     * @param knativeDevServingPkgApisServingV1RevisionSpec
     * @param knativeDevServingPkgApisServingV1RouteList
     * @param knativeDevServingPkgApisServingV1ServiceSpec
     * @param knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus
     * @param knativeDevEventingPkgApisSourcesV1SinkBindingList
     * @param knativeDevPkgTrackerReference
     * @param knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList
     * @param knativeDevEventingPkgApisSourcesV1PingSourceStatus
     * @param knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec
     * @param knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList
     * @param knativeDevEventingPkgApisSourcesV1ContainerSource
     * @param knativeDevServingPkgApisServingV1ContainerStatus
     * @param knativeDevServingPkgApisServingV1RevisionStatus
     * @param knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel
     * @param knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus
     * @param knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus
     * @param knativeDevEventingPkgApisMessagingV1InMemoryChannelStatus
     * @param knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus
     * @param knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource
     * @param knativeDevEventingPkgApisFlowsV1SequenceChannelStatus
     * @param knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding
     * @param knativeDevEventingPkgApisSourcesV1PingSourceList
     * @param knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus
     * @param knativeDevEventingPkgApisMessagingV1SubscriptionStatus
     * @param knativeDevServingPkgApisServingV1Configuration
     * @param knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus
     * @param knativeDevEventingPkgApisFlowsV1ParallelStatus
     * @param knativeDevEventingPkgApisSourcesV1ApiServerSourceSpec
     * @param knativeDevPkgApisDuckV1CloudEventAttributes
     * @param knativeDevEventingPkgApisFlowsV1ParallelSpec
     * @param knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList
     * @param knativeDevEventingPkgApisEventingV1BrokerList
     * @param knativeDevEventingPkgApisDuckV1SubscriberStatus
     * @param knativeDevEventingPkgApisSourcesV1PingSource
     * @param knativeDevEventingPkgApisSourcesV1ContainerSourceSpec
     * @param knativeDevEventingPkgApisDuckV1DeliverySpec
     * @param knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource
     * @param knativeDevEventingPkgApisDuckV1SubscriberSpec
     * @param knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding
     * @param knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource
     * @param knativeDevEventingPkgApisSourcesV1PingSourceSpec
     * @param knativeDevPkgApisDuckV1KReference
     * @param knativeDevServingPkgApisServingV1Route
     * @param knativeDevEventingPkgApisMessagingV1InMemoryChannel
     * @param knativeDevEventingPkgApisFlowsV1ParallelList
     * @param knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec
     * @param knativeDevServingPkgApisServingV1ConfigurationSpec
     * @param knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec
     * @param knativeDevEventingPkgApisFlowsV1ParallelBranch
     * @param knativeDevEventingPkgApisSourcesV1APIVersionKind
     * @param knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec
     * @param knativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource
     * @param knativeDevEventingPkgApisMessagingV1InMemoryChannelList
     * @param knativeDevEventingPkgApisSourcesV1ContainerSourceList
     * @param knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec
     * @param knativeDevEventingPkgApisMessagingV1ChannelSpec
     * @param knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList
     * @param knativeDevEventingPkgApisEventingV1BrokerStatus
     * @param knativeDevEventingPkgApisMessagingV1SubscriptionSpec
     * @param knativeDevServingPkgApisServingV1Revision
     * @param knativeDevEventingPkgApisFlowsV1Parallel
     * @param knativeDevEventingPkgApisMessagingV1SubscriptionList
     * @param knativeDevServingPkgApisServingV1ConfigurationList
     * @param knativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource
     * @param knativeDevEventingPkgApisSourcesV1ContainerSourceStatus
     * @param knativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus
     * @param knativeDevServingPkgApisServingV1RevisionTemplateSpec
     * @param knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList
     * @param knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus
     * @param knativeDevEventingPkgApisSourcesV1ApiServerSource
     * @param knativeDevEventingPkgApisMessagingV1InMemoryChannelSpec
     * @param knativeDevEventingPkgApisFlowsV1SequenceList
     * @param knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList
     * @param knativeDevEventingPkgApisMessagingV1ChannelTemplateSpec
     * @param knativeDevEventingPkgApisSourcesV1ApiServerSourceList
     * @param knativeDevEventingPkgApisMessagingV1ChannelStatus
     * @param knativeDevEventingPkgApisSourcesV1SinkBindingSpec
     * @param knativeDevServingPkgApisServingV1RouteSpec
     * @param knativeDevEventingPkgApisEventingV1TriggerSpec
     * @param knativeDevEventingPkgApisSourcesV1APIVersionKindSelector
     * @param knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource
     * @param knativeDevEventingPkgApisEventingV1beta1EventTypeStatus
     * @param knativeDevEventingPkgApisFlowsV1Sequence
     * @param knativeDevPkgApisCondition
     * @param knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource
     * @param knativeDevEventingPkgApisMessagingV1Channel
     * @param knativeDevServingPkgApisServingV1RouteStatus
     * @param knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding
     * @param knativeDevEventingPkgApisEventingV1TriggerList
     * @param knativeDevPkgApisDuckV1CloudEventOverrides
     * @param knativeDevEventingPkgApisFlowsV1SequenceStatus
     * @param knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList
     * @param knativeDevEventingPkgApisEventingV1beta1EventTypeList
     * @param knativeDevEventingPkgApisFlowsV1SequenceSpec
     * @param knativeDevServingPkgApisServingV1Service
     * @param knativeDevEventingPkgApisEventingV1beta1EventType
     * @param knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec
     * @param knativeDevEventingPkgApisFlowsV1ParallelBranchStatus
     * @param knativeDevEventingPkgApisMessagingV1Subscription
     * @param knativeDevPkgApisDuckV1Destination
     * @param knativeDevServingPkgApisServingV1TrafficTarget
     * @param knativeDevEventingPkgApisSourcesV1SinkBindingStatus
     * @param knativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource
     * @param knativeDevEventingPkgApisFlowsV1SequenceStep
     * @param knativeDevServingPkgApisServingV1ServiceStatus
     * @param knativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription
     * @param knativeDevEventingPkgApisSourcesV1SinkBinding
     * @param knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList
     * @param knativeDevEventingPkgApisMessagingV1ChannelList
     * @param knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource
     * @param knativeDevEventingPkgApisEventingV1TriggerFilter
     * @param knativeDevEventingPkgApisEventingV1beta1EventTypeSpec
     * @param knativeDevServingPkgApisServingV1ConfigurationStatus
     * @param knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec
     * @param knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList
     */
    public KnativeSchema(AwsSqsSource knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource, AwsSqsSourceList knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList, AwsSqsSourceSpec knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec, AwsSqsSourceStatus knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus, CouchDbSource knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource, CouchDbSourceList knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList, CouchDbSourceSpec knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec, CouchDbSourceStatus knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus, GitHubBinding knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding, GitHubBindingList knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList, GitHubBindingSpec knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec, GitHubBindingStatus knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus, io.fabric8.knative.eventing.contrib.github.v1alpha1.SecretValueFromSource knativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource, GitHubSource knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource, GitHubSourceList knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList, GitHubSourceSpec knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec, GitHubSourceStatus knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus, io.fabric8.knative.eventing.contrib.github.v1alpha1.SecretValueFromSource knativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource, GitLabBinding knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding, GitLabBindingList knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList, GitLabBindingSpec knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec, GitLabBindingStatus knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus, io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.SecretValueFromSource knativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource, GitLabSource knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource, GitLabSourceList knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList, GitLabSourceSpec knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec, GitLabSourceStatus knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus, io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.SecretValueFromSource knativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource, KafkaChannel knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel, KafkaChannelList knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList, KafkaChannelSpec knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec, KafkaChannelStatus knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus, KafkaBinding knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding, KafkaBindingList knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList, KafkaBindingSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec, KafkaBindingStatus knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus, KafkaNetSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec, KafkaSASLSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec, KafkaTLSSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec, io.fabric8.knative.eventing.contrib.kafka.v1beta1.SecretValueFromSource knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource, KafkaSource knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource, KafkaSourceList knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList, KafkaSourceSpec knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec, KafkaSourceStatus knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus, PrometheusSource knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource, PrometheusSourceList knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList, PrometheusSourceSpec knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec, PrometheusSourceStatus knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus, DeliverySpec knativeDevEventingPkgApisDuckV1DeliverySpec, SubscriberSpec knativeDevEventingPkgApisDuckV1SubscriberSpec, SubscriberStatus knativeDevEventingPkgApisDuckV1SubscriberStatus, Broker knativeDevEventingPkgApisEventingV1Broker, BrokerList knativeDevEventingPkgApisEventingV1BrokerList, BrokerSpec knativeDevEventingPkgApisEventingV1BrokerSpec, BrokerStatus knativeDevEventingPkgApisEventingV1BrokerStatus, Trigger knativeDevEventingPkgApisEventingV1Trigger, TriggerFilter knativeDevEventingPkgApisEventingV1TriggerFilter, TriggerList knativeDevEventingPkgApisEventingV1TriggerList, TriggerSpec knativeDevEventingPkgApisEventingV1TriggerSpec, TriggerStatus knativeDevEventingPkgApisEventingV1TriggerStatus, EventType knativeDevEventingPkgApisEventingV1beta1EventType, EventTypeList knativeDevEventingPkgApisEventingV1beta1EventTypeList, EventTypeSpec knativeDevEventingPkgApisEventingV1beta1EventTypeSpec, EventTypeStatus knativeDevEventingPkgApisEventingV1beta1EventTypeStatus, Parallel knativeDevEventingPkgApisFlowsV1Parallel, ParallelBranch knativeDevEventingPkgApisFlowsV1ParallelBranch, ParallelBranchStatus knativeDevEventingPkgApisFlowsV1ParallelBranchStatus, ParallelChannelStatus knativeDevEventingPkgApisFlowsV1ParallelChannelStatus, ParallelList knativeDevEventingPkgApisFlowsV1ParallelList, ParallelSpec knativeDevEventingPkgApisFlowsV1ParallelSpec, ParallelStatus knativeDevEventingPkgApisFlowsV1ParallelStatus, ParallelSubscriptionStatus knativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus, Sequence knativeDevEventingPkgApisFlowsV1Sequence, SequenceChannelStatus knativeDevEventingPkgApisFlowsV1SequenceChannelStatus, SequenceList knativeDevEventingPkgApisFlowsV1SequenceList, SequenceSpec knativeDevEventingPkgApisFlowsV1SequenceSpec, SequenceStatus knativeDevEventingPkgApisFlowsV1SequenceStatus, SequenceStep knativeDevEventingPkgApisFlowsV1SequenceStep, SequenceSubscriptionStatus knativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus, Channel knativeDevEventingPkgApisMessagingV1Channel, ChannelList knativeDevEventingPkgApisMessagingV1ChannelList, ChannelSpec knativeDevEventingPkgApisMessagingV1ChannelSpec, ChannelStatus knativeDevEventingPkgApisMessagingV1ChannelStatus, ChannelTemplateSpec knativeDevEventingPkgApisMessagingV1ChannelTemplateSpec, InMemoryChannel knativeDevEventingPkgApisMessagingV1InMemoryChannel, InMemoryChannelList knativeDevEventingPkgApisMessagingV1InMemoryChannelList, InMemoryChannelSpec knativeDevEventingPkgApisMessagingV1InMemoryChannelSpec, InMemoryChannelStatus knativeDevEventingPkgApisMessagingV1InMemoryChannelStatus, Subscription knativeDevEventingPkgApisMessagingV1Subscription, SubscriptionList knativeDevEventingPkgApisMessagingV1SubscriptionList, SubscriptionSpec knativeDevEventingPkgApisMessagingV1SubscriptionSpec, SubscriptionStatus knativeDevEventingPkgApisMessagingV1SubscriptionStatus, SubscriptionStatusPhysicalSubscription knativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription, APIVersionKind knativeDevEventingPkgApisSourcesV1APIVersionKind, APIVersionKindSelector knativeDevEventingPkgApisSourcesV1APIVersionKindSelector, ApiServerSource knativeDevEventingPkgApisSourcesV1ApiServerSource, ApiServerSourceList knativeDevEventingPkgApisSourcesV1ApiServerSourceList, ApiServerSourceSpec knativeDevEventingPkgApisSourcesV1ApiServerSourceSpec, ApiServerSourceStatus knativeDevEventingPkgApisSourcesV1ApiServerSourceStatus, ContainerSource knativeDevEventingPkgApisSourcesV1ContainerSource, ContainerSourceList knativeDevEventingPkgApisSourcesV1ContainerSourceList, ContainerSourceSpec knativeDevEventingPkgApisSourcesV1ContainerSourceSpec, ContainerSourceStatus knativeDevEventingPkgApisSourcesV1ContainerSourceStatus, PingSource knativeDevEventingPkgApisSourcesV1PingSource, PingSourceList knativeDevEventingPkgApisSourcesV1PingSourceList, PingSourceSpec knativeDevEventingPkgApisSourcesV1PingSourceSpec, PingSourceStatus knativeDevEventingPkgApisSourcesV1PingSourceStatus, SinkBinding knativeDevEventingPkgApisSourcesV1SinkBinding, SinkBindingList knativeDevEventingPkgApisSourcesV1SinkBindingList, SinkBindingSpec knativeDevEventingPkgApisSourcesV1SinkBindingSpec, SinkBindingStatus knativeDevEventingPkgApisSourcesV1SinkBindingStatus, Condition knativeDevPkgApisCondition, Addressable knativeDevPkgApisDuckV1Addressable, CloudEventAttributes knativeDevPkgApisDuckV1CloudEventAttributes, CloudEventOverrides knativeDevPkgApisDuckV1CloudEventOverrides, Destination knativeDevPkgApisDuckV1Destination, KReference knativeDevPkgApisDuckV1KReference, Reference knativeDevPkgTrackerReference, Configuration knativeDevServingPkgApisServingV1Configuration, ConfigurationList knativeDevServingPkgApisServingV1ConfigurationList, ConfigurationSpec knativeDevServingPkgApisServingV1ConfigurationSpec, ConfigurationStatus knativeDevServingPkgApisServingV1ConfigurationStatus, ContainerStatus knativeDevServingPkgApisServingV1ContainerStatus, Revision knativeDevServingPkgApisServingV1Revision, RevisionList knativeDevServingPkgApisServingV1RevisionList, RevisionSpec knativeDevServingPkgApisServingV1RevisionSpec, RevisionStatus knativeDevServingPkgApisServingV1RevisionStatus, RevisionTemplateSpec knativeDevServingPkgApisServingV1RevisionTemplateSpec, Route knativeDevServingPkgApisServingV1Route, RouteList knativeDevServingPkgApisServingV1RouteList, RouteSpec knativeDevServingPkgApisServingV1RouteSpec, RouteStatus knativeDevServingPkgApisServingV1RouteStatus, Service knativeDevServingPkgApisServingV1Service, ServiceList knativeDevServingPkgApisServingV1ServiceList, ServiceSpec knativeDevServingPkgApisServingV1ServiceSpec, ServiceStatus knativeDevServingPkgApisServingV1ServiceStatus, TrafficTarget knativeDevServingPkgApisServingV1TrafficTarget) {
        super();
        this.knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource = knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource;
        this.knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList = knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList;
        this.knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec = knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec;
        this.knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus = knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus;
        this.knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource = knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource;
        this.knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList = knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList;
        this.knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec = knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec;
        this.knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus = knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus;
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding = knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding;
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList = knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList;
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec = knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec;
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus = knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus;
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource = knativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource;
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource = knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource;
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList = knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList;
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec = knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec;
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus = knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus;
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource = knativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource;
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding;
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList;
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec;
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus;
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource;
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource;
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList;
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec;
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus;
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource;
        this.knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel = knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel;
        this.knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList = knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList;
        this.knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec = knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec;
        this.knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus = knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus;
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding;
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList;
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec;
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus;
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec;
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec;
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec;
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource;
        this.knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource = knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource;
        this.knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList = knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList;
        this.knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec = knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec;
        this.knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus = knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus;
        this.knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource = knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource;
        this.knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList = knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList;
        this.knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec = knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec;
        this.knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus = knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus;
        this.knativeDevEventingPkgApisDuckV1DeliverySpec = knativeDevEventingPkgApisDuckV1DeliverySpec;
        this.knativeDevEventingPkgApisDuckV1SubscriberSpec = knativeDevEventingPkgApisDuckV1SubscriberSpec;
        this.knativeDevEventingPkgApisDuckV1SubscriberStatus = knativeDevEventingPkgApisDuckV1SubscriberStatus;
        this.knativeDevEventingPkgApisEventingV1Broker = knativeDevEventingPkgApisEventingV1Broker;
        this.knativeDevEventingPkgApisEventingV1BrokerList = knativeDevEventingPkgApisEventingV1BrokerList;
        this.knativeDevEventingPkgApisEventingV1BrokerSpec = knativeDevEventingPkgApisEventingV1BrokerSpec;
        this.knativeDevEventingPkgApisEventingV1BrokerStatus = knativeDevEventingPkgApisEventingV1BrokerStatus;
        this.knativeDevEventingPkgApisEventingV1Trigger = knativeDevEventingPkgApisEventingV1Trigger;
        this.knativeDevEventingPkgApisEventingV1TriggerFilter = knativeDevEventingPkgApisEventingV1TriggerFilter;
        this.knativeDevEventingPkgApisEventingV1TriggerList = knativeDevEventingPkgApisEventingV1TriggerList;
        this.knativeDevEventingPkgApisEventingV1TriggerSpec = knativeDevEventingPkgApisEventingV1TriggerSpec;
        this.knativeDevEventingPkgApisEventingV1TriggerStatus = knativeDevEventingPkgApisEventingV1TriggerStatus;
        this.knativeDevEventingPkgApisEventingV1beta1EventType = knativeDevEventingPkgApisEventingV1beta1EventType;
        this.knativeDevEventingPkgApisEventingV1beta1EventTypeList = knativeDevEventingPkgApisEventingV1beta1EventTypeList;
        this.knativeDevEventingPkgApisEventingV1beta1EventTypeSpec = knativeDevEventingPkgApisEventingV1beta1EventTypeSpec;
        this.knativeDevEventingPkgApisEventingV1beta1EventTypeStatus = knativeDevEventingPkgApisEventingV1beta1EventTypeStatus;
        this.knativeDevEventingPkgApisFlowsV1Parallel = knativeDevEventingPkgApisFlowsV1Parallel;
        this.knativeDevEventingPkgApisFlowsV1ParallelBranch = knativeDevEventingPkgApisFlowsV1ParallelBranch;
        this.knativeDevEventingPkgApisFlowsV1ParallelBranchStatus = knativeDevEventingPkgApisFlowsV1ParallelBranchStatus;
        this.knativeDevEventingPkgApisFlowsV1ParallelChannelStatus = knativeDevEventingPkgApisFlowsV1ParallelChannelStatus;
        this.knativeDevEventingPkgApisFlowsV1ParallelList = knativeDevEventingPkgApisFlowsV1ParallelList;
        this.knativeDevEventingPkgApisFlowsV1ParallelSpec = knativeDevEventingPkgApisFlowsV1ParallelSpec;
        this.knativeDevEventingPkgApisFlowsV1ParallelStatus = knativeDevEventingPkgApisFlowsV1ParallelStatus;
        this.knativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus = knativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus;
        this.knativeDevEventingPkgApisFlowsV1Sequence = knativeDevEventingPkgApisFlowsV1Sequence;
        this.knativeDevEventingPkgApisFlowsV1SequenceChannelStatus = knativeDevEventingPkgApisFlowsV1SequenceChannelStatus;
        this.knativeDevEventingPkgApisFlowsV1SequenceList = knativeDevEventingPkgApisFlowsV1SequenceList;
        this.knativeDevEventingPkgApisFlowsV1SequenceSpec = knativeDevEventingPkgApisFlowsV1SequenceSpec;
        this.knativeDevEventingPkgApisFlowsV1SequenceStatus = knativeDevEventingPkgApisFlowsV1SequenceStatus;
        this.knativeDevEventingPkgApisFlowsV1SequenceStep = knativeDevEventingPkgApisFlowsV1SequenceStep;
        this.knativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus = knativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus;
        this.knativeDevEventingPkgApisMessagingV1Channel = knativeDevEventingPkgApisMessagingV1Channel;
        this.knativeDevEventingPkgApisMessagingV1ChannelList = knativeDevEventingPkgApisMessagingV1ChannelList;
        this.knativeDevEventingPkgApisMessagingV1ChannelSpec = knativeDevEventingPkgApisMessagingV1ChannelSpec;
        this.knativeDevEventingPkgApisMessagingV1ChannelStatus = knativeDevEventingPkgApisMessagingV1ChannelStatus;
        this.knativeDevEventingPkgApisMessagingV1ChannelTemplateSpec = knativeDevEventingPkgApisMessagingV1ChannelTemplateSpec;
        this.knativeDevEventingPkgApisMessagingV1InMemoryChannel = knativeDevEventingPkgApisMessagingV1InMemoryChannel;
        this.knativeDevEventingPkgApisMessagingV1InMemoryChannelList = knativeDevEventingPkgApisMessagingV1InMemoryChannelList;
        this.knativeDevEventingPkgApisMessagingV1InMemoryChannelSpec = knativeDevEventingPkgApisMessagingV1InMemoryChannelSpec;
        this.knativeDevEventingPkgApisMessagingV1InMemoryChannelStatus = knativeDevEventingPkgApisMessagingV1InMemoryChannelStatus;
        this.knativeDevEventingPkgApisMessagingV1Subscription = knativeDevEventingPkgApisMessagingV1Subscription;
        this.knativeDevEventingPkgApisMessagingV1SubscriptionList = knativeDevEventingPkgApisMessagingV1SubscriptionList;
        this.knativeDevEventingPkgApisMessagingV1SubscriptionSpec = knativeDevEventingPkgApisMessagingV1SubscriptionSpec;
        this.knativeDevEventingPkgApisMessagingV1SubscriptionStatus = knativeDevEventingPkgApisMessagingV1SubscriptionStatus;
        this.knativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription = knativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription;
        this.knativeDevEventingPkgApisSourcesV1APIVersionKind = knativeDevEventingPkgApisSourcesV1APIVersionKind;
        this.knativeDevEventingPkgApisSourcesV1APIVersionKindSelector = knativeDevEventingPkgApisSourcesV1APIVersionKindSelector;
        this.knativeDevEventingPkgApisSourcesV1ApiServerSource = knativeDevEventingPkgApisSourcesV1ApiServerSource;
        this.knativeDevEventingPkgApisSourcesV1ApiServerSourceList = knativeDevEventingPkgApisSourcesV1ApiServerSourceList;
        this.knativeDevEventingPkgApisSourcesV1ApiServerSourceSpec = knativeDevEventingPkgApisSourcesV1ApiServerSourceSpec;
        this.knativeDevEventingPkgApisSourcesV1ApiServerSourceStatus = knativeDevEventingPkgApisSourcesV1ApiServerSourceStatus;
        this.knativeDevEventingPkgApisSourcesV1ContainerSource = knativeDevEventingPkgApisSourcesV1ContainerSource;
        this.knativeDevEventingPkgApisSourcesV1ContainerSourceList = knativeDevEventingPkgApisSourcesV1ContainerSourceList;
        this.knativeDevEventingPkgApisSourcesV1ContainerSourceSpec = knativeDevEventingPkgApisSourcesV1ContainerSourceSpec;
        this.knativeDevEventingPkgApisSourcesV1ContainerSourceStatus = knativeDevEventingPkgApisSourcesV1ContainerSourceStatus;
        this.knativeDevEventingPkgApisSourcesV1PingSource = knativeDevEventingPkgApisSourcesV1PingSource;
        this.knativeDevEventingPkgApisSourcesV1PingSourceList = knativeDevEventingPkgApisSourcesV1PingSourceList;
        this.knativeDevEventingPkgApisSourcesV1PingSourceSpec = knativeDevEventingPkgApisSourcesV1PingSourceSpec;
        this.knativeDevEventingPkgApisSourcesV1PingSourceStatus = knativeDevEventingPkgApisSourcesV1PingSourceStatus;
        this.knativeDevEventingPkgApisSourcesV1SinkBinding = knativeDevEventingPkgApisSourcesV1SinkBinding;
        this.knativeDevEventingPkgApisSourcesV1SinkBindingList = knativeDevEventingPkgApisSourcesV1SinkBindingList;
        this.knativeDevEventingPkgApisSourcesV1SinkBindingSpec = knativeDevEventingPkgApisSourcesV1SinkBindingSpec;
        this.knativeDevEventingPkgApisSourcesV1SinkBindingStatus = knativeDevEventingPkgApisSourcesV1SinkBindingStatus;
        this.knativeDevPkgApisCondition = knativeDevPkgApisCondition;
        this.knativeDevPkgApisDuckV1Addressable = knativeDevPkgApisDuckV1Addressable;
        this.knativeDevPkgApisDuckV1CloudEventAttributes = knativeDevPkgApisDuckV1CloudEventAttributes;
        this.knativeDevPkgApisDuckV1CloudEventOverrides = knativeDevPkgApisDuckV1CloudEventOverrides;
        this.knativeDevPkgApisDuckV1Destination = knativeDevPkgApisDuckV1Destination;
        this.knativeDevPkgApisDuckV1KReference = knativeDevPkgApisDuckV1KReference;
        this.knativeDevPkgTrackerReference = knativeDevPkgTrackerReference;
        this.knativeDevServingPkgApisServingV1Configuration = knativeDevServingPkgApisServingV1Configuration;
        this.knativeDevServingPkgApisServingV1ConfigurationList = knativeDevServingPkgApisServingV1ConfigurationList;
        this.knativeDevServingPkgApisServingV1ConfigurationSpec = knativeDevServingPkgApisServingV1ConfigurationSpec;
        this.knativeDevServingPkgApisServingV1ConfigurationStatus = knativeDevServingPkgApisServingV1ConfigurationStatus;
        this.knativeDevServingPkgApisServingV1ContainerStatus = knativeDevServingPkgApisServingV1ContainerStatus;
        this.knativeDevServingPkgApisServingV1Revision = knativeDevServingPkgApisServingV1Revision;
        this.knativeDevServingPkgApisServingV1RevisionList = knativeDevServingPkgApisServingV1RevisionList;
        this.knativeDevServingPkgApisServingV1RevisionSpec = knativeDevServingPkgApisServingV1RevisionSpec;
        this.knativeDevServingPkgApisServingV1RevisionStatus = knativeDevServingPkgApisServingV1RevisionStatus;
        this.knativeDevServingPkgApisServingV1RevisionTemplateSpec = knativeDevServingPkgApisServingV1RevisionTemplateSpec;
        this.knativeDevServingPkgApisServingV1Route = knativeDevServingPkgApisServingV1Route;
        this.knativeDevServingPkgApisServingV1RouteList = knativeDevServingPkgApisServingV1RouteList;
        this.knativeDevServingPkgApisServingV1RouteSpec = knativeDevServingPkgApisServingV1RouteSpec;
        this.knativeDevServingPkgApisServingV1RouteStatus = knativeDevServingPkgApisServingV1RouteStatus;
        this.knativeDevServingPkgApisServingV1Service = knativeDevServingPkgApisServingV1Service;
        this.knativeDevServingPkgApisServingV1ServiceList = knativeDevServingPkgApisServingV1ServiceList;
        this.knativeDevServingPkgApisServingV1ServiceSpec = knativeDevServingPkgApisServingV1ServiceSpec;
        this.knativeDevServingPkgApisServingV1ServiceStatus = knativeDevServingPkgApisServingV1ServiceStatus;
        this.knativeDevServingPkgApisServingV1TrafficTarget = knativeDevServingPkgApisServingV1TrafficTarget;
    }

    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSource")
    public AwsSqsSource getKnativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource() {
        return knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSource")
    public void setKnativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource(AwsSqsSource knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource) {
        this.knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource = knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceList")
    public AwsSqsSourceList getKnativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList() {
        return knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceList")
    public void setKnativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList(AwsSqsSourceList knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList) {
        this.knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList = knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceSpec")
    public AwsSqsSourceSpec getKnativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec() {
        return knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceSpec")
    public void setKnativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec(AwsSqsSourceSpec knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec) {
        this.knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec = knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceStatus")
    public AwsSqsSourceStatus getKnativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus() {
        return knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_awssqs_pkg_apis_sources_v1alpha1_AwsSqsSourceStatus")
    public void setKnativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus(AwsSqsSourceStatus knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus) {
        this.knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus = knativeDevEventingContribAwssqsPkgApisSourcesV1alpha1AwsSqsSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSource")
    public CouchDbSource getKnativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource() {
        return knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSource")
    public void setKnativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource(CouchDbSource knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource) {
        this.knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource = knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceList")
    public CouchDbSourceList getKnativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList() {
        return knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceList")
    public void setKnativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList(CouchDbSourceList knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList) {
        this.knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList = knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceSpec")
    public CouchDbSourceSpec getKnativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec() {
        return knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceSpec")
    public void setKnativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec(CouchDbSourceSpec knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec) {
        this.knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec = knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceStatus")
    public CouchDbSourceStatus getKnativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus() {
        return knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_couchdb_source_pkg_apis_sources_v1alpha1_CouchDbSourceStatus")
    public void setKnativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus(CouchDbSourceStatus knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus) {
        this.knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus = knativeDevEventingContribCouchdbSourcePkgApisSourcesV1alpha1CouchDbSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBinding")
    public GitHubBinding getKnativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding() {
        return knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBinding")
    public void setKnativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding(GitHubBinding knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding) {
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding = knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBinding;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingList")
    public GitHubBindingList getKnativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList() {
        return knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingList")
    public void setKnativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList(GitHubBindingList knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList) {
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList = knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingList;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingSpec")
    public GitHubBindingSpec getKnativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec() {
        return knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingSpec")
    public void setKnativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec(GitHubBindingSpec knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec) {
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec = knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingStatus")
    public GitHubBindingStatus getKnativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus() {
        return knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_GitHubBindingStatus")
    public void setKnativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus(GitHubBindingStatus knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus) {
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus = knativeDevEventingContribGithubPkgApisBindingsV1alpha1GitHubBindingStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_SecretValueFromSource")
    public io.fabric8.knative.eventing.contrib.github.v1alpha1.SecretValueFromSource getKnativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource() {
        return knativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_bindings_v1alpha1_SecretValueFromSource")
    public void setKnativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource(io.fabric8.knative.eventing.contrib.github.v1alpha1.SecretValueFromSource knativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource) {
        this.knativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource = knativeDevEventingContribGithubPkgApisBindingsV1alpha1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSource")
    public GitHubSource getKnativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource() {
        return knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSource")
    public void setKnativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource(GitHubSource knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource) {
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource = knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceList")
    public GitHubSourceList getKnativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList() {
        return knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceList")
    public void setKnativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList(GitHubSourceList knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList) {
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList = knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceSpec")
    public GitHubSourceSpec getKnativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec() {
        return knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceSpec")
    public void setKnativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec(GitHubSourceSpec knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec) {
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec = knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceStatus")
    public GitHubSourceStatus getKnativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus() {
        return knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_GitHubSourceStatus")
    public void setKnativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus(GitHubSourceStatus knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus) {
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus = knativeDevEventingContribGithubPkgApisSourcesV1alpha1GitHubSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_SecretValueFromSource")
    public io.fabric8.knative.eventing.contrib.github.v1alpha1.SecretValueFromSource getKnativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource() {
        return knativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_github_pkg_apis_sources_v1alpha1_SecretValueFromSource")
    public void setKnativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource(io.fabric8.knative.eventing.contrib.github.v1alpha1.SecretValueFromSource knativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource) {
        this.knativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource = knativeDevEventingContribGithubPkgApisSourcesV1alpha1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBinding")
    public GitLabBinding getKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding() {
        return knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBinding")
    public void setKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding(GitLabBinding knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding) {
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBinding;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingList")
    public GitLabBindingList getKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList() {
        return knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingList")
    public void setKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList(GitLabBindingList knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList) {
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingList;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingSpec")
    public GitLabBindingSpec getKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec() {
        return knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingSpec")
    public void setKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec(GitLabBindingSpec knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec) {
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingStatus")
    public GitLabBindingStatus getKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus() {
        return knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_GitLabBindingStatus")
    public void setKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus(GitLabBindingStatus knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus) {
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1GitLabBindingStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_SecretValueFromSource")
    public io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.SecretValueFromSource getKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource() {
        return knativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_bindings_v1alpha1_SecretValueFromSource")
    public void setKnativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource(io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.SecretValueFromSource knativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource) {
        this.knativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource = knativeDevEventingContribGitlabPkgApisBindingsV1alpha1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSource")
    public GitLabSource getKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource() {
        return knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSource")
    public void setKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource(GitLabSource knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource) {
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceList")
    public GitLabSourceList getKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList() {
        return knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceList")
    public void setKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList(GitLabSourceList knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList) {
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceSpec")
    public GitLabSourceSpec getKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec() {
        return knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceSpec")
    public void setKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec(GitLabSourceSpec knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec) {
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceStatus")
    public GitLabSourceStatus getKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus() {
        return knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_GitLabSourceStatus")
    public void setKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus(GitLabSourceStatus knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus) {
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1GitLabSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_SecretValueFromSource")
    public io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.SecretValueFromSource getKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource() {
        return knativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_gitlab_pkg_apis_sources_v1alpha1_SecretValueFromSource")
    public void setKnativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource(io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.SecretValueFromSource knativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource) {
        this.knativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource = knativeDevEventingContribGitlabPkgApisSourcesV1alpha1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannel")
    public KafkaChannel getKnativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel() {
        return knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannel")
    public void setKnativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel(KafkaChannel knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel) {
        this.knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel = knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannel;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelList")
    public KafkaChannelList getKnativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList() {
        return knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelList")
    public void setKnativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList(KafkaChannelList knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList) {
        this.knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList = knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelList;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelSpec")
    public KafkaChannelSpec getKnativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec() {
        return knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelSpec")
    public void setKnativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec(KafkaChannelSpec knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec) {
        this.knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec = knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelStatus")
    public KafkaChannelStatus getKnativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus() {
        return knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_channel_pkg_apis_messaging_v1beta1_KafkaChannelStatus")
    public void setKnativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus(KafkaChannelStatus knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus) {
        this.knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus = knativeDevEventingContribKafkaChannelPkgApisMessagingV1beta1KafkaChannelStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBinding")
    public KafkaBinding getKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding() {
        return knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBinding")
    public void setKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding(KafkaBinding knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding) {
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBinding;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingList")
    public KafkaBindingList getKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList() {
        return knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingList")
    public void setKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList(KafkaBindingList knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList) {
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingList;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingSpec")
    public KafkaBindingSpec getKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec() {
        return knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingSpec")
    public void setKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec(KafkaBindingSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec) {
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingStatus")
    public KafkaBindingStatus getKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus() {
        return knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaBindingStatus")
    public void setKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus(KafkaBindingStatus knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus) {
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaBindingStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaNetSpec")
    public KafkaNetSpec getKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec() {
        return knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaNetSpec")
    public void setKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec(KafkaNetSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec) {
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaNetSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaSASLSpec")
    public KafkaSASLSpec getKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec() {
        return knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaSASLSpec")
    public void setKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec(KafkaSASLSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec) {
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaSASLSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaTLSSpec")
    public KafkaTLSSpec getKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec() {
        return knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_KafkaTLSSpec")
    public void setKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec(KafkaTLSSpec knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec) {
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1KafkaTLSSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_SecretValueFromSource")
    public io.fabric8.knative.eventing.contrib.kafka.v1beta1.SecretValueFromSource getKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource() {
        return knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_bindings_v1beta1_SecretValueFromSource")
    public void setKnativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource(io.fabric8.knative.eventing.contrib.kafka.v1beta1.SecretValueFromSource knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource) {
        this.knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource = knativeDevEventingContribKafkaSourcePkgApisBindingsV1beta1SecretValueFromSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSource")
    public KafkaSource getKnativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource() {
        return knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSource")
    public void setKnativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource(KafkaSource knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource) {
        this.knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource = knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceList")
    public KafkaSourceList getKnativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList() {
        return knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceList")
    public void setKnativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList(KafkaSourceList knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList) {
        this.knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList = knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceSpec")
    public KafkaSourceSpec getKnativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec() {
        return knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceSpec")
    public void setKnativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec(KafkaSourceSpec knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec) {
        this.knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec = knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceStatus")
    public KafkaSourceStatus getKnativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus() {
        return knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_kafka_source_pkg_apis_sources_v1beta1_KafkaSourceStatus")
    public void setKnativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus(KafkaSourceStatus knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus) {
        this.knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus = knativeDevEventingContribKafkaSourcePkgApisSourcesV1beta1KafkaSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSource")
    public PrometheusSource getKnativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource() {
        return knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSource")
    public void setKnativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource(PrometheusSource knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource) {
        this.knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource = knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSource;
    }

    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceList")
    public PrometheusSourceList getKnativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList() {
        return knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceList")
    public void setKnativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList(PrometheusSourceList knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList) {
        this.knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList = knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceList;
    }

    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceSpec")
    public PrometheusSourceSpec getKnativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec() {
        return knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceSpec")
    public void setKnativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec(PrometheusSourceSpec knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec) {
        this.knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec = knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceSpec;
    }

    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceStatus")
    public PrometheusSourceStatus getKnativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus() {
        return knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus;
    }

    @JsonProperty("knative_dev_eventing-contrib_prometheus_pkg_apis_sources_v1alpha1_PrometheusSourceStatus")
    public void setKnativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus(PrometheusSourceStatus knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus) {
        this.knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus = knativeDevEventingContribPrometheusPkgApisSourcesV1alpha1PrometheusSourceStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_duck_v1_DeliverySpec")
    public DeliverySpec getKnativeDevEventingPkgApisDuckV1DeliverySpec() {
        return knativeDevEventingPkgApisDuckV1DeliverySpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_duck_v1_DeliverySpec")
    public void setKnativeDevEventingPkgApisDuckV1DeliverySpec(DeliverySpec knativeDevEventingPkgApisDuckV1DeliverySpec) {
        this.knativeDevEventingPkgApisDuckV1DeliverySpec = knativeDevEventingPkgApisDuckV1DeliverySpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_duck_v1_SubscriberSpec")
    public SubscriberSpec getKnativeDevEventingPkgApisDuckV1SubscriberSpec() {
        return knativeDevEventingPkgApisDuckV1SubscriberSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_duck_v1_SubscriberSpec")
    public void setKnativeDevEventingPkgApisDuckV1SubscriberSpec(SubscriberSpec knativeDevEventingPkgApisDuckV1SubscriberSpec) {
        this.knativeDevEventingPkgApisDuckV1SubscriberSpec = knativeDevEventingPkgApisDuckV1SubscriberSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_duck_v1_SubscriberStatus")
    public SubscriberStatus getKnativeDevEventingPkgApisDuckV1SubscriberStatus() {
        return knativeDevEventingPkgApisDuckV1SubscriberStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_duck_v1_SubscriberStatus")
    public void setKnativeDevEventingPkgApisDuckV1SubscriberStatus(SubscriberStatus knativeDevEventingPkgApisDuckV1SubscriberStatus) {
        this.knativeDevEventingPkgApisDuckV1SubscriberStatus = knativeDevEventingPkgApisDuckV1SubscriberStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_Broker")
    public Broker getKnativeDevEventingPkgApisEventingV1Broker() {
        return knativeDevEventingPkgApisEventingV1Broker;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_Broker")
    public void setKnativeDevEventingPkgApisEventingV1Broker(Broker knativeDevEventingPkgApisEventingV1Broker) {
        this.knativeDevEventingPkgApisEventingV1Broker = knativeDevEventingPkgApisEventingV1Broker;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_BrokerList")
    public BrokerList getKnativeDevEventingPkgApisEventingV1BrokerList() {
        return knativeDevEventingPkgApisEventingV1BrokerList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_BrokerList")
    public void setKnativeDevEventingPkgApisEventingV1BrokerList(BrokerList knativeDevEventingPkgApisEventingV1BrokerList) {
        this.knativeDevEventingPkgApisEventingV1BrokerList = knativeDevEventingPkgApisEventingV1BrokerList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_BrokerSpec")
    public BrokerSpec getKnativeDevEventingPkgApisEventingV1BrokerSpec() {
        return knativeDevEventingPkgApisEventingV1BrokerSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_BrokerSpec")
    public void setKnativeDevEventingPkgApisEventingV1BrokerSpec(BrokerSpec knativeDevEventingPkgApisEventingV1BrokerSpec) {
        this.knativeDevEventingPkgApisEventingV1BrokerSpec = knativeDevEventingPkgApisEventingV1BrokerSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_BrokerStatus")
    public BrokerStatus getKnativeDevEventingPkgApisEventingV1BrokerStatus() {
        return knativeDevEventingPkgApisEventingV1BrokerStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_BrokerStatus")
    public void setKnativeDevEventingPkgApisEventingV1BrokerStatus(BrokerStatus knativeDevEventingPkgApisEventingV1BrokerStatus) {
        this.knativeDevEventingPkgApisEventingV1BrokerStatus = knativeDevEventingPkgApisEventingV1BrokerStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_Trigger")
    public Trigger getKnativeDevEventingPkgApisEventingV1Trigger() {
        return knativeDevEventingPkgApisEventingV1Trigger;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_Trigger")
    public void setKnativeDevEventingPkgApisEventingV1Trigger(Trigger knativeDevEventingPkgApisEventingV1Trigger) {
        this.knativeDevEventingPkgApisEventingV1Trigger = knativeDevEventingPkgApisEventingV1Trigger;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerFilter")
    public TriggerFilter getKnativeDevEventingPkgApisEventingV1TriggerFilter() {
        return knativeDevEventingPkgApisEventingV1TriggerFilter;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerFilter")
    public void setKnativeDevEventingPkgApisEventingV1TriggerFilter(TriggerFilter knativeDevEventingPkgApisEventingV1TriggerFilter) {
        this.knativeDevEventingPkgApisEventingV1TriggerFilter = knativeDevEventingPkgApisEventingV1TriggerFilter;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerList")
    public TriggerList getKnativeDevEventingPkgApisEventingV1TriggerList() {
        return knativeDevEventingPkgApisEventingV1TriggerList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerList")
    public void setKnativeDevEventingPkgApisEventingV1TriggerList(TriggerList knativeDevEventingPkgApisEventingV1TriggerList) {
        this.knativeDevEventingPkgApisEventingV1TriggerList = knativeDevEventingPkgApisEventingV1TriggerList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerSpec")
    public TriggerSpec getKnativeDevEventingPkgApisEventingV1TriggerSpec() {
        return knativeDevEventingPkgApisEventingV1TriggerSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerSpec")
    public void setKnativeDevEventingPkgApisEventingV1TriggerSpec(TriggerSpec knativeDevEventingPkgApisEventingV1TriggerSpec) {
        this.knativeDevEventingPkgApisEventingV1TriggerSpec = knativeDevEventingPkgApisEventingV1TriggerSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerStatus")
    public TriggerStatus getKnativeDevEventingPkgApisEventingV1TriggerStatus() {
        return knativeDevEventingPkgApisEventingV1TriggerStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1_TriggerStatus")
    public void setKnativeDevEventingPkgApisEventingV1TriggerStatus(TriggerStatus knativeDevEventingPkgApisEventingV1TriggerStatus) {
        this.knativeDevEventingPkgApisEventingV1TriggerStatus = knativeDevEventingPkgApisEventingV1TriggerStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventType")
    public EventType getKnativeDevEventingPkgApisEventingV1beta1EventType() {
        return knativeDevEventingPkgApisEventingV1beta1EventType;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventType")
    public void setKnativeDevEventingPkgApisEventingV1beta1EventType(EventType knativeDevEventingPkgApisEventingV1beta1EventType) {
        this.knativeDevEventingPkgApisEventingV1beta1EventType = knativeDevEventingPkgApisEventingV1beta1EventType;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeList")
    public EventTypeList getKnativeDevEventingPkgApisEventingV1beta1EventTypeList() {
        return knativeDevEventingPkgApisEventingV1beta1EventTypeList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeList")
    public void setKnativeDevEventingPkgApisEventingV1beta1EventTypeList(EventTypeList knativeDevEventingPkgApisEventingV1beta1EventTypeList) {
        this.knativeDevEventingPkgApisEventingV1beta1EventTypeList = knativeDevEventingPkgApisEventingV1beta1EventTypeList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeSpec")
    public EventTypeSpec getKnativeDevEventingPkgApisEventingV1beta1EventTypeSpec() {
        return knativeDevEventingPkgApisEventingV1beta1EventTypeSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeSpec")
    public void setKnativeDevEventingPkgApisEventingV1beta1EventTypeSpec(EventTypeSpec knativeDevEventingPkgApisEventingV1beta1EventTypeSpec) {
        this.knativeDevEventingPkgApisEventingV1beta1EventTypeSpec = knativeDevEventingPkgApisEventingV1beta1EventTypeSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeStatus")
    public EventTypeStatus getKnativeDevEventingPkgApisEventingV1beta1EventTypeStatus() {
        return knativeDevEventingPkgApisEventingV1beta1EventTypeStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_eventing_v1beta1_EventTypeStatus")
    public void setKnativeDevEventingPkgApisEventingV1beta1EventTypeStatus(EventTypeStatus knativeDevEventingPkgApisEventingV1beta1EventTypeStatus) {
        this.knativeDevEventingPkgApisEventingV1beta1EventTypeStatus = knativeDevEventingPkgApisEventingV1beta1EventTypeStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_Parallel")
    public Parallel getKnativeDevEventingPkgApisFlowsV1Parallel() {
        return knativeDevEventingPkgApisFlowsV1Parallel;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_Parallel")
    public void setKnativeDevEventingPkgApisFlowsV1Parallel(Parallel knativeDevEventingPkgApisFlowsV1Parallel) {
        this.knativeDevEventingPkgApisFlowsV1Parallel = knativeDevEventingPkgApisFlowsV1Parallel;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelBranch")
    public ParallelBranch getKnativeDevEventingPkgApisFlowsV1ParallelBranch() {
        return knativeDevEventingPkgApisFlowsV1ParallelBranch;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelBranch")
    public void setKnativeDevEventingPkgApisFlowsV1ParallelBranch(ParallelBranch knativeDevEventingPkgApisFlowsV1ParallelBranch) {
        this.knativeDevEventingPkgApisFlowsV1ParallelBranch = knativeDevEventingPkgApisFlowsV1ParallelBranch;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelBranchStatus")
    public ParallelBranchStatus getKnativeDevEventingPkgApisFlowsV1ParallelBranchStatus() {
        return knativeDevEventingPkgApisFlowsV1ParallelBranchStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelBranchStatus")
    public void setKnativeDevEventingPkgApisFlowsV1ParallelBranchStatus(ParallelBranchStatus knativeDevEventingPkgApisFlowsV1ParallelBranchStatus) {
        this.knativeDevEventingPkgApisFlowsV1ParallelBranchStatus = knativeDevEventingPkgApisFlowsV1ParallelBranchStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelChannelStatus")
    public ParallelChannelStatus getKnativeDevEventingPkgApisFlowsV1ParallelChannelStatus() {
        return knativeDevEventingPkgApisFlowsV1ParallelChannelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelChannelStatus")
    public void setKnativeDevEventingPkgApisFlowsV1ParallelChannelStatus(ParallelChannelStatus knativeDevEventingPkgApisFlowsV1ParallelChannelStatus) {
        this.knativeDevEventingPkgApisFlowsV1ParallelChannelStatus = knativeDevEventingPkgApisFlowsV1ParallelChannelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelList")
    public ParallelList getKnativeDevEventingPkgApisFlowsV1ParallelList() {
        return knativeDevEventingPkgApisFlowsV1ParallelList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelList")
    public void setKnativeDevEventingPkgApisFlowsV1ParallelList(ParallelList knativeDevEventingPkgApisFlowsV1ParallelList) {
        this.knativeDevEventingPkgApisFlowsV1ParallelList = knativeDevEventingPkgApisFlowsV1ParallelList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelSpec")
    public ParallelSpec getKnativeDevEventingPkgApisFlowsV1ParallelSpec() {
        return knativeDevEventingPkgApisFlowsV1ParallelSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelSpec")
    public void setKnativeDevEventingPkgApisFlowsV1ParallelSpec(ParallelSpec knativeDevEventingPkgApisFlowsV1ParallelSpec) {
        this.knativeDevEventingPkgApisFlowsV1ParallelSpec = knativeDevEventingPkgApisFlowsV1ParallelSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelStatus")
    public ParallelStatus getKnativeDevEventingPkgApisFlowsV1ParallelStatus() {
        return knativeDevEventingPkgApisFlowsV1ParallelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelStatus")
    public void setKnativeDevEventingPkgApisFlowsV1ParallelStatus(ParallelStatus knativeDevEventingPkgApisFlowsV1ParallelStatus) {
        this.knativeDevEventingPkgApisFlowsV1ParallelStatus = knativeDevEventingPkgApisFlowsV1ParallelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelSubscriptionStatus")
    public ParallelSubscriptionStatus getKnativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus() {
        return knativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_ParallelSubscriptionStatus")
    public void setKnativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus(ParallelSubscriptionStatus knativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus) {
        this.knativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus = knativeDevEventingPkgApisFlowsV1ParallelSubscriptionStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_Sequence")
    public Sequence getKnativeDevEventingPkgApisFlowsV1Sequence() {
        return knativeDevEventingPkgApisFlowsV1Sequence;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_Sequence")
    public void setKnativeDevEventingPkgApisFlowsV1Sequence(Sequence knativeDevEventingPkgApisFlowsV1Sequence) {
        this.knativeDevEventingPkgApisFlowsV1Sequence = knativeDevEventingPkgApisFlowsV1Sequence;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceChannelStatus")
    public SequenceChannelStatus getKnativeDevEventingPkgApisFlowsV1SequenceChannelStatus() {
        return knativeDevEventingPkgApisFlowsV1SequenceChannelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceChannelStatus")
    public void setKnativeDevEventingPkgApisFlowsV1SequenceChannelStatus(SequenceChannelStatus knativeDevEventingPkgApisFlowsV1SequenceChannelStatus) {
        this.knativeDevEventingPkgApisFlowsV1SequenceChannelStatus = knativeDevEventingPkgApisFlowsV1SequenceChannelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceList")
    public SequenceList getKnativeDevEventingPkgApisFlowsV1SequenceList() {
        return knativeDevEventingPkgApisFlowsV1SequenceList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceList")
    public void setKnativeDevEventingPkgApisFlowsV1SequenceList(SequenceList knativeDevEventingPkgApisFlowsV1SequenceList) {
        this.knativeDevEventingPkgApisFlowsV1SequenceList = knativeDevEventingPkgApisFlowsV1SequenceList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceSpec")
    public SequenceSpec getKnativeDevEventingPkgApisFlowsV1SequenceSpec() {
        return knativeDevEventingPkgApisFlowsV1SequenceSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceSpec")
    public void setKnativeDevEventingPkgApisFlowsV1SequenceSpec(SequenceSpec knativeDevEventingPkgApisFlowsV1SequenceSpec) {
        this.knativeDevEventingPkgApisFlowsV1SequenceSpec = knativeDevEventingPkgApisFlowsV1SequenceSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceStatus")
    public SequenceStatus getKnativeDevEventingPkgApisFlowsV1SequenceStatus() {
        return knativeDevEventingPkgApisFlowsV1SequenceStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceStatus")
    public void setKnativeDevEventingPkgApisFlowsV1SequenceStatus(SequenceStatus knativeDevEventingPkgApisFlowsV1SequenceStatus) {
        this.knativeDevEventingPkgApisFlowsV1SequenceStatus = knativeDevEventingPkgApisFlowsV1SequenceStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceStep")
    public SequenceStep getKnativeDevEventingPkgApisFlowsV1SequenceStep() {
        return knativeDevEventingPkgApisFlowsV1SequenceStep;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceStep")
    public void setKnativeDevEventingPkgApisFlowsV1SequenceStep(SequenceStep knativeDevEventingPkgApisFlowsV1SequenceStep) {
        this.knativeDevEventingPkgApisFlowsV1SequenceStep = knativeDevEventingPkgApisFlowsV1SequenceStep;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceSubscriptionStatus")
    public SequenceSubscriptionStatus getKnativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus() {
        return knativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_flows_v1_SequenceSubscriptionStatus")
    public void setKnativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus(SequenceSubscriptionStatus knativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus) {
        this.knativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus = knativeDevEventingPkgApisFlowsV1SequenceSubscriptionStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_Channel")
    public Channel getKnativeDevEventingPkgApisMessagingV1Channel() {
        return knativeDevEventingPkgApisMessagingV1Channel;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_Channel")
    public void setKnativeDevEventingPkgApisMessagingV1Channel(Channel knativeDevEventingPkgApisMessagingV1Channel) {
        this.knativeDevEventingPkgApisMessagingV1Channel = knativeDevEventingPkgApisMessagingV1Channel;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelList")
    public ChannelList getKnativeDevEventingPkgApisMessagingV1ChannelList() {
        return knativeDevEventingPkgApisMessagingV1ChannelList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelList")
    public void setKnativeDevEventingPkgApisMessagingV1ChannelList(ChannelList knativeDevEventingPkgApisMessagingV1ChannelList) {
        this.knativeDevEventingPkgApisMessagingV1ChannelList = knativeDevEventingPkgApisMessagingV1ChannelList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelSpec")
    public ChannelSpec getKnativeDevEventingPkgApisMessagingV1ChannelSpec() {
        return knativeDevEventingPkgApisMessagingV1ChannelSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelSpec")
    public void setKnativeDevEventingPkgApisMessagingV1ChannelSpec(ChannelSpec knativeDevEventingPkgApisMessagingV1ChannelSpec) {
        this.knativeDevEventingPkgApisMessagingV1ChannelSpec = knativeDevEventingPkgApisMessagingV1ChannelSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelStatus")
    public ChannelStatus getKnativeDevEventingPkgApisMessagingV1ChannelStatus() {
        return knativeDevEventingPkgApisMessagingV1ChannelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelStatus")
    public void setKnativeDevEventingPkgApisMessagingV1ChannelStatus(ChannelStatus knativeDevEventingPkgApisMessagingV1ChannelStatus) {
        this.knativeDevEventingPkgApisMessagingV1ChannelStatus = knativeDevEventingPkgApisMessagingV1ChannelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelTemplateSpec")
    public ChannelTemplateSpec getKnativeDevEventingPkgApisMessagingV1ChannelTemplateSpec() {
        return knativeDevEventingPkgApisMessagingV1ChannelTemplateSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_ChannelTemplateSpec")
    public void setKnativeDevEventingPkgApisMessagingV1ChannelTemplateSpec(ChannelTemplateSpec knativeDevEventingPkgApisMessagingV1ChannelTemplateSpec) {
        this.knativeDevEventingPkgApisMessagingV1ChannelTemplateSpec = knativeDevEventingPkgApisMessagingV1ChannelTemplateSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannel")
    public InMemoryChannel getKnativeDevEventingPkgApisMessagingV1InMemoryChannel() {
        return knativeDevEventingPkgApisMessagingV1InMemoryChannel;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannel")
    public void setKnativeDevEventingPkgApisMessagingV1InMemoryChannel(InMemoryChannel knativeDevEventingPkgApisMessagingV1InMemoryChannel) {
        this.knativeDevEventingPkgApisMessagingV1InMemoryChannel = knativeDevEventingPkgApisMessagingV1InMemoryChannel;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelList")
    public InMemoryChannelList getKnativeDevEventingPkgApisMessagingV1InMemoryChannelList() {
        return knativeDevEventingPkgApisMessagingV1InMemoryChannelList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelList")
    public void setKnativeDevEventingPkgApisMessagingV1InMemoryChannelList(InMemoryChannelList knativeDevEventingPkgApisMessagingV1InMemoryChannelList) {
        this.knativeDevEventingPkgApisMessagingV1InMemoryChannelList = knativeDevEventingPkgApisMessagingV1InMemoryChannelList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelSpec")
    public InMemoryChannelSpec getKnativeDevEventingPkgApisMessagingV1InMemoryChannelSpec() {
        return knativeDevEventingPkgApisMessagingV1InMemoryChannelSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelSpec")
    public void setKnativeDevEventingPkgApisMessagingV1InMemoryChannelSpec(InMemoryChannelSpec knativeDevEventingPkgApisMessagingV1InMemoryChannelSpec) {
        this.knativeDevEventingPkgApisMessagingV1InMemoryChannelSpec = knativeDevEventingPkgApisMessagingV1InMemoryChannelSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelStatus")
    public InMemoryChannelStatus getKnativeDevEventingPkgApisMessagingV1InMemoryChannelStatus() {
        return knativeDevEventingPkgApisMessagingV1InMemoryChannelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_InMemoryChannelStatus")
    public void setKnativeDevEventingPkgApisMessagingV1InMemoryChannelStatus(InMemoryChannelStatus knativeDevEventingPkgApisMessagingV1InMemoryChannelStatus) {
        this.knativeDevEventingPkgApisMessagingV1InMemoryChannelStatus = knativeDevEventingPkgApisMessagingV1InMemoryChannelStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_Subscription")
    public Subscription getKnativeDevEventingPkgApisMessagingV1Subscription() {
        return knativeDevEventingPkgApisMessagingV1Subscription;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_Subscription")
    public void setKnativeDevEventingPkgApisMessagingV1Subscription(Subscription knativeDevEventingPkgApisMessagingV1Subscription) {
        this.knativeDevEventingPkgApisMessagingV1Subscription = knativeDevEventingPkgApisMessagingV1Subscription;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionList")
    public SubscriptionList getKnativeDevEventingPkgApisMessagingV1SubscriptionList() {
        return knativeDevEventingPkgApisMessagingV1SubscriptionList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionList")
    public void setKnativeDevEventingPkgApisMessagingV1SubscriptionList(SubscriptionList knativeDevEventingPkgApisMessagingV1SubscriptionList) {
        this.knativeDevEventingPkgApisMessagingV1SubscriptionList = knativeDevEventingPkgApisMessagingV1SubscriptionList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionSpec")
    public SubscriptionSpec getKnativeDevEventingPkgApisMessagingV1SubscriptionSpec() {
        return knativeDevEventingPkgApisMessagingV1SubscriptionSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionSpec")
    public void setKnativeDevEventingPkgApisMessagingV1SubscriptionSpec(SubscriptionSpec knativeDevEventingPkgApisMessagingV1SubscriptionSpec) {
        this.knativeDevEventingPkgApisMessagingV1SubscriptionSpec = knativeDevEventingPkgApisMessagingV1SubscriptionSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionStatus")
    public SubscriptionStatus getKnativeDevEventingPkgApisMessagingV1SubscriptionStatus() {
        return knativeDevEventingPkgApisMessagingV1SubscriptionStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionStatus")
    public void setKnativeDevEventingPkgApisMessagingV1SubscriptionStatus(SubscriptionStatus knativeDevEventingPkgApisMessagingV1SubscriptionStatus) {
        this.knativeDevEventingPkgApisMessagingV1SubscriptionStatus = knativeDevEventingPkgApisMessagingV1SubscriptionStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionStatusPhysicalSubscription")
    public SubscriptionStatusPhysicalSubscription getKnativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription() {
        return knativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_messaging_v1_SubscriptionStatusPhysicalSubscription")
    public void setKnativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription(SubscriptionStatusPhysicalSubscription knativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription) {
        this.knativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription = knativeDevEventingPkgApisMessagingV1SubscriptionStatusPhysicalSubscription;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_APIVersionKind")
    public APIVersionKind getKnativeDevEventingPkgApisSourcesV1APIVersionKind() {
        return knativeDevEventingPkgApisSourcesV1APIVersionKind;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_APIVersionKind")
    public void setKnativeDevEventingPkgApisSourcesV1APIVersionKind(APIVersionKind knativeDevEventingPkgApisSourcesV1APIVersionKind) {
        this.knativeDevEventingPkgApisSourcesV1APIVersionKind = knativeDevEventingPkgApisSourcesV1APIVersionKind;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_APIVersionKindSelector")
    public APIVersionKindSelector getKnativeDevEventingPkgApisSourcesV1APIVersionKindSelector() {
        return knativeDevEventingPkgApisSourcesV1APIVersionKindSelector;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_APIVersionKindSelector")
    public void setKnativeDevEventingPkgApisSourcesV1APIVersionKindSelector(APIVersionKindSelector knativeDevEventingPkgApisSourcesV1APIVersionKindSelector) {
        this.knativeDevEventingPkgApisSourcesV1APIVersionKindSelector = knativeDevEventingPkgApisSourcesV1APIVersionKindSelector;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSource")
    public ApiServerSource getKnativeDevEventingPkgApisSourcesV1ApiServerSource() {
        return knativeDevEventingPkgApisSourcesV1ApiServerSource;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSource")
    public void setKnativeDevEventingPkgApisSourcesV1ApiServerSource(ApiServerSource knativeDevEventingPkgApisSourcesV1ApiServerSource) {
        this.knativeDevEventingPkgApisSourcesV1ApiServerSource = knativeDevEventingPkgApisSourcesV1ApiServerSource;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceList")
    public ApiServerSourceList getKnativeDevEventingPkgApisSourcesV1ApiServerSourceList() {
        return knativeDevEventingPkgApisSourcesV1ApiServerSourceList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceList")
    public void setKnativeDevEventingPkgApisSourcesV1ApiServerSourceList(ApiServerSourceList knativeDevEventingPkgApisSourcesV1ApiServerSourceList) {
        this.knativeDevEventingPkgApisSourcesV1ApiServerSourceList = knativeDevEventingPkgApisSourcesV1ApiServerSourceList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceSpec")
    public ApiServerSourceSpec getKnativeDevEventingPkgApisSourcesV1ApiServerSourceSpec() {
        return knativeDevEventingPkgApisSourcesV1ApiServerSourceSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceSpec")
    public void setKnativeDevEventingPkgApisSourcesV1ApiServerSourceSpec(ApiServerSourceSpec knativeDevEventingPkgApisSourcesV1ApiServerSourceSpec) {
        this.knativeDevEventingPkgApisSourcesV1ApiServerSourceSpec = knativeDevEventingPkgApisSourcesV1ApiServerSourceSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceStatus")
    public ApiServerSourceStatus getKnativeDevEventingPkgApisSourcesV1ApiServerSourceStatus() {
        return knativeDevEventingPkgApisSourcesV1ApiServerSourceStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ApiServerSourceStatus")
    public void setKnativeDevEventingPkgApisSourcesV1ApiServerSourceStatus(ApiServerSourceStatus knativeDevEventingPkgApisSourcesV1ApiServerSourceStatus) {
        this.knativeDevEventingPkgApisSourcesV1ApiServerSourceStatus = knativeDevEventingPkgApisSourcesV1ApiServerSourceStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSource")
    public ContainerSource getKnativeDevEventingPkgApisSourcesV1ContainerSource() {
        return knativeDevEventingPkgApisSourcesV1ContainerSource;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSource")
    public void setKnativeDevEventingPkgApisSourcesV1ContainerSource(ContainerSource knativeDevEventingPkgApisSourcesV1ContainerSource) {
        this.knativeDevEventingPkgApisSourcesV1ContainerSource = knativeDevEventingPkgApisSourcesV1ContainerSource;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceList")
    public ContainerSourceList getKnativeDevEventingPkgApisSourcesV1ContainerSourceList() {
        return knativeDevEventingPkgApisSourcesV1ContainerSourceList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceList")
    public void setKnativeDevEventingPkgApisSourcesV1ContainerSourceList(ContainerSourceList knativeDevEventingPkgApisSourcesV1ContainerSourceList) {
        this.knativeDevEventingPkgApisSourcesV1ContainerSourceList = knativeDevEventingPkgApisSourcesV1ContainerSourceList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceSpec")
    public ContainerSourceSpec getKnativeDevEventingPkgApisSourcesV1ContainerSourceSpec() {
        return knativeDevEventingPkgApisSourcesV1ContainerSourceSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceSpec")
    public void setKnativeDevEventingPkgApisSourcesV1ContainerSourceSpec(ContainerSourceSpec knativeDevEventingPkgApisSourcesV1ContainerSourceSpec) {
        this.knativeDevEventingPkgApisSourcesV1ContainerSourceSpec = knativeDevEventingPkgApisSourcesV1ContainerSourceSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceStatus")
    public ContainerSourceStatus getKnativeDevEventingPkgApisSourcesV1ContainerSourceStatus() {
        return knativeDevEventingPkgApisSourcesV1ContainerSourceStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_ContainerSourceStatus")
    public void setKnativeDevEventingPkgApisSourcesV1ContainerSourceStatus(ContainerSourceStatus knativeDevEventingPkgApisSourcesV1ContainerSourceStatus) {
        this.knativeDevEventingPkgApisSourcesV1ContainerSourceStatus = knativeDevEventingPkgApisSourcesV1ContainerSourceStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSource")
    public PingSource getKnativeDevEventingPkgApisSourcesV1PingSource() {
        return knativeDevEventingPkgApisSourcesV1PingSource;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSource")
    public void setKnativeDevEventingPkgApisSourcesV1PingSource(PingSource knativeDevEventingPkgApisSourcesV1PingSource) {
        this.knativeDevEventingPkgApisSourcesV1PingSource = knativeDevEventingPkgApisSourcesV1PingSource;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSourceList")
    public PingSourceList getKnativeDevEventingPkgApisSourcesV1PingSourceList() {
        return knativeDevEventingPkgApisSourcesV1PingSourceList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSourceList")
    public void setKnativeDevEventingPkgApisSourcesV1PingSourceList(PingSourceList knativeDevEventingPkgApisSourcesV1PingSourceList) {
        this.knativeDevEventingPkgApisSourcesV1PingSourceList = knativeDevEventingPkgApisSourcesV1PingSourceList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSourceSpec")
    public PingSourceSpec getKnativeDevEventingPkgApisSourcesV1PingSourceSpec() {
        return knativeDevEventingPkgApisSourcesV1PingSourceSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSourceSpec")
    public void setKnativeDevEventingPkgApisSourcesV1PingSourceSpec(PingSourceSpec knativeDevEventingPkgApisSourcesV1PingSourceSpec) {
        this.knativeDevEventingPkgApisSourcesV1PingSourceSpec = knativeDevEventingPkgApisSourcesV1PingSourceSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSourceStatus")
    public PingSourceStatus getKnativeDevEventingPkgApisSourcesV1PingSourceStatus() {
        return knativeDevEventingPkgApisSourcesV1PingSourceStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_PingSourceStatus")
    public void setKnativeDevEventingPkgApisSourcesV1PingSourceStatus(PingSourceStatus knativeDevEventingPkgApisSourcesV1PingSourceStatus) {
        this.knativeDevEventingPkgApisSourcesV1PingSourceStatus = knativeDevEventingPkgApisSourcesV1PingSourceStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBinding")
    public SinkBinding getKnativeDevEventingPkgApisSourcesV1SinkBinding() {
        return knativeDevEventingPkgApisSourcesV1SinkBinding;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBinding")
    public void setKnativeDevEventingPkgApisSourcesV1SinkBinding(SinkBinding knativeDevEventingPkgApisSourcesV1SinkBinding) {
        this.knativeDevEventingPkgApisSourcesV1SinkBinding = knativeDevEventingPkgApisSourcesV1SinkBinding;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBindingList")
    public SinkBindingList getKnativeDevEventingPkgApisSourcesV1SinkBindingList() {
        return knativeDevEventingPkgApisSourcesV1SinkBindingList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBindingList")
    public void setKnativeDevEventingPkgApisSourcesV1SinkBindingList(SinkBindingList knativeDevEventingPkgApisSourcesV1SinkBindingList) {
        this.knativeDevEventingPkgApisSourcesV1SinkBindingList = knativeDevEventingPkgApisSourcesV1SinkBindingList;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBindingSpec")
    public SinkBindingSpec getKnativeDevEventingPkgApisSourcesV1SinkBindingSpec() {
        return knativeDevEventingPkgApisSourcesV1SinkBindingSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBindingSpec")
    public void setKnativeDevEventingPkgApisSourcesV1SinkBindingSpec(SinkBindingSpec knativeDevEventingPkgApisSourcesV1SinkBindingSpec) {
        this.knativeDevEventingPkgApisSourcesV1SinkBindingSpec = knativeDevEventingPkgApisSourcesV1SinkBindingSpec;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBindingStatus")
    public SinkBindingStatus getKnativeDevEventingPkgApisSourcesV1SinkBindingStatus() {
        return knativeDevEventingPkgApisSourcesV1SinkBindingStatus;
    }

    @JsonProperty("knative_dev_eventing_pkg_apis_sources_v1_SinkBindingStatus")
    public void setKnativeDevEventingPkgApisSourcesV1SinkBindingStatus(SinkBindingStatus knativeDevEventingPkgApisSourcesV1SinkBindingStatus) {
        this.knativeDevEventingPkgApisSourcesV1SinkBindingStatus = knativeDevEventingPkgApisSourcesV1SinkBindingStatus;
    }

    @JsonProperty("knative_dev_pkg_apis_Condition")
    public Condition getKnativeDevPkgApisCondition() {
        return knativeDevPkgApisCondition;
    }

    @JsonProperty("knative_dev_pkg_apis_Condition")
    public void setKnativeDevPkgApisCondition(Condition knativeDevPkgApisCondition) {
        this.knativeDevPkgApisCondition = knativeDevPkgApisCondition;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_Addressable")
    public Addressable getKnativeDevPkgApisDuckV1Addressable() {
        return knativeDevPkgApisDuckV1Addressable;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_Addressable")
    public void setKnativeDevPkgApisDuckV1Addressable(Addressable knativeDevPkgApisDuckV1Addressable) {
        this.knativeDevPkgApisDuckV1Addressable = knativeDevPkgApisDuckV1Addressable;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_CloudEventAttributes")
    public CloudEventAttributes getKnativeDevPkgApisDuckV1CloudEventAttributes() {
        return knativeDevPkgApisDuckV1CloudEventAttributes;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_CloudEventAttributes")
    public void setKnativeDevPkgApisDuckV1CloudEventAttributes(CloudEventAttributes knativeDevPkgApisDuckV1CloudEventAttributes) {
        this.knativeDevPkgApisDuckV1CloudEventAttributes = knativeDevPkgApisDuckV1CloudEventAttributes;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_CloudEventOverrides")
    public CloudEventOverrides getKnativeDevPkgApisDuckV1CloudEventOverrides() {
        return knativeDevPkgApisDuckV1CloudEventOverrides;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_CloudEventOverrides")
    public void setKnativeDevPkgApisDuckV1CloudEventOverrides(CloudEventOverrides knativeDevPkgApisDuckV1CloudEventOverrides) {
        this.knativeDevPkgApisDuckV1CloudEventOverrides = knativeDevPkgApisDuckV1CloudEventOverrides;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_Destination")
    public Destination getKnativeDevPkgApisDuckV1Destination() {
        return knativeDevPkgApisDuckV1Destination;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_Destination")
    public void setKnativeDevPkgApisDuckV1Destination(Destination knativeDevPkgApisDuckV1Destination) {
        this.knativeDevPkgApisDuckV1Destination = knativeDevPkgApisDuckV1Destination;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_KReference")
    public KReference getKnativeDevPkgApisDuckV1KReference() {
        return knativeDevPkgApisDuckV1KReference;
    }

    @JsonProperty("knative_dev_pkg_apis_duck_v1_KReference")
    public void setKnativeDevPkgApisDuckV1KReference(KReference knativeDevPkgApisDuckV1KReference) {
        this.knativeDevPkgApisDuckV1KReference = knativeDevPkgApisDuckV1KReference;
    }

    @JsonProperty("knative_dev_pkg_tracker_Reference")
    public Reference getKnativeDevPkgTrackerReference() {
        return knativeDevPkgTrackerReference;
    }

    @JsonProperty("knative_dev_pkg_tracker_Reference")
    public void setKnativeDevPkgTrackerReference(Reference knativeDevPkgTrackerReference) {
        this.knativeDevPkgTrackerReference = knativeDevPkgTrackerReference;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Configuration")
    public Configuration getKnativeDevServingPkgApisServingV1Configuration() {
        return knativeDevServingPkgApisServingV1Configuration;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Configuration")
    public void setKnativeDevServingPkgApisServingV1Configuration(Configuration knativeDevServingPkgApisServingV1Configuration) {
        this.knativeDevServingPkgApisServingV1Configuration = knativeDevServingPkgApisServingV1Configuration;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ConfigurationList")
    public ConfigurationList getKnativeDevServingPkgApisServingV1ConfigurationList() {
        return knativeDevServingPkgApisServingV1ConfigurationList;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ConfigurationList")
    public void setKnativeDevServingPkgApisServingV1ConfigurationList(ConfigurationList knativeDevServingPkgApisServingV1ConfigurationList) {
        this.knativeDevServingPkgApisServingV1ConfigurationList = knativeDevServingPkgApisServingV1ConfigurationList;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ConfigurationSpec")
    public ConfigurationSpec getKnativeDevServingPkgApisServingV1ConfigurationSpec() {
        return knativeDevServingPkgApisServingV1ConfigurationSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ConfigurationSpec")
    public void setKnativeDevServingPkgApisServingV1ConfigurationSpec(ConfigurationSpec knativeDevServingPkgApisServingV1ConfigurationSpec) {
        this.knativeDevServingPkgApisServingV1ConfigurationSpec = knativeDevServingPkgApisServingV1ConfigurationSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ConfigurationStatus")
    public ConfigurationStatus getKnativeDevServingPkgApisServingV1ConfigurationStatus() {
        return knativeDevServingPkgApisServingV1ConfigurationStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ConfigurationStatus")
    public void setKnativeDevServingPkgApisServingV1ConfigurationStatus(ConfigurationStatus knativeDevServingPkgApisServingV1ConfigurationStatus) {
        this.knativeDevServingPkgApisServingV1ConfigurationStatus = knativeDevServingPkgApisServingV1ConfigurationStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ContainerStatus")
    public ContainerStatus getKnativeDevServingPkgApisServingV1ContainerStatus() {
        return knativeDevServingPkgApisServingV1ContainerStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ContainerStatus")
    public void setKnativeDevServingPkgApisServingV1ContainerStatus(ContainerStatus knativeDevServingPkgApisServingV1ContainerStatus) {
        this.knativeDevServingPkgApisServingV1ContainerStatus = knativeDevServingPkgApisServingV1ContainerStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Revision")
    public Revision getKnativeDevServingPkgApisServingV1Revision() {
        return knativeDevServingPkgApisServingV1Revision;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Revision")
    public void setKnativeDevServingPkgApisServingV1Revision(Revision knativeDevServingPkgApisServingV1Revision) {
        this.knativeDevServingPkgApisServingV1Revision = knativeDevServingPkgApisServingV1Revision;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionList")
    public RevisionList getKnativeDevServingPkgApisServingV1RevisionList() {
        return knativeDevServingPkgApisServingV1RevisionList;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionList")
    public void setKnativeDevServingPkgApisServingV1RevisionList(RevisionList knativeDevServingPkgApisServingV1RevisionList) {
        this.knativeDevServingPkgApisServingV1RevisionList = knativeDevServingPkgApisServingV1RevisionList;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionSpec")
    public RevisionSpec getKnativeDevServingPkgApisServingV1RevisionSpec() {
        return knativeDevServingPkgApisServingV1RevisionSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionSpec")
    public void setKnativeDevServingPkgApisServingV1RevisionSpec(RevisionSpec knativeDevServingPkgApisServingV1RevisionSpec) {
        this.knativeDevServingPkgApisServingV1RevisionSpec = knativeDevServingPkgApisServingV1RevisionSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionStatus")
    public RevisionStatus getKnativeDevServingPkgApisServingV1RevisionStatus() {
        return knativeDevServingPkgApisServingV1RevisionStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionStatus")
    public void setKnativeDevServingPkgApisServingV1RevisionStatus(RevisionStatus knativeDevServingPkgApisServingV1RevisionStatus) {
        this.knativeDevServingPkgApisServingV1RevisionStatus = knativeDevServingPkgApisServingV1RevisionStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionTemplateSpec")
    public RevisionTemplateSpec getKnativeDevServingPkgApisServingV1RevisionTemplateSpec() {
        return knativeDevServingPkgApisServingV1RevisionTemplateSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RevisionTemplateSpec")
    public void setKnativeDevServingPkgApisServingV1RevisionTemplateSpec(RevisionTemplateSpec knativeDevServingPkgApisServingV1RevisionTemplateSpec) {
        this.knativeDevServingPkgApisServingV1RevisionTemplateSpec = knativeDevServingPkgApisServingV1RevisionTemplateSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Route")
    public Route getKnativeDevServingPkgApisServingV1Route() {
        return knativeDevServingPkgApisServingV1Route;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Route")
    public void setKnativeDevServingPkgApisServingV1Route(Route knativeDevServingPkgApisServingV1Route) {
        this.knativeDevServingPkgApisServingV1Route = knativeDevServingPkgApisServingV1Route;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RouteList")
    public RouteList getKnativeDevServingPkgApisServingV1RouteList() {
        return knativeDevServingPkgApisServingV1RouteList;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RouteList")
    public void setKnativeDevServingPkgApisServingV1RouteList(RouteList knativeDevServingPkgApisServingV1RouteList) {
        this.knativeDevServingPkgApisServingV1RouteList = knativeDevServingPkgApisServingV1RouteList;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RouteSpec")
    public RouteSpec getKnativeDevServingPkgApisServingV1RouteSpec() {
        return knativeDevServingPkgApisServingV1RouteSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RouteSpec")
    public void setKnativeDevServingPkgApisServingV1RouteSpec(RouteSpec knativeDevServingPkgApisServingV1RouteSpec) {
        this.knativeDevServingPkgApisServingV1RouteSpec = knativeDevServingPkgApisServingV1RouteSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RouteStatus")
    public RouteStatus getKnativeDevServingPkgApisServingV1RouteStatus() {
        return knativeDevServingPkgApisServingV1RouteStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_RouteStatus")
    public void setKnativeDevServingPkgApisServingV1RouteStatus(RouteStatus knativeDevServingPkgApisServingV1RouteStatus) {
        this.knativeDevServingPkgApisServingV1RouteStatus = knativeDevServingPkgApisServingV1RouteStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Service")
    public Service getKnativeDevServingPkgApisServingV1Service() {
        return knativeDevServingPkgApisServingV1Service;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_Service")
    public void setKnativeDevServingPkgApisServingV1Service(Service knativeDevServingPkgApisServingV1Service) {
        this.knativeDevServingPkgApisServingV1Service = knativeDevServingPkgApisServingV1Service;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ServiceList")
    public ServiceList getKnativeDevServingPkgApisServingV1ServiceList() {
        return knativeDevServingPkgApisServingV1ServiceList;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ServiceList")
    public void setKnativeDevServingPkgApisServingV1ServiceList(ServiceList knativeDevServingPkgApisServingV1ServiceList) {
        this.knativeDevServingPkgApisServingV1ServiceList = knativeDevServingPkgApisServingV1ServiceList;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ServiceSpec")
    public ServiceSpec getKnativeDevServingPkgApisServingV1ServiceSpec() {
        return knativeDevServingPkgApisServingV1ServiceSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ServiceSpec")
    public void setKnativeDevServingPkgApisServingV1ServiceSpec(ServiceSpec knativeDevServingPkgApisServingV1ServiceSpec) {
        this.knativeDevServingPkgApisServingV1ServiceSpec = knativeDevServingPkgApisServingV1ServiceSpec;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ServiceStatus")
    public ServiceStatus getKnativeDevServingPkgApisServingV1ServiceStatus() {
        return knativeDevServingPkgApisServingV1ServiceStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_ServiceStatus")
    public void setKnativeDevServingPkgApisServingV1ServiceStatus(ServiceStatus knativeDevServingPkgApisServingV1ServiceStatus) {
        this.knativeDevServingPkgApisServingV1ServiceStatus = knativeDevServingPkgApisServingV1ServiceStatus;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_TrafficTarget")
    public TrafficTarget getKnativeDevServingPkgApisServingV1TrafficTarget() {
        return knativeDevServingPkgApisServingV1TrafficTarget;
    }

    @JsonProperty("knative_dev_serving_pkg_apis_serving_v1_TrafficTarget")
    public void setKnativeDevServingPkgApisServingV1TrafficTarget(TrafficTarget knativeDevServingPkgApisServingV1TrafficTarget) {
        this.knativeDevServingPkgApisServingV1TrafficTarget = knativeDevServingPkgApisServingV1TrafficTarget;
    }

}
