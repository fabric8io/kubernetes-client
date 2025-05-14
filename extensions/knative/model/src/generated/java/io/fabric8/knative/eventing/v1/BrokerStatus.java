
package io.fabric8.knative.eventing.v1;

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
import io.fabric8.knative.duck.v1.Addressable;
import io.fabric8.knative.duck.v1.AppliedEventPolicyRef;
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

/**
 * BrokerStatus represents the current state of a Broker.
 */
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
    "policies"
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
public class BrokerStatus implements Editable<BrokerStatusBuilder>, KubernetesResource
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BrokerStatus() {
    }

    public BrokerStatus(Addressable address, List<Addressable> addresses, Map<String, String> annotations, List<Condition> conditions, String deadLetterSinkAudience, String deadLetterSinkCACerts, String deadLetterSinkUri, Long observedGeneration, List<AppliedEventPolicyRef> policies) {
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
    }

    /**
     * BrokerStatus represents the current state of a Broker.
     */
    @JsonProperty("address")
    public Addressable getAddress() {
        return address;
    }

    /**
     * BrokerStatus represents the current state of a Broker.
     */
    @JsonProperty("address")
    public void setAddress(Addressable address) {
        this.address = address;
    }

    /**
     * Addresses is a list of addresses for different protocols (HTTP and HTTPS) If Addresses is present, Address must be ignored by clients.
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Addressable> getAddresses() {
        return addresses;
    }

    /**
     * Addresses is a list of addresses for different protocols (HTTP and HTTPS) If Addresses is present, Address must be ignored by clients.
     */
    @JsonProperty("addresses")
    public void setAddresses(List<Addressable> addresses) {
        this.addresses = addresses;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * DeadLetterSinkAudience is the OIDC audience of the DeadLetterSink
     */
    @JsonProperty("deadLetterSinkAudience")
    public String getDeadLetterSinkAudience() {
        return deadLetterSinkAudience;
    }

    /**
     * DeadLetterSinkAudience is the OIDC audience of the DeadLetterSink
     */
    @JsonProperty("deadLetterSinkAudience")
    public void setDeadLetterSinkAudience(String deadLetterSinkAudience) {
        this.deadLetterSinkAudience = deadLetterSinkAudience;
    }

    /**
     * DeadLetterSinkCACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468.
     */
    @JsonProperty("deadLetterSinkCACerts")
    public String getDeadLetterSinkCACerts() {
        return deadLetterSinkCACerts;
    }

    /**
     * DeadLetterSinkCACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468.
     */
    @JsonProperty("deadLetterSinkCACerts")
    public void setDeadLetterSinkCACerts(String deadLetterSinkCACerts) {
        this.deadLetterSinkCACerts = deadLetterSinkCACerts;
    }

    /**
     * BrokerStatus represents the current state of a Broker.
     */
    @JsonProperty("deadLetterSinkUri")
    public String getDeadLetterSinkUri() {
        return deadLetterSinkUri;
    }

    /**
     * BrokerStatus represents the current state of a Broker.
     */
    @JsonProperty("deadLetterSinkUri")
    public void setDeadLetterSinkUri(String deadLetterSinkUri) {
        this.deadLetterSinkUri = deadLetterSinkUri;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * Policies holds the list of applied EventPolicies
     */
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AppliedEventPolicyRef> getPolicies() {
        return policies;
    }

    /**
     * Policies holds the list of applied EventPolicies
     */
    @JsonProperty("policies")
    public void setPolicies(List<AppliedEventPolicyRef> policies) {
        this.policies = policies;
    }

    @JsonIgnore
    public BrokerStatusBuilder edit() {
        return new BrokerStatusBuilder(this);
    }

    @JsonIgnore
    public BrokerStatusBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
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
