
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

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
 * K8SSelectorConfig is Kubernetes Selector Config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "field",
    "label",
    "role"
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
public class K8SSelectorConfig implements Editable<K8SSelectorConfigBuilder>, KubernetesResource
{

    @JsonProperty("field")
    private String field;
    @JsonProperty("label")
    private String label;
    @JsonProperty("role")
    private String role;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public K8SSelectorConfig() {
    }

    public K8SSelectorConfig(String field, String label, String role) {
        super();
        this.field = field;
        this.label = label;
        this.role = role;
    }

    /**
     * field defines an optional field selector to limit the service discovery to resources which have fields with specific values. e.g: `metadata.name=foobar`
     */
    @JsonProperty("field")
    public String getField() {
        return field;
    }

    /**
     * field defines an optional field selector to limit the service discovery to resources which have fields with specific values. e.g: `metadata.name=foobar`
     */
    @JsonProperty("field")
    public void setField(String field) {
        this.field = field;
    }

    /**
     * label defines an optional label selector to limit the service discovery to resources with specific labels and label values. e.g: `node.kubernetes.io/instance-type=master`
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * label defines an optional label selector to limit the service discovery to resources with specific labels and label values. e.g: `node.kubernetes.io/instance-type=master`
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * role defines the type of Kubernetes resource to limit the service discovery to. Accepted values are: Node, Pod, Endpoints, EndpointSlice, Service, Ingress.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * role defines the type of Kubernetes resource to limit the service discovery to. Accepted values are: Node, Pod, Endpoints, EndpointSlice, Service, Ingress.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonIgnore
    public K8SSelectorConfigBuilder edit() {
        return new K8SSelectorConfigBuilder(this);
    }

    @JsonIgnore
    public K8SSelectorConfigBuilder toBuilder() {
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
        if (!(o instanceof K8SSelectorConfig)) {
            return false;
        }
        K8SSelectorConfig other = (K8SSelectorConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$field = this.getField();
        Object other$field = other.getField();
        if (this$field == null ? other$field != null : !this$field.equals(other$field)) {
            return false;
        }
        Object this$label = this.getLabel();
        Object other$label = other.getLabel();
        if (this$label == null ? other$label != null : !this$label.equals(other$label)) {
            return false;
        }
        Object this$role = this.getRole();
        Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) {
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
        return other instanceof K8SSelectorConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $field = this.getField();
        result = result * prime + ($field == null ? 43 : $field.hashCode());
        Object $label = this.getLabel();
        result = result * prime + ($label == null ? 43 : $label.hashCode());
        Object $role = this.getRole();
        result = result * prime + ($role == null ? 43 : $role.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "K8SSelectorConfig(" + "field=" + this.getField() + ", label=" + this.getLabel() + ", role=" + this.getRole() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
