
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * ExtensionScope defines the scope of the AKS marketplace extension, if configured.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "releaseNamespace",
    "scopeType",
    "targetNamespace"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class ExtensionScope implements Editable<ExtensionScopeBuilder>, KubernetesResource
{

    @JsonProperty("releaseNamespace")
    private String releaseNamespace;
    @JsonProperty("scopeType")
    private String scopeType;
    @JsonProperty("targetNamespace")
    private String targetNamespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExtensionScope() {
    }

    public ExtensionScope(String releaseNamespace, String scopeType, String targetNamespace) {
        super();
        this.releaseNamespace = releaseNamespace;
        this.scopeType = scopeType;
        this.targetNamespace = targetNamespace;
    }

    /**
     * ReleaseNamespace is the namespace where the extension Release must be placed, for a Cluster-scoped extension. Required for Cluster-scoped extensions.
     */
    @JsonProperty("releaseNamespace")
    public String getReleaseNamespace() {
        return releaseNamespace;
    }

    /**
     * ReleaseNamespace is the namespace where the extension Release must be placed, for a Cluster-scoped extension. Required for Cluster-scoped extensions.
     */
    @JsonProperty("releaseNamespace")
    public void setReleaseNamespace(String releaseNamespace) {
        this.releaseNamespace = releaseNamespace;
    }

    /**
     * ScopeType is the scope of the extension. It can be either Cluster or Namespace, but not both.
     */
    @JsonProperty("scopeType")
    public String getScopeType() {
        return scopeType;
    }

    /**
     * ScopeType is the scope of the extension. It can be either Cluster or Namespace, but not both.
     */
    @JsonProperty("scopeType")
    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    /**
     * TargetNamespace is the namespace where the extension will be created for a Namespace-scoped extension. Required for Namespace-scoped extensions.
     */
    @JsonProperty("targetNamespace")
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * TargetNamespace is the namespace where the extension will be created for a Namespace-scoped extension. Required for Namespace-scoped extensions.
     */
    @JsonProperty("targetNamespace")
    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

    @JsonIgnore
    public ExtensionScopeBuilder edit() {
        return new ExtensionScopeBuilder(this);
    }

    @JsonIgnore
    public ExtensionScopeBuilder toBuilder() {
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
