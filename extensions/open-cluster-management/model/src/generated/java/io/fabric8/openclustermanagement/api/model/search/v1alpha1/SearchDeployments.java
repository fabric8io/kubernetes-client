
package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

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
    "collector",
    "database",
    "indexer",
    "queryapi"
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
public class SearchDeployments implements Editable<SearchDeploymentsBuilder>, KubernetesResource
{

    @JsonProperty("collector")
    private DeploymentConfig collector;
    @JsonProperty("database")
    private DeploymentConfig database;
    @JsonProperty("indexer")
    private DeploymentConfig indexer;
    @JsonProperty("queryapi")
    private DeploymentConfig queryapi;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SearchDeployments() {
    }

    public SearchDeployments(DeploymentConfig collector, DeploymentConfig database, DeploymentConfig indexer, DeploymentConfig queryapi) {
        super();
        this.collector = collector;
        this.database = database;
        this.indexer = indexer;
        this.queryapi = queryapi;
    }

    @JsonProperty("collector")
    public DeploymentConfig getCollector() {
        return collector;
    }

    @JsonProperty("collector")
    public void setCollector(DeploymentConfig collector) {
        this.collector = collector;
    }

    @JsonProperty("database")
    public DeploymentConfig getDatabase() {
        return database;
    }

    @JsonProperty("database")
    public void setDatabase(DeploymentConfig database) {
        this.database = database;
    }

    @JsonProperty("indexer")
    public DeploymentConfig getIndexer() {
        return indexer;
    }

    @JsonProperty("indexer")
    public void setIndexer(DeploymentConfig indexer) {
        this.indexer = indexer;
    }

    @JsonProperty("queryapi")
    public DeploymentConfig getQueryapi() {
        return queryapi;
    }

    @JsonProperty("queryapi")
    public void setQueryapi(DeploymentConfig queryapi) {
        this.queryapi = queryapi;
    }

    @JsonIgnore
    public SearchDeploymentsBuilder edit() {
        return new SearchDeploymentsBuilder(this);
    }

    @JsonIgnore
    public SearchDeploymentsBuilder toBuilder() {
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
        if (!(o instanceof SearchDeployments)) {
            return false;
        }
        SearchDeployments other = (SearchDeployments) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$collector = this.getCollector();
        Object other$collector = other.getCollector();
        if (this$collector == null ? other$collector != null : !this$collector.equals(other$collector)) {
            return false;
        }
        Object this$database = this.getDatabase();
        Object other$database = other.getDatabase();
        if (this$database == null ? other$database != null : !this$database.equals(other$database)) {
            return false;
        }
        Object this$indexer = this.getIndexer();
        Object other$indexer = other.getIndexer();
        if (this$indexer == null ? other$indexer != null : !this$indexer.equals(other$indexer)) {
            return false;
        }
        Object this$queryapi = this.getQueryapi();
        Object other$queryapi = other.getQueryapi();
        if (this$queryapi == null ? other$queryapi != null : !this$queryapi.equals(other$queryapi)) {
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
        return other instanceof SearchDeployments;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $collector = this.getCollector();
        result = result * prime + ($collector == null ? 43 : $collector.hashCode());
        Object $database = this.getDatabase();
        result = result * prime + ($database == null ? 43 : $database.hashCode());
        Object $indexer = this.getIndexer();
        result = result * prime + ($indexer == null ? 43 : $indexer.hashCode());
        Object $queryapi = this.getQueryapi();
        result = result * prime + ($queryapi == null ? 43 : $queryapi.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SearchDeployments(" + "collector=" + this.getCollector() + ", database=" + this.getDatabase() + ", indexer=" + this.getIndexer() + ", queryapi=" + this.getQueryapi() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
