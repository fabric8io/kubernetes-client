package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NativeHistogramConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.NativeHistogramConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean convertClassicHistogramsToNHCB;
  private Long nativeHistogramBucketLimit;
  private Quantity nativeHistogramMinBucketFactor;
  private Boolean scrapeClassicHistograms;
  private Boolean scrapeNativeHistograms;

  public NativeHistogramConfigFluent() {
  }
  
  public NativeHistogramConfigFluent(NativeHistogramConfig instance) {
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
  
  protected void copyInstance(NativeHistogramConfig instance) {
    instance = instance != null ? instance : new NativeHistogramConfig();
    if (instance != null) {
        this.withConvertClassicHistogramsToNHCB(instance.getConvertClassicHistogramsToNHCB());
        this.withNativeHistogramBucketLimit(instance.getNativeHistogramBucketLimit());
        this.withNativeHistogramMinBucketFactor(instance.getNativeHistogramMinBucketFactor());
        this.withScrapeClassicHistograms(instance.getScrapeClassicHistograms());
        this.withScrapeNativeHistograms(instance.getScrapeNativeHistograms());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    NativeHistogramConfigFluent that = (NativeHistogramConfigFluent) o;
    if (!(Objects.equals(convertClassicHistogramsToNHCB, that.convertClassicHistogramsToNHCB))) {
      return false;
    }
    if (!(Objects.equals(nativeHistogramBucketLimit, that.nativeHistogramBucketLimit))) {
      return false;
    }
    if (!(Objects.equals(nativeHistogramMinBucketFactor, that.nativeHistogramMinBucketFactor))) {
      return false;
    }
    if (!(Objects.equals(scrapeClassicHistograms, that.scrapeClassicHistograms))) {
      return false;
    }
    if (!(Objects.equals(scrapeNativeHistograms, that.scrapeNativeHistograms))) {
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
  
  public Boolean getConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB;
  }
  
  public Long getNativeHistogramBucketLimit() {
    return this.nativeHistogramBucketLimit;
  }
  
  public Quantity getNativeHistogramMinBucketFactor() {
    return this.nativeHistogramMinBucketFactor;
  }
  
  public Boolean getScrapeClassicHistograms() {
    return this.scrapeClassicHistograms;
  }
  
  public Boolean getScrapeNativeHistograms() {
    return this.scrapeNativeHistograms;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB != null;
  }
  
  public boolean hasNativeHistogramBucketLimit() {
    return this.nativeHistogramBucketLimit != null;
  }
  
  public boolean hasNativeHistogramMinBucketFactor() {
    return this.nativeHistogramMinBucketFactor != null;
  }
  
  public boolean hasScrapeClassicHistograms() {
    return this.scrapeClassicHistograms != null;
  }
  
  public boolean hasScrapeNativeHistograms() {
    return this.scrapeNativeHistograms != null;
  }
  
  public int hashCode() {
    return Objects.hash(convertClassicHistogramsToNHCB, nativeHistogramBucketLimit, nativeHistogramMinBucketFactor, scrapeClassicHistograms, scrapeNativeHistograms, additionalProperties);
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
    if (!(convertClassicHistogramsToNHCB == null)) {
        sb.append("convertClassicHistogramsToNHCB:");
        sb.append(convertClassicHistogramsToNHCB);
        sb.append(",");
    }
    if (!(nativeHistogramBucketLimit == null)) {
        sb.append("nativeHistogramBucketLimit:");
        sb.append(nativeHistogramBucketLimit);
        sb.append(",");
    }
    if (!(nativeHistogramMinBucketFactor == null)) {
        sb.append("nativeHistogramMinBucketFactor:");
        sb.append(nativeHistogramMinBucketFactor);
        sb.append(",");
    }
    if (!(scrapeClassicHistograms == null)) {
        sb.append("scrapeClassicHistograms:");
        sb.append(scrapeClassicHistograms);
        sb.append(",");
    }
    if (!(scrapeNativeHistograms == null)) {
        sb.append("scrapeNativeHistograms:");
        sb.append(scrapeNativeHistograms);
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
  
  public A withConvertClassicHistogramsToNHCB() {
    return withConvertClassicHistogramsToNHCB(true);
  }
  
  public A withConvertClassicHistogramsToNHCB(Boolean convertClassicHistogramsToNHCB) {
    this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
    return (A) this;
  }
  
  public A withNativeHistogramBucketLimit(Long nativeHistogramBucketLimit) {
    this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
    return (A) this;
  }
  
  public A withNativeHistogramMinBucketFactor(Quantity nativeHistogramMinBucketFactor) {
    this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
    return (A) this;
  }
  
  public A withNewNativeHistogramMinBucketFactor(String amount) {
    return (A) this.withNativeHistogramMinBucketFactor(new Quantity(amount));
  }
  
  public A withNewNativeHistogramMinBucketFactor(String amount,String format) {
    return (A) this.withNativeHistogramMinBucketFactor(new Quantity(amount, format));
  }
  
  public A withScrapeClassicHistograms() {
    return withScrapeClassicHistograms(true);
  }
  
  public A withScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
    this.scrapeClassicHistograms = scrapeClassicHistograms;
    return (A) this;
  }
  
  public A withScrapeNativeHistograms() {
    return withScrapeNativeHistograms(true);
  }
  
  public A withScrapeNativeHistograms(Boolean scrapeNativeHistograms) {
    this.scrapeNativeHistograms = scrapeNativeHistograms;
    return (A) this;
  }
  
}