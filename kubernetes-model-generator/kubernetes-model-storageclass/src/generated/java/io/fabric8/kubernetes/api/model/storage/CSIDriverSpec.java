
package io.fabric8.kubernetes.api.model.storage;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * CSIDriverSpec is the specification of a CSIDriver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachRequired",
    "fsGroupPolicy",
    "nodeAllocatableUpdatePeriodSeconds",
    "podInfoOnMount",
    "requiresRepublish",
    "seLinuxMount",
    "storageCapacity",
    "tokenRequests",
    "volumeLifecycleModes"
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
public class CSIDriverSpec implements Editable<CSIDriverSpecBuilder>, KubernetesResource
{

    @JsonProperty("attachRequired")
    private Boolean attachRequired;
    @JsonProperty("fsGroupPolicy")
    private String fsGroupPolicy;
    @JsonProperty("nodeAllocatableUpdatePeriodSeconds")
    private Long nodeAllocatableUpdatePeriodSeconds;
    @JsonProperty("podInfoOnMount")
    private Boolean podInfoOnMount;
    @JsonProperty("requiresRepublish")
    private Boolean requiresRepublish;
    @JsonProperty("seLinuxMount")
    private Boolean seLinuxMount;
    @JsonProperty("storageCapacity")
    private Boolean storageCapacity;
    @JsonProperty("tokenRequests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TokenRequest> tokenRequests = new ArrayList<>();
    @JsonProperty("volumeLifecycleModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> volumeLifecycleModes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CSIDriverSpec() {
    }

    public CSIDriverSpec(Boolean attachRequired, String fsGroupPolicy, Long nodeAllocatableUpdatePeriodSeconds, Boolean podInfoOnMount, Boolean requiresRepublish, Boolean seLinuxMount, Boolean storageCapacity, List<TokenRequest> tokenRequests, List<String> volumeLifecycleModes) {
        super();
        this.attachRequired = attachRequired;
        this.fsGroupPolicy = fsGroupPolicy;
        this.nodeAllocatableUpdatePeriodSeconds = nodeAllocatableUpdatePeriodSeconds;
        this.podInfoOnMount = podInfoOnMount;
        this.requiresRepublish = requiresRepublish;
        this.seLinuxMount = seLinuxMount;
        this.storageCapacity = storageCapacity;
        this.tokenRequests = tokenRequests;
        this.volumeLifecycleModes = volumeLifecycleModes;
    }

    /**
     * attachRequired indicates this CSI volume driver requires an attach operation (because it implements the CSI ControllerPublishVolume() method), and that the Kubernetes attach detach controller should call the attach volume interface which checks the volumeattachment status and waits until the volume is attached before proceeding to mounting. The CSI external-attacher coordinates with CSI volume driver and updates the volumeattachment status when the attach operation is complete. If the value is specified to false, the attach operation will be skipped. Otherwise the attach operation will be called.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("attachRequired")
    public Boolean getAttachRequired() {
        return attachRequired;
    }

    /**
     * attachRequired indicates this CSI volume driver requires an attach operation (because it implements the CSI ControllerPublishVolume() method), and that the Kubernetes attach detach controller should call the attach volume interface which checks the volumeattachment status and waits until the volume is attached before proceeding to mounting. The CSI external-attacher coordinates with CSI volume driver and updates the volumeattachment status when the attach operation is complete. If the value is specified to false, the attach operation will be skipped. Otherwise the attach operation will be called.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("attachRequired")
    public void setAttachRequired(Boolean attachRequired) {
        this.attachRequired = attachRequired;
    }

    /**
     * fsGroupPolicy defines if the underlying volume supports changing ownership and permission of the volume before being mounted. Refer to the specific FSGroupPolicy values for additional details.<br><p> <br><p> This field was immutable in Kubernetes &lt; 1.29 and now is mutable.<br><p> <br><p> Defaults to ReadWriteOnceWithFSType, which will examine each volume to determine if Kubernetes should modify ownership and permissions of the volume. With the default policy the defined fsGroup will only be applied if a fstype is defined and the volume's access mode contains ReadWriteOnce.
     */
    @JsonProperty("fsGroupPolicy")
    public String getFsGroupPolicy() {
        return fsGroupPolicy;
    }

    /**
     * fsGroupPolicy defines if the underlying volume supports changing ownership and permission of the volume before being mounted. Refer to the specific FSGroupPolicy values for additional details.<br><p> <br><p> This field was immutable in Kubernetes &lt; 1.29 and now is mutable.<br><p> <br><p> Defaults to ReadWriteOnceWithFSType, which will examine each volume to determine if Kubernetes should modify ownership and permissions of the volume. With the default policy the defined fsGroup will only be applied if a fstype is defined and the volume's access mode contains ReadWriteOnce.
     */
    @JsonProperty("fsGroupPolicy")
    public void setFsGroupPolicy(String fsGroupPolicy) {
        this.fsGroupPolicy = fsGroupPolicy;
    }

    /**
     * nodeAllocatableUpdatePeriodSeconds specifies the interval between periodic updates of the CSINode allocatable capacity for this driver. When set, both periodic updates and updates triggered by capacity-related failures are enabled. If not set, no updates occur (neither periodic nor upon detecting capacity-related failures), and the allocatable.count remains static. The minimum allowed value for this field is 10 seconds.<br><p> <br><p> This is a beta feature and requires the MutableCSINodeAllocatableCount feature gate to be enabled.<br><p> <br><p> This field is mutable.
     */
    @JsonProperty("nodeAllocatableUpdatePeriodSeconds")
    public Long getNodeAllocatableUpdatePeriodSeconds() {
        return nodeAllocatableUpdatePeriodSeconds;
    }

    /**
     * nodeAllocatableUpdatePeriodSeconds specifies the interval between periodic updates of the CSINode allocatable capacity for this driver. When set, both periodic updates and updates triggered by capacity-related failures are enabled. If not set, no updates occur (neither periodic nor upon detecting capacity-related failures), and the allocatable.count remains static. The minimum allowed value for this field is 10 seconds.<br><p> <br><p> This is a beta feature and requires the MutableCSINodeAllocatableCount feature gate to be enabled.<br><p> <br><p> This field is mutable.
     */
    @JsonProperty("nodeAllocatableUpdatePeriodSeconds")
    public void setNodeAllocatableUpdatePeriodSeconds(Long nodeAllocatableUpdatePeriodSeconds) {
        this.nodeAllocatableUpdatePeriodSeconds = nodeAllocatableUpdatePeriodSeconds;
    }

    /**
     * podInfoOnMount indicates this CSI volume driver requires additional pod information (like podName, podUID, etc.) during mount operations, if set to true. If set to false, pod information will not be passed on mount. Default is false.<br><p> <br><p> The CSI driver specifies podInfoOnMount as part of driver deployment. If true, Kubelet will pass pod information as VolumeContext in the CSI NodePublishVolume() calls. The CSI driver is responsible for parsing and validating the information passed in as VolumeContext.<br><p> <br><p> The following VolumeContext will be passed if podInfoOnMount is set to true. This list might grow, but the prefix will be used. "csi.storage.k8s.io/pod.name": pod.Name "csi.storage.k8s.io/pod.namespace": pod.Namespace "csi.storage.k8s.io/pod.uid": string(pod.UID) "csi.storage.k8s.io/ephemeral": "true" if the volume is an ephemeral inline volume<br><p>                                 defined by a CSIVolumeSource, otherwise "false"<br><p> <br><p> "csi.storage.k8s.io/ephemeral" is a new feature in Kubernetes 1.16. It is only required for drivers which support both the "Persistent" and "Ephemeral" VolumeLifecycleMode. Other drivers can leave pod info disabled and/or ignore this field. As Kubernetes 1.15 doesn't support this field, drivers can only support one mode when deployed on such a cluster and the deployment determines which mode that is, for example via a command line parameter of the driver.<br><p> <br><p> This field was immutable in Kubernetes &lt; 1.29 and now is mutable.
     */
    @JsonProperty("podInfoOnMount")
    public Boolean getPodInfoOnMount() {
        return podInfoOnMount;
    }

    /**
     * podInfoOnMount indicates this CSI volume driver requires additional pod information (like podName, podUID, etc.) during mount operations, if set to true. If set to false, pod information will not be passed on mount. Default is false.<br><p> <br><p> The CSI driver specifies podInfoOnMount as part of driver deployment. If true, Kubelet will pass pod information as VolumeContext in the CSI NodePublishVolume() calls. The CSI driver is responsible for parsing and validating the information passed in as VolumeContext.<br><p> <br><p> The following VolumeContext will be passed if podInfoOnMount is set to true. This list might grow, but the prefix will be used. "csi.storage.k8s.io/pod.name": pod.Name "csi.storage.k8s.io/pod.namespace": pod.Namespace "csi.storage.k8s.io/pod.uid": string(pod.UID) "csi.storage.k8s.io/ephemeral": "true" if the volume is an ephemeral inline volume<br><p>                                 defined by a CSIVolumeSource, otherwise "false"<br><p> <br><p> "csi.storage.k8s.io/ephemeral" is a new feature in Kubernetes 1.16. It is only required for drivers which support both the "Persistent" and "Ephemeral" VolumeLifecycleMode. Other drivers can leave pod info disabled and/or ignore this field. As Kubernetes 1.15 doesn't support this field, drivers can only support one mode when deployed on such a cluster and the deployment determines which mode that is, for example via a command line parameter of the driver.<br><p> <br><p> This field was immutable in Kubernetes &lt; 1.29 and now is mutable.
     */
    @JsonProperty("podInfoOnMount")
    public void setPodInfoOnMount(Boolean podInfoOnMount) {
        this.podInfoOnMount = podInfoOnMount;
    }

    /**
     * requiresRepublish indicates the CSI driver wants `NodePublishVolume` being periodically called to reflect any possible change in the mounted volume. This field defaults to false.<br><p> <br><p> Note: After a successful initial NodePublishVolume call, subsequent calls to NodePublishVolume should only update the contents of the volume. New mount points will not be seen by a running container.
     */
    @JsonProperty("requiresRepublish")
    public Boolean getRequiresRepublish() {
        return requiresRepublish;
    }

    /**
     * requiresRepublish indicates the CSI driver wants `NodePublishVolume` being periodically called to reflect any possible change in the mounted volume. This field defaults to false.<br><p> <br><p> Note: After a successful initial NodePublishVolume call, subsequent calls to NodePublishVolume should only update the contents of the volume. New mount points will not be seen by a running container.
     */
    @JsonProperty("requiresRepublish")
    public void setRequiresRepublish(Boolean requiresRepublish) {
        this.requiresRepublish = requiresRepublish;
    }

    /**
     * seLinuxMount specifies if the CSI driver supports "-o context" mount option.<br><p> <br><p> When "true", the CSI driver must ensure that all volumes provided by this CSI driver can be mounted separately with different `-o context` options. This is typical for storage backends that provide volumes as filesystems on block devices or as independent shared volumes. Kubernetes will call NodeStage / NodePublish with "-o context=xyz" mount option when mounting a ReadWriteOncePod volume used in Pod that has explicitly set SELinux context. In the future, it may be expanded to other volume AccessModes. In any case, Kubernetes will ensure that the volume is mounted only with a single SELinux context.<br><p> <br><p> When "false", Kubernetes won't pass any special SELinux mount options to the driver. This is typical for volumes that represent subdirectories of a bigger shared filesystem.<br><p> <br><p> Default is "false".
     */
    @JsonProperty("seLinuxMount")
    public Boolean getSeLinuxMount() {
        return seLinuxMount;
    }

    /**
     * seLinuxMount specifies if the CSI driver supports "-o context" mount option.<br><p> <br><p> When "true", the CSI driver must ensure that all volumes provided by this CSI driver can be mounted separately with different `-o context` options. This is typical for storage backends that provide volumes as filesystems on block devices or as independent shared volumes. Kubernetes will call NodeStage / NodePublish with "-o context=xyz" mount option when mounting a ReadWriteOncePod volume used in Pod that has explicitly set SELinux context. In the future, it may be expanded to other volume AccessModes. In any case, Kubernetes will ensure that the volume is mounted only with a single SELinux context.<br><p> <br><p> When "false", Kubernetes won't pass any special SELinux mount options to the driver. This is typical for volumes that represent subdirectories of a bigger shared filesystem.<br><p> <br><p> Default is "false".
     */
    @JsonProperty("seLinuxMount")
    public void setSeLinuxMount(Boolean seLinuxMount) {
        this.seLinuxMount = seLinuxMount;
    }

    /**
     * storageCapacity indicates that the CSI volume driver wants pod scheduling to consider the storage capacity that the driver deployment will report by creating CSIStorageCapacity objects with capacity information, if set to true.<br><p> <br><p> The check can be enabled immediately when deploying a driver. In that case, provisioning new volumes with late binding will pause until the driver deployment has published some suitable CSIStorageCapacity object.<br><p> <br><p> Alternatively, the driver can be deployed with the field unset or false and it can be flipped later when storage capacity information has been published.<br><p> <br><p> This field was immutable in Kubernetes &lt;= 1.22 and now is mutable.
     */
    @JsonProperty("storageCapacity")
    public Boolean getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * storageCapacity indicates that the CSI volume driver wants pod scheduling to consider the storage capacity that the driver deployment will report by creating CSIStorageCapacity objects with capacity information, if set to true.<br><p> <br><p> The check can be enabled immediately when deploying a driver. In that case, provisioning new volumes with late binding will pause until the driver deployment has published some suitable CSIStorageCapacity object.<br><p> <br><p> Alternatively, the driver can be deployed with the field unset or false and it can be flipped later when storage capacity information has been published.<br><p> <br><p> This field was immutable in Kubernetes &lt;= 1.22 and now is mutable.
     */
    @JsonProperty("storageCapacity")
    public void setStorageCapacity(Boolean storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    /**
     * tokenRequests indicates the CSI driver needs pods' service account tokens it is mounting volume for to do necessary authentication. Kubelet will pass the tokens in VolumeContext in the CSI NodePublishVolume calls. The CSI driver should parse and validate the following VolumeContext: "csi.storage.k8s.io/serviceAccount.tokens": {<br><p>   "&lt;audience&gt;": {<br><p>     "token": &lt;token&gt;,<br><p>     "expirationTimestamp": &lt;expiration timestamp in RFC3339&gt;,<br><p>   },<br><p>   ...<br><p> }<br><p> <br><p> Note: Audience in each TokenRequest should be different and at most one token is empty string. To receive a new token after expiry, RequiresRepublish can be used to trigger NodePublishVolume periodically.
     */
    @JsonProperty("tokenRequests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TokenRequest> getTokenRequests() {
        return tokenRequests;
    }

    /**
     * tokenRequests indicates the CSI driver needs pods' service account tokens it is mounting volume for to do necessary authentication. Kubelet will pass the tokens in VolumeContext in the CSI NodePublishVolume calls. The CSI driver should parse and validate the following VolumeContext: "csi.storage.k8s.io/serviceAccount.tokens": {<br><p>   "&lt;audience&gt;": {<br><p>     "token": &lt;token&gt;,<br><p>     "expirationTimestamp": &lt;expiration timestamp in RFC3339&gt;,<br><p>   },<br><p>   ...<br><p> }<br><p> <br><p> Note: Audience in each TokenRequest should be different and at most one token is empty string. To receive a new token after expiry, RequiresRepublish can be used to trigger NodePublishVolume periodically.
     */
    @JsonProperty("tokenRequests")
    public void setTokenRequests(List<TokenRequest> tokenRequests) {
        this.tokenRequests = tokenRequests;
    }

    /**
     * volumeLifecycleModes defines what kind of volumes this CSI volume driver supports. The default if the list is empty is "Persistent", which is the usage defined by the CSI specification and implemented in Kubernetes via the usual PV/PVC mechanism.<br><p> <br><p> The other mode is "Ephemeral". In this mode, volumes are defined inline inside the pod spec with CSIVolumeSource and their lifecycle is tied to the lifecycle of that pod. A driver has to be aware of this because it is only going to get a NodePublishVolume call for such a volume.<br><p> <br><p> For more information about implementing this mode, see https://kubernetes-csi.github.io/docs/ephemeral-local-volumes.html A driver can support one or more of these modes and more modes may be added in the future.<br><p> <br><p> This field is beta. This field is immutable.
     */
    @JsonProperty("volumeLifecycleModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVolumeLifecycleModes() {
        return volumeLifecycleModes;
    }

    /**
     * volumeLifecycleModes defines what kind of volumes this CSI volume driver supports. The default if the list is empty is "Persistent", which is the usage defined by the CSI specification and implemented in Kubernetes via the usual PV/PVC mechanism.<br><p> <br><p> The other mode is "Ephemeral". In this mode, volumes are defined inline inside the pod spec with CSIVolumeSource and their lifecycle is tied to the lifecycle of that pod. A driver has to be aware of this because it is only going to get a NodePublishVolume call for such a volume.<br><p> <br><p> For more information about implementing this mode, see https://kubernetes-csi.github.io/docs/ephemeral-local-volumes.html A driver can support one or more of these modes and more modes may be added in the future.<br><p> <br><p> This field is beta. This field is immutable.
     */
    @JsonProperty("volumeLifecycleModes")
    public void setVolumeLifecycleModes(List<String> volumeLifecycleModes) {
        this.volumeLifecycleModes = volumeLifecycleModes;
    }

    @JsonIgnore
    public CSIDriverSpecBuilder edit() {
        return new CSIDriverSpecBuilder(this);
    }

    @JsonIgnore
    public CSIDriverSpecBuilder toBuilder() {
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
