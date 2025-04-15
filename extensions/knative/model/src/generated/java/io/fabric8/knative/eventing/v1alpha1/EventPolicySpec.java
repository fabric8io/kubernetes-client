
package io.fabric8.knative.eventing.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filters",
    "from",
    "to"
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
public class EventPolicySpec implements Editable<EventPolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriptionsAPIFilter> filters = new ArrayList<>();
    @JsonProperty("from")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EventPolicySpecFrom> from = new ArrayList<>();
    @JsonProperty("to")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EventPolicySpecTo> to = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EventPolicySpec() {
    }

    public EventPolicySpec(List<SubscriptionsAPIFilter> filters, List<EventPolicySpecFrom> from, List<EventPolicySpecTo> to) {
        super();
        this.filters = filters;
        this.from = from;
        this.to = to;
    }

    /**
     * Filters is the list of SubscriptoinsApi filters which determine whether or not the event is accepted. It is an array of filter expressions that evaluate to true or false. If any filter expression in the array evaluates to false, the event will not pass the target resource's ingress. Absence of any filters implies that the filters always evaluate to true.
     */
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriptionsAPIFilter> getFilters() {
        return filters;
    }

    /**
     * Filters is the list of SubscriptoinsApi filters which determine whether or not the event is accepted. It is an array of filter expressions that evaluate to true or false. If any filter expression in the array evaluates to false, the event will not pass the target resource's ingress. Absence of any filters implies that the filters always evaluate to true.
     */
    @JsonProperty("filters")
    public void setFilters(List<SubscriptionsAPIFilter> filters) {
        this.filters = filters;
    }

    /**
     * From is the list of sources or oidc identities, which are allowed to send events to the targets (.spec.to).
     */
    @JsonProperty("from")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EventPolicySpecFrom> getFrom() {
        return from;
    }

    /**
     * From is the list of sources or oidc identities, which are allowed to send events to the targets (.spec.to).
     */
    @JsonProperty("from")
    public void setFrom(List<EventPolicySpecFrom> from) {
        this.from = from;
    }

    /**
     * To lists all resources for which this policy applies. Resources in this list must act like an ingress and have an audience. The resources are part of the same namespace as the EventPolicy. An empty list means it applies to all resources in the EventPolicies namespace
     */
    @JsonProperty("to")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EventPolicySpecTo> getTo() {
        return to;
    }

    /**
     * To lists all resources for which this policy applies. Resources in this list must act like an ingress and have an audience. The resources are part of the same namespace as the EventPolicy. An empty list means it applies to all resources in the EventPolicies namespace
     */
    @JsonProperty("to")
    public void setTo(List<EventPolicySpecTo> to) {
        this.to = to;
    }

    @JsonIgnore
    public EventPolicySpecBuilder edit() {
        return new EventPolicySpecBuilder(this);
    }

    @JsonIgnore
    public EventPolicySpecBuilder toBuilder() {
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
