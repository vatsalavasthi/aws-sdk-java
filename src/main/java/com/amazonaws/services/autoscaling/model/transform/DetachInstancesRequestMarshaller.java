/*
 * Copyright 2010-2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.autoscaling.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import com.amazonaws.services.autoscaling.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * Detach Instances Request Marshaller
 */
public class DetachInstancesRequestMarshaller implements Marshaller<Request<DetachInstancesRequest>, DetachInstancesRequest> {

    public Request<DetachInstancesRequest> marshall(DetachInstancesRequest detachInstancesRequest) {

        if (detachInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DetachInstancesRequest> request = new DefaultRequest<DetachInstancesRequest>(detachInstancesRequest, "AmazonAutoScaling");
        request.addParameter("Action", "DetachInstances");
        request.addParameter("Version", "2011-01-01");

        java.util.List<String> instanceIdsList = detachInstancesRequest.getInstanceIds();
        int instanceIdsListIndex = 1;

        for (String instanceIdsListValue : instanceIdsList) {
            if (instanceIdsListValue != null) {
                request.addParameter("InstanceIds.member." + instanceIdsListIndex, StringUtils.fromString(instanceIdsListValue));
            }

            instanceIdsListIndex++;
        }
        if (detachInstancesRequest.getAutoScalingGroupName() != null) {
            request.addParameter("AutoScalingGroupName", StringUtils.fromString(detachInstancesRequest.getAutoScalingGroupName()));
        }
        if (detachInstancesRequest.isShouldDecrementDesiredCapacity() != null) {
            request.addParameter("ShouldDecrementDesiredCapacity", StringUtils.fromBoolean(detachInstancesRequest.isShouldDecrementDesiredCapacity()));
        }

        return request;
    }
}
