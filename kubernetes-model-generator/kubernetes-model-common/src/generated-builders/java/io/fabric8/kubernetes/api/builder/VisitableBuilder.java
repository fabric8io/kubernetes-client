package io.fabric8.kubernetes.api.builder;

public interface VisitableBuilder<T,V extends VisitableBuilder<T,V>> extends Builder<T>,Visitable<V>{

  
  
  
}