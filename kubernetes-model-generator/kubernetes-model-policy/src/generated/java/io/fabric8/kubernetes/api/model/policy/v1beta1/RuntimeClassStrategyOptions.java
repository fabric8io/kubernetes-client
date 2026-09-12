
package io.fabric8.kubernetes.api.model.policy.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * RuntimeClassStrategyOptions define the strategy that will dictate the allowable RuntimeClasses for a pod.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedRuntimeClassNames",
    "defaultRuntimeClassName"
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
public class RuntimeClassStrategyOptions implements Editable<RuntimeClassStrategyOptionsBuilder>, KubernetesResource
{

    @JsonProperty("allowedRuntimeClassNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedRuntimeClassNames = new ArrayList<>();
    @JsonProperty("defaultRuntimeClassName")
    private String defaultRuntimeClassName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RuntimeClassStrategyOptions() {
    }

    public RuntimeClassStrategyOptions(List<String> allowedRuntimeClassNames, String defaultRuntimeClassName) {
        super();
        this.allowedRuntimeClassNames = allowedRuntimeClassNames;
        this.defaultRuntimeClassName = defaultRuntimeClassName;
    }

    /**
     * allowedRuntimeClassNames is an allowlist of RuntimeClass names that may be specified on a pod. A value of "&#42;" means that any RuntimeClass name is allowed, and must be the only item in the list. An empty list requires the RuntimeClassName field to be unset.
     */
    @JsonProperty("allowedRuntimeClassNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedRuntimeClassNames() {
        return allowedRuntimeClassNames;
    }

    /**
     * allowedRuntimeClassNames is an allowlist of RuntimeClass names that may be specified on a pod. A value of "&#42;" means that any RuntimeClass name is allowed, and must be the only item in the list. An empty list requires the RuntimeClassName field to be unset.
     */
    @JsonProperty("allowedRuntimeClassNames")
    public void setAllowedRuntimeClassNames(List<String> allowedRuntimeClassNames) {
        this.allowedRuntimeClassNames = allowedRuntimeClassNames;
    }

    /**
     * defaultRuntimeClassName is the default RuntimeClassName to set on the pod. The default MUST be allowed by the allowedRuntimeClassNames list. A value of nil does not mutate the Pod.
     */
    @JsonProperty("defaultRuntimeClassName")
    public String getDefaultRuntimeClassName() {
        return defaultRuntimeClassName;
    }

    /**
     * defaultRuntimeClassName is the default RuntimeClassName to set on the pod. The default MUST be allowed by the allowedRuntimeClassNames list. A value of nil does not mutate the Pod.
     */
    @JsonProperty("defaultRuntimeClassName")
    public void setDefaultRuntimeClassName(String defaultRuntimeClassName) {
        this.defaultRuntimeClassName = defaultRuntimeClassName;
    }

    @JsonIgnore
    public RuntimeClassStrategyOptionsBuilder edit() {
        return new RuntimeClassStrategyOptionsBuilder(this);
    }

    @JsonIgnore
    public RuntimeClassStrategyOptionsBuilder toBuilder() {
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
        if (!(o instanceof RuntimeClassStrategyOptions)) {
            return false;
        }
        RuntimeClassStrategyOptions other = (RuntimeClassStrategyOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowedRuntimeClassNames = this.getAllowedRuntimeClassNames();
        Object other$allowedRuntimeClassNames = other.getAllowedRuntimeClassNames();
        if (this$allowedRuntimeClassNames == null ? other$allowedRuntimeClassNames != null : !this$allowedRuntimeClassNames.equals(other$allowedRuntimeClassNames)) {
            return false;
        }
        Object this$defaultRuntimeClassName = this.getDefaultRuntimeClassName();
        Object other$defaultRuntimeClassName = other.getDefaultRuntimeClassName();
        if (this$defaultRuntimeClassName == null ? other$defaultRuntimeClassName != null : !this$defaultRuntimeClassName.equals(other$defaultRuntimeClassName)) {
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
        return other instanceof RuntimeClassStrategyOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowedRuntimeClassNames = this.getAllowedRuntimeClassNames();
        result = result * prime + ($allowedRuntimeClassNames == null ? 43 : $allowedRuntimeClassNames.hashCode());
        Object $defaultRuntimeClassName = this.getDefaultRuntimeClassName();
        result = result * prime + ($defaultRuntimeClassName == null ? 43 : $defaultRuntimeClassName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RuntimeClassStrategyOptions(" + "allowedRuntimeClassNames=" + this.getAllowedRuntimeClassNames() + ", defaultRuntimeClassName=" + this.getDefaultRuntimeClassName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
