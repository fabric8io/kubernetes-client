
package io.fabric8.knative.duck.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.pkg.apis.Condition;
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
    "address",
    "addresses",
    "annotations",
    "conditions",
    "deadLetterSinkAudience",
    "deadLetterSinkCACerts",
    "deadLetterSinkUri",
    "observedGeneration",
    "policies",
    "subscribers"
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
public class ChannelableStatus implements Editable<ChannelableStatusBuilder> , KubernetesResource
{

    @JsonProperty("address")
    private Addressable address;
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Addressable> addresses = new ArrayList<>();
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("deadLetterSinkAudience")
    private String deadLetterSinkAudience;
    @JsonProperty("deadLetterSinkCACerts")
    private String deadLetterSinkCACerts;
    @JsonProperty("deadLetterSinkUri")
    private String deadLetterSinkUri;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AppliedEventPolicyRef> policies = new ArrayList<>();
    @JsonProperty("subscribers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriberStatus> subscribers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ChannelableStatus() {
    }

    public ChannelableStatus(Addressable address, List<Addressable> addresses, Map<String, String> annotations, List<Condition> conditions, String deadLetterSinkAudience, String deadLetterSinkCACerts, String deadLetterSinkUri, Long observedGeneration, List<AppliedEventPolicyRef> policies, List<SubscriberStatus> subscribers) {
        super();
        this.address = address;
        this.addresses = addresses;
        this.annotations = annotations;
        this.conditions = conditions;
        this.deadLetterSinkAudience = deadLetterSinkAudience;
        this.deadLetterSinkCACerts = deadLetterSinkCACerts;
        this.deadLetterSinkUri = deadLetterSinkUri;
        this.observedGeneration = observedGeneration;
        this.policies = policies;
        this.subscribers = subscribers;
    }

    @JsonProperty("address")
    public Addressable getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Addressable address) {
        this.address = address;
    }

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Addressable> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<Addressable> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("deadLetterSinkAudience")
    public String getDeadLetterSinkAudience() {
        return deadLetterSinkAudience;
    }

    @JsonProperty("deadLetterSinkAudience")
    public void setDeadLetterSinkAudience(String deadLetterSinkAudience) {
        this.deadLetterSinkAudience = deadLetterSinkAudience;
    }

    @JsonProperty("deadLetterSinkCACerts")
    public String getDeadLetterSinkCACerts() {
        return deadLetterSinkCACerts;
    }

    @JsonProperty("deadLetterSinkCACerts")
    public void setDeadLetterSinkCACerts(String deadLetterSinkCACerts) {
        this.deadLetterSinkCACerts = deadLetterSinkCACerts;
    }

    @JsonProperty("deadLetterSinkUri")
    public String getDeadLetterSinkUri() {
        return deadLetterSinkUri;
    }

    @JsonProperty("deadLetterSinkUri")
    public void setDeadLetterSinkUri(String deadLetterSinkUri) {
        this.deadLetterSinkUri = deadLetterSinkUri;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AppliedEventPolicyRef> getPolicies() {
        return policies;
    }

    @JsonProperty("policies")
    public void setPolicies(List<AppliedEventPolicyRef> policies) {
        this.policies = policies;
    }

    @JsonProperty("subscribers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriberStatus> getSubscribers() {
        return subscribers;
    }

    @JsonProperty("subscribers")
    public void setSubscribers(List<SubscriberStatus> subscribers) {
        this.subscribers = subscribers;
    }

    @JsonIgnore
    public ChannelableStatusBuilder edit() {
        return new ChannelableStatusBuilder(this);
    }

    @JsonIgnore
    public ChannelableStatusBuilder toBuilder() {
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
