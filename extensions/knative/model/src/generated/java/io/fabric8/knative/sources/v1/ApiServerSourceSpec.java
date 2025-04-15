
package io.fabric8.knative.sources.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ApiServerSourceSpec defines the desired state of ApiServerSource
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ceOverrides",
    "filters",
    "mode",
    "namespaceSelector",
    "owner",
    "resources",
    "serviceAccountName",
    "sink"
})
@ToString
@EqualsAndHashCode
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ApiServerSourceSpec implements Editable<ApiServerSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("ceOverrides")
    private CloudEventOverrides ceOverrides;
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionsAPIFilter> filters = new ArrayList<>();
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("owner")
    private APIVersionKind owner;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<APIVersionKindSelector> resources = new ArrayList<>();
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sink")
    private Destination sink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ApiServerSourceSpec() {
    }

    public ApiServerSourceSpec(CloudEventOverrides ceOverrides, List<SubscriptionsAPIFilter> filters, String mode, LabelSelector namespaceSelector, APIVersionKind owner, List<APIVersionKindSelector> resources, String serviceAccountName, Destination sink) {
        super();
        this.ceOverrides = ceOverrides;
        this.filters = filters;
        this.mode = mode;
        this.namespaceSelector = namespaceSelector;
        this.owner = owner;
        this.resources = resources;
        this.serviceAccountName = serviceAccountName;
        this.sink = sink;
    }

    /**
     * ApiServerSourceSpec defines the desired state of ApiServerSource
     */
    @JsonProperty("ceOverrides")
    public CloudEventOverrides getCeOverrides() {
        return ceOverrides;
    }

    /**
     * ApiServerSourceSpec defines the desired state of ApiServerSource
     */
    @JsonProperty("ceOverrides")
    public void setCeOverrides(CloudEventOverrides ceOverrides) {
        this.ceOverrides = ceOverrides;
    }

    /**
     * Filters is an experimental field that conforms to the CNCF CloudEvents Subscriptions API. It's an array of filter expressions that evaluate to true or false. If any filter expression in the array evaluates to false, the event MUST NOT be sent to the Sink. If all the filter expressions in the array evaluate to true, the event MUST be attempted to be delivered. Absence of a filter or empty array implies a value of true.
     */
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionsAPIFilter> getFilters() {
        return filters;
    }

    /**
     * Filters is an experimental field that conforms to the CNCF CloudEvents Subscriptions API. It's an array of filter expressions that evaluate to true or false. If any filter expression in the array evaluates to false, the event MUST NOT be sent to the Sink. If all the filter expressions in the array evaluate to true, the event MUST be attempted to be delivered. Absence of a filter or empty array implies a value of true.
     */
    @JsonProperty("filters")
    public void setFilters(List<SubscriptionsAPIFilter> filters) {
        this.filters = filters;
    }

    /**
     * EventMode controls the format of the event. `Reference` sends a dataref event type for the resource under watch. `Resource` send the full resource lifecycle event. Defaults to `Reference`
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * EventMode controls the format of the event. `Reference` sends a dataref event type for the resource under watch. `Resource` send the full resource lifecycle event. Defaults to `Reference`
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * ApiServerSourceSpec defines the desired state of ApiServerSource
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * ApiServerSourceSpec defines the desired state of ApiServerSource
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * ApiServerSourceSpec defines the desired state of ApiServerSource
     */
    @JsonProperty("owner")
    public APIVersionKind getOwner() {
        return owner;
    }

    /**
     * ApiServerSourceSpec defines the desired state of ApiServerSource
     */
    @JsonProperty("owner")
    public void setOwner(APIVersionKind owner) {
        this.owner = owner;
    }

    /**
     * Resource are the resources this source will track and send related lifecycle events from the Kubernetes ApiServer, with an optional label selector to help filter.
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<APIVersionKindSelector> getResources() {
        return resources;
    }

    /**
     * Resource are the resources this source will track and send related lifecycle events from the Kubernetes ApiServer, with an optional label selector to help filter.
     */
    @JsonProperty("resources")
    public void setResources(List<APIVersionKindSelector> resources) {
        this.resources = resources;
    }

    /**
     * ServiceAccountName is the name of the ServiceAccount to use to run this source. Defaults to default if not set.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName is the name of the ServiceAccount to use to run this source. Defaults to default if not set.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * ApiServerSourceSpec defines the desired state of ApiServerSource
     */
    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    /**
     * ApiServerSourceSpec defines the desired state of ApiServerSource
     */
    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    @JsonIgnore
    public ApiServerSourceSpecBuilder edit() {
        return new ApiServerSourceSpecBuilder(this);
    }

    @JsonIgnore
    public ApiServerSourceSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
