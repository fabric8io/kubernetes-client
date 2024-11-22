
package io.fabric8.openshift.api.model.config.v1;

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
    "additionalTrustedCA",
    "allowedRegistriesForImport",
    "externalRegistryHostnames",
    "imageStreamImportMode",
    "registrySources"
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
public class ImageSpec implements Editable<ImageSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalTrustedCA")
    private ConfigMapNameReference additionalTrustedCA;
    @JsonProperty("allowedRegistriesForImport")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RegistryLocation> allowedRegistriesForImport = new ArrayList<>();
    @JsonProperty("externalRegistryHostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> externalRegistryHostnames = new ArrayList<>();
    @JsonProperty("imageStreamImportMode")
    private String imageStreamImportMode;
    @JsonProperty("registrySources")
    private RegistrySources registrySources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageSpec() {
    }

    public ImageSpec(ConfigMapNameReference additionalTrustedCA, List<RegistryLocation> allowedRegistriesForImport, List<String> externalRegistryHostnames, String imageStreamImportMode, RegistrySources registrySources) {
        super();
        this.additionalTrustedCA = additionalTrustedCA;
        this.allowedRegistriesForImport = allowedRegistriesForImport;
        this.externalRegistryHostnames = externalRegistryHostnames;
        this.imageStreamImportMode = imageStreamImportMode;
        this.registrySources = registrySources;
    }

    @JsonProperty("additionalTrustedCA")
    public ConfigMapNameReference getAdditionalTrustedCA() {
        return additionalTrustedCA;
    }

    @JsonProperty("additionalTrustedCA")
    public void setAdditionalTrustedCA(ConfigMapNameReference additionalTrustedCA) {
        this.additionalTrustedCA = additionalTrustedCA;
    }

    @JsonProperty("allowedRegistriesForImport")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RegistryLocation> getAllowedRegistriesForImport() {
        return allowedRegistriesForImport;
    }

    @JsonProperty("allowedRegistriesForImport")
    public void setAllowedRegistriesForImport(List<RegistryLocation> allowedRegistriesForImport) {
        this.allowedRegistriesForImport = allowedRegistriesForImport;
    }

    @JsonProperty("externalRegistryHostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExternalRegistryHostnames() {
        return externalRegistryHostnames;
    }

    @JsonProperty("externalRegistryHostnames")
    public void setExternalRegistryHostnames(List<String> externalRegistryHostnames) {
        this.externalRegistryHostnames = externalRegistryHostnames;
    }

    @JsonProperty("imageStreamImportMode")
    public String getImageStreamImportMode() {
        return imageStreamImportMode;
    }

    @JsonProperty("imageStreamImportMode")
    public void setImageStreamImportMode(String imageStreamImportMode) {
        this.imageStreamImportMode = imageStreamImportMode;
    }

    @JsonProperty("registrySources")
    public RegistrySources getRegistrySources() {
        return registrySources;
    }

    @JsonProperty("registrySources")
    public void setRegistrySources(RegistrySources registrySources) {
        this.registrySources = registrySources;
    }

    @JsonIgnore
    public ImageSpecBuilder edit() {
        return new ImageSpecBuilder(this);
    }

    @JsonIgnore
    public ImageSpecBuilder toBuilder() {
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
