
package io.fabric8.openshift.api.model.operator.v1alpha1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * ClusterAPISpec defines the desired configuration of the capi-operator. The spec is required but we deliberately allow it to be empty.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "unmanagedCustomResourceDefinitions"
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
public class ClusterAPISpec implements Editable<ClusterAPISpecBuilder>, KubernetesResource
{

    @JsonProperty("unmanagedCustomResourceDefinitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> unmanagedCustomResourceDefinitions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAPISpec() {
    }

    public ClusterAPISpec(List<String> unmanagedCustomResourceDefinitions) {
        super();
        this.unmanagedCustomResourceDefinitions = unmanagedCustomResourceDefinitions;
    }

    /**
     * unmanagedCustomResourceDefinitions is a list of ClusterResourceDefinition (CRD) names that should not be managed by the capi-operator installer controller. This allows external actors to own specific CRDs while capi-operator manages others.<br><p> <br><p> Each CRD name must be a valid DNS-1123 subdomain consisting of lowercase alphanumeric characters, '-' or '.', and must start and end with an alphanumeric character, with a maximum length of 253 characters. CRD names must contain at least two '.' characters. Example: "clusters.cluster.x-k8s.io"<br><p> <br><p> Items cannot be removed from this list once added.<br><p> <br><p> The maximum number of unmanagedCustomResourceDefinitions is 128.
     */
    @JsonProperty("unmanagedCustomResourceDefinitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUnmanagedCustomResourceDefinitions() {
        return unmanagedCustomResourceDefinitions;
    }

    /**
     * unmanagedCustomResourceDefinitions is a list of ClusterResourceDefinition (CRD) names that should not be managed by the capi-operator installer controller. This allows external actors to own specific CRDs while capi-operator manages others.<br><p> <br><p> Each CRD name must be a valid DNS-1123 subdomain consisting of lowercase alphanumeric characters, '-' or '.', and must start and end with an alphanumeric character, with a maximum length of 253 characters. CRD names must contain at least two '.' characters. Example: "clusters.cluster.x-k8s.io"<br><p> <br><p> Items cannot be removed from this list once added.<br><p> <br><p> The maximum number of unmanagedCustomResourceDefinitions is 128.
     */
    @JsonProperty("unmanagedCustomResourceDefinitions")
    public void setUnmanagedCustomResourceDefinitions(List<String> unmanagedCustomResourceDefinitions) {
        this.unmanagedCustomResourceDefinitions = unmanagedCustomResourceDefinitions;
    }

    @JsonIgnore
    public ClusterAPISpecBuilder edit() {
        return new ClusterAPISpecBuilder(this);
    }

    @JsonIgnore
    public ClusterAPISpecBuilder toBuilder() {
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
