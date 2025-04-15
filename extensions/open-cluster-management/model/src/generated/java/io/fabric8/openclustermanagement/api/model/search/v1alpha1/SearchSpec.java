
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
