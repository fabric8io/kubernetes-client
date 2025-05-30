
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
 * CapabilitiesSpec defines the platform and user workload observabilities capabilities managed exclusively by the multicluster-observability-addon. Enabling any of these capabilities will result in deploying the following resources:<br><p>   - The addon Deployment, ServiceAccount and RBAC.<br><p>   - A ClusterManagementAddon managing placement for capability related custom resources.<br><p>   - An AddonDeploymentConfig managing the addon feature gates for activated capabilities.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "platform",
    "userWorkloads"
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
public class CapabilitiesSpec implements Editable<CapabilitiesSpecBuilder>, KubernetesResource
{

    @JsonProperty("platform")
    private PlatformCapabilitiesSpec platform;
    @JsonProperty("userWorkloads")
    private UserWorkloadCapabilitiesSpec userWorkloads;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CapabilitiesSpec() {
    }

    public CapabilitiesSpec(PlatformCapabilitiesSpec platform, UserWorkloadCapabilitiesSpec userWorkloads) {
        super();
        this.platform = platform;
        this.userWorkloads = userWorkloads;
    }

    /**
     * CapabilitiesSpec defines the platform and user workload observabilities capabilities managed exclusively by the multicluster-observability-addon. Enabling any of these capabilities will result in deploying the following resources:<br><p>   - The addon Deployment, ServiceAccount and RBAC.<br><p>   - A ClusterManagementAddon managing placement for capability related custom resources.<br><p>   - An AddonDeploymentConfig managing the addon feature gates for activated capabilities.
     */
    @JsonProperty("platform")
    public PlatformCapabilitiesSpec getPlatform() {
        return platform;
    }

    /**
     * CapabilitiesSpec defines the platform and user workload observabilities capabilities managed exclusively by the multicluster-observability-addon. Enabling any of these capabilities will result in deploying the following resources:<br><p>   - The addon Deployment, ServiceAccount and RBAC.<br><p>   - A ClusterManagementAddon managing placement for capability related custom resources.<br><p>   - An AddonDeploymentConfig managing the addon feature gates for activated capabilities.
     */
    @JsonProperty("platform")
    public void setPlatform(PlatformCapabilitiesSpec platform) {
        this.platform = platform;
    }

    /**
     * CapabilitiesSpec defines the platform and user workload observabilities capabilities managed exclusively by the multicluster-observability-addon. Enabling any of these capabilities will result in deploying the following resources:<br><p>   - The addon Deployment, ServiceAccount and RBAC.<br><p>   - A ClusterManagementAddon managing placement for capability related custom resources.<br><p>   - An AddonDeploymentConfig managing the addon feature gates for activated capabilities.
     */
    @JsonProperty("userWorkloads")
    public UserWorkloadCapabilitiesSpec getUserWorkloads() {
        return userWorkloads;
    }

    /**
     * CapabilitiesSpec defines the platform and user workload observabilities capabilities managed exclusively by the multicluster-observability-addon. Enabling any of these capabilities will result in deploying the following resources:<br><p>   - The addon Deployment, ServiceAccount and RBAC.<br><p>   - A ClusterManagementAddon managing placement for capability related custom resources.<br><p>   - An AddonDeploymentConfig managing the addon feature gates for activated capabilities.
     */
    @JsonProperty("userWorkloads")
    public void setUserWorkloads(UserWorkloadCapabilitiesSpec userWorkloads) {
        this.userWorkloads = userWorkloads;
    }

    @JsonIgnore
    public CapabilitiesSpecBuilder edit() {
        return new CapabilitiesSpecBuilder(this);
    }

    @JsonIgnore
    public CapabilitiesSpecBuilder toBuilder() {
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
