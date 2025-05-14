
package io.fabric8.openshift.api.model;

import java.util.LinkedHashMap;
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
 * RunAsUserStrategyOptions defines the strategy type and any options used to create the strategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "uid",
    "uidRangeMax",
    "uidRangeMin"
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
public class RunAsUserStrategyOptions implements Editable<RunAsUserStrategyOptionsBuilder>, KubernetesResource
{

    @JsonProperty("type")
    private String type;
    @JsonProperty("uid")
    private Long uid;
    @JsonProperty("uidRangeMax")
    private Long uidRangeMax;
    @JsonProperty("uidRangeMin")
    private Long uidRangeMin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RunAsUserStrategyOptions() {
    }

    public RunAsUserStrategyOptions(String type, Long uid, Long uidRangeMax, Long uidRangeMin) {
        super();
        this.type = type;
        this.uid = uid;
        this.uidRangeMax = uidRangeMax;
        this.uidRangeMin = uidRangeMin;
    }

    /**
     * Type is the strategy that will dictate what RunAsUser is used in the SecurityContext.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the strategy that will dictate what RunAsUser is used in the SecurityContext.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * UID is the user id that containers must run as.  Required for the MustRunAs strategy if not using namespace/service account allocated uids.
     */
    @JsonProperty("uid")
    public Long getUid() {
        return uid;
    }

    /**
     * UID is the user id that containers must run as.  Required for the MustRunAs strategy if not using namespace/service account allocated uids.
     */
    @JsonProperty("uid")
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * UIDRangeMax defines the max value for a strategy that allocates by range.
     */
    @JsonProperty("uidRangeMax")
    public Long getUidRangeMax() {
        return uidRangeMax;
    }

    /**
     * UIDRangeMax defines the max value for a strategy that allocates by range.
     */
    @JsonProperty("uidRangeMax")
    public void setUidRangeMax(Long uidRangeMax) {
        this.uidRangeMax = uidRangeMax;
    }

    /**
     * UIDRangeMin defines the min value for a strategy that allocates by range.
     */
    @JsonProperty("uidRangeMin")
    public Long getUidRangeMin() {
        return uidRangeMin;
    }

    /**
     * UIDRangeMin defines the min value for a strategy that allocates by range.
     */
    @JsonProperty("uidRangeMin")
    public void setUidRangeMin(Long uidRangeMin) {
        this.uidRangeMin = uidRangeMin;
    }

    @JsonIgnore
    public RunAsUserStrategyOptionsBuilder edit() {
        return new RunAsUserStrategyOptionsBuilder(this);
    }

    @JsonIgnore
    public RunAsUserStrategyOptionsBuilder toBuilder() {
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
