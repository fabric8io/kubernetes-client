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

package org.arquillian.cube.requirement;

import io.fabric8.kubernetes.client.Client;
import org.arquillian.cube.spi.requirement.Requires;
import org.arquillian.cube.spi.requirement.UnsatisfiedRequirementException;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.arquillian.cube.requirement.Constraints.checkConstraint;

/**
 * Hack to close {@link Client}s
 */
public class ArquillianConditionalRunner extends Arquillian {

    private static final Logger log = Logger.getLogger(ArquillianConditionalRunner.class.getName());

    public ArquillianConditionalRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    public void run(RunNotifier notifier) {
        Class testClass = getTestClass().getJavaClass();
        try {
            checkRequirements(testClass);
            super.run(notifier);
        } catch (UnsatisfiedRequirementException e) {
            log.log(Level.WARNING,
                String.format("Unsatisfied assumption in test class %s. Requirement problem: %s.", testClass.getName(),
                    e.getMessage()));
            notifier.fireTestAssumptionFailed(new Failure(getDescription(), e));
        }
    }

    private void checkRequirements(Class<?> testClass) throws UnsatisfiedRequirementException {
        //Check if Requires is used directly.
        checkConstraint(testClass.getAnnotation(Requires.class), null);

        for (Annotation annotation : testClass.getAnnotations()) {
            //Check if Requires is annotating an other annotation
            checkConstraint(annotation.annotationType().getAnnotation(Requires.class), annotation);
        }
    }

    @Override
    protected Statement withAfters(FrameworkMethod method, Object target, Statement originalStatement) {
      Statement statement = super.withAfters(method, target, originalStatement);
      return new Statement() {

        @Override
        public void evaluate() throws Throwable {
          statement.evaluate();
          Field[] fields = target.getClass().getDeclaredFields();
          for (Field f : fields) {
            if (!Modifier.isStatic(f.getModifiers()) && Client.class.isAssignableFrom(f.getType())) {
              f.setAccessible(true);
              Client client = (Client)f.get(target);
              if (client != null) {
                client.close();
              }
            }
          }
        }
      };

    }


}
