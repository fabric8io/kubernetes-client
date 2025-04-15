
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusStatus;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * The `PrometheusAgent` custom resource definition (CRD) defines a desired [Prometheus Agent](https://prometheus.io/blog/2021/11/16/agent/) setup to run in a Kubernetes cluster.<br><p> <br><p> The CRD is very similar to the `Prometheus` CRD except for features which aren't available in agent mode like rule evaluation, persistent storage and Thanos sidecar.
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1alpha1")
@Group("monitoring.coreos.com")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PrometheusAgent implements Editable<PrometheusAgentBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "monitoring.coreos.com/v1alpha1";
    @JsonProperty("kind")
    private String kind = "PrometheusAgent";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private PrometheusAgentSpec spec;
    @JsonProperty("status")
    private PrometheusStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrometheusAgent() {
    }

    public PrometheusAgent(String apiVersion, String kind, ObjectMeta metadata, PrometheusAgentSpec spec, PrometheusStatus status) {
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
     * The `PrometheusAgent` custom resource definition (CRD) defines a desired [Prometheus Agent](https://prometheus.io/blog/2021/11/16/agent/) setup to run in a Kubernetes cluster.<br><p> <br><p> The CRD is very similar to the `Prometheus` CRD except for features which aren't available in agent mode like rule evaluation, persistent storage and Thanos sidecar.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * The `PrometheusAgent` custom resource definition (CRD) defines a desired [Prometheus Agent](https://prometheus.io/blog/2021/11/16/agent/) setup to run in a Kubernetes cluster.<br><p> <br><p> The CRD is very similar to the `Prometheus` CRD except for features which aren't available in agent mode like rule evaluation, persistent storage and Thanos sidecar.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * The `PrometheusAgent` custom resource definition (CRD) defines a desired [Prometheus Agent](https://prometheus.io/blog/2021/11/16/agent/) setup to run in a Kubernetes cluster.<br><p> <br><p> The CRD is very similar to the `Prometheus` CRD except for features which aren't available in agent mode like rule evaluation, persistent storage and Thanos sidecar.
     */
    @JsonProperty("spec")
    public PrometheusAgentSpec getSpec() {
        return spec;
    }

    /**
     * The `PrometheusAgent` custom resource definition (CRD) defines a desired [Prometheus Agent](https://prometheus.io/blog/2021/11/16/agent/) setup to run in a Kubernetes cluster.<br><p> <br><p> The CRD is very similar to the `Prometheus` CRD except for features which aren't available in agent mode like rule evaluation, persistent storage and Thanos sidecar.
     */
    @JsonProperty("spec")
    public void setSpec(PrometheusAgentSpec spec) {
        this.spec = spec;
    }

    /**
     * The `PrometheusAgent` custom resource definition (CRD) defines a desired [Prometheus Agent](https://prometheus.io/blog/2021/11/16/agent/) setup to run in a Kubernetes cluster.<br><p> <br><p> The CRD is very similar to the `Prometheus` CRD except for features which aren't available in agent mode like rule evaluation, persistent storage and Thanos sidecar.
     */
    @JsonProperty("status")
    public PrometheusStatus getStatus() {
        return status;
    }

    /**
     * The `PrometheusAgent` custom resource definition (CRD) defines a desired [Prometheus Agent](https://prometheus.io/blog/2021/11/16/agent/) setup to run in a Kubernetes cluster.<br><p> <br><p> The CRD is very similar to the `Prometheus` CRD except for features which aren't available in agent mode like rule evaluation, persistent storage and Thanos sidecar.
     */
    @JsonProperty("status")
    public void setStatus(PrometheusStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public PrometheusAgentBuilder edit() {
        return new PrometheusAgentBuilder(this);
    }

    @JsonIgnore
    public PrometheusAgentBuilder toBuilder() {
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
