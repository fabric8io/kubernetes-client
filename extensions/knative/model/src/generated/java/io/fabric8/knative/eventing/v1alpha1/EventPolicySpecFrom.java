
package io.fabric8.knative.eventing.v1alpha1;

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
    "ref",
    "sub"
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
public class EventPolicySpecFrom implements Editable<EventPolicySpecFromBuilder>, KubernetesResource
{

    @JsonProperty("ref")
    private EventPolicyFromReference ref;
    @JsonProperty("sub")
    private String sub;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EventPolicySpecFrom() {
    }

    public EventPolicySpecFrom(EventPolicyFromReference ref, String sub) {
        super();
        this.ref = ref;
        this.sub = sub;
    }

    @JsonProperty("ref")
    public EventPolicyFromReference getRef() {
        return ref;
    }

    @JsonProperty("ref")
    public void setRef(EventPolicyFromReference ref) {
        this.ref = ref;
    }

    /**
     * Sub sets the OIDC identity name to be allowed to send events to the target. It is also possible to set a glob-like pattern to match any suffix.
     */
    @JsonProperty("sub")
    public String getSub() {
        return sub;
    }

    /**
     * Sub sets the OIDC identity name to be allowed to send events to the target. It is also possible to set a glob-like pattern to match any suffix.
     */
    @JsonProperty("sub")
    public void setSub(String sub) {
        this.sub = sub;
    }

    @JsonIgnore
    public EventPolicySpecFromBuilder edit() {
        return new EventPolicySpecFromBuilder(this);
    }

    @JsonIgnore
    public EventPolicySpecFromBuilder toBuilder() {
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
        if (!(o instanceof EventPolicySpecFrom)) {
            return false;
        }
        EventPolicySpecFrom other = (EventPolicySpecFrom) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ref = this.getRef();
        Object other$ref = other.getRef();
        if (this$ref == null ? other$ref != null : !this$ref.equals(other$ref)) {
            return false;
        }
        Object this$sub = this.getSub();
        Object other$sub = other.getSub();
        if (this$sub == null ? other$sub != null : !this$sub.equals(other$sub)) {
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
        return other instanceof EventPolicySpecFrom;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ref = this.getRef();
        result = result * prime + ($ref == null ? 43 : $ref.hashCode());
        Object $sub = this.getSub();
        result = result * prime + ($sub == null ? 43 : $sub.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EventPolicySpecFrom(" + "ref=" + this.getRef() + ", sub=" + this.getSub() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
