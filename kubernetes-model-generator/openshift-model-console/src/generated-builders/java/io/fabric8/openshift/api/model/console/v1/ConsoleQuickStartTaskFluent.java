package io.fabric8.openshift.api.model.console.v1;

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
public class ConsoleQuickStartTaskFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleQuickStartTaskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private ConsoleQuickStartTaskReviewBuilder review;
  private ConsoleQuickStartTaskSummaryBuilder summary;
  private String title;

  public ConsoleQuickStartTaskFluent() {
  }
  
  public ConsoleQuickStartTaskFluent(ConsoleQuickStartTask instance) {
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
  
  public ConsoleQuickStartTaskReview buildReview() {
    return this.review != null ? this.review.build() : null;
  }
  
  public ConsoleQuickStartTaskSummary buildSummary() {
    return this.summary != null ? this.summary.build() : null;
  }
  
  protected void copyInstance(ConsoleQuickStartTask instance) {
    instance = instance != null ? instance : new ConsoleQuickStartTask();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withReview(instance.getReview());
        this.withSummary(instance.getSummary());
        this.withTitle(instance.getTitle());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ReviewNested<A> editOrNewReview() {
    return this.withNewReviewLike(Optional.ofNullable(this.buildReview()).orElse(new ConsoleQuickStartTaskReviewBuilder().build()));
  }
  
  public ReviewNested<A> editOrNewReviewLike(ConsoleQuickStartTaskReview item) {
    return this.withNewReviewLike(Optional.ofNullable(this.buildReview()).orElse(item));
  }
  
  public SummaryNested<A> editOrNewSummary() {
    return this.withNewSummaryLike(Optional.ofNullable(this.buildSummary()).orElse(new ConsoleQuickStartTaskSummaryBuilder().build()));
  }
  
  public SummaryNested<A> editOrNewSummaryLike(ConsoleQuickStartTaskSummary item) {
    return this.withNewSummaryLike(Optional.ofNullable(this.buildSummary()).orElse(item));
  }
  
  public ReviewNested<A> editReview() {
    return this.withNewReviewLike(Optional.ofNullable(this.buildReview()).orElse(null));
  }
  
  public SummaryNested<A> editSummary() {
    return this.withNewSummaryLike(Optional.ofNullable(this.buildSummary()).orElse(null));
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
    ConsoleQuickStartTaskFluent that = (ConsoleQuickStartTaskFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(review, that.review))) {
      return false;
    }
    if (!(Objects.equals(summary, that.summary))) {
      return false;
    }
    if (!(Objects.equals(title, that.title))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasReview() {
    return this.review != null;
  }
  
  public boolean hasSummary() {
    return this.summary != null;
  }
  
  public boolean hasTitle() {
    return this.title != null;
  }
  
  public int hashCode() {
    return Objects.hash(description, review, summary, title, additionalProperties);
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
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(review == null)) {
        sb.append("review:");
        sb.append(review);
        sb.append(",");
    }
    if (!(summary == null)) {
        sb.append("summary:");
        sb.append(summary);
        sb.append(",");
    }
    if (!(title == null)) {
        sb.append("title:");
        sb.append(title);
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
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public ReviewNested<A> withNewReview() {
    return new ReviewNested(null);
  }
  
  public A withNewReview(String failedTaskHelp,String instructions) {
    return (A) this.withReview(new ConsoleQuickStartTaskReview(failedTaskHelp, instructions));
  }
  
  public ReviewNested<A> withNewReviewLike(ConsoleQuickStartTaskReview item) {
    return new ReviewNested(item);
  }
  
  public SummaryNested<A> withNewSummary() {
    return new SummaryNested(null);
  }
  
  public A withNewSummary(String failed,String success) {
    return (A) this.withSummary(new ConsoleQuickStartTaskSummary(failed, success));
  }
  
  public SummaryNested<A> withNewSummaryLike(ConsoleQuickStartTaskSummary item) {
    return new SummaryNested(item);
  }
  
  public A withReview(ConsoleQuickStartTaskReview review) {
    this._visitables.remove("review");
    if (review != null) {
        this.review = new ConsoleQuickStartTaskReviewBuilder(review);
        this._visitables.get("review").add(this.review);
    } else {
        this.review = null;
        this._visitables.get("review").remove(this.review);
    }
    return (A) this;
  }
  
  public A withSummary(ConsoleQuickStartTaskSummary summary) {
    this._visitables.remove("summary");
    if (summary != null) {
        this.summary = new ConsoleQuickStartTaskSummaryBuilder(summary);
        this._visitables.get("summary").add(this.summary);
    } else {
        this.summary = null;
        this._visitables.get("summary").remove(this.summary);
    }
    return (A) this;
  }
  
  public A withTitle(String title) {
    this.title = title;
    return (A) this;
  }
  public class ReviewNested<N> extends ConsoleQuickStartTaskReviewFluent<ReviewNested<N>> implements Nested<N>{
  
    ConsoleQuickStartTaskReviewBuilder builder;
  
    ReviewNested(ConsoleQuickStartTaskReview item) {
      this.builder = new ConsoleQuickStartTaskReviewBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleQuickStartTaskFluent.this.withReview(builder.build());
    }
    
    public N endReview() {
      return and();
    }
    
  }
  public class SummaryNested<N> extends ConsoleQuickStartTaskSummaryFluent<SummaryNested<N>> implements Nested<N>{
  
    ConsoleQuickStartTaskSummaryBuilder builder;
  
    SummaryNested(ConsoleQuickStartTaskSummary item) {
      this.builder = new ConsoleQuickStartTaskSummaryBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleQuickStartTaskFluent.this.withSummary(builder.build());
    }
    
    public N endSummary() {
      return and();
    }
    
  }
}