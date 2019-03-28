/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.messaging.v1;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.List;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class WebhookUpdater extends Updater<Webhook> {
    private String webhookMethod;
    private List<String> webhookFilters;
    private String preWebhookUrl;
    private String postWebhookUrl;
    private Integer preWebhookRetryCount;
    private Integer postWebhookRetryCount;
    private Webhook.Target target;

    /**
     * The HTTP method to be used when sending a webhook request..
     * 
     * @param webhookMethod The HTTP method to be used when sending a webhook
     *                      request.
     * @return this
     */
    public WebhookUpdater setWebhookMethod(final String webhookMethod) {
        this.webhookMethod = webhookMethod;
        return this;
    }

    /**
     * The list of webhook event triggers that are enabled for this Service..
     * 
     * @param webhookFilters The list of webhook event triggers that are enabled
     *                       for this Service.
     * @return this
     */
    public WebhookUpdater setWebhookFilters(final List<String> webhookFilters) {
        this.webhookFilters = webhookFilters;
        return this;
    }

    /**
     * The list of webhook event triggers that are enabled for this Service..
     * 
     * @param webhookFilters The list of webhook event triggers that are enabled
     *                       for this Service.
     * @return this
     */
    public WebhookUpdater setWebhookFilters(final String webhookFilters) {
        return setWebhookFilters(Promoter.listOfOne(webhookFilters));
    }

    /**
     * The absolute url the pre-event webhook request should be sent to..
     * 
     * @param preWebhookUrl The absolute url the pre-event webhook request should
     *                      be sent to.
     * @return this
     */
    public WebhookUpdater setPreWebhookUrl(final String preWebhookUrl) {
        this.preWebhookUrl = preWebhookUrl;
        return this;
    }

    /**
     * The absolute url the post-event webhook request should be sent to..
     * 
     * @param postWebhookUrl The absolute url the post-event webhook request should
     *                       be sent to.
     * @return this
     */
    public WebhookUpdater setPostWebhookUrl(final String postWebhookUrl) {
        this.postWebhookUrl = postWebhookUrl;
        return this;
    }

    /**
     * The number of retries in case of pre-event webhook request failures. Maximum
     * 3 retries are allowed, the default value is 0..
     * 
     * @param preWebhookRetryCount The number of retries in case of pre-event
     *                             webhook request failures.
     * @return this
     */
    public WebhookUpdater setPreWebhookRetryCount(final Integer preWebhookRetryCount) {
        this.preWebhookRetryCount = preWebhookRetryCount;
        return this;
    }

    /**
     * The number of retries in case of post-event webhook request failures. Maximum
     * 3 retries are allowed, the default value is 0..
     * 
     * @param postWebhookRetryCount The number of retries in case of post-event
     *                              webhook request failures.
     * @return this
     */
    public WebhookUpdater setPostWebhookRetryCount(final Integer postWebhookRetryCount) {
        this.postWebhookRetryCount = postWebhookRetryCount;
        return this;
    }

    /**
     * The routing target of the webhook. Can be ordinary or route internally to
     * Flex.
     * 
     * @param target The routing target of the webhook.
     * @return this
     */
    public WebhookUpdater setTarget(final Webhook.Target target) {
        this.target = target;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Webhook
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Webhook update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.MESSAGING.toString(),
            "/v1/Sessions/Webhooks",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Webhook update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Webhook.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (webhookMethod != null) {
            request.addPostParam("WebhookMethod", webhookMethod);
        }

        if (webhookFilters != null) {
            for (String prop : webhookFilters) {
                request.addPostParam("WebhookFilters", prop);
            }
        }

        if (preWebhookUrl != null) {
            request.addPostParam("PreWebhookUrl", preWebhookUrl);
        }

        if (postWebhookUrl != null) {
            request.addPostParam("PostWebhookUrl", postWebhookUrl);
        }

        if (preWebhookRetryCount != null) {
            request.addPostParam("PreWebhookRetryCount", preWebhookRetryCount.toString());
        }

        if (postWebhookRetryCount != null) {
            request.addPostParam("PostWebhookRetryCount", postWebhookRetryCount.toString());
        }

        if (target != null) {
            request.addPostParam("Target", target.toString());
        }
    }
}