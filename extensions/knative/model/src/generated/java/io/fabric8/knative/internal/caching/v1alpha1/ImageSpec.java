
package io.fabric8.knative.internal.caching.v1alpha1;

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
 * ImageSpec holds the desired state of the Image (from the client).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "imagePullSecrets",
    "serviceAccountName"
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
public class ImageSpec implements Editable<ImageSpecBuilder>, KubernetesResource
{

    @JsonProperty("image")
    private String image;
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> imagePullSecrets = new ArrayList<>();
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageSpec() {
    }

    public ImageSpec(String image, List<LocalObjectReference> imagePullSecrets, String serviceAccountName) {
        super();
        this.image = image;
        this.imagePullSecrets = imagePullSecrets;
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * Image is the name of the container image url to cache across the cluster.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * Image is the name of the container image url to cache across the cluster.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * ImagePullSecrets contains the names of the Kubernetes Secrets containing login information used by the Pods which will run this container.
     */
    @JsonProperty("imagePullSecrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getImagePullSecrets() {
        return imagePullSecrets;
    }

    /**
     * ImagePullSecrets contains the names of the Kubernetes Secrets containing login information used by the Pods which will run this container.
     */
    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    /**
     * ServiceAccountName is the name of the Kubernetes ServiceAccount as which the Pods will run this container.  This is potentially used to authenticate the image pull if the service account has attached pull secrets.  For more information: https://kubernetes.io/docs/tasks/configure-pod-container/configure-service-account/#add-imagepullsecrets-to-a-service-account
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName is the name of the Kubernetes ServiceAccount as which the Pods will run this container.  This is potentially used to authenticate the image pull if the service account has attached pull secrets.  For more information: https://kubernetes.io/docs/tasks/configure-pod-container/configure-service-account/#add-imagepullsecrets-to-a-service-account
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonIgnore
    public ImageSpecBuilder edit() {
        return new ImageSpecBuilder(this);
    }

    @JsonIgnore
    public ImageSpecBuilder toBuilder() {
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
        if (!(o instanceof ImageSpec)) {
            return false;
        }
        ImageSpec other = (ImageSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$imagePullSecrets = this.getImagePullSecrets();
        Object other$imagePullSecrets = other.getImagePullSecrets();
        if (this$imagePullSecrets == null ? other$imagePullSecrets != null : !this$imagePullSecrets.equals(other$imagePullSecrets)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
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
        return other instanceof ImageSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $imagePullSecrets = this.getImagePullSecrets();
        result = result * prime + ($imagePullSecrets == null ? 43 : $imagePullSecrets.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageSpec(" + "image=" + this.getImage() + ", imagePullSecrets=" + this.getImagePullSecrets() + ", serviceAccountName=" + this.getServiceAccountName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
