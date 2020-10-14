/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.commons;

import org.junit.Assume;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import java.lang.reflect.Modifier;

/**
 * Implementation taken from https://gist.github.com/rherrmann/7447571
 */
public class ConditionalIgnoreRule implements MethodRule {

  public interface IgnoreCondition {
    boolean isSatisfied();
  }

  public Statement apply(Statement base, FrameworkMethod method, Object target ) {
    Statement result = base;
    if( hasConditionalIgnoreAnnotation( method ) ) {
      IgnoreCondition condition = getIgnoreContition( method , target);
      if( condition.isSatisfied() ) {
        result = new IgnoreStatement( condition );
      }
    }
    return result;
  }

  private boolean hasConditionalIgnoreAnnotation( FrameworkMethod method ) {
    return method.getAnnotation( ConditionalIgnore.class ) != null;
  }

  private IgnoreCondition getIgnoreContition( FrameworkMethod method , Object instance) {
    ConditionalIgnore annotation = method.getAnnotation( ConditionalIgnore.class );
    return newCondition( annotation, instance );
  }

  private IgnoreCondition newCondition( ConditionalIgnore annotation, Object instance ) {
      final Class<? extends IgnoreCondition> cond = annotation.condition();
    try {
        if (cond.isMemberClass()) {
            if (Modifier.isStatic(cond.getModifiers())) {
                return cond.getDeclaredConstructor(new Class<?>[]{}).newInstance();
            } else if (instance != null && instance.getClass().isAssignableFrom(cond.getDeclaringClass())) {
                return cond.getDeclaredConstructor(new Class<?>[]{instance.getClass()}).newInstance(instance);
            }
            throw new IllegalArgumentException("Conditional class: " + cond.getName() + " was an inner member class however it was not declared inside the test case using it. Either make this class a static class (by adding static keyword), standalone class (by declaring it in it's own file) or move it inside the test case using it");
        } else {
            return cond.newInstance();
        }
    } catch( RuntimeException re ) { 
      throw re;
    } catch( Exception e ) {
      throw new RuntimeException( e );
    }
  }

  private static class IgnoreStatement extends Statement {
    private final IgnoreCondition condition;

    IgnoreStatement( IgnoreCondition condition ) {
      this.condition = condition;
    }

    @Override
    public void evaluate() {
      Assume.assumeTrue( "Ignored by " + condition.getClass().getSimpleName(), false );
    }
  }
  
}
