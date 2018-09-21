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
package quota

// ConvertClusterResourceQuotaToAppliedClusterQuota returns back a converted AppliedClusterResourceQuota which is NOT a deep copy.
func ConvertClusterResourceQuotaToAppliedClusterResourceQuota(in *ClusterResourceQuota) *AppliedClusterResourceQuota {
	return &AppliedClusterResourceQuota{
		ObjectMeta: in.ObjectMeta,
		Spec:       in.Spec,
		Status:     in.Status,
	}
}

// ConvertClusterResourceQuotaToAppliedClusterQuota returns back a converted AppliedClusterResourceQuota which is NOT a deep copy.
func ConvertAppliedClusterResourceQuotaToClusterResourceQuota(in *AppliedClusterResourceQuota) *ClusterResourceQuota {
	return &ClusterResourceQuota{
		ObjectMeta: in.ObjectMeta,
		Spec:       in.Spec,
		Status:     in.Status,
	}
}
