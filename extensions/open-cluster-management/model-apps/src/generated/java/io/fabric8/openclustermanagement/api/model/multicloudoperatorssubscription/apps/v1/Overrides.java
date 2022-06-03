
package io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1;

import java.util.ArrayList;
import java.util.HashMap;
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
    "packageAlias",
    "packageName",
    "packageOverrides"
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
public class Overrides implements KubernetesResource
{

    @JsonProperty("packageAlias")
    private java.lang.String packageAlias;
    @JsonProperty("packageName")
    private java.lang.String packageName;
    @JsonProperty("packageOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Map<String, Object>> packageOverrides = new ArrayList<Map<String, Object>>();
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Overrides() {
    }

    /**
     * 
     * @param packageOverrides
     * @param packageName
     * @param packageAlias
     */
    public Overrides(java.lang.String packageAlias, java.lang.String packageName, List<Map<String, Object>> packageOverrides) {
        super();
        this.packageAlias = packageAlias;
        this.packageName = packageName;
        this.packageOverrides = packageOverrides;
    }

    @JsonProperty("packageAlias")
    public java.lang.String getPackageAlias() {
        return packageAlias;
    }

    @JsonProperty("packageAlias")
    public void setPackageAlias(java.lang.String packageAlias) {
        this.packageAlias = packageAlias;
    }

    @JsonProperty("packageName")
    public java.lang.String getPackageName() {
        return packageName;
    }

    @JsonProperty("packageName")
    public void setPackageName(java.lang.String packageName) {
        this.packageName = packageName;
    }

    @JsonProperty("packageOverrides")
    public List<Map<String, Object>> getPackageOverrides() {
        return packageOverrides;
    }

    @JsonProperty("packageOverrides")
    public void setPackageOverrides(List<Map<String, Object>> packageOverrides) {
        this.packageOverrides = packageOverrides;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
