
package io.fabric8.knative.sources.v1beta1;

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

/**
 * KafkaSourceStatus defines the observed state of KafkaSource.
 */
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
public class KafkaSourceStatus implements Editable<KafkaSourceStatusBuilder>, KubernetesResource
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
     * KafkaSourceStatus defines the observed state of KafkaSource.
     */
    @JsonProperty("auth")
    public AuthStatus getAuth() {
        return auth;
    }

    /**
     * KafkaSourceStatus defines the observed state of KafkaSource.
     */
    @JsonProperty("auth")
    public void setAuth(AuthStatus auth) {
        this.auth = auth;
    }

    /**
     * CloudEventAttributes are the specific attributes that the Source uses as part of its CloudEvents.
     */
    @JsonProperty("ceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CloudEventAttributes> getCeAttributes() {
        return ceAttributes;
    }

    /**
     * CloudEventAttributes are the specific attributes that the Source uses as part of its CloudEvents.
     */
    @JsonProperty("ceAttributes")
    public void setCeAttributes(List<CloudEventAttributes> ceAttributes) {
        this.ceAttributes = ceAttributes;
    }

    /**
     * Claims consumed by this KafkaSource instance
     */
    @JsonProperty("claims")
    public String getClaims() {
        return claims;
    }

    /**
     * Claims consumed by this KafkaSource instance
     */
    @JsonProperty("claims")
    public void setClaims(String claims) {
        this.claims = claims;
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
     * Total number of consumers actually running in the consumer group.
     */
    @JsonProperty("consumers")
    public Integer getConsumers() {
        return consumers;
    }

    /**
     * Total number of consumers actually running in the consumer group.
     */
    @JsonProperty("consumers")
    public void setConsumers(Integer consumers) {
        this.consumers = consumers;
    }

    /**
     * KafkaSourceStatus defines the observed state of KafkaSource.
     */
    @JsonProperty("maxAllowedVReplicas")
    public Integer getMaxAllowedVReplicas() {
        return maxAllowedVReplicas;
    }

    /**
     * KafkaSourceStatus defines the observed state of KafkaSource.
     */
    @JsonProperty("maxAllowedVReplicas")
    public void setMaxAllowedVReplicas(Integer maxAllowedVReplicas) {
        this.maxAllowedVReplicas = maxAllowedVReplicas;
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
     * KafkaSourceStatus defines the observed state of KafkaSource.
     */
    @JsonProperty("placements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Placement> getPlacements() {
        return placements;
    }

    /**
     * KafkaSourceStatus defines the observed state of KafkaSource.
     */
    @JsonProperty("placements")
    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    /**
     * Use for labelSelectorPath when scaling Kafka source
     */
    @JsonProperty("selector")
    public String getSelector() {
        return selector;
    }

    /**
     * Use for labelSelectorPath when scaling Kafka source
     */
    @JsonProperty("selector")
    public void setSelector(String selector) {
        this.selector = selector;
    }

    /**
     * SinkAudience is the OIDC audience of the sink.
     */
    @JsonProperty("sinkAudience")
    public String getSinkAudience() {
        return sinkAudience;
    }

    /**
     * SinkAudience is the OIDC audience of the sink.
     */
    @JsonProperty("sinkAudience")
    public void setSinkAudience(String sinkAudience) {
        this.sinkAudience = sinkAudience;
    }

    /**
     * SinkCACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468.
     */
    @JsonProperty("sinkCACerts")
    public String getSinkCACerts() {
        return sinkCACerts;
    }

    /**
     * SinkCACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468.
     */
    @JsonProperty("sinkCACerts")
    public void setSinkCACerts(String sinkCACerts) {
        this.sinkCACerts = sinkCACerts;
    }

    /**
     * KafkaSourceStatus defines the observed state of KafkaSource.
     */
    @JsonProperty("sinkUri")
    public String getSinkUri() {
        return sinkUri;
    }

    /**
     * KafkaSourceStatus defines the observed state of KafkaSource.
     */
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof KafkaSourceStatus)) {
            return false;
        }
        KafkaSourceStatus other = (KafkaSourceStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$annotations = this.getAnnotations();
        Object other$annotations = other.getAnnotations();
        if (this$annotations == null ? other$annotations != null : !this$annotations.equals(other$annotations)) {
            return false;
        }
        Object this$auth = this.getAuth();
        Object other$auth = other.getAuth();
        if (this$auth == null ? other$auth != null : !this$auth.equals(other$auth)) {
            return false;
        }
        Object this$ceAttributes = this.getCeAttributes();
        Object other$ceAttributes = other.getCeAttributes();
        if (this$ceAttributes == null ? other$ceAttributes != null : !this$ceAttributes.equals(other$ceAttributes)) {
            return false;
        }
        Object this$claims = this.getClaims();
        Object other$claims = other.getClaims();
        if (this$claims == null ? other$claims != null : !this$claims.equals(other$claims)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$consumers = this.getConsumers();
        Object other$consumers = other.getConsumers();
        if (this$consumers == null ? other$consumers != null : !this$consumers.equals(other$consumers)) {
            return false;
        }
        Object this$maxAllowedVReplicas = this.getMaxAllowedVReplicas();
        Object other$maxAllowedVReplicas = other.getMaxAllowedVReplicas();
        if (this$maxAllowedVReplicas == null ? other$maxAllowedVReplicas != null : !this$maxAllowedVReplicas.equals(other$maxAllowedVReplicas)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$placements = this.getPlacements();
        Object other$placements = other.getPlacements();
        if (this$placements == null ? other$placements != null : !this$placements.equals(other$placements)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$sinkAudience = this.getSinkAudience();
        Object other$sinkAudience = other.getSinkAudience();
        if (this$sinkAudience == null ? other$sinkAudience != null : !this$sinkAudience.equals(other$sinkAudience)) {
            return false;
        }
        Object this$sinkCACerts = this.getSinkCACerts();
        Object other$sinkCACerts = other.getSinkCACerts();
        if (this$sinkCACerts == null ? other$sinkCACerts != null : !this$sinkCACerts.equals(other$sinkCACerts)) {
            return false;
        }
        Object this$sinkUri = this.getSinkUri();
        Object other$sinkUri = other.getSinkUri();
        if (this$sinkUri == null ? other$sinkUri != null : !this$sinkUri.equals(other$sinkUri)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof KafkaSourceStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $auth = this.getAuth();
        result = result * prime + ($auth == null ? 43 : $auth.hashCode());
        Object $ceAttributes = this.getCeAttributes();
        result = result * prime + ($ceAttributes == null ? 43 : $ceAttributes.hashCode());
        Object $claims = this.getClaims();
        result = result * prime + ($claims == null ? 43 : $claims.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $consumers = this.getConsumers();
        result = result * prime + ($consumers == null ? 43 : $consumers.hashCode());
        Object $maxAllowedVReplicas = this.getMaxAllowedVReplicas();
        result = result * prime + ($maxAllowedVReplicas == null ? 43 : $maxAllowedVReplicas.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $placements = this.getPlacements();
        result = result * prime + ($placements == null ? 43 : $placements.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $sinkAudience = this.getSinkAudience();
        result = result * prime + ($sinkAudience == null ? 43 : $sinkAudience.hashCode());
        Object $sinkCACerts = this.getSinkCACerts();
        result = result * prime + ($sinkCACerts == null ? 43 : $sinkCACerts.hashCode());
        Object $sinkUri = this.getSinkUri();
        result = result * prime + ($sinkUri == null ? 43 : $sinkUri.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaSourceStatus(" + "annotations=" + this.getAnnotations() + ", auth=" + this.getAuth() + ", ceAttributes=" + this.getCeAttributes() + ", claims=" + this.getClaims() + ", conditions=" + this.getConditions() + ", consumers=" + this.getConsumers() + ", maxAllowedVReplicas=" + this.getMaxAllowedVReplicas() + ", observedGeneration=" + this.getObservedGeneration() + ", placements=" + this.getPlacements() + ", selector=" + this.getSelector() + ", sinkAudience=" + this.getSinkAudience() + ", sinkCACerts=" + this.getSinkCACerts() + ", sinkUri=" + this.getSinkUri() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
