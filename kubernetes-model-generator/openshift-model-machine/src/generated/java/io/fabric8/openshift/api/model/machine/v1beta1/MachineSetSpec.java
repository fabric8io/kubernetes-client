
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * MachineSetSpec defines the desired state of MachineSet
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authoritativeAPI",
    "deletePolicy",
    "minReadySeconds",
    "replicas",
    "selector",
    "template"
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
public class MachineSetSpec implements Editable<MachineSetSpecBuilder>, KubernetesResource
{

    @JsonProperty("authoritativeAPI")
    private String authoritativeAPI;
    @JsonProperty("deletePolicy")
    private String deletePolicy;
    @JsonProperty("minReadySeconds")
    private Integer minReadySeconds;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("template")
    private MachineTemplateSpec template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineSetSpec() {
    }

    public MachineSetSpec(String authoritativeAPI, String deletePolicy, Integer minReadySeconds, Integer replicas, LabelSelector selector, MachineTemplateSpec template) {
        super();
        this.authoritativeAPI = authoritativeAPI;
        this.deletePolicy = deletePolicy;
        this.minReadySeconds = minReadySeconds;
        this.replicas = replicas;
        this.selector = selector;
        this.template = template;
    }

    /**
     * authoritativeAPI is the API that is authoritative for this resource. Valid values are MachineAPI and ClusterAPI. When set to MachineAPI, writes to the spec of the machine.openshift.io copy of this resource will be reflected into the cluster.x-k8s.io copy. When set to ClusterAPI, writes to the spec of the cluster.x-k8s.io copy of this resource will be reflected into the machine.openshift.io copy. Updates to the status will be reflected in both copies of the resource, based on the controller implementing the functionality of the API. Currently the authoritative API determines which controller will manage the resource, this will change in a future release. To ensure the change has been accepted, please verify that the `status.authoritativeAPI` field has been updated to the desired value and that the `Synchronized` condition is present and set to `True`.
     */
    @JsonProperty("authoritativeAPI")
    public String getAuthoritativeAPI() {
        return authoritativeAPI;
    }

    /**
     * authoritativeAPI is the API that is authoritative for this resource. Valid values are MachineAPI and ClusterAPI. When set to MachineAPI, writes to the spec of the machine.openshift.io copy of this resource will be reflected into the cluster.x-k8s.io copy. When set to ClusterAPI, writes to the spec of the cluster.x-k8s.io copy of this resource will be reflected into the machine.openshift.io copy. Updates to the status will be reflected in both copies of the resource, based on the controller implementing the functionality of the API. Currently the authoritative API determines which controller will manage the resource, this will change in a future release. To ensure the change has been accepted, please verify that the `status.authoritativeAPI` field has been updated to the desired value and that the `Synchronized` condition is present and set to `True`.
     */
    @JsonProperty("authoritativeAPI")
    public void setAuthoritativeAPI(String authoritativeAPI) {
        this.authoritativeAPI = authoritativeAPI;
    }

    /**
     * DeletePolicy defines the policy used to identify nodes to delete when downscaling. Defaults to "Random".  Valid values are "Random, "Newest", "Oldest"
     */
    @JsonProperty("deletePolicy")
    public String getDeletePolicy() {
        return deletePolicy;
    }

    /**
     * DeletePolicy defines the policy used to identify nodes to delete when downscaling. Defaults to "Random".  Valid values are "Random, "Newest", "Oldest"
     */
    @JsonProperty("deletePolicy")
    public void setDeletePolicy(String deletePolicy) {
        this.deletePolicy = deletePolicy;
    }

    /**
     * MinReadySeconds is the minimum number of seconds for which a newly created machine should be ready. Defaults to 0 (machine will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public Integer getMinReadySeconds() {
        return minReadySeconds;
    }

    /**
     * MinReadySeconds is the minimum number of seconds for which a newly created machine should be ready. Defaults to 0 (machine will be considered available as soon as it is ready)
     */
    @JsonProperty("minReadySeconds")
    public void setMinReadySeconds(Integer minReadySeconds) {
        this.minReadySeconds = minReadySeconds;
    }

    /**
     * Replicas is the number of desired replicas. This is a pointer to distinguish between explicit zero and unspecified. Defaults to 1.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas is the number of desired replicas. This is a pointer to distinguish between explicit zero and unspecified. Defaults to 1.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet
     */
    @JsonProperty("template")
    public MachineTemplateSpec getTemplate() {
        return template;
    }

    /**
     * MachineSetSpec defines the desired state of MachineSet
     */
    @JsonProperty("template")
    public void setTemplate(MachineTemplateSpec template) {
        this.template = template;
    }

    @JsonIgnore
    public MachineSetSpecBuilder edit() {
        return new MachineSetSpecBuilder(this);
    }

    @JsonIgnore
    public MachineSetSpecBuilder toBuilder() {
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
