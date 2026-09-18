
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
 * MachineConfigSpec is the spec for MachineConfig
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseOSExtensionsContainerImage",
    "config",
    "extensions",
    "fips",
    "kernelArguments",
    "kernelType",
    "osImageURL"
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
public class MachineConfigSpec implements Editable<MachineConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("baseOSExtensionsContainerImage")
    private String baseOSExtensionsContainerImage;
    @JsonProperty("config")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object config;
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> extensions = new ArrayList<>();
    @JsonProperty("fips")
    private Boolean fips;
    @JsonProperty("kernelArguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> kernelArguments = new ArrayList<>();
    @JsonProperty("kernelType")
    private String kernelType;
    @JsonProperty("osImageURL")
    private String osImageURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigSpec() {
    }

    public MachineConfigSpec(String baseOSExtensionsContainerImage, Object config, List<String> extensions, Boolean fips, List<String> kernelArguments, String kernelType, String osImageURL) {
        super();
        this.baseOSExtensionsContainerImage = baseOSExtensionsContainerImage;
        this.config = config;
        this.extensions = extensions;
        this.fips = fips;
        this.kernelArguments = kernelArguments;
        this.kernelType = kernelType;
        this.osImageURL = osImageURL;
    }

    /**
     * baseOSExtensionsContainerImage specifies the remote location that will be used to fetch the extensions container matching a new-format OS image
     */
    @JsonProperty("baseOSExtensionsContainerImage")
    public String getBaseOSExtensionsContainerImage() {
        return baseOSExtensionsContainerImage;
    }

    /**
     * baseOSExtensionsContainerImage specifies the remote location that will be used to fetch the extensions container matching a new-format OS image
     */
    @JsonProperty("baseOSExtensionsContainerImage")
    public void setBaseOSExtensionsContainerImage(String baseOSExtensionsContainerImage) {
        this.baseOSExtensionsContainerImage = baseOSExtensionsContainerImage;
    }

    /**
     * MachineConfigSpec is the spec for MachineConfig
     */
    @JsonProperty("config")
    public Object getConfig() {
        return config;
    }

    /**
     * MachineConfigSpec is the spec for MachineConfig
     */
    @JsonProperty("config")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setConfig(Object config) {
        this.config = config;
    }

    /**
     * extensions contains a list of additional features that can be enabled on host
     */
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExtensions() {
        return extensions;
    }

    /**
     * extensions contains a list of additional features that can be enabled on host
     */
    @JsonProperty("extensions")
    public void setExtensions(List<String> extensions) {
        this.extensions = extensions;
    }

    /**
     * fips controls FIPS mode
     */
    @JsonProperty("fips")
    public Boolean getFips() {
        return fips;
    }

    /**
     * fips controls FIPS mode
     */
    @JsonProperty("fips")
    public void setFips(Boolean fips) {
        this.fips = fips;
    }

    /**
     * kernelArguments contains a list of kernel arguments to be added
     */
    @JsonProperty("kernelArguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getKernelArguments() {
        return kernelArguments;
    }

    /**
     * kernelArguments contains a list of kernel arguments to be added
     */
    @JsonProperty("kernelArguments")
    public void setKernelArguments(List<String> kernelArguments) {
        this.kernelArguments = kernelArguments;
    }

    /**
     * kernelType contains which kernel we want to be running like default (traditional), realtime, 64k-pages (aarch64 only).
     */
    @JsonProperty("kernelType")
    public String getKernelType() {
        return kernelType;
    }

    /**
     * kernelType contains which kernel we want to be running like default (traditional), realtime, 64k-pages (aarch64 only).
     */
    @JsonProperty("kernelType")
    public void setKernelType(String kernelType) {
        this.kernelType = kernelType;
    }

    /**
     * osImageURL specifies the remote location that will be used to fetch the OS.
     */
    @JsonProperty("osImageURL")
    public String getOsImageURL() {
        return osImageURL;
    }

    /**
     * osImageURL specifies the remote location that will be used to fetch the OS.
     */
    @JsonProperty("osImageURL")
    public void setOsImageURL(String osImageURL) {
        this.osImageURL = osImageURL;
    }

    @JsonIgnore
    public MachineConfigSpecBuilder edit() {
        return new MachineConfigSpecBuilder(this);
    }

    @JsonIgnore
    public MachineConfigSpecBuilder toBuilder() {
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
        if (!(o instanceof MachineConfigSpec)) {
            return false;
        }
        MachineConfigSpec other = (MachineConfigSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$baseOSExtensionsContainerImage = this.getBaseOSExtensionsContainerImage();
        Object other$baseOSExtensionsContainerImage = other.getBaseOSExtensionsContainerImage();
        if (this$baseOSExtensionsContainerImage == null ? other$baseOSExtensionsContainerImage != null : !this$baseOSExtensionsContainerImage.equals(other$baseOSExtensionsContainerImage)) {
            return false;
        }
        Object this$config = this.getConfig();
        Object other$config = other.getConfig();
        if (this$config == null ? other$config != null : !this$config.equals(other$config)) {
            return false;
        }
        Object this$extensions = this.getExtensions();
        Object other$extensions = other.getExtensions();
        if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions)) {
            return false;
        }
        Object this$fips = this.getFips();
        Object other$fips = other.getFips();
        if (this$fips == null ? other$fips != null : !this$fips.equals(other$fips)) {
            return false;
        }
        Object this$kernelArguments = this.getKernelArguments();
        Object other$kernelArguments = other.getKernelArguments();
        if (this$kernelArguments == null ? other$kernelArguments != null : !this$kernelArguments.equals(other$kernelArguments)) {
            return false;
        }
        Object this$kernelType = this.getKernelType();
        Object other$kernelType = other.getKernelType();
        if (this$kernelType == null ? other$kernelType != null : !this$kernelType.equals(other$kernelType)) {
            return false;
        }
        Object this$osImageURL = this.getOsImageURL();
        Object other$osImageURL = other.getOsImageURL();
        if (this$osImageURL == null ? other$osImageURL != null : !this$osImageURL.equals(other$osImageURL)) {
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
        return other instanceof MachineConfigSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $baseOSExtensionsContainerImage = this.getBaseOSExtensionsContainerImage();
        result = result * prime + ($baseOSExtensionsContainerImage == null ? 43 : $baseOSExtensionsContainerImage.hashCode());
        Object $config = this.getConfig();
        result = result * prime + ($config == null ? 43 : $config.hashCode());
        Object $extensions = this.getExtensions();
        result = result * prime + ($extensions == null ? 43 : $extensions.hashCode());
        Object $fips = this.getFips();
        result = result * prime + ($fips == null ? 43 : $fips.hashCode());
        Object $kernelArguments = this.getKernelArguments();
        result = result * prime + ($kernelArguments == null ? 43 : $kernelArguments.hashCode());
        Object $kernelType = this.getKernelType();
        result = result * prime + ($kernelType == null ? 43 : $kernelType.hashCode());
        Object $osImageURL = this.getOsImageURL();
        result = result * prime + ($osImageURL == null ? 43 : $osImageURL.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineConfigSpec(" + "baseOSExtensionsContainerImage=" + this.getBaseOSExtensionsContainerImage() + ", config=" + this.getConfig() + ", extensions=" + this.getExtensions() + ", fips=" + this.getFips() + ", kernelArguments=" + this.getKernelArguments() + ", kernelType=" + this.getKernelType() + ", osImageURL=" + this.getOsImageURL() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
