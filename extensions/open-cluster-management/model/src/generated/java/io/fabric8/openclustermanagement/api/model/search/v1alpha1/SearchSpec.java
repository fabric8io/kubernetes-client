
package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SearchSpec defines the desired state of Search.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availabilityConfig",
    "dbConfig",
    "dbStorage",
    "deployments",
    "externalDBInstance",
    "imagePullPolicy",
    "imagePullSecret",
    "nodeSelector",
    "tolerations"
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
public class SearchSpec implements Editable<SearchSpecBuilder>, KubernetesResource
{

    @JsonProperty("availabilityConfig")
    private String availabilityConfig;
    @JsonProperty("dbConfig")
    private String dbConfig;
    @JsonProperty("dbStorage")
    private StorageSpec dbStorage;
    @JsonProperty("deployments")
    private SearchDeployments deployments;
    @JsonProperty("externalDBInstance")
    private String externalDBInstance;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("imagePullSecret")
    private String imagePullSecret;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SearchSpec() {
    }

    public SearchSpec(String availabilityConfig, String dbConfig, StorageSpec dbStorage, SearchDeployments deployments, String externalDBInstance, String imagePullPolicy, String imagePullSecret, Map<String, String> nodeSelector, List<Toleration> tolerations) {
        super();
        this.availabilityConfig = availabilityConfig;
        this.dbConfig = dbConfig;
        this.dbStorage = dbStorage;
        this.deployments = deployments;
        this.externalDBInstance = externalDBInstance;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecret = imagePullSecret;
        this.nodeSelector = nodeSelector;
        this.tolerations = tolerations;
    }

    /**
     * [PLACEHOLDER, NOT IMPLEMENTED] Specifies deployment replication for improved availability. Options are: Basic and High (default)
     */
    @JsonProperty("availabilityConfig")
    public String getAvailabilityConfig() {
        return availabilityConfig;
    }

    /**
     * [PLACEHOLDER, NOT IMPLEMENTED] Specifies deployment replication for improved availability. Options are: Basic and High (default)
     */
    @JsonProperty("availabilityConfig")
    public void setAvailabilityConfig(String availabilityConfig) {
        this.availabilityConfig = availabilityConfig;
    }

    /**
     * The config map name contains parameters to override default database parameters.
     */
    @JsonProperty("dbConfig")
    public String getDbConfig() {
        return dbConfig;
    }

    /**
     * The config map name contains parameters to override default database parameters.
     */
    @JsonProperty("dbConfig")
    public void setDbConfig(String dbConfig) {
        this.dbConfig = dbConfig;
    }

    /**
     * SearchSpec defines the desired state of Search.
     */
    @JsonProperty("dbStorage")
    public StorageSpec getDbStorage() {
        return dbStorage;
    }

    /**
     * SearchSpec defines the desired state of Search.
     */
    @JsonProperty("dbStorage")
    public void setDbStorage(StorageSpec dbStorage) {
        this.dbStorage = dbStorage;
    }

    /**
     * SearchSpec defines the desired state of Search.
     */
    @JsonProperty("deployments")
    public SearchDeployments getDeployments() {
        return deployments;
    }

    /**
     * SearchSpec defines the desired state of Search.
     */
    @JsonProperty("deployments")
    public void setDeployments(SearchDeployments deployments) {
        this.deployments = deployments;
    }

    /**
     * [PLACEHOLDER, NOT IMPLEMENTED] Kubernetes secret name containing user provided db secret Secret should contain connection parameters [db_host, db_port, db_user, db_password, db_name, ca_cert] Not supported for development preview.
     */
    @JsonProperty("externalDBInstance")
    public String getExternalDBInstance() {
        return externalDBInstance;
    }

    /**
     * [PLACEHOLDER, NOT IMPLEMENTED] Kubernetes secret name containing user provided db secret Secret should contain connection parameters [db_host, db_port, db_user, db_password, db_name, ca_cert] Not supported for development preview.
     */
    @JsonProperty("externalDBInstance")
    public void setExternalDBInstance(String externalDBInstance) {
        this.externalDBInstance = externalDBInstance;
    }

