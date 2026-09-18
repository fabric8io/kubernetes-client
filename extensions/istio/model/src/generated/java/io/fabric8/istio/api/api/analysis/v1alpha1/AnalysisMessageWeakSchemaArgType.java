
package io.fabric8.istio.api.api.analysis.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "goType",
    "name"
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
public class AnalysisMessageWeakSchemaArgType implements Editable<AnalysisMessageWeakSchemaArgTypeBuilder>, KubernetesResource
{

    @JsonProperty("goType")
    private String goType;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AnalysisMessageWeakSchemaArgType() {
    }

    public AnalysisMessageWeakSchemaArgType(String goType, String name) {
        super();
        this.goType = goType;
        this.name = name;
    }

    /**
     * Required. Should be a golang type, used in code generation. Ideally this will change to a less language-pinned type before this gets out of alpha, but for compatibility with current istio/istio code it's go_type for now.
     */
    @JsonProperty("goType")
    public String getGoType() {
        return goType;
    }

    /**
     * Required. Should be a golang type, used in code generation. Ideally this will change to a less language-pinned type before this gets out of alpha, but for compatibility with current istio/istio code it's go_type for now.
     */
    @JsonProperty("goType")
    public void setGoType(String goType) {
        this.goType = goType;
    }

    /**
     * Required
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Required
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public AnalysisMessageWeakSchemaArgTypeBuilder edit() {
        return new AnalysisMessageWeakSchemaArgTypeBuilder(this);
    }

    @JsonIgnore
    public AnalysisMessageWeakSchemaArgTypeBuilder toBuilder() {
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
        if (!(o instanceof AnalysisMessageWeakSchemaArgType)) {
            return false;
        }
        AnalysisMessageWeakSchemaArgType other = (AnalysisMessageWeakSchemaArgType) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$goType = this.getGoType();
        Object other$goType = other.getGoType();
        if (this$goType == null ? other$goType != null : !this$goType.equals(other$goType)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof AnalysisMessageWeakSchemaArgType;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $goType = this.getGoType();
        result = result * prime + ($goType == null ? 43 : $goType.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AnalysisMessageWeakSchemaArgType(" + "goType=" + this.getGoType() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
