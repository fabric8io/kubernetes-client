
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "additionalTrustedCA",
    "allowedRegistriesForImport",
    "externalRegistryHostnames",
    "registrySources"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ImageSpec implements KubernetesResource
{

    @JsonProperty("additionalTrustedCA")
    private ConfigMapNameReference additionalTrustedCA;
    @JsonProperty("allowedRegistriesForImport")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RegistryLocation> allowedRegistriesForImport = new ArrayList<RegistryLocation>();
    @JsonProperty("externalRegistryHostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> externalRegistryHostnames = new ArrayList<String>();
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

    public ImageSpec(ConfigMapNameReference additionalTrustedCA, List<RegistryLocation> allowedRegistriesForImport, List<String> externalRegistryHostnames, RegistrySources registrySources) {
        super();
        this.additionalTrustedCA = additionalTrustedCA;
        this.allowedRegistriesForImport = allowedRegistriesForImport;
        this.externalRegistryHostnames = externalRegistryHostnames;
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
    public List<RegistryLocation> getAllowedRegistriesForImport() {
        return allowedRegistriesForImport;
    }

    @JsonProperty("allowedRegistriesForImport")
    public void setAllowedRegistriesForImport(List<RegistryLocation> allowedRegistriesForImport) {
        this.allowedRegistriesForImport = allowedRegistriesForImport;
    }

    @JsonProperty("externalRegistryHostnames")
    public List<String> getExternalRegistryHostnames() {
        return externalRegistryHostnames;
    }

    @JsonProperty("externalRegistryHostnames")
    public void setExternalRegistryHostnames(List<String> externalRegistryHostnames) {
        this.externalRegistryHostnames = externalRegistryHostnames;
    }

    @JsonProperty("registrySources")
    public RegistrySources getRegistrySources() {
        return registrySources;
    }

    @JsonProperty("registrySources")
    public void setRegistrySources(RegistrySources registrySources) {
        this.registrySources = registrySources;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
