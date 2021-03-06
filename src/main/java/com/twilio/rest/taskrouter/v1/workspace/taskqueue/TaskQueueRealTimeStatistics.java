/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace.taskqueue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskQueueRealTimeStatistics extends Resource {
    private static final long serialVersionUID = 17721333657575L;

    /**
     * Create a TaskQueueRealTimeStatisticsFetcher to execute fetch.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the TaskQueue to fetch
     * @param pathTaskQueueSid The SID of the TaskQueue for which to fetch
     *                         statistics
     * @return TaskQueueRealTimeStatisticsFetcher capable of executing the fetch
     */
    public static TaskQueueRealTimeStatisticsFetcher fetcher(final String pathWorkspaceSid,
                                                             final String pathTaskQueueSid) {
        return new TaskQueueRealTimeStatisticsFetcher(pathWorkspaceSid, pathTaskQueueSid);
    }

    /**
     * Converts a JSON String into a TaskQueueRealTimeStatistics object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueueRealTimeStatistics object represented by the provided JSON
     */
    public static TaskQueueRealTimeStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueueRealTimeStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a TaskQueueRealTimeStatistics object using
     * the provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueueRealTimeStatistics object represented by the provided JSON
     */
    public static TaskQueueRealTimeStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueueRealTimeStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final List<Map<String, Object>> activityStatistics;
    private final Integer longestTaskWaitingAge;
    private final String longestTaskWaitingSid;
    private final String taskQueueSid;
    private final Map<String, Object> tasksByPriority;
    private final Map<String, Object> tasksByStatus;
    private final Integer totalAvailableWorkers;
    private final Integer totalEligibleWorkers;
    private final Integer totalTasks;
    private final String workspaceSid;
    private final URI url;

    @JsonCreator
    private TaskQueueRealTimeStatistics(@JsonProperty("account_sid")
                                        final String accountSid,
                                        @JsonProperty("activity_statistics")
                                        final List<Map<String, Object>> activityStatistics,
                                        @JsonProperty("longest_task_waiting_age")
                                        final Integer longestTaskWaitingAge,
                                        @JsonProperty("longest_task_waiting_sid")
                                        final String longestTaskWaitingSid,
                                        @JsonProperty("task_queue_sid")
                                        final String taskQueueSid,
                                        @JsonProperty("tasks_by_priority")
                                        final Map<String, Object> tasksByPriority,
                                        @JsonProperty("tasks_by_status")
                                        final Map<String, Object> tasksByStatus,
                                        @JsonProperty("total_available_workers")
                                        final Integer totalAvailableWorkers,
                                        @JsonProperty("total_eligible_workers")
                                        final Integer totalEligibleWorkers,
                                        @JsonProperty("total_tasks")
                                        final Integer totalTasks,
                                        @JsonProperty("workspace_sid")
                                        final String workspaceSid,
                                        @JsonProperty("url")
                                        final URI url) {
        this.accountSid = accountSid;
        this.activityStatistics = activityStatistics;
        this.longestTaskWaitingAge = longestTaskWaitingAge;
        this.longestTaskWaitingSid = longestTaskWaitingSid;
        this.taskQueueSid = taskQueueSid;
        this.tasksByPriority = tasksByPriority;
        this.tasksByStatus = tasksByStatus;
        this.totalAvailableWorkers = totalAvailableWorkers;
        this.totalEligibleWorkers = totalEligibleWorkers;
        this.totalTasks = totalTasks;
        this.workspaceSid = workspaceSid;
        this.url = url;
    }

    /**
     * Returns The The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The number of current Workers by Activity.
     *
     * @return The number of current Workers by Activity
     */
    public final List<Map<String, Object>> getActivityStatistics() {
        return this.activityStatistics;
    }

    /**
     * Returns The The age of the longest waiting Task.
     *
     * @return The age of the longest waiting Task
     */
    public final Integer getLongestTaskWaitingAge() {
        return this.longestTaskWaitingAge;
    }

    /**
     * Returns The The SID of the longest waiting Task.
     *
     * @return The SID of the longest waiting Task
     */
    public final String getLongestTaskWaitingSid() {
        return this.longestTaskWaitingSid;
    }

    /**
     * Returns The The SID of the TaskQueue from which these statistics were
     * calculated.
     *
     * @return The SID of the TaskQueue from which these statistics were calculated
     */
    public final String getTaskQueueSid() {
        return this.taskQueueSid;
    }

    /**
     * Returns The The number of Tasks by priority.
     *
     * @return The number of Tasks by priority
     */
    public final Map<String, Object> getTasksByPriority() {
        return this.tasksByPriority;
    }

    /**
     * Returns The The number of Tasks by their current status.
     *
     * @return The number of Tasks by their current status
     */
    public final Map<String, Object> getTasksByStatus() {
        return this.tasksByStatus;
    }

    /**
     * Returns The The total number of Workers available for Tasks in the TaskQueue.
     *
     * @return The total number of Workers available for Tasks in the TaskQueue
     */
    public final Integer getTotalAvailableWorkers() {
        return this.totalAvailableWorkers;
    }

    /**
     * Returns The The total number of Workers eligible for Tasks in the TaskQueue,
     * independent of their Activity state.
     *
     * @return The total number of Workers eligible for Tasks in the TaskQueue,
     *         independent of their Activity state
     */
    public final Integer getTotalEligibleWorkers() {
        return this.totalEligibleWorkers;
    }

    /**
     * Returns The The total number of Tasks.
     *
     * @return The total number of Tasks
     */
    public final Integer getTotalTasks() {
        return this.totalTasks;
    }

    /**
     * Returns The The SID of the Workspace that contains the TaskQueue.
     *
     * @return The SID of the Workspace that contains the TaskQueue
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    /**
     * Returns The The absolute URL of the TaskQueue statistics resource.
     *
     * @return The absolute URL of the TaskQueue statistics resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TaskQueueRealTimeStatistics other = (TaskQueueRealTimeStatistics) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(activityStatistics, other.activityStatistics) &&
               Objects.equals(longestTaskWaitingAge, other.longestTaskWaitingAge) &&
               Objects.equals(longestTaskWaitingSid, other.longestTaskWaitingSid) &&
               Objects.equals(taskQueueSid, other.taskQueueSid) &&
               Objects.equals(tasksByPriority, other.tasksByPriority) &&
               Objects.equals(tasksByStatus, other.tasksByStatus) &&
               Objects.equals(totalAvailableWorkers, other.totalAvailableWorkers) &&
               Objects.equals(totalEligibleWorkers, other.totalEligibleWorkers) &&
               Objects.equals(totalTasks, other.totalTasks) &&
               Objects.equals(workspaceSid, other.workspaceSid) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            activityStatistics,
                            longestTaskWaitingAge,
                            longestTaskWaitingSid,
                            taskQueueSid,
                            tasksByPriority,
                            tasksByStatus,
                            totalAvailableWorkers,
                            totalEligibleWorkers,
                            totalTasks,
                            workspaceSid,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("activityStatistics", activityStatistics)
                          .add("longestTaskWaitingAge", longestTaskWaitingAge)
                          .add("longestTaskWaitingSid", longestTaskWaitingSid)
                          .add("taskQueueSid", taskQueueSid)
                          .add("tasksByPriority", tasksByPriority)
                          .add("tasksByStatus", tasksByStatus)
                          .add("totalAvailableWorkers", totalAvailableWorkers)
                          .add("totalEligibleWorkers", totalEligibleWorkers)
                          .add("totalTasks", totalTasks)
                          .add("workspaceSid", workspaceSid)
                          .add("url", url)
                          .toString();
    }
}