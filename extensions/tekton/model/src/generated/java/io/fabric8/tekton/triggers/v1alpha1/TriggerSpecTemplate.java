
package io.fabric8.tekton.triggers.v1alpha1;

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

/**
 * EventListenerTemplate refers to a particular TriggerTemplate resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiversion",
    "ref",
    "spec"
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
public class TriggerSpecTemplate implements Editable<TriggerSpecTemplateBuilder>, KubernetesResource
{

    @JsonProperty("apiversion")
    private String apiversion;
    @JsonProperty("ref")
    private String ref;
    @JsonProperty("spec")
    private TriggerTemplateSpec spec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TriggerSpecTemplate() {
    }

    public TriggerSpecTemplate(String apiversion, String ref, TriggerTemplateSpec spec) {
        super();
        this.apiversion = apiversion;
        this.ref = ref;
        this.spec = spec;
    }

    /**
     * EventListenerTemplate refers to a particular TriggerTemplate resource.
     */
    @JsonProperty("apiversion")
    public String getApiversion() {
        return apiversion;
    }

    /**
     * EventListenerTemplate refers to a particular TriggerTemplate resource.
     */
    @JsonProperty("apiversion")
    public void setApiversion(String apiversion) {
        this.apiversion = apiversion;
    }

    /**
     * EventListenerTemplate refers to a particular TriggerTemplate resource.
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * EventListenerTemplate refers to a particular TriggerTemplate resource.
     */
    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * EventListenerTemplate refers to a particular TriggerTemplate resource.
     */
    @JsonProperty("spec")
    public TriggerTemplateSpec getSpec() {
        return spec;
    }

    /**
     * EventListenerTemplate refers to a particular TriggerTemplate resource.
     */
    @JsonProperty("spec")
    public void setSpec(TriggerTemplateSpec spec) {
        this.spec = spec;
    }

    @JsonIgnore
    public TriggerSpecTemplateBuilder edit() {
        return new TriggerSpecTemplateBuilder(this);
    }

    @JsonIgnore
    public TriggerSpecTemplateBuilder toBuilder() {
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
        if (!(o instanceof TriggerSpecTemplate)) {
            return false;
        }
        TriggerSpecTemplate other = (TriggerSpecTemplate) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiversion = this.getApiversion();
        Object other$apiversion = other.getApiversion();
        if (this$apiversion == null ? other$apiversion != null : !this$apiversion.equals(other$apiversion)) {
            return false;
        }
        Object this$ref = this.getRef();
        Object other$ref = other.getRef();
        if (this$ref == null ? other$ref != null : !this$ref.equals(other$ref)) {
            return false;
        }
        Object this$spec = this.getSpec();
        Object other$spec = other.getSpec();
        if (this$spec == null ? other$spec != null : !this$spec.equals(other$spec)) {
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
        return other instanceof TriggerSpecTemplate;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiversion = this.getApiversion();
        result = result * prime + ($apiversion == null ? 43 : $apiversion.hashCode());
        Object $ref = this.getRef();
        result = result * prime + ($ref == null ? 43 : $ref.hashCode());
        Object $spec = this.getSpec();
        result = result * prime + ($spec == null ? 43 : $spec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TriggerSpecTemplate(" + "apiversion=" + this.getApiversion() + ", ref=" + this.getRef() + ", spec=" + this.getSpec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
