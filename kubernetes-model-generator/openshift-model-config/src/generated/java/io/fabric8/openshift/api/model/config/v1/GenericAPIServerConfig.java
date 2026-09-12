
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "admission",
    "auditConfig",
    "corsAllowedOrigins",
    "kubeClientConfig",
    "servingInfo",
    "storageConfig"
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
public class GenericAPIServerConfig implements Editable<GenericAPIServerConfigBuilder>, KubernetesResource
{

    @JsonProperty("admission")
    private AdmissionConfig admission;
    @JsonProperty("auditConfig")
    private AuditConfig auditConfig;
    @JsonProperty("corsAllowedOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> corsAllowedOrigins = new ArrayList<>();
    @JsonProperty("kubeClientConfig")
    private KubeClientConfig kubeClientConfig;
    @JsonProperty("servingInfo")
    private HTTPServingInfo servingInfo;
    @JsonProperty("storageConfig")
    private EtcdStorageConfig storageConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GenericAPIServerConfig() {
    }

    public GenericAPIServerConfig(AdmissionConfig admission, AuditConfig auditConfig, List<String> corsAllowedOrigins, KubeClientConfig kubeClientConfig, HTTPServingInfo servingInfo, EtcdStorageConfig storageConfig) {
        super();
        this.admission = admission;
        this.auditConfig = auditConfig;
        this.corsAllowedOrigins = corsAllowedOrigins;
        this.kubeClientConfig = kubeClientConfig;
        this.servingInfo = servingInfo;
        this.storageConfig = storageConfig;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("admission")
    public AdmissionConfig getAdmission() {
        return admission;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("admission")
    public void setAdmission(AdmissionConfig admission) {
        this.admission = admission;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("auditConfig")
    public AuditConfig getAuditConfig() {
        return auditConfig;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("auditConfig")
    public void setAuditConfig(AuditConfig auditConfig) {
        this.auditConfig = auditConfig;
    }

    /**
     * corsAllowedOrigins
     */
    @JsonProperty("corsAllowedOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCorsAllowedOrigins() {
        return corsAllowedOrigins;
    }

    /**
     * corsAllowedOrigins
     */
    @JsonProperty("corsAllowedOrigins")
    public void setCorsAllowedOrigins(List<String> corsAllowedOrigins) {
        this.corsAllowedOrigins = corsAllowedOrigins;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("kubeClientConfig")
    public KubeClientConfig getKubeClientConfig() {
        return kubeClientConfig;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("kubeClientConfig")
    public void setKubeClientConfig(KubeClientConfig kubeClientConfig) {
        this.kubeClientConfig = kubeClientConfig;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("servingInfo")
    public HTTPServingInfo getServingInfo() {
        return servingInfo;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("servingInfo")
    public void setServingInfo(HTTPServingInfo servingInfo) {
        this.servingInfo = servingInfo;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("storageConfig")
    public EtcdStorageConfig getStorageConfig() {
        return storageConfig;
    }

    /**
     * GenericAPIServerConfig is an inline-able struct for aggregated apiservers that need to store data in etcd
     */
    @JsonProperty("storageConfig")
    public void setStorageConfig(EtcdStorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    @JsonIgnore
    public GenericAPIServerConfigBuilder edit() {
        return new GenericAPIServerConfigBuilder(this);
    }

    @JsonIgnore
    public GenericAPIServerConfigBuilder toBuilder() {
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
        if (!(o instanceof GenericAPIServerConfig)) {
            return false;
        }
        GenericAPIServerConfig other = (GenericAPIServerConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$admission = this.getAdmission();
        Object other$admission = other.getAdmission();
        if (this$admission == null ? other$admission != null : !this$admission.equals(other$admission)) {
            return false;
        }
        Object this$auditConfig = this.getAuditConfig();
        Object other$auditConfig = other.getAuditConfig();
        if (this$auditConfig == null ? other$auditConfig != null : !this$auditConfig.equals(other$auditConfig)) {
            return false;
        }
        Object this$corsAllowedOrigins = this.getCorsAllowedOrigins();
        Object other$corsAllowedOrigins = other.getCorsAllowedOrigins();
        if (this$corsAllowedOrigins == null ? other$corsAllowedOrigins != null : !this$corsAllowedOrigins.equals(other$corsAllowedOrigins)) {
            return false;
        }
        Object this$kubeClientConfig = this.getKubeClientConfig();
        Object other$kubeClientConfig = other.getKubeClientConfig();
        if (this$kubeClientConfig == null ? other$kubeClientConfig != null : !this$kubeClientConfig.equals(other$kubeClientConfig)) {
            return false;
        }
        Object this$servingInfo = this.getServingInfo();
        Object other$servingInfo = other.getServingInfo();
        if (this$servingInfo == null ? other$servingInfo != null : !this$servingInfo.equals(other$servingInfo)) {
            return false;
        }
        Object this$storageConfig = this.getStorageConfig();
        Object other$storageConfig = other.getStorageConfig();
        if (this$storageConfig == null ? other$storageConfig != null : !this$storageConfig.equals(other$storageConfig)) {
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
        return other instanceof GenericAPIServerConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $admission = this.getAdmission();
        result = result * prime + ($admission == null ? 43 : $admission.hashCode());
        Object $auditConfig = this.getAuditConfig();
        result = result * prime + ($auditConfig == null ? 43 : $auditConfig.hashCode());
        Object $corsAllowedOrigins = this.getCorsAllowedOrigins();
        result = result * prime + ($corsAllowedOrigins == null ? 43 : $corsAllowedOrigins.hashCode());
        Object $kubeClientConfig = this.getKubeClientConfig();
        result = result * prime + ($kubeClientConfig == null ? 43 : $kubeClientConfig.hashCode());
        Object $servingInfo = this.getServingInfo();
        result = result * prime + ($servingInfo == null ? 43 : $servingInfo.hashCode());
        Object $storageConfig = this.getStorageConfig();
        result = result * prime + ($storageConfig == null ? 43 : $storageConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GenericAPIServerConfig(" + "admission=" + this.getAdmission() + ", auditConfig=" + this.getAuditConfig() + ", corsAllowedOrigins=" + this.getCorsAllowedOrigins() + ", kubeClientConfig=" + this.getKubeClientConfig() + ", servingInfo=" + this.getServingInfo() + ", storageConfig=" + this.getStorageConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