    /**
     * ImagePullPolicy
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * ImagePullPolicy
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * ImagePullSecret
     */
    @JsonProperty("imagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    /**
     * ImagePullSecret
     */
    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    /**
     * Define the nodes that you want to schedule with matching labels.
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * Define the nodes that you want to schedule with matching labels.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * Define tolerations to schedule pods on nodes with matching taints.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * Define tolerations to schedule pods on nodes with matching taints.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonIgnore
    public SearchSpecBuilder edit() {
        return new SearchSpecBuilder(this);
    }

    @JsonIgnore
    public SearchSpecBuilder toBuilder() {
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
        if (!(o instanceof SearchSpec)) {
            return false;
        }
        SearchSpec other = (SearchSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$availabilityConfig = this.getAvailabilityConfig();
        Object other$availabilityConfig = other.getAvailabilityConfig();
        if (this$availabilityConfig == null ? other$availabilityConfig != null : !this$availabilityConfig.equals(other$availabilityConfig)) {
            return false;
        }
        Object this$dbConfig = this.getDbConfig();
        Object other$dbConfig = other.getDbConfig();
        if (this$dbConfig == null ? other$dbConfig != null : !this$dbConfig.equals(other$dbConfig)) {
            return false;
        }
        Object this$dbStorage = this.getDbStorage();
        Object other$dbStorage = other.getDbStorage();
        if (this$dbStorage == null ? other$dbStorage != null : !this$dbStorage.equals(other$dbStorage)) {
            return false;
        }
        Object this$deployments = this.getDeployments();
        Object other$deployments = other.getDeployments();
        if (this$deployments == null ? other$deployments != null : !this$deployments.equals(other$deployments)) {
            return false;
        }
        Object this$externalDBInstance = this.getExternalDBInstance();
        Object other$externalDBInstance = other.getExternalDBInstance();
        if (this$externalDBInstance == null ? other$externalDBInstance != null : !this$externalDBInstance.equals(other$externalDBInstance)) {
            return false;
        }
        Object this$imagePullPolicy = this.getImagePullPolicy();
        Object other$imagePullPolicy = other.getImagePullPolicy();
        if (this$imagePullPolicy == null ? other$imagePullPolicy != null : !this$imagePullPolicy.equals(other$imagePullPolicy)) {
            return false;
        }
        Object this$imagePullSecret = this.getImagePullSecret();
        Object other$imagePullSecret = other.getImagePullSecret();
        if (this$imagePullSecret == null ? other$imagePullSecret != null : !this$imagePullSecret.equals(other$imagePullSecret)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$tolerations = this.getTolerations();
        Object other$tolerations = other.getTolerations();
        if (this$tolerations == null ? other$tolerations != null : !this$tolerations.equals(other$tolerations)) {
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
        return other instanceof SearchSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $availabilityConfig = this.getAvailabilityConfig();
        result = result * prime + ($availabilityConfig == null ? 43 : $availabilityConfig.hashCode());
        Object $dbConfig = this.getDbConfig();
        result = result * prime + ($dbConfig == null ? 43 : $dbConfig.hashCode());
        Object $dbStorage = this.getDbStorage();
        result = result * prime + ($dbStorage == null ? 43 : $dbStorage.hashCode());
        Object $deployments = this.getDeployments();
        result = result * prime + ($deployments == null ? 43 : $deployments.hashCode());
        Object $externalDBInstance = this.getExternalDBInstance();
        result = result * prime + ($externalDBInstance == null ? 43 : $externalDBInstance.hashCode());
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $imagePullSecret = this.getImagePullSecret();
        result = result * prime + ($imagePullSecret == null ? 43 : $imagePullSecret.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SearchSpec(" + "availabilityConfig=" + this.getAvailabilityConfig() + ", dbConfig=" + this.getDbConfig() + ", dbStorage=" + this.getDbStorage() + ", deployments=" + this.getDeployments() + ", externalDBInstance=" + this.getExternalDBInstance() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSecret=" + this.getImagePullSecret() + ", nodeSelector=" + this.getNodeSelector() + ", tolerations=" + this.getTolerations() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
