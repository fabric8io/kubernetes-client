
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
 * One or more match conditions to be met before a patch is applied to the generated configuration for a given proxy.
 */
@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ObjectTypes",
    "context",
    "proxy"
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
public class EnvoyFilterEnvoyConfigObjectMatch implements Editable<EnvoyFilterEnvoyConfigObjectMatchBuilder>, KubernetesResource
{

    @JsonProperty("ObjectTypes")
    @JsonUnwrapped
    private IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes objectTypes;
    @JsonProperty("context")
    private EnvoyFilterPatchContext context;
    @JsonProperty("proxy")
    private EnvoyFilterProxyMatch proxy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EnvoyFilterEnvoyConfigObjectMatch() {
    }

    public EnvoyFilterEnvoyConfigObjectMatch(IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes objectTypes, EnvoyFilterPatchContext context, EnvoyFilterProxyMatch proxy) {
        super();
        this.objectTypes = objectTypes;
        this.context = context;
        this.proxy = proxy;
    }

    /**
     * One or more match conditions to be met before a patch is applied to the generated configuration for a given proxy.
     */
    @JsonProperty("ObjectTypes")
    @JsonUnwrapped
    public IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes getObjectTypes() {
        return objectTypes;
    }

    /**
     * One or more match conditions to be met before a patch is applied to the generated configuration for a given proxy.
     */
    @JsonProperty("ObjectTypes")
    public void setObjectTypes(IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes objectTypes) {
        this.objectTypes = objectTypes;
    }

    /**
     * One or more match conditions to be met before a patch is applied to the generated configuration for a given proxy.
     */
    @JsonProperty("context")
    public EnvoyFilterPatchContext getContext() {
        return context;
    }

    /**
     * One or more match conditions to be met before a patch is applied to the generated configuration for a given proxy.
     */
    @JsonProperty("context")
    public void setContext(EnvoyFilterPatchContext context) {
        this.context = context;
    }

    /**
     * One or more match conditions to be met before a patch is applied to the generated configuration for a given proxy.
     */
    @JsonProperty("proxy")
    public EnvoyFilterProxyMatch getProxy() {
        return proxy;
    }

    /**
     * One or more match conditions to be met before a patch is applied to the generated configuration for a given proxy.
     */
    @JsonProperty("proxy")
    public void setProxy(EnvoyFilterProxyMatch proxy) {
        this.proxy = proxy;
    }

    @JsonIgnore
    public EnvoyFilterEnvoyConfigObjectMatchBuilder edit() {
        return new EnvoyFilterEnvoyConfigObjectMatchBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterEnvoyConfigObjectMatchBuilder toBuilder() {
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
        if (!(o instanceof EnvoyFilterEnvoyConfigObjectMatch)) {
            return false;
        }
        EnvoyFilterEnvoyConfigObjectMatch other = (EnvoyFilterEnvoyConfigObjectMatch) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$objectTypes = this.getObjectTypes();
        Object other$objectTypes = other.getObjectTypes();
        if (this$objectTypes == null ? other$objectTypes != null : !this$objectTypes.equals(other$objectTypes)) {
            return false;
        }
        Object this$context = this.getContext();
        Object other$context = other.getContext();
        if (this$context == null ? other$context != null : !this$context.equals(other$context)) {
            return false;
        }
        Object this$proxy = this.getProxy();
        Object other$proxy = other.getProxy();
        if (this$proxy == null ? other$proxy != null : !this$proxy.equals(other$proxy)) {
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
        return other instanceof EnvoyFilterEnvoyConfigObjectMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $objectTypes = this.getObjectTypes();
        result = result * prime + ($objectTypes == null ? 43 : $objectTypes.hashCode());
        Object $context = this.getContext();
        result = result * prime + ($context == null ? 43 : $context.hashCode());
        Object $proxy = this.getProxy();
        result = result * prime + ($proxy == null ? 43 : $proxy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EnvoyFilterEnvoyConfigObjectMatch(" + "objectTypes=" + this.getObjectTypes() + ", context=" + this.getContext() + ", proxy=" + this.getProxy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
