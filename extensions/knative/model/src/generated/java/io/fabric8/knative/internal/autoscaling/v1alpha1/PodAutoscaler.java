
package io.fabric8.knative.internal.autoscaling.v1alpha1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PodAutoscaler is a Knative abstraction that encapsulates the interface by which Knative components instantiate autoscalers.  This definition is an abstraction that may be backed by multiple definitions.  For more information, see the Knative Pluggability presentation: https://docs.google.com/presentation/d/19vW9HFZ6Puxt31biNZF3uLRejDmu82rxJIk1cWmxF7w/edit
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
@Group("autoscaling.internal.knative.dev")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodAutoscaler implements Editable<PodAutoscalerBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "autoscaling.internal.knative.dev/v1alpha1";
    @JsonProperty("kind")
    private String kind = "PodAutoscaler";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private PodAutoscalerSpec spec;
    @JsonProperty("status")
    private PodAutoscalerStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodAutoscaler() {
    }

    public PodAutoscaler(String apiVersion, String kind, ObjectMeta metadata, PodAutoscalerSpec spec, PodAutoscalerStatus status) {
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
     * PodAutoscaler is a Knative abstraction that encapsulates the interface by which Knative components instantiate autoscalers.  This definition is an abstraction that may be backed by multiple definitions.  For more information, see the Knative Pluggability presentation: https://docs.google.com/presentation/d/19vW9HFZ6Puxt31biNZF3uLRejDmu82rxJIk1cWmxF7w/edit
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * PodAutoscaler is a Knative abstraction that encapsulates the interface by which Knative components instantiate autoscalers.  This definition is an abstraction that may be backed by multiple definitions.  For more information, see the Knative Pluggability presentation: https://docs.google.com/presentation/d/19vW9HFZ6Puxt31biNZF3uLRejDmu82rxJIk1cWmxF7w/edit
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * PodAutoscaler is a Knative abstraction that encapsulates the interface by which Knative components instantiate autoscalers.  This definition is an abstraction that may be backed by multiple definitions.  For more information, see the Knative Pluggability presentation: https://docs.google.com/presentation/d/19vW9HFZ6Puxt31biNZF3uLRejDmu82rxJIk1cWmxF7w/edit
     */
    @JsonProperty("spec")
    public PodAutoscalerSpec getSpec() {
        return spec;
    }

    /**
     * PodAutoscaler is a Knative abstraction that encapsulates the interface by which Knative components instantiate autoscalers.  This definition is an abstraction that may be backed by multiple definitions.  For more information, see the Knative Pluggability presentation: https://docs.google.com/presentation/d/19vW9HFZ6Puxt31biNZF3uLRejDmu82rxJIk1cWmxF7w/edit
     */
    @JsonProperty("spec")
    public void setSpec(PodAutoscalerSpec spec) {
        this.spec = spec;
    }

    /**
     * PodAutoscaler is a Knative abstraction that encapsulates the interface by which Knative components instantiate autoscalers.  This definition is an abstraction that may be backed by multiple definitions.  For more information, see the Knative Pluggability presentation: https://docs.google.com/presentation/d/19vW9HFZ6Puxt31biNZF3uLRejDmu82rxJIk1cWmxF7w/edit
     */
    @JsonProperty("status")
    public PodAutoscalerStatus getStatus() {
        return status;
    }

    /**
     * PodAutoscaler is a Knative abstraction that encapsulates the interface by which Knative components instantiate autoscalers.  This definition is an abstraction that may be backed by multiple definitions.  For more information, see the Knative Pluggability presentation: https://docs.google.com/presentation/d/19vW9HFZ6Puxt31biNZF3uLRejDmu82rxJIk1cWmxF7w/edit
     */
    @JsonProperty("status")
    public void setStatus(PodAutoscalerStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public PodAutoscalerBuilder edit() {
        return new PodAutoscalerBuilder(this);
    }

    @JsonIgnore
    public PodAutoscalerBuilder toBuilder() {
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
