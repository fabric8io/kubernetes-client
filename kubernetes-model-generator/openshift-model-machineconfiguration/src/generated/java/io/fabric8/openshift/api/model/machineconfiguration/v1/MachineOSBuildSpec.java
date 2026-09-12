
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MachineOSBuildSpec describes information about a build process primarily populated from a MachineOSConfig object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "machineConfig",
    "machineOSConfig",
    "renderedImagePushSpec"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MachineOSBuildSpec implements Editable<MachineOSBuildSpecBuilder>, KubernetesResource
{

    @JsonProperty("machineConfig")
    private MachineConfigReference machineConfig;
    @JsonProperty("machineOSConfig")
    private MachineOSConfigReference machineOSConfig;
    @JsonProperty("renderedImagePushSpec")
    private String renderedImagePushSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineOSBuildSpec() {
    }

    public MachineOSBuildSpec(MachineConfigReference machineConfig, MachineOSConfigReference machineOSConfig, String renderedImagePushSpec) {
        super();
        this.machineConfig = machineConfig;
        this.machineOSConfig = machineOSConfig;
        this.renderedImagePushSpec = renderedImagePushSpec;
    }

    /**
     * MachineOSBuildSpec describes information about a build process primarily populated from a MachineOSConfig object.
     */
    @JsonProperty("machineConfig")
    public MachineConfigReference getMachineConfig() {
        return machineConfig;
    }

    /**
     * MachineOSBuildSpec describes information about a build process primarily populated from a MachineOSConfig object.
     */
    @JsonProperty("machineConfig")
    public void setMachineConfig(MachineConfigReference machineConfig) {
        this.machineConfig = machineConfig;
    }

    /**
     * MachineOSBuildSpec describes information about a build process primarily populated from a MachineOSConfig object.
     */
    @JsonProperty("machineOSConfig")
    public MachineOSConfigReference getMachineOSConfig() {
        return machineOSConfig;
    }

    /**
     * MachineOSBuildSpec describes information about a build process primarily populated from a MachineOSConfig object.
     */
    @JsonProperty("machineOSConfig")
    public void setMachineOSConfig(MachineOSConfigReference machineOSConfig) {
        this.machineOSConfig = machineOSConfig;
    }

    /**
     * renderedImagePushSpec is set by the Machine Config Operator from the MachineOSConfig object this build is attached to. This field describes the location of the final image, which will be pushed by the build once complete. The format of the image push spec is: host[:port][/namespace]/name:&lt;tag&gt; or svc_name.namespace.svc[:port]/repository/name:&lt;tag&gt;. The length of the push spec must be between 1 to 447 characters.
     */
    @JsonProperty("renderedImagePushSpec")
    public String getRenderedImagePushSpec() {
        return renderedImagePushSpec;
    }

    /**
     * renderedImagePushSpec is set by the Machine Config Operator from the MachineOSConfig object this build is attached to. This field describes the location of the final image, which will be pushed by the build once complete. The format of the image push spec is: host[:port][/namespace]/name:&lt;tag&gt; or svc_name.namespace.svc[:port]/repository/name:&lt;tag&gt;. The length of the push spec must be between 1 to 447 characters.
     */
    @JsonProperty("renderedImagePushSpec")
    public void setRenderedImagePushSpec(String renderedImagePushSpec) {
        this.renderedImagePushSpec = renderedImagePushSpec;
    }

    @JsonIgnore
    public MachineOSBuildSpecBuilder edit() {
        return new MachineOSBuildSpecBuilder(this);
    }

    @JsonIgnore
    public MachineOSBuildSpecBuilder toBuilder() {
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
        if (!(o instanceof MachineOSBuildSpec)) {
            return false;
        }
        MachineOSBuildSpec other = (MachineOSBuildSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$machineConfig = this.getMachineConfig();
        Object other$machineConfig = other.getMachineConfig();
        if (this$machineConfig == null ? other$machineConfig != null : !this$machineConfig.equals(other$machineConfig)) {
            return false;
        }
        Object this$machineOSConfig = this.getMachineOSConfig();
        Object other$machineOSConfig = other.getMachineOSConfig();
        if (this$machineOSConfig == null ? other$machineOSConfig != null : !this$machineOSConfig.equals(other$machineOSConfig)) {
            return false;
        }
        Object this$renderedImagePushSpec = this.getRenderedImagePushSpec();
        Object other$renderedImagePushSpec = other.getRenderedImagePushSpec();
        if (this$renderedImagePushSpec == null ? other$renderedImagePushSpec != null : !this$renderedImagePushSpec.equals(other$renderedImagePushSpec)) {
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
        return other instanceof MachineOSBuildSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $machineConfig = this.getMachineConfig();
        result = result * prime + ($machineConfig == null ? 43 : $machineConfig.hashCode());
        Object $machineOSConfig = this.getMachineOSConfig();
        result = result * prime + ($machineOSConfig == null ? 43 : $machineOSConfig.hashCode());
        Object $renderedImagePushSpec = this.getRenderedImagePushSpec();
        result = result * prime + ($renderedImagePushSpec == null ? 43 : $renderedImagePushSpec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineOSBuildSpec(" + "machineConfig=" + this.getMachineConfig() + ", machineOSConfig=" + this.getMachineOSConfig() + ", renderedImagePushSpec=" + this.getRenderedImagePushSpec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
