package com.twilio.sdk.resource.instance.taskrouter;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.twilio.sdk.TwilioTaskRouterClient;
import com.twilio.sdk.resource.NextGenInstanceResource;

/**
 * Workers represent an entity that is able to perform tasks, such as an agent working in a call center,
 * or a salesperson handling leads.
 *
 * See <a href="https://www.twilio.com/docs/taskrouter/workers">the TaskRouter documentation</a>.
 */
public class Worker extends NextGenInstanceResource<TwilioTaskRouterClient> {

	private static final String WORKSPACE_SID_PROPERTY = "workspace_sid";

	/**
	 * Instantiates a worker.
	 *
	 * @param client the client
	 */
	public Worker(final TwilioTaskRouterClient client) {
		super(client);
	}

	/**
	 * Instantiates a worker.
	 *
	 * @param client the client
	 * @param properties the properties
	 */
	public Worker(final TwilioTaskRouterClient client, final Map<String, Object> properties) {
		super(client, properties);
	}

	/**
	 * Instantiates a worker.
	 *
	 * @param client the client
	 * @param workspaceSid the workspace sid
	 * @param workerSid the worker sid
	 */
	public Worker(final TwilioTaskRouterClient client, final String workspaceSid, final String workerSid) {
		super(client);
		if (workspaceSid == null || "".equals(workspaceSid)) {
			throw new IllegalArgumentException("The workspaceSid for an Worker cannot be null");
		}
		if (workerSid == null || "".equals(workerSid)) {
			throw new IllegalArgumentException("The workerSid for an Worker cannot be null");
		}
		setProperty(WORKSPACE_SID_PROPERTY, workspaceSid);
		setProperty(SID_PROPERTY, workerSid);
	}

	/**
	 * The ID of the {@link com.twilio.sdk.resource.instance.Account} that owns this worker.
	 *
	 * @return the account sid
	 */
	public String getAccountSid() {
		return getProperty("account_sid");
	}

	/**
	 * String describing the worker's current activity, for example 'on-call', 'after-call-work', 'break', etc.
	 * Workers may only perform Activities that exist in this Workspace.
	 *
	 * @return the activity name
	 */
	public String getActivityName() {
		return getProperty("activity_name");
	}

	/**
	 * The ID of the {@link com.twilio.sdk.resource.instance.taskrouter.Activity} this Worker is currently performing.
	 *
	 * @return the activity sid
	 */
	public String getActivitySid() {
		return getProperty("activity_sid");
	}

	/**
	 * A user-defined JSON object describing this Worker.
	 *
	 * @return the attributes
	 */
	public String getAttributes() {
		return getProperty("attributes");
	}
	
	/**
	 * A map that represents the JSON describing this Worker.
	 *
	 * @return the attributes
	 * @throws ParseException 
	 */
	public Map parseAttributes() throws ParseException {
		String attributes = getProperty("attributes");
		JSONParser parser = new JSONParser();
		return (Map) parser.parse(attributes);
	}

	/**
	 * The date and time this Worker was created.
	 *
	 * @return the date created
	 */
	public Date getDateCreated() {
		return parseDate(getProperty(DATE_CREATED_PROPERTY));
	}

	/**
	 * The date and time this Worker's Activity status last changed.
	 *
	 * @return the date updated
	 */
	public Date getDateStatusChanged() {
		return parseDate(getProperty("date_status_changed"));
	}

	/**
	 * The date and time this Worker was last updated.
	 *
	 * @return the date updated
	 */
	public Date getDateUpdated() {
		return parseDate(getProperty(DATE_UPDATED_PROPERTY));
	}

	/**
	 * A human-readable name for this Worker.
	 *
	 * @return the friendly name
	 */
	public String getFriendlyName() {
		return getProperty("friendly_name");
	}

	/**
	 * This Worker's unique ID.
	 *
	 * @return the sid
	 */
	public String getSid() {
		return getProperty(SID_PROPERTY);
	}

	/**
	 * The ID of the {@link com.twilio.sdk.resource.instance.taskrouter.Workspace} containing this Worker.
	 *
	 * @return the workspace sid
	 */
	public String getWorkspaceSid() {
		return getProperty(WORKSPACE_SID_PROPERTY);
	}

	/**
	 * Whether this Worker can be assigned another {@link com.twilio.sdk.resource.instance.taskrouter.Task}.
	 *
	 * @return true, if available
	 */
	public boolean isAvailable() {
		return (Boolean) getObject("available");
	}
	
	/**
	 * Get worker statistics.
	 * @return worker statistics
	 */
	public WorkerStatistics getStatistics() {
		return getWorkerStatistics(null);
	}
	
	/**
	 * Get worker statistics.
	 *
	 * @param startDate start date to query by
	 * @param endDate end date to query by
	 * @param minutes minutes to query by
	 * @return worker statistics
	 */
	public WorkerStatistics getWorkerStatistics(final Calendar startDate, final Calendar endDate, final Integer minutes) {
		Map<String, String> filters = new HashMap<String, String>();
		if(startDate != null) {
			filters.put("StartDate", formatCalendar(startDate));
		}
		if(endDate != null) {
			filters.put("EndDate", formatCalendar(endDate));
		}
		if(minutes != null) {
			filters.put("Minutes", minutes.toString());
		}
		return getWorkerStatistics(filters);
	}

	/**
	 * Get worker statistics.
	 *
	 * @param filters the filters
	 * @return worker statistics
	 */
	public WorkerStatistics getWorkerStatistics(final Map<String, String> filters) {
		WorkerStatistics statistics = new WorkerStatistics(this.getClient(), this.getWorkspaceSid(), this.getSid(), filters);
		return statistics;
	}

	@Override
	protected String getResourceLocation() {
		return "/" + TwilioTaskRouterClient.DEFAULT_VERSION + "/Workspaces/" + getWorkspaceSid() + "/Workers/" +
		       getSid();
	}
}
