
package io.fabric8.kubernetes.api.model.storage.v1beta1;

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
 * CSIDriverSpec is the specification of a CSIDriver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachRequired",
    "fsGroupPolicy",
    "podInfoOnMount",
    "requiresRepublish",
    "storageCapacity",
    "tokenRequests",
    "volumeLifecycleModes"
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
    @JsonProperty("podInfoOnMount")
    private Boolean podInfoOnMount;
    @JsonProperty("requiresRepublish")
    private Boolean requiresRepublish;
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

    public CSIDriverSpec(Boolean attachRequired, String fsGroupPolicy, Boolean podInfoOnMount, Boolean requiresRepublish, Boolean storageCapacity, List<TokenRequest> tokenRequests, List<String> volumeLifecycleModes) {
        super();
        this.attachRequired = attachRequired;
        this.fsGroupPolicy = fsGroupPolicy;
        this.podInfoOnMount = podInfoOnMount;
        this.requiresRepublish = requiresRepublish;
        this.storageCapacity = storageCapacity;
        this.tokenRequests = tokenRequests;
        this.volumeLifecycleModes = volumeLifecycleModes;
    }

    /**
     * attachRequired indicates this CSI volume driver requires an attach operation (because it implements the CSI ControllerPublishVolume() method), and that the Kubernetes attach detach controller should call the attach volume interface which checks the volumeattachment status and waits until the volume is attached before proceeding to mounting. The CSI external-attacher coordinates with CSI volume driver and updates the volumeattachment status when the attach operation is complete. If the CSIDriverRegistry feature gate is enabled and the value is specified to false, the attach operation will be skipped. Otherwise the attach operation will be called.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("attachRequired")
    public Boolean getAttachRequired() {
        return attachRequired;
    }

    /**
     * attachRequired indicates this CSI volume driver requires an attach operation (because it implements the CSI ControllerPublishVolume() method), and that the Kubernetes attach detach controller should call the attach volume interface which checks the volumeattachment status and waits until the volume is attached before proceeding to mounting. The CSI external-attacher coordinates with CSI volume driver and updates the volumeattachment status when the attach operation is complete. If the CSIDriverRegistry feature gate is enabled and the value is specified to false, the attach operation will be skipped. Otherwise the attach operation will be called.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("attachRequired")
    public void setAttachRequired(Boolean attachRequired) {
        this.attachRequired = attachRequired;
    }

    /**
     * Defines if the underlying volume supports changing ownership and permission of the volume before being mounted. Refer to the specific FSGroupPolicy values for additional details. This field is alpha-level, and is only honored by servers that enable the CSIVolumeFSGroupPolicy feature gate.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("fsGroupPolicy")
    public String getFsGroupPolicy() {
        return fsGroupPolicy;
    }

    /**
     * Defines if the underlying volume supports changing ownership and permission of the volume before being mounted. Refer to the specific FSGroupPolicy values for additional details. This field is alpha-level, and is only honored by servers that enable the CSIVolumeFSGroupPolicy feature gate.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("fsGroupPolicy")
    public void setFsGroupPolicy(String fsGroupPolicy) {
        this.fsGroupPolicy = fsGroupPolicy;
    }

    /**
     * If set to true, podInfoOnMount indicates this CSI volume driver requires additional pod information (like podName, podUID, etc.) during mount operations. If set to false, pod information will not be passed on mount. Default is false. The CSI driver specifies podInfoOnMount as part of driver deployment. If true, Kubelet will pass pod information as VolumeContext in the CSI NodePublishVolume() calls. The CSI driver is responsible for parsing and validating the information passed in as VolumeContext. The following VolumeConext will be passed if podInfoOnMount is set to true. This list might grow, but the prefix will be used. "csi.storage.k8s.io/pod.name": pod.Name "csi.storage.k8s.io/pod.namespace": pod.Namespace "csi.storage.k8s.io/pod.uid": string(pod.UID) "csi.storage.k8s.io/ephemeral": "true" if the volume is an ephemeral inline volume<br><p>                                 defined by a CSIVolumeSource, otherwise "false"<br><p> <br><p> "csi.storage.k8s.io/ephemeral" is a new feature in Kubernetes 1.16. It is only required for drivers which support both the "Persistent" and "Ephemeral" VolumeLifecycleMode. Other drivers can leave pod info disabled and/or ignore this field. As Kubernetes 1.15 doesn't support this field, drivers can only support one mode when deployed on such a cluster and the deployment determines which mode that is, for example via a command line parameter of the driver.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("podInfoOnMount")
    public Boolean getPodInfoOnMount() {
        return podInfoOnMount;
    }

    /**
     * If set to true, podInfoOnMount indicates this CSI volume driver requires additional pod information (like podName, podUID, etc.) during mount operations. If set to false, pod information will not be passed on mount. Default is false. The CSI driver specifies podInfoOnMount as part of driver deployment. If true, Kubelet will pass pod information as VolumeContext in the CSI NodePublishVolume() calls. The CSI driver is responsible for parsing and validating the information passed in as VolumeContext. The following VolumeConext will be passed if podInfoOnMount is set to true. This list might grow, but the prefix will be used. "csi.storage.k8s.io/pod.name": pod.Name "csi.storage.k8s.io/pod.namespace": pod.Namespace "csi.storage.k8s.io/pod.uid": string(pod.UID) "csi.storage.k8s.io/ephemeral": "true" if the volume is an ephemeral inline volume<br><p>                                 defined by a CSIVolumeSource, otherwise "false"<br><p> <br><p> "csi.storage.k8s.io/ephemeral" is a new feature in Kubernetes 1.16. It is only required for drivers which support both the "Persistent" and "Ephemeral" VolumeLifecycleMode. Other drivers can leave pod info disabled and/or ignore this field. As Kubernetes 1.15 doesn't support this field, drivers can only support one mode when deployed on such a cluster and the deployment determines which mode that is, for example via a command line parameter of the driver.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("podInfoOnMount")
    public void setPodInfoOnMount(Boolean podInfoOnMount) {
        this.podInfoOnMount = podInfoOnMount;
    }

    /**
     * RequiresRepublish indicates the CSI driver wants `NodePublishVolume` being periodically called to reflect any possible change in the mounted volume. This field defaults to false.<br><p> <br><p> Note: After a successful initial NodePublishVolume call, subsequent calls to NodePublishVolume should only update the contents of the volume. New mount points will not be seen by a running container.<br><p> <br><p> This is a beta feature and only available when the CSIServiceAccountToken feature is enabled.
     */
    @JsonProperty("requiresRepublish")
    public Boolean getRequiresRepublish() {
        return requiresRepublish;
    }

    /**
     * RequiresRepublish indicates the CSI driver wants `NodePublishVolume` being periodically called to reflect any possible change in the mounted volume. This field defaults to false.<br><p> <br><p> Note: After a successful initial NodePublishVolume call, subsequent calls to NodePublishVolume should only update the contents of the volume. New mount points will not be seen by a running container.<br><p> <br><p> This is a beta feature and only available when the CSIServiceAccountToken feature is enabled.
     */
    @JsonProperty("requiresRepublish")
    public void setRequiresRepublish(Boolean requiresRepublish) {
        this.requiresRepublish = requiresRepublish;
    }

    /**
     * If set to true, storageCapacity indicates that the CSI volume driver wants pod scheduling to consider the storage capacity that the driver deployment will report by creating CSIStorageCapacity objects with capacity information.<br><p> <br><p> The check can be enabled immediately when deploying a driver. In that case, provisioning new volumes with late binding will pause until the driver deployment has published some suitable CSIStorageCapacity object.<br><p> <br><p> Alternatively, the driver can be deployed with the field unset or false and it can be flipped later when storage capacity information has been published.<br><p> <br><p> This field is immutable.<br><p> <br><p> This is a beta field and only available when the CSIStorageCapacity feature is enabled. The default is false.
     */
    @JsonProperty("storageCapacity")
    public Boolean getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * If set to true, storageCapacity indicates that the CSI volume driver wants pod scheduling to consider the storage capacity that the driver deployment will report by creating CSIStorageCapacity objects with capacity information.<br><p> <br><p> The check can be enabled immediately when deploying a driver. In that case, provisioning new volumes with late binding will pause until the driver deployment has published some suitable CSIStorageCapacity object.<br><p> <br><p> Alternatively, the driver can be deployed with the field unset or false and it can be flipped later when storage capacity information has been published.<br><p> <br><p> This field is immutable.<br><p> <br><p> This is a beta field and only available when the CSIStorageCapacity feature is enabled. The default is false.
     */
    @JsonProperty("storageCapacity")
    public void setStorageCapacity(Boolean storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    /**
     * TokenRequests indicates the CSI driver needs pods' service account tokens it is mounting volume for to do necessary authentication. Kubelet will pass the tokens in VolumeContext in the CSI NodePublishVolume calls. The CSI driver should parse and validate the following VolumeContext: "csi.storage.k8s.io/serviceAccount.tokens": {<br><p>   "&lt;audience&gt;": {<br><p>     "token": &lt;token&gt;,<br><p>     "expirationTimestamp": &lt;expiration timestamp in RFC3339&gt;,<br><p>   },<br><p>   ...<br><p> }<br><p> <br><p> Note: Audience in each TokenRequest should be different and at most one token is empty string. To receive a new token after expiry, RequiresRepublish can be used to trigger NodePublishVolume periodically.<br><p> <br><p> This is a beta feature and only available when the CSIServiceAccountToken feature is enabled.
     */
    @JsonProperty("tokenRequests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TokenRequest> getTokenRequests() {
        return tokenRequests;
    }

    /**
     * TokenRequests indicates the CSI driver needs pods' service account tokens it is mounting volume for to do necessary authentication. Kubelet will pass the tokens in VolumeContext in the CSI NodePublishVolume calls. The CSI driver should parse and validate the following VolumeContext: "csi.storage.k8s.io/serviceAccount.tokens": {<br><p>   "&lt;audience&gt;": {<br><p>     "token": &lt;token&gt;,<br><p>     "expirationTimestamp": &lt;expiration timestamp in RFC3339&gt;,<br><p>   },<br><p>   ...<br><p> }<br><p> <br><p> Note: Audience in each TokenRequest should be different and at most one token is empty string. To receive a new token after expiry, RequiresRepublish can be used to trigger NodePublishVolume periodically.<br><p> <br><p> This is a beta feature and only available when the CSIServiceAccountToken feature is enabled.
     */
    @JsonProperty("tokenRequests")
    public void setTokenRequests(List<TokenRequest> tokenRequests) {
        this.tokenRequests = tokenRequests;
    }

    /**
     * VolumeLifecycleModes defines what kind of volumes this CSI volume driver supports. The default if the list is empty is "Persistent", which is the usage defined by the CSI specification and implemented in Kubernetes via the usual PV/PVC mechanism. The other mode is "Ephemeral". In this mode, volumes are defined inline inside the pod spec with CSIVolumeSource and their lifecycle is tied to the lifecycle of that pod. A driver has to be aware of this because it is only going to get a NodePublishVolume call for such a volume. For more information about implementing this mode, see https://kubernetes-csi.github.io/docs/ephemeral-local-volumes.html A driver can support one or more of these modes and more modes may be added in the future.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("volumeLifecycleModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVolumeLifecycleModes() {
        return volumeLifecycleModes;
    }

    /**
     * VolumeLifecycleModes defines what kind of volumes this CSI volume driver supports. The default if the list is empty is "Persistent", which is the usage defined by the CSI specification and implemented in Kubernetes via the usual PV/PVC mechanism. The other mode is "Ephemeral". In this mode, volumes are defined inline inside the pod spec with CSIVolumeSource and their lifecycle is tied to the lifecycle of that pod. A driver has to be aware of this because it is only going to get a NodePublishVolume call for such a volume. For more information about implementing this mode, see https://kubernetes-csi.github.io/docs/ephemeral-local-volumes.html A driver can support one or more of these modes and more modes may be added in the future.<br><p> <br><p> This field is immutable.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CSIDriverSpec)) {
            return false;
        }
        CSIDriverSpec other = (CSIDriverSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attachRequired = this.getAttachRequired();
        Object other$attachRequired = other.getAttachRequired();
        if (this$attachRequired == null ? other$attachRequired != null : !this$attachRequired.equals(other$attachRequired)) {
            return false;
        }
        Object this$fsGroupPolicy = this.getFsGroupPolicy();
        Object other$fsGroupPolicy = other.getFsGroupPolicy();
        if (this$fsGroupPolicy == null ? other$fsGroupPolicy != null : !this$fsGroupPolicy.equals(other$fsGroupPolicy)) {
            return false;
        }
        Object this$podInfoOnMount = this.getPodInfoOnMount();
        Object other$podInfoOnMount = other.getPodInfoOnMount();
        if (this$podInfoOnMount == null ? other$podInfoOnMount != null : !this$podInfoOnMount.equals(other$podInfoOnMount)) {
            return false;
        }
        Object this$requiresRepublish = this.getRequiresRepublish();
        Object other$requiresRepublish = other.getRequiresRepublish();
        if (this$requiresRepublish == null ? other$requiresRepublish != null : !this$requiresRepublish.equals(other$requiresRepublish)) {
            return false;
        }
        Object this$storageCapacity = this.getStorageCapacity();
        Object other$storageCapacity = other.getStorageCapacity();
        if (this$storageCapacity == null ? other$storageCapacity != null : !this$storageCapacity.equals(other$storageCapacity)) {
            return false;
        }
        Object this$tokenRequests = this.getTokenRequests();
        Object other$tokenRequests = other.getTokenRequests();
        if (this$tokenRequests == null ? other$tokenRequests != null : !this$tokenRequests.equals(other$tokenRequests)) {
            return false;
        }
        Object this$volumeLifecycleModes = this.getVolumeLifecycleModes();
        Object other$volumeLifecycleModes = other.getVolumeLifecycleModes();
        if (this$volumeLifecycleModes == null ? other$volumeLifecycleModes != null : !this$volumeLifecycleModes.equals(other$volumeLifecycleModes)) {
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
        return other instanceof CSIDriverSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attachRequired = this.getAttachRequired();
        result = result * prime + ($attachRequired == null ? 43 : $attachRequired.hashCode());
        Object $fsGroupPolicy = this.getFsGroupPolicy();
        result = result * prime + ($fsGroupPolicy == null ? 43 : $fsGroupPolicy.hashCode());
        Object $podInfoOnMount = this.getPodInfoOnMount();
        result = result * prime + ($podInfoOnMount == null ? 43 : $podInfoOnMount.hashCode());
        Object $requiresRepublish = this.getRequiresRepublish();
        result = result * prime + ($requiresRepublish == null ? 43 : $requiresRepublish.hashCode());
        Object $storageCapacity = this.getStorageCapacity();
        result = result * prime + ($storageCapacity == null ? 43 : $storageCapacity.hashCode());
        Object $tokenRequests = this.getTokenRequests();
        result = result * prime + ($tokenRequests == null ? 43 : $tokenRequests.hashCode());
        Object $volumeLifecycleModes = this.getVolumeLifecycleModes();
        result = result * prime + ($volumeLifecycleModes == null ? 43 : $volumeLifecycleModes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CSIDriverSpec(" + "attachRequired=" + this.getAttachRequired() + ", fsGroupPolicy=" + this.getFsGroupPolicy() + ", podInfoOnMount=" + this.getPodInfoOnMount() + ", requiresRepublish=" + this.getRequiresRepublish() + ", storageCapacity=" + this.getStorageCapacity() + ", tokenRequests=" + this.getTokenRequests() + ", volumeLifecycleModes=" + this.getVolumeLifecycleModes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
