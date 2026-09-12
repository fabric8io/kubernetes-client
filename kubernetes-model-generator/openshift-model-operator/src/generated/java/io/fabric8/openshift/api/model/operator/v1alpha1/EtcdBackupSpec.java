
package io.fabric8.openshift.api.model.operator.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pvcName"
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
public class EtcdBackupSpec implements Editable<EtcdBackupSpecBuilder>, KubernetesResource
{

    @JsonProperty("pvcName")
    private String pvcName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EtcdBackupSpec() {
    }

    public EtcdBackupSpec(String pvcName) {
        super();
        this.pvcName = pvcName;
    }

    /**
     * pvcName specifies the name of the PersistentVolumeClaim (PVC) which binds a PersistentVolume where the etcd backup file would be saved The PVC itself must always be created in the "openshift-etcd" namespace If the PVC is left unspecified "" then the platform will choose a reasonable default location to save the backup. In the future this would be backups saved across the control-plane master nodes.
     */
    @JsonProperty("pvcName")
    public String getPvcName() {
        return pvcName;
    }

    /**
     * pvcName specifies the name of the PersistentVolumeClaim (PVC) which binds a PersistentVolume where the etcd backup file would be saved The PVC itself must always be created in the "openshift-etcd" namespace If the PVC is left unspecified "" then the platform will choose a reasonable default location to save the backup. In the future this would be backups saved across the control-plane master nodes.
     */
    @JsonProperty("pvcName")
    public void setPvcName(String pvcName) {
        this.pvcName = pvcName;
    }

    @JsonIgnore
    public EtcdBackupSpecBuilder edit() {
        return new EtcdBackupSpecBuilder(this);
    }

    @JsonIgnore
    public EtcdBackupSpecBuilder toBuilder() {
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
        if (!(o instanceof EtcdBackupSpec)) {
            return false;
        }
        EtcdBackupSpec other = (EtcdBackupSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$pvcName = this.getPvcName();
        Object other$pvcName = other.getPvcName();
        if (this$pvcName == null ? other$pvcName != null : !this$pvcName.equals(other$pvcName)) {
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
        return other instanceof EtcdBackupSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $pvcName = this.getPvcName();
        result = result * prime + ($pvcName == null ? 43 : $pvcName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EtcdBackupSpec(" + "pvcName=" + this.getPvcName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
