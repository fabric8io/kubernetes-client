
package io.fabric8.camelk.v1;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
    "artifacts",
    "loaders",
    "runtime"
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
public class CamelCatalogSpec implements KubernetesResource
{

    @JsonProperty("artifacts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, CamelArtifact> artifacts = new LinkedHashMap<String, CamelArtifact>();
    @JsonProperty("loaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, CamelLoader> loaders = new LinkedHashMap<String, CamelLoader>();
    @JsonProperty("runtime")
    private RuntimeSpec runtime;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CamelCatalogSpec() {
    }

    /**
     * 
     * @param loaders
     * @param runtime
     * @param artifacts
     */
    public CamelCatalogSpec(Map<String, CamelArtifact> artifacts, Map<String, CamelLoader> loaders, RuntimeSpec runtime) {
        super();
        this.artifacts = artifacts;
        this.loaders = loaders;
        this.runtime = runtime;
    }

    @JsonProperty("artifacts")
    public Map<String, CamelArtifact> getArtifacts() {
        return artifacts;
    }

    @JsonProperty("artifacts")
    public void setArtifacts(Map<String, CamelArtifact> artifacts) {
        this.artifacts = artifacts;
    }

    @JsonProperty("loaders")
    public Map<String, CamelLoader> getLoaders() {
        return loaders;
    }

    @JsonProperty("loaders")
    public void setLoaders(Map<String, CamelLoader> loaders) {
        this.loaders = loaders;
    }

    @JsonProperty("runtime")
    public RuntimeSpec getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(RuntimeSpec runtime) {
        this.runtime = runtime;
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
