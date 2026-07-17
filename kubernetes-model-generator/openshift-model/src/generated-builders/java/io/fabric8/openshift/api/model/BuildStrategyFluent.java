package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class BuildStrategyFluent<A extends io.fabric8.openshift.api.model.BuildStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CustomBuildStrategyBuilder customStrategy;
  private DockerBuildStrategyBuilder dockerStrategy;
  private JenkinsPipelineBuildStrategyBuilder jenkinsPipelineStrategy;
  private SourceBuildStrategyBuilder sourceStrategy;
  private String type;

  public BuildStrategyFluent() {
  }
  
  public BuildStrategyFluent(BuildStrategy instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public CustomBuildStrategy buildCustomStrategy() {
    return this.customStrategy != null ? this.customStrategy.build() : null;
  }
  
  public DockerBuildStrategy buildDockerStrategy() {
    return this.dockerStrategy != null ? this.dockerStrategy.build() : null;
  }
  
  public JenkinsPipelineBuildStrategy buildJenkinsPipelineStrategy() {
    return this.jenkinsPipelineStrategy != null ? this.jenkinsPipelineStrategy.build() : null;
  }
  
  public SourceBuildStrategy buildSourceStrategy() {
    return this.sourceStrategy != null ? this.sourceStrategy.build() : null;
  }
  
  protected void copyInstance(BuildStrategy instance) {
    instance = instance != null ? instance : new BuildStrategy();
    if (instance != null) {
        this.withCustomStrategy(instance.getCustomStrategy());
        this.withDockerStrategy(instance.getDockerStrategy());
        this.withJenkinsPipelineStrategy(instance.getJenkinsPipelineStrategy());
        this.withSourceStrategy(instance.getSourceStrategy());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CustomStrategyNested<A> editCustomStrategy() {
    return this.withNewCustomStrategyLike(Optional.ofNullable(this.buildCustomStrategy()).orElse(null));
  }
  
  public DockerStrategyNested<A> editDockerStrategy() {
    return this.withNewDockerStrategyLike(Optional.ofNullable(this.buildDockerStrategy()).orElse(null));
  }
  
  public JenkinsPipelineStrategyNested<A> editJenkinsPipelineStrategy() {
    return this.withNewJenkinsPipelineStrategyLike(Optional.ofNullable(this.buildJenkinsPipelineStrategy()).orElse(null));
  }
  
  public CustomStrategyNested<A> editOrNewCustomStrategy() {
    return this.withNewCustomStrategyLike(Optional.ofNullable(this.buildCustomStrategy()).orElse(new CustomBuildStrategyBuilder().build()));
  }
  
  public CustomStrategyNested<A> editOrNewCustomStrategyLike(CustomBuildStrategy item) {
    return this.withNewCustomStrategyLike(Optional.ofNullable(this.buildCustomStrategy()).orElse(item));
  }
  
  public DockerStrategyNested<A> editOrNewDockerStrategy() {
    return this.withNewDockerStrategyLike(Optional.ofNullable(this.buildDockerStrategy()).orElse(new DockerBuildStrategyBuilder().build()));
  }
  
  public DockerStrategyNested<A> editOrNewDockerStrategyLike(DockerBuildStrategy item) {
    return this.withNewDockerStrategyLike(Optional.ofNullable(this.buildDockerStrategy()).orElse(item));
  }
  
  public JenkinsPipelineStrategyNested<A> editOrNewJenkinsPipelineStrategy() {
    return this.withNewJenkinsPipelineStrategyLike(Optional.ofNullable(this.buildJenkinsPipelineStrategy()).orElse(new JenkinsPipelineBuildStrategyBuilder().build()));
  }
  
  public JenkinsPipelineStrategyNested<A> editOrNewJenkinsPipelineStrategyLike(JenkinsPipelineBuildStrategy item) {
    return this.withNewJenkinsPipelineStrategyLike(Optional.ofNullable(this.buildJenkinsPipelineStrategy()).orElse(item));
  }
  
  public SourceStrategyNested<A> editOrNewSourceStrategy() {
    return this.withNewSourceStrategyLike(Optional.ofNullable(this.buildSourceStrategy()).orElse(new SourceBuildStrategyBuilder().build()));
  }
  
  public SourceStrategyNested<A> editOrNewSourceStrategyLike(SourceBuildStrategy item) {
    return this.withNewSourceStrategyLike(Optional.ofNullable(this.buildSourceStrategy()).orElse(item));
  }
  
  public SourceStrategyNested<A> editSourceStrategy() {
    return this.withNewSourceStrategyLike(Optional.ofNullable(this.buildSourceStrategy()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    BuildStrategyFluent that = (BuildStrategyFluent) o;
    if (!(Objects.equals(customStrategy, that.customStrategy))) {
      return false;
    }
    if (!(Objects.equals(dockerStrategy, that.dockerStrategy))) {
      return false;
    }
    if (!(Objects.equals(jenkinsPipelineStrategy, that.jenkinsPipelineStrategy))) {
      return false;
    }
    if (!(Objects.equals(sourceStrategy, that.sourceStrategy))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCustomStrategy() {
    return this.customStrategy != null;
  }
  
  public boolean hasDockerStrategy() {
    return this.dockerStrategy != null;
  }
  
  public boolean hasJenkinsPipelineStrategy() {
    return this.jenkinsPipelineStrategy != null;
  }
  
  public boolean hasSourceStrategy() {
    return this.sourceStrategy != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(customStrategy, dockerStrategy, jenkinsPipelineStrategy, sourceStrategy, type, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(customStrategy == null)) {
        sb.append("customStrategy:");
        sb.append(customStrategy);
        sb.append(",");
    }
    if (!(dockerStrategy == null)) {
        sb.append("dockerStrategy:");
        sb.append(dockerStrategy);
        sb.append(",");
    }
    if (!(jenkinsPipelineStrategy == null)) {
        sb.append("jenkinsPipelineStrategy:");
        sb.append(jenkinsPipelineStrategy);
        sb.append(",");
    }
    if (!(sourceStrategy == null)) {
        sb.append("sourceStrategy:");
        sb.append(sourceStrategy);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withCustomStrategy(CustomBuildStrategy customStrategy) {
    this._visitables.remove("customStrategy");
    if (customStrategy != null) {
        this.customStrategy = new CustomBuildStrategyBuilder(customStrategy);
        this._visitables.get("customStrategy").add(this.customStrategy);
    } else {
        this.customStrategy = null;
        this._visitables.get("customStrategy").remove(this.customStrategy);
    }
    return (A) this;
  }
  
  public A withDockerStrategy(DockerBuildStrategy dockerStrategy) {
    this._visitables.remove("dockerStrategy");
    if (dockerStrategy != null) {
        this.dockerStrategy = new DockerBuildStrategyBuilder(dockerStrategy);
        this._visitables.get("dockerStrategy").add(this.dockerStrategy);
    } else {
        this.dockerStrategy = null;
        this._visitables.get("dockerStrategy").remove(this.dockerStrategy);
    }
    return (A) this;
  }
  
  public A withJenkinsPipelineStrategy(JenkinsPipelineBuildStrategy jenkinsPipelineStrategy) {
    this._visitables.remove("jenkinsPipelineStrategy");
    if (jenkinsPipelineStrategy != null) {
        this.jenkinsPipelineStrategy = new JenkinsPipelineBuildStrategyBuilder(jenkinsPipelineStrategy);
        this._visitables.get("jenkinsPipelineStrategy").add(this.jenkinsPipelineStrategy);
    } else {
        this.jenkinsPipelineStrategy = null;
        this._visitables.get("jenkinsPipelineStrategy").remove(this.jenkinsPipelineStrategy);
    }
    return (A) this;
  }
  
  public CustomStrategyNested<A> withNewCustomStrategy() {
    return new CustomStrategyNested(null);
  }
  
  public CustomStrategyNested<A> withNewCustomStrategyLike(CustomBuildStrategy item) {
    return new CustomStrategyNested(item);
  }
  
  public DockerStrategyNested<A> withNewDockerStrategy() {
    return new DockerStrategyNested(null);
  }
  
  public DockerStrategyNested<A> withNewDockerStrategyLike(DockerBuildStrategy item) {
    return new DockerStrategyNested(item);
  }
  
  public JenkinsPipelineStrategyNested<A> withNewJenkinsPipelineStrategy() {
    return new JenkinsPipelineStrategyNested(null);
  }
  
  public JenkinsPipelineStrategyNested<A> withNewJenkinsPipelineStrategyLike(JenkinsPipelineBuildStrategy item) {
    return new JenkinsPipelineStrategyNested(item);
  }
  
  public SourceStrategyNested<A> withNewSourceStrategy() {
    return new SourceStrategyNested(null);
  }
  
  public SourceStrategyNested<A> withNewSourceStrategyLike(SourceBuildStrategy item) {
    return new SourceStrategyNested(item);
  }
  
  public A withSourceStrategy(SourceBuildStrategy sourceStrategy) {
    this._visitables.remove("sourceStrategy");
    if (sourceStrategy != null) {
        this.sourceStrategy = new SourceBuildStrategyBuilder(sourceStrategy);
        this._visitables.get("sourceStrategy").add(this.sourceStrategy);
    } else {
        this.sourceStrategy = null;
        this._visitables.get("sourceStrategy").remove(this.sourceStrategy);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class CustomStrategyNested<N> extends CustomBuildStrategyFluent<CustomStrategyNested<N>> implements Nested<N>{
  
    CustomBuildStrategyBuilder builder;
  
    CustomStrategyNested(CustomBuildStrategy item) {
      this.builder = new CustomBuildStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildStrategyFluent.this.withCustomStrategy(builder.build());
    }
    
    public N endCustomStrategy() {
      return and();
    }
    
  }
  public class DockerStrategyNested<N> extends DockerBuildStrategyFluent<DockerStrategyNested<N>> implements Nested<N>{
  
    DockerBuildStrategyBuilder builder;
  
    DockerStrategyNested(DockerBuildStrategy item) {
      this.builder = new DockerBuildStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildStrategyFluent.this.withDockerStrategy(builder.build());
    }
    
    public N endDockerStrategy() {
      return and();
    }
    
  }
  public class JenkinsPipelineStrategyNested<N> extends JenkinsPipelineBuildStrategyFluent<JenkinsPipelineStrategyNested<N>> implements Nested<N>{
  
    JenkinsPipelineBuildStrategyBuilder builder;
  
    JenkinsPipelineStrategyNested(JenkinsPipelineBuildStrategy item) {
      this.builder = new JenkinsPipelineBuildStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildStrategyFluent.this.withJenkinsPipelineStrategy(builder.build());
    }
    
    public N endJenkinsPipelineStrategy() {
      return and();
    }
    
  }
  public class SourceStrategyNested<N> extends SourceBuildStrategyFluent<SourceStrategyNested<N>> implements Nested<N>{
  
    SourceBuildStrategyBuilder builder;
  
    SourceStrategyNested(SourceBuildStrategy item) {
      this.builder = new SourceBuildStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildStrategyFluent.this.withSourceStrategy(builder.build());
    }
    
    public N endSourceStrategy() {
      return and();
    }
    
  }
}