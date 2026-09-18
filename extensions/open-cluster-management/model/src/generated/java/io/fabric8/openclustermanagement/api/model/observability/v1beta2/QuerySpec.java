
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
 * Thanos Query Spec.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containers",
    "replicas",
    "resources",
    "serviceAccountAnnotations",
    "usePrometheusEngine"
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
public class QuerySpec implements Editable<QuerySpecBuilder>, KubernetesResource
{

    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Container> containers = new ArrayList<>();
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("serviceAccountAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> serviceAccountAnnotations = new LinkedHashMap<>();
    @JsonProperty("usePrometheusEngine")
    private Boolean usePrometheusEngine;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public QuerySpec() {
    }

    public QuerySpec(List<Container> containers, Integer replicas, ResourceRequirements resources, Map<String, String> serviceAccountAnnotations, Boolean usePrometheusEngine) {
        super();
        this.containers = containers;
        this.replicas = replicas;
        this.resources = resources;
        this.serviceAccountAnnotations = serviceAccountAnnotations;
        this.usePrometheusEngine = usePrometheusEngine;
    }

    /**
     * WARNING: Use only with guidance from Red Hat Support. Using this feature incorrectly can lead to an unrecoverable state, data loss, or both, which is not covered by Red Hat Support.
     */
    @JsonProperty("containers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Container> getContainers() {
        return containers;
    }

    /**
     * WARNING: Use only with guidance from Red Hat Support. Using this feature incorrectly can lead to an unrecoverable state, data loss, or both, which is not covered by Red Hat Support.
     */
    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    /**
     * Replicas for this component.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas for this component.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * Thanos Query Spec.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * Thanos Query Spec.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * Annotations is an unstructured key value map stored with a service account
     */
    @JsonProperty("serviceAccountAnnotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getServiceAccountAnnotations() {
        return serviceAccountAnnotations;
    }

    /**
     * Annotations is an unstructured key value map stored with a service account
     */
    @JsonProperty("serviceAccountAnnotations")
    public void setServiceAccountAnnotations(Map<String, String> serviceAccountAnnotations) {
        this.serviceAccountAnnotations = serviceAccountAnnotations;
    }

    /**
     * Set to true to use the old Prometheus engine for PromQL queries.
     */
    @JsonProperty("usePrometheusEngine")
    public Boolean getUsePrometheusEngine() {
        return usePrometheusEngine;
    }

    /**
     * Set to true to use the old Prometheus engine for PromQL queries.
     */
    @JsonProperty("usePrometheusEngine")
    public void setUsePrometheusEngine(Boolean usePrometheusEngine) {
        this.usePrometheusEngine = usePrometheusEngine;
    }

    @JsonIgnore
    public QuerySpecBuilder edit() {
        return new QuerySpecBuilder(this);
    }

    @JsonIgnore
    public QuerySpecBuilder toBuilder() {
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
        if (!(o instanceof QuerySpec)) {
            return false;
        }
        QuerySpec other = (QuerySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containers = this.getContainers();
        Object other$containers = other.getContainers();
        if (this$containers == null ? other$containers != null : !this$containers.equals(other$containers)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$serviceAccountAnnotations = this.getServiceAccountAnnotations();
        Object other$serviceAccountAnnotations = other.getServiceAccountAnnotations();
        if (this$serviceAccountAnnotations == null ? other$serviceAccountAnnotations != null : !this$serviceAccountAnnotations.equals(other$serviceAccountAnnotations)) {
            return false;
        }
        Object this$usePrometheusEngine = this.getUsePrometheusEngine();
        Object other$usePrometheusEngine = other.getUsePrometheusEngine();
        if (this$usePrometheusEngine == null ? other$usePrometheusEngine != null : !this$usePrometheusEngine.equals(other$usePrometheusEngine)) {
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
        return other instanceof QuerySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containers = this.getContainers();
        result = result * prime + ($containers == null ? 43 : $containers.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $serviceAccountAnnotations = this.getServiceAccountAnnotations();
        result = result * prime + ($serviceAccountAnnotations == null ? 43 : $serviceAccountAnnotations.hashCode());
        Object $usePrometheusEngine = this.getUsePrometheusEngine();
        result = result * prime + ($usePrometheusEngine == null ? 43 : $usePrometheusEngine.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "QuerySpec(" + "containers=" + this.getContainers() + ", replicas=" + this.getReplicas() + ", resources=" + this.getResources() + ", serviceAccountAnnotations=" + this.getServiceAccountAnnotations() + ", usePrometheusEngine=" + this.getUsePrometheusEngine() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
