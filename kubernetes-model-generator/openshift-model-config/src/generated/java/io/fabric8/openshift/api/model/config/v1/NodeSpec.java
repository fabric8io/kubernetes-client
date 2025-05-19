
package io.fabric8.openshift.api.model.config.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cgroupMode",
    "minimumKubeletVersion",
    "workerLatencyProfile"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeSpec implements Editable<NodeSpecBuilder>, KubernetesResource
{

    @JsonProperty("cgroupMode")
    private String cgroupMode;
    @JsonProperty("minimumKubeletVersion")
    private String minimumKubeletVersion;
    @JsonProperty("workerLatencyProfile")
    private String workerLatencyProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeSpec() {
    }

    public NodeSpec(String cgroupMode, String minimumKubeletVersion, String workerLatencyProfile) {
        super();
        this.cgroupMode = cgroupMode;
        this.minimumKubeletVersion = minimumKubeletVersion;
        this.workerLatencyProfile = workerLatencyProfile;
    }

    /**
     * CgroupMode determines the cgroups version on the node
     */
    @JsonProperty("cgroupMode")
    public String getCgroupMode() {
        return cgroupMode;
    }

    /**
     * CgroupMode determines the cgroups version on the node
     */
    @JsonProperty("cgroupMode")
    public void setCgroupMode(String cgroupMode) {
        this.cgroupMode = cgroupMode;
    }

    /**
     * minimumKubeletVersion is the lowest version of a kubelet that can join the cluster. Specifically, the apiserver will deny most authorization requests of kubelets that are older than the specified version, only allowing the kubelet to get and update its node object, and perform subjectaccessreviews. This means any kubelet that attempts to join the cluster will not be able to run any assigned workloads, and will eventually be marked as not ready. Its max length is 8, so maximum version allowed is either "9.999.99" or "99.99.99". Since the kubelet reports the version of the kubernetes release, not Openshift, this field references the underlying kubernetes version this version of Openshift is based off of. In other words: if an admin wishes to ensure no nodes run an older version than Openshift 4.17, then they should set the minimumKubeletVersion to 1.30.0. When comparing versions, the kubelet's version is stripped of any contents outside of major.minor.patch version. Thus, a kubelet with version "1.0.0-ec.0" will be compatible with minimumKubeletVersion "1.0.0" or earlier.
     */
    @JsonProperty("minimumKubeletVersion")
    public String getMinimumKubeletVersion() {
        return minimumKubeletVersion;
    }

    /**
     * minimumKubeletVersion is the lowest version of a kubelet that can join the cluster. Specifically, the apiserver will deny most authorization requests of kubelets that are older than the specified version, only allowing the kubelet to get and update its node object, and perform subjectaccessreviews. This means any kubelet that attempts to join the cluster will not be able to run any assigned workloads, and will eventually be marked as not ready. Its max length is 8, so maximum version allowed is either "9.999.99" or "99.99.99". Since the kubelet reports the version of the kubernetes release, not Openshift, this field references the underlying kubernetes version this version of Openshift is based off of. In other words: if an admin wishes to ensure no nodes run an older version than Openshift 4.17, then they should set the minimumKubeletVersion to 1.30.0. When comparing versions, the kubelet's version is stripped of any contents outside of major.minor.patch version. Thus, a kubelet with version "1.0.0-ec.0" will be compatible with minimumKubeletVersion "1.0.0" or earlier.
     */
    @JsonProperty("minimumKubeletVersion")
    public void setMinimumKubeletVersion(String minimumKubeletVersion) {
        this.minimumKubeletVersion = minimumKubeletVersion;
    }

    /**
     * WorkerLatencyProfile determins the how fast the kubelet is updating the status and corresponding reaction of the cluster
     */
    @JsonProperty("workerLatencyProfile")
    public String getWorkerLatencyProfile() {
        return workerLatencyProfile;
    }

    /**
     * WorkerLatencyProfile determins the how fast the kubelet is updating the status and corresponding reaction of the cluster
     */
    @JsonProperty("workerLatencyProfile")
    public void setWorkerLatencyProfile(String workerLatencyProfile) {
        this.workerLatencyProfile = workerLatencyProfile;
    }

    @JsonIgnore
    public NodeSpecBuilder edit() {
        return new NodeSpecBuilder(this);
    }

    @JsonIgnore
    public NodeSpecBuilder toBuilder() {
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
