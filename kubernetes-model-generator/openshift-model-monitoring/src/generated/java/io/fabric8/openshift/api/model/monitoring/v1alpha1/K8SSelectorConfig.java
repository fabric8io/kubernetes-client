
package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
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
     * An optional field selector to limit the service discovery to resources which have fields with specific values. e.g: `metadata.name=foobar`
     */
    @JsonProperty("field")
    public String getField() {
        return field;
    }

    /**
     * An optional field selector to limit the service discovery to resources which have fields with specific values. e.g: `metadata.name=foobar`
     */
    @JsonProperty("field")
    public void setField(String field) {
        this.field = field;
    }

    /**
     * An optional label selector to limit the service discovery to resources with specific labels and label values. e.g: `node.kubernetes.io/instance-type=master`
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * An optional label selector to limit the service discovery to resources with specific labels and label values. e.g: `node.kubernetes.io/instance-type=master`
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Role specifies the type of Kubernetes resource to limit the service discovery to. Accepted values are: Node, Pod, Endpoints, EndpointSlice, Service, Ingress.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Role specifies the type of Kubernetes resource to limit the service discovery to. Accepted values are: Node, Pod, Endpoints, EndpointSlice, Service, Ingress.
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
