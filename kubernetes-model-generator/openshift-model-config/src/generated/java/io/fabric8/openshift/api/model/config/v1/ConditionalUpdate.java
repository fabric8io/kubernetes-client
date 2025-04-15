
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Condition;
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
 * ConditionalUpdate represents an update which is recommended to some clusters on the version the current cluster is reconciling, but which may not be recommended for the current cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "release",
    "risks"
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
public class ConditionalUpdate implements Editable<ConditionalUpdateBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("release")
    private Release release;
    @JsonProperty("risks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConditionalUpdateRisk> risks = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConditionalUpdate() {
    }

    public ConditionalUpdate(List<Condition> conditions, Release release, List<ConditionalUpdateRisk> risks) {
        super();
        this.conditions = conditions;
        this.release = release;
        this.risks = risks;
    }

    /**
     * conditions represents the observations of the conditional update's current status. Known types are: &#42; Recommended, for whether the update is recommended for the current cluster.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions represents the observations of the conditional update's current status. Known types are: &#42; Recommended, for whether the update is recommended for the current cluster.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ConditionalUpdate represents an update which is recommended to some clusters on the version the current cluster is reconciling, but which may not be recommended for the current cluster.
     */
    @JsonProperty("release")
    public Release getRelease() {
        return release;
    }

    /**
     * ConditionalUpdate represents an update which is recommended to some clusters on the version the current cluster is reconciling, but which may not be recommended for the current cluster.
     */
    @JsonProperty("release")
    public void setRelease(Release release) {
        this.release = release;
    }

    /**
     * risks represents the range of issues associated with updating to the target release. The cluster-version operator will evaluate all entries, and only recommend the update if there is at least one entry and all entries recommend the update.
     */
    @JsonProperty("risks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConditionalUpdateRisk> getRisks() {
        return risks;
    }

    /**
     * risks represents the range of issues associated with updating to the target release. The cluster-version operator will evaluate all entries, and only recommend the update if there is at least one entry and all entries recommend the update.
     */
    @JsonProperty("risks")
    public void setRisks(List<ConditionalUpdateRisk> risks) {
        this.risks = risks;
    }

    @JsonIgnore
    public ConditionalUpdateBuilder edit() {
        return new ConditionalUpdateBuilder(this);
    }

    @JsonIgnore
    public ConditionalUpdateBuilder toBuilder() {
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
