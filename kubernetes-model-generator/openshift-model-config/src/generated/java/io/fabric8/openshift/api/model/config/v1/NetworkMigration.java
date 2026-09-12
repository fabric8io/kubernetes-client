
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

/**
 * NetworkMigration represents the network migration status.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mtu",
    "networkType"
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
public class NetworkMigration implements Editable<NetworkMigrationBuilder>, KubernetesResource
{

    @JsonProperty("mtu")
    private MTUMigration mtu;
    @JsonProperty("networkType")
    private String networkType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkMigration() {
    }

    public NetworkMigration(MTUMigration mtu, String networkType) {
        super();
        this.mtu = mtu;
        this.networkType = networkType;
    }

    /**
     * NetworkMigration represents the network migration status.
     */
    @JsonProperty("mtu")
    public MTUMigration getMtu() {
        return mtu;
    }

    /**
     * NetworkMigration represents the network migration status.
     */
    @JsonProperty("mtu")
    public void setMtu(MTUMigration mtu) {
        this.mtu = mtu;
    }

    /**
     * networkType is the target plugin that is being deployed. DEPRECATED: network type migration is no longer supported, so this should always be unset.
     */
    @JsonProperty("networkType")
    public String getNetworkType() {
        return networkType;
    }

    /**
     * networkType is the target plugin that is being deployed. DEPRECATED: network type migration is no longer supported, so this should always be unset.
     */
    @JsonProperty("networkType")
    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    @JsonIgnore
    public NetworkMigrationBuilder edit() {
        return new NetworkMigrationBuilder(this);
    }

    @JsonIgnore
    public NetworkMigrationBuilder toBuilder() {
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
        if (!(o instanceof NetworkMigration)) {
            return false;
        }
        NetworkMigration other = (NetworkMigration) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$mtu = this.getMtu();
        Object other$mtu = other.getMtu();
        if (this$mtu == null ? other$mtu != null : !this$mtu.equals(other$mtu)) {
            return false;
        }
        Object this$networkType = this.getNetworkType();
        Object other$networkType = other.getNetworkType();
        if (this$networkType == null ? other$networkType != null : !this$networkType.equals(other$networkType)) {
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
        return other instanceof NetworkMigration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mtu = this.getMtu();
        result = result * prime + ($mtu == null ? 43 : $mtu.hashCode());
        Object $networkType = this.getNetworkType();
        result = result * prime + ($networkType == null ? 43 : $networkType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkMigration(" + "mtu=" + this.getMtu() + ", networkType=" + this.getNetworkType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
