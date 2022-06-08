
package io.fabric8.camelk.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "applicationClass",
    "capabilities",
    "dependencies",
    "provider",
    "version"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class RuntimeSpec implements KubernetesResource
{

    @JsonProperty("applicationClass")
    private java.lang.String applicationClass;
    @JsonProperty("capabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Capability> capabilities = new LinkedHashMap<String, Capability>();
    @JsonProperty("dependencies")
    private List<MavenArtifact> dependencies = new ArrayList<MavenArtifact>();
    @JsonProperty("metadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> metadata = new LinkedHashMap<String, String>();
    @JsonProperty("provider")
    private java.lang.String provider;
    @JsonProperty("version")
    private java.lang.String version;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RuntimeSpec() {
    }

    /**
     * 
     * @param metadata
     * @param capabilities
     * @param applicationClass
     * @param provider
     * @param version
     * @param dependencies
     */
    public RuntimeSpec(java.lang.String applicationClass, Map<String, Capability> capabilities, List<MavenArtifact> dependencies, Map<String, String> metadata, java.lang.String provider, java.lang.String version) {
        super();
        this.applicationClass = applicationClass;
        this.capabilities = capabilities;
        this.dependencies = dependencies;
        this.metadata = metadata;
        this.provider = provider;
        this.version = version;
    }

    @JsonProperty("applicationClass")
    public java.lang.String getApplicationClass() {
        return applicationClass;
    }

    @JsonProperty("applicationClass")
    public void setApplicationClass(java.lang.String applicationClass) {
        this.applicationClass = applicationClass;
    }

    @JsonProperty("capabilities")
    public Map<String, Capability> getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(Map<String, Capability> capabilities) {
        this.capabilities = capabilities;
    }

    @JsonProperty("dependencies")
    public List<MavenArtifact> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(List<MavenArtifact> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("provider")
    public java.lang.String getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(java.lang.String provider) {
        this.provider = provider;
    }

    @JsonProperty("version")
    public java.lang.String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
