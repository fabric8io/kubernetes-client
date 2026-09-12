
package io.fabric8.tekton.triggers.v1beta1;

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
 * TriggerSpec represents a connection between TriggerSpecBinding, and TriggerSpecTemplate; TriggerSpecBinding provides extracted values for TriggerSpecTemplate to then create resources from.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bindings",
    "interceptors",
    "name",
    "serviceAccountName",
    "template"
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
public class TriggerSpec implements Editable<TriggerSpecBuilder>, KubernetesResource
{

    @JsonProperty("bindings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TriggerSpecBinding> bindings = new ArrayList<>();
    @JsonProperty("interceptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TriggerInterceptor> interceptors = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("template")
    private TriggerSpecTemplate template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TriggerSpec() {
    }

    public TriggerSpec(List<TriggerSpecBinding> bindings, List<TriggerInterceptor> interceptors, String name, String serviceAccountName, TriggerSpecTemplate template) {
        super();
        this.bindings = bindings;
        this.interceptors = interceptors;
        this.name = name;
        this.serviceAccountName = serviceAccountName;
        this.template = template;
    }

    /**
     * TriggerSpec represents a connection between TriggerSpecBinding, and TriggerSpecTemplate; TriggerSpecBinding provides extracted values for TriggerSpecTemplate to then create resources from.
     */
    @JsonProperty("bindings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TriggerSpecBinding> getBindings() {
        return bindings;
    }

    /**
     * TriggerSpec represents a connection between TriggerSpecBinding, and TriggerSpecTemplate; TriggerSpecBinding provides extracted values for TriggerSpecTemplate to then create resources from.
     */
    @JsonProperty("bindings")
    public void setBindings(List<TriggerSpecBinding> bindings) {
        this.bindings = bindings;
    }

    /**
     * TriggerSpec represents a connection between TriggerSpecBinding, and TriggerSpecTemplate; TriggerSpecBinding provides extracted values for TriggerSpecTemplate to then create resources from.
     */
    @JsonProperty("interceptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TriggerInterceptor> getInterceptors() {
        return interceptors;
    }

    /**
     * TriggerSpec represents a connection between TriggerSpecBinding, and TriggerSpecTemplate; TriggerSpecBinding provides extracted values for TriggerSpecTemplate to then create resources from.
     */
    @JsonProperty("interceptors")
    public void setInterceptors(List<TriggerInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    /**
     * TriggerSpec represents a connection between TriggerSpecBinding, and TriggerSpecTemplate; TriggerSpecBinding provides extracted values for TriggerSpecTemplate to then create resources from.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * TriggerSpec represents a connection between TriggerSpecBinding, and TriggerSpecTemplate; TriggerSpecBinding provides extracted values for TriggerSpecTemplate to then create resources from.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ServiceAccountName optionally associates credentials with each trigger; Unlike EventListeners, this should be scoped to the same namespace as the Trigger itself
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName optionally associates credentials with each trigger; Unlike EventListeners, this should be scoped to the same namespace as the Trigger itself
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * TriggerSpec represents a connection between TriggerSpecBinding, and TriggerSpecTemplate; TriggerSpecBinding provides extracted values for TriggerSpecTemplate to then create resources from.
     */
    @JsonProperty("template")
    public TriggerSpecTemplate getTemplate() {
        return template;
    }

    /**
     * TriggerSpec represents a connection between TriggerSpecBinding, and TriggerSpecTemplate; TriggerSpecBinding provides extracted values for TriggerSpecTemplate to then create resources from.
     */
    @JsonProperty("template")
    public void setTemplate(TriggerSpecTemplate template) {
        this.template = template;
    }

    @JsonIgnore
    public TriggerSpecBuilder edit() {
        return new TriggerSpecBuilder(this);
    }

    @JsonIgnore
    public TriggerSpecBuilder toBuilder() {
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
        if (!(o instanceof TriggerSpec)) {
            return false;
        }
        TriggerSpec other = (TriggerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bindings = this.getBindings();
        Object other$bindings = other.getBindings();
        if (this$bindings == null ? other$bindings != null : !this$bindings.equals(other$bindings)) {
            return false;
        }
        Object this$interceptors = this.getInterceptors();
        Object other$interceptors = other.getInterceptors();
        if (this$interceptors == null ? other$interceptors != null : !this$interceptors.equals(other$interceptors)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
            return false;
        }
        Object this$template = this.getTemplate();
        Object other$template = other.getTemplate();
        if (this$template == null ? other$template != null : !this$template.equals(other$template)) {
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
        return other instanceof TriggerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bindings = this.getBindings();
        result = result * prime + ($bindings == null ? 43 : $bindings.hashCode());
        Object $interceptors = this.getInterceptors();
        result = result * prime + ($interceptors == null ? 43 : $interceptors.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $template = this.getTemplate();
        result = result * prime + ($template == null ? 43 : $template.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TriggerSpec(" + "bindings=" + this.getBindings() + ", interceptors=" + this.getInterceptors() + ", name=" + this.getName() + ", serviceAccountName=" + this.getServiceAccountName() + ", template=" + this.getTemplate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
