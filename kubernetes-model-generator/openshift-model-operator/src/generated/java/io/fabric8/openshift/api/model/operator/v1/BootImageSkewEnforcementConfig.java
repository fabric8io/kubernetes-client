
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * BootImageSkewEnforcementConfig is used to configure how boot image version skew is enforced on the cluster.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "manual",
    "mode"
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
public class BootImageSkewEnforcementConfig implements Editable<BootImageSkewEnforcementConfigBuilder>, KubernetesResource
{

    @JsonProperty("manual")
    private ClusterBootImageManual manual;
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BootImageSkewEnforcementConfig() {
    }

    public BootImageSkewEnforcementConfig(ClusterBootImageManual manual, String mode) {
        super();
        this.manual = manual;
        this.mode = mode;
    }

    /**
     * BootImageSkewEnforcementConfig is used to configure how boot image version skew is enforced on the cluster.
     */
    @JsonProperty("manual")
    public ClusterBootImageManual getManual() {
        return manual;
    }

    /**
     * BootImageSkewEnforcementConfig is used to configure how boot image version skew is enforced on the cluster.
     */
    @JsonProperty("manual")
    public void setManual(ClusterBootImageManual manual) {
        this.manual = manual;
    }

    /**
     * mode determines the underlying behavior of skew enforcement mechanism. Valid values are Manual and None. Manual means that the cluster admin is expected to perform manual boot image updates and store the OCP &amp; RHCOS version associated with the last boot image update in the manual field. In Manual mode, the MCO will prevent upgrades when the boot image skew exceeds the skew limit described by the release image. None means that the MCO will no longer monitor the boot image skew. This may affect the cluster's ability to scale. This field is required.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * mode determines the underlying behavior of skew enforcement mechanism. Valid values are Manual and None. Manual means that the cluster admin is expected to perform manual boot image updates and store the OCP &amp; RHCOS version associated with the last boot image update in the manual field. In Manual mode, the MCO will prevent upgrades when the boot image skew exceeds the skew limit described by the release image. None means that the MCO will no longer monitor the boot image skew. This may affect the cluster's ability to scale. This field is required.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public BootImageSkewEnforcementConfigBuilder edit() {
        return new BootImageSkewEnforcementConfigBuilder(this);
    }

    @JsonIgnore
    public BootImageSkewEnforcementConfigBuilder toBuilder() {
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
