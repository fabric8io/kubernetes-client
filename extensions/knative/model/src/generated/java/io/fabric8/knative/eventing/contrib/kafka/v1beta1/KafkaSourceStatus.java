
package io.fabric8.knative.eventing.contrib.kafka.v1beta1;

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
import io.fabric8.knative.internal.eventing.pkg.apis.duck.v1alpha1.Placement;
import io.fabric8.knative.internal.pkg.apis.Condition;
import io.fabric8.knative.internal.pkg.apis.duck.v1.CloudEventAttributes;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "annotations",
    "ceAttributes",
    "claims",
    "conditions",
    "consumers",
    "maxAllowedVReplicas",
    "observedGeneration",
    "placements",
    "selector",
    "sinkUri"
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
@Generated("jsonschema2pojo")
public class KafkaSourceStatus implements KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("ceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CloudEventAttributes> ceAttributes = new ArrayList<CloudEventAttributes>();
    @JsonProperty("claims")
    private java.lang.String claims;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("consumers")
    private java.lang.Integer consumers;
    @JsonProperty("maxAllowedVReplicas")
    private Integer maxAllowedVReplicas;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("placements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Placement> placements = new ArrayList<Placement>();
    @JsonProperty("selector")
    private java.lang.String selector;
    @JsonProperty("sinkUri")
    private java.lang.String sinkUri;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KafkaSourceStatus() {
    }

    public KafkaSourceStatus(Map<String, String> annotations, List<CloudEventAttributes> ceAttributes, java.lang.String claims, List<Condition> conditions, java.lang.Integer consumers, Integer maxAllowedVReplicas, Long observedGeneration, List<Placement> placements, java.lang.String selector, java.lang.String sinkUri) {
        super();
        this.annotations = annotations;
        this.ceAttributes = ceAttributes;
        this.claims = claims;
        this.conditions = conditions;
        this.consumers = consumers;
        this.maxAllowedVReplicas = maxAllowedVReplicas;
        this.observedGeneration = observedGeneration;
        this.placements = placements;
        this.selector = selector;
        this.sinkUri = sinkUri;
    }

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("ceAttributes")
    public List<CloudEventAttributes> getCeAttributes() {
        return ceAttributes;
    }

    @JsonProperty("ceAttributes")
    public void setCeAttributes(List<CloudEventAttributes> ceAttributes) {
        this.ceAttributes = ceAttributes;
    }

    @JsonProperty("claims")
    public java.lang.String getClaims() {
        return claims;
    }

    @JsonProperty("claims")
    public void setClaims(java.lang.String claims) {
        this.claims = claims;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("consumers")
    public java.lang.Integer getConsumers() {
        return consumers;
    }

    @JsonProperty("consumers")
    public void setConsumers(java.lang.Integer consumers) {
        this.consumers = consumers;
    }

    @JsonProperty("maxAllowedVReplicas")
    public Integer getMaxAllowedVReplicas() {
        return maxAllowedVReplicas;
    }

    @JsonProperty("maxAllowedVReplicas")
    public void setMaxAllowedVReplicas(Integer maxAllowedVReplicas) {
        this.maxAllowedVReplicas = maxAllowedVReplicas;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("placements")
    public List<Placement> getPlacements() {
        return placements;
    }

    @JsonProperty("placements")
    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    @JsonProperty("selector")
    public java.lang.String getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(java.lang.String selector) {
        this.selector = selector;
    }

    @JsonProperty("sinkUri")
    public java.lang.String getSinkUri() {
        return sinkUri;
    }

    @JsonProperty("sinkUri")
    public void setSinkUri(java.lang.String sinkUri) {
        this.sinkUri = sinkUri;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
