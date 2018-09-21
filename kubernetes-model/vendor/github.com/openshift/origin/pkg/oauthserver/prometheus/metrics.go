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
package metrics

import (
	"github.com/prometheus/client_golang/prometheus"
)

const (
	authSubsystem = "openshift_auth"
)

const (
	SuccessResult = "success"
	FailResult    = "failure"
	ErrorResult   = "error"
)

var (
	authPasswordTotal = prometheus.NewCounterVec(
		prometheus.CounterOpts{
			Subsystem: authSubsystem,
			Name:      "password_total",
			Help:      "Counts total password authentication attempts",
		}, []string{},
	)
	authFormCounter = prometheus.NewCounterVec(
		prometheus.CounterOpts{
			Subsystem: authSubsystem,
			Name:      "form_password_count",
			Help:      "Counts form password authentication attempts",
		}, []string{},
	)
	authFormCounterResult = prometheus.NewCounterVec(
		prometheus.CounterOpts{
			Subsystem: authSubsystem,
			Name:      "form_password_count_result",
			Help:      "Counts form password authentication attempts by result",
		}, []string{"result"},
	)
	authBasicCounter = prometheus.NewCounterVec(
		prometheus.CounterOpts{
			Subsystem: authSubsystem,
			Name:      "basic_password_count",
			Help:      "Counts basic password authentication attempts",
		}, []string{},
	)
	authBasicCounterResult = prometheus.NewCounterVec(
		prometheus.CounterOpts{
			Subsystem: authSubsystem,
			Name:      "basic_password_count_result",
			Help:      "Counts basic password authentication attempts by result",
		}, []string{"result"},
	)
)

func init() {
	prometheus.MustRegister(authPasswordTotal)
	prometheus.MustRegister(authFormCounter)
	prometheus.MustRegister(authFormCounterResult)
	prometheus.MustRegister(authBasicCounter)
	prometheus.MustRegister(authBasicCounterResult)
}

func RecordBasicPasswordAuth(result string) {
	authPasswordTotal.WithLabelValues().Inc()
	authBasicCounter.WithLabelValues().Inc()
	authBasicCounterResult.WithLabelValues(result).Inc()
}

func RecordFormPasswordAuth(result string) {
	authPasswordTotal.WithLabelValues().Inc()
	authFormCounter.WithLabelValues().Inc()
	authFormCounterResult.WithLabelValues(result).Inc()
}
