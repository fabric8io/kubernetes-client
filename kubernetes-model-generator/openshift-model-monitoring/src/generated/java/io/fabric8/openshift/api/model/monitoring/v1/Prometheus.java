
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * The `Prometheus` custom resource definition (CRD) defines a desired [Prometheus](https://prometheus.io/docs/prometheus) setup to run in a Kubernetes cluster. It allows to specify many options such as the number of replicas, persistent storage, and Alertmanagers where firing alerts should be sent and many more.<br><p> <br><p> For each `Prometheus` resource, the Operator deploys one or several `StatefulSet` objects in the same namespace. The number of StatefulSets is equal to the number of shards which is 1 by default.<br><p> <br><p> The resource defines via label and namespace selectors which `ServiceMonitor`, `PodMonitor`, `Probe` and `PrometheusRule` objects should be associated to the deployed Prometheus instances.<br><p> <br><p> The Operator continuously reconciles the scrape and rules configuration and a sidecar container running in the Prometheus pods triggers a reload of the configuration when needed.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Version("v1")
@Group("monitoring.coreos.com")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Prometheus implements Editable<PrometheusBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "monitoring.coreos.com/v1";
    @JsonProperty("kind")
    private String kind = "Prometheus";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private PrometheusSpec spec;
    @JsonProperty("status")
    private PrometheusStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Prometheus() {
    }

    public Prometheus(String apiVersion, String kind, ObjectMeta metadata, PrometheusSpec spec, PrometheusStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * The `Prometheus` custom resource definition (CRD) defines a desired [Prometheus](https://prometheus.io/docs/prometheus) setup to run in a Kubernetes cluster. It allows to specify many options such as the number of replicas, persistent storage, and Alertmanagers where firing alerts should be sent and many more.<br><p> <br><p> For each `Prometheus` resource, the Operator deploys one or several `StatefulSet` objects in the same namespace. The number of StatefulSets is equal to the number of shards which is 1 by default.<br><p> <br><p> The resource defines via label and namespace selectors which `ServiceMonitor`, `PodMonitor`, `Probe` and `PrometheusRule` objects should be associated to the deployed Prometheus instances.<br><p> <br><p> The Operator continuously reconciles the scrape and rules configuration and a sidecar container running in the Prometheus pods triggers a reload of the configuration when needed.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * The `Prometheus` custom resource definition (CRD) defines a desired [Prometheus](https://prometheus.io/docs/prometheus) setup to run in a Kubernetes cluster. It allows to specify many options such as the number of replicas, persistent storage, and Alertmanagers where firing alerts should be sent and many more.<br><p> <br><p> For each `Prometheus` resource, the Operator deploys one or several `StatefulSet` objects in the same namespace. The number of StatefulSets is equal to the number of shards which is 1 by default.<br><p> <br><p> The resource defines via label and namespace selectors which `ServiceMonitor`, `PodMonitor`, `Probe` and `PrometheusRule` objects should be associated to the deployed Prometheus instances.<br><p> <br><p> The Operator continuously reconciles the scrape and rules configuration and a sidecar container running in the Prometheus pods triggers a reload of the configuration when needed.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * The `Prometheus` custom resource definition (CRD) defines a desired [Prometheus](https://prometheus.io/docs/prometheus) setup to run in a Kubernetes cluster. It allows to specify many options such as the number of replicas, persistent storage, and Alertmanagers where firing alerts should be sent and many more.<br><p> <br><p> For each `Prometheus` resource, the Operator deploys one or several `StatefulSet` objects in the same namespace. The number of StatefulSets is equal to the number of shards which is 1 by default.<br><p> <br><p> The resource defines via label and namespace selectors which `ServiceMonitor`, `PodMonitor`, `Probe` and `PrometheusRule` objects should be associated to the deployed Prometheus instances.<br><p> <br><p> The Operator continuously reconciles the scrape and rules configuration and a sidecar container running in the Prometheus pods triggers a reload of the configuration when needed.
     */
    @JsonProperty("spec")
    public PrometheusSpec getSpec() {
        return spec;
    }

    /**
     * The `Prometheus` custom resource definition (CRD) defines a desired [Prometheus](https://prometheus.io/docs/prometheus) setup to run in a Kubernetes cluster. It allows to specify many options such as the number of replicas, persistent storage, and Alertmanagers where firing alerts should be sent and many more.<br><p> <br><p> For each `Prometheus` resource, the Operator deploys one or several `StatefulSet` objects in the same namespace. The number of StatefulSets is equal to the number of shards which is 1 by default.<br><p> <br><p> The resource defines via label and namespace selectors which `ServiceMonitor`, `PodMonitor`, `Probe` and `PrometheusRule` objects should be associated to the deployed Prometheus instances.<br><p> <br><p> The Operator continuously reconciles the scrape and rules configuration and a sidecar container running in the Prometheus pods triggers a reload of the configuration when needed.
     */
    @JsonProperty("spec")
    public void setSpec(PrometheusSpec spec) {
        this.spec = spec;
    }

    /**
     * The `Prometheus` custom resource definition (CRD) defines a desired [Prometheus](https://prometheus.io/docs/prometheus) setup to run in a Kubernetes cluster. It allows to specify many options such as the number of replicas, persistent storage, and Alertmanagers where firing alerts should be sent and many more.<br><p> <br><p> For each `Prometheus` resource, the Operator deploys one or several `StatefulSet` objects in the same namespace. The number of StatefulSets is equal to the number of shards which is 1 by default.<br><p> <br><p> The resource defines via label and namespace selectors which `ServiceMonitor`, `PodMonitor`, `Probe` and `PrometheusRule` objects should be associated to the deployed Prometheus instances.<br><p> <br><p> The Operator continuously reconciles the scrape and rules configuration and a sidecar container running in the Prometheus pods triggers a reload of the configuration when needed.
     */
    @JsonProperty("status")
    public PrometheusStatus getStatus() {
        return status;
    }

    /**
     * The `Prometheus` custom resource definition (CRD) defines a desired [Prometheus](https://prometheus.io/docs/prometheus) setup to run in a Kubernetes cluster. It allows to specify many options such as the number of replicas, persistent storage, and Alertmanagers where firing alerts should be sent and many more.<br><p> <br><p> For each `Prometheus` resource, the Operator deploys one or several `StatefulSet` objects in the same namespace. The number of StatefulSets is equal to the number of shards which is 1 by default.<br><p> <br><p> The resource defines via label and namespace selectors which `ServiceMonitor`, `PodMonitor`, `Probe` and `PrometheusRule` objects should be associated to the deployed Prometheus instances.<br><p> <br><p> The Operator continuously reconciles the scrape and rules configuration and a sidecar container running in the Prometheus pods triggers a reload of the configuration when needed.
     */
    @JsonProperty("status")
    public void setStatus(PrometheusStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public PrometheusBuilder edit() {
        return new PrometheusBuilder(this);
    }

    @JsonIgnore
    public PrometheusBuilder toBuilder() {
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
        if (!(o instanceof Prometheus)) {
            return false;
        }
        Prometheus other = (Prometheus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$spec = this.getSpec();
        Object other$spec = other.getSpec();
        if (this$spec == null ? other$spec != null : !this$spec.equals(other$spec)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
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
        return other instanceof Prometheus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $spec = this.getSpec();
        result = result * prime + ($spec == null ? 43 : $spec.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Prometheus(" + "apiVersion=" + this.getApiVersion() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", spec=" + this.getSpec() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
