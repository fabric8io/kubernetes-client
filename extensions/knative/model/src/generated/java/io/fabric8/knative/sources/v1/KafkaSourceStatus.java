
package io.fabric8.knative.sources.v1;

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
import io.fabric8.knative.duck.v1.AuthStatus;
import io.fabric8.knative.duck.v1.CloudEventAttributes;
import io.fabric8.knative.duck.v1alpha1.Placement;
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
    "annotations",
    "auth",
    "ceAttributes",
    "claims",
    "conditions",
    "consumers",
    "maxAllowedVReplicas",
    "observedGeneration",
    "placements",
    "selector",
    "sinkAudience",
    "sinkCACerts",
    "sinkUri"
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
public class KafkaSourceStatus implements Editable<KafkaSourceStatusBuilder> , KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("auth")
    private AuthStatus auth;
    @JsonProperty("ceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CloudEventAttributes> ceAttributes = new ArrayList<>();
    @JsonProperty("claims")
    private String claims;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("consumers")
    private Integer consumers;
    @JsonProperty("maxAllowedVReplicas")
    private Integer maxAllowedVReplicas;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("placements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Placement> placements = new ArrayList<>();
    @JsonProperty("selector")
    private String selector;
    @JsonProperty("sinkAudience")
    private String sinkAudience;
    @JsonProperty("sinkCACerts")
    private String sinkCACerts;
    @JsonProperty("sinkUri")
    private String sinkUri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KafkaSourceStatus() {
    }

    public KafkaSourceStatus(Map<String, String> annotations, AuthStatus auth, List<CloudEventAttributes> ceAttributes, String claims, List<Condition> conditions, Integer consumers, Integer maxAllowedVReplicas, Long observedGeneration, List<Placement> placements, String selector, String sinkAudience, String sinkCACerts, String sinkUri) {
        super();
        this.annotations = annotations;
        this.auth = auth;
        this.ceAttributes = ceAttributes;
        this.claims = claims;
        this.conditions = conditions;
        this.consumers = consumers;
        this.maxAllowedVReplicas = maxAllowedVReplicas;
        this.observedGeneration = observedGeneration;
        this.placements = placements;
        this.selector = selector;
        this.sinkAudience = sinkAudience;
        this.sinkCACerts = sinkCACerts;
        this.sinkUri = sinkUri;
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

    @JsonProperty("auth")
    public AuthStatus getAuth() {
        return auth;
    }

    @JsonProperty("auth")
    public void setAuth(AuthStatus auth) {
        this.auth = auth;
    }

    @JsonProperty("ceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CloudEventAttributes> getCeAttributes() {
        return ceAttributes;
    }

    @JsonProperty("ceAttributes")
    public void setCeAttributes(List<CloudEventAttributes> ceAttributes) {
        this.ceAttributes = ceAttributes;
    }

    @JsonProperty("claims")
    public String getClaims() {
        return claims;
    }

    @JsonProperty("claims")
    public void setClaims(String claims) {
        this.claims = claims;
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

    @JsonProperty("consumers")
    public Integer getConsumers() {
        return consumers;
    }

    @JsonProperty("consumers")
    public void setConsumers(Integer consumers) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Placement> getPlacements() {
        return placements;
    }

    @JsonProperty("placements")
    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    @JsonProperty("selector")
    public String getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(String selector) {
        this.selector = selector;
    }

    @JsonProperty("sinkAudience")
    public String getSinkAudience() {
        return sinkAudience;
    }

    @JsonProperty("sinkAudience")
    public void setSinkAudience(String sinkAudience) {
        this.sinkAudience = sinkAudience;
    }

    @JsonProperty("sinkCACerts")
    public String getSinkCACerts() {
        return sinkCACerts;
    }

    @JsonProperty("sinkCACerts")
    public void setSinkCACerts(String sinkCACerts) {
        this.sinkCACerts = sinkCACerts;
    }

    @JsonProperty("sinkUri")
    public String getSinkUri() {
        return sinkUri;
    }

    @JsonProperty("sinkUri")
    public void setSinkUri(String sinkUri) {
        this.sinkUri = sinkUri;
    }

    @JsonIgnore
    public KafkaSourceStatusBuilder edit() {
        return new KafkaSourceStatusBuilder(this);
    }

    @JsonIgnore
    public KafkaSourceStatusBuilder toBuilder() {
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
