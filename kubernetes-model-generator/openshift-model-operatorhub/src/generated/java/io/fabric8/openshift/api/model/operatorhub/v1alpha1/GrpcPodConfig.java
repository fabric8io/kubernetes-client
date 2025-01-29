
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.Affinity;
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * GrpcPodConfig contains configuration specified for a catalog source
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affinity",
    "extractContent",
    "memoryTarget",
    "nodeSelector",
    "priorityClassName",
    "securityContextConfig",
    "tolerations"
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
public class GrpcPodConfig implements Editable<GrpcPodConfigBuilder>, KubernetesResource
{

    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("extractContent")
    private ExtractContentConfig extractContent;
    @JsonProperty("memoryTarget")
    private Quantity memoryTarget;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("securityContextConfig")
    private String securityContextConfig;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GrpcPodConfig() {
    }

    public GrpcPodConfig(Affinity affinity, ExtractContentConfig extractContent, Quantity memoryTarget, Map<String, String> nodeSelector, String priorityClassName, String securityContextConfig, List<Toleration> tolerations) {
        super();
        this.affinity = affinity;
        this.extractContent = extractContent;
        this.memoryTarget = memoryTarget;
        this.nodeSelector = nodeSelector;
        this.priorityClassName = priorityClassName;
        this.securityContextConfig = securityContextConfig;
        this.tolerations = tolerations;
    }

    /**
     * GrpcPodConfig contains configuration specified for a catalog source
     */
    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    /**
     * GrpcPodConfig contains configuration specified for a catalog source
     */
    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    /**
     * GrpcPodConfig contains configuration specified for a catalog source
     */
    @JsonProperty("extractContent")
    public ExtractContentConfig getExtractContent() {
        return extractContent;
    }

    /**
     * GrpcPodConfig contains configuration specified for a catalog source
     */
    @JsonProperty("extractContent")
    public void setExtractContent(ExtractContentConfig extractContent) {
        this.extractContent = extractContent;
    }

    /**
     * GrpcPodConfig contains configuration specified for a catalog source
     */
    @JsonProperty("memoryTarget")
    public Quantity getMemoryTarget() {
        return memoryTarget;
    }

    /**
     * GrpcPodConfig contains configuration specified for a catalog source
     */
    @JsonProperty("memoryTarget")
    public void setMemoryTarget(Quantity memoryTarget) {
        this.memoryTarget = memoryTarget;
    }

    /**
     * NodeSelector is a selector which must be true for the pod to fit on a node. Selector which must match a node's labels for the pod to be scheduled on that node.
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * NodeSelector is a selector which must be true for the pod to fit on a node. Selector which must match a node's labels for the pod to be scheduled on that node.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * If specified, indicates the pod's priority. If not specified, the pod priority will be default or zero if there is no default.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * If specified, indicates the pod's priority. If not specified, the pod priority will be default or zero if there is no default.
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * SecurityContextConfig can be one of `legacy` or `restricted`. The CatalogSource's pod is either injected with the right pod.spec.securityContext and pod.spec.container[&#42;].securityContext values to allow the pod to run in Pod Security Admission (PSA) `restricted` mode, or doesn't set these values at all, in which case the pod can only be run in PSA `baseline` or `privileged` namespaces. If the SecurityContextConfig is unspecified, the mode will be determined by the namespace's PSA configuration. If the namespace is enforcing `restricted` mode, then the pod will be configured as if `restricted` was specified. Otherwise, it will be configured as if `legacy` was specified. Specifying a value other than `legacy` or `restricted` result in a validation error. When using older catalog images, which can not run in `restricted` mode, the SecurityContextConfig should be set to `legacy`.<br><p> <br><p> More information about PSA can be found here: https://kubernetes.io/docs/concepts/security/pod-security-admission/'
     */
    @JsonProperty("securityContextConfig")
    public String getSecurityContextConfig() {
        return securityContextConfig;
    }

    /**
     * SecurityContextConfig can be one of `legacy` or `restricted`. The CatalogSource's pod is either injected with the right pod.spec.securityContext and pod.spec.container[&#42;].securityContext values to allow the pod to run in Pod Security Admission (PSA) `restricted` mode, or doesn't set these values at all, in which case the pod can only be run in PSA `baseline` or `privileged` namespaces. If the SecurityContextConfig is unspecified, the mode will be determined by the namespace's PSA configuration. If the namespace is enforcing `restricted` mode, then the pod will be configured as if `restricted` was specified. Otherwise, it will be configured as if `legacy` was specified. Specifying a value other than `legacy` or `restricted` result in a validation error. When using older catalog images, which can not run in `restricted` mode, the SecurityContextConfig should be set to `legacy`.<br><p> <br><p> More information about PSA can be found here: https://kubernetes.io/docs/concepts/security/pod-security-admission/'
     */
    @JsonProperty("securityContextConfig")
    public void setSecurityContextConfig(String securityContextConfig) {
        this.securityContextConfig = securityContextConfig;
    }

    /**
     * Tolerations are the catalog source's pod's tolerations.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * Tolerations are the catalog source's pod's tolerations.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonIgnore
    public GrpcPodConfigBuilder edit() {
        return new GrpcPodConfigBuilder(this);
    }

    @JsonIgnore
    public GrpcPodConfigBuilder toBuilder() {
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
